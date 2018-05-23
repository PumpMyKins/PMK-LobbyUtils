package fr.pmk_lobbyutils.hotbarconnectv2.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.pmk_lobbyutils.MainLobbyUtils;

public class InventoryProtectListener implements Listener {

	@EventHandler
	public void OnPlayerDropItem(PlayerDropItemEvent e) {
		
		Player p = e.getPlayer();
		
		e.getItemDrop().remove();
		
		if(!p.getGameMode().equals(GameMode.CREATIVE)) {
			
			MainLobbyUtils.getHotBarManager().setInventory(p);
			
		}
		
	}
	
	@EventHandler
	public void OnPlayerMoveItem(InventoryMoveItemEvent e) {

		System.out.println();
		
	}
	
	@EventHandler
	public void OnPlayerDragItem(InventoryDragEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		
		if(!p.getGameMode().equals(GameMode.CREATIVE)) {
			e.setCancelled(true);
			MainLobbyUtils.getHotBarManager().setInventory(p);
			
		}
		
	}
	
	@EventHandler
	public void OnPlayerClickItem(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		
		Inventory i = e.getClickedInventory();
		
		if(i == null) {
			return;
		}else {
			
			if(p.getGameMode().equals(GameMode.CREATIVE))
				return;
			
			if(i.getType().equals(InventoryType.PLAYER)) {
					
				e.setCancelled(true);
				MainLobbyUtils.getHotBarManager().setInventory(p);
				return;
					
			}else {
				
				
				ItemStack item = e.getCurrentItem();
				String name = item.getItemMeta().getDisplayName();
				
				System.out.println(name);
				
				e.setCancelled(true);
			}
			
		}
		/*
		if(!p.getGameMode().equals(GameMode.CREATIVE)) {
			
			e.setCancelled(true);
			
		}*/
		
	}
	
}
