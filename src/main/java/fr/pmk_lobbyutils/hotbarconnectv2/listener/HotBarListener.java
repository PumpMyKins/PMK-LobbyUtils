package fr.pmk_lobbyutils.hotbarconnectv2.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import fr.pmk_lobbyutils.MainLobbyUtils;
import fr.pmk_lobbyutils.hotbarconnectv2.HotBarManager;
import fr.pmk_lobbyutils.hotbarconnectv2.utils.IHotBarConnectPlayerListener;

public class HotBarListener implements Listener,IHotBarConnectPlayerListener {

	private HotBarManager hotBarManager = MainLobbyUtils.getHotBarManager();
	
	@Override
	@EventHandler
	public void OnPlayerJoin(PlayerJoinEvent event) {
		// TODO Auto-generated method stub
		hotBarManager.setInventory(event.getPlayer());
		
	}

	@Override
	//@EventHandler pas utile pour l'instant
	public void OnPlayerLeave(PlayerQuitEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@EventHandler
	public void OnPlayerRespawn(PlayerRespawnEvent event) {
		// TODO Auto-generated method stub
		
		if(event.getPlayer().getGameMode().equals(GameMode.CREATIVE))
			return;
		
		hotBarManager.setInventory(event.getPlayer());
		
	}

	@Override
	@EventHandler
	public void OnPlayerUseItem(PlayerInteractEvent event) {
		// TODO Auto-generated method stub
		Player p = event.getPlayer();
		
		if(p.getGameMode().equals(GameMode.CREATIVE))
			return;
		
		ItemStack i = event.getItem();
		
		if(event.getItem() == null) {
			//System.out.println("pas d'item");
			return;
		}
		
		event.setCancelled(true);
		
		//System.out.println("get name item");
		String n = i.getItemMeta().getDisplayName();
		HotBarManager h = MainLobbyUtils.getHotBarManager();
		
		if(h.getHotBarInv().contains(n)) {
			//System.out.println("apelle de l'event");
			h.getHotBarInv().getHashItem().get(n).getListener().callItem(event);
			
		}
		
	}

}
