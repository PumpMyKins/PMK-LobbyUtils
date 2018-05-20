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

		e.setCancelled(true);
		
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
			
			if(i.getType().equals(InventoryType.PLAYER)) {
				
				if(!p.getGameMode().equals(GameMode.CREATIVE)) {
					
					e.setCancelled(true);
					MainLobbyUtils.getHotBarManager().setInventory(p);
					return;
					
					
				}
				
			}else if(!e.getClick().isLeftClick()) {
				
				e.setCancelled(true);
				
			}
			
		}
		/*
		if(!p.getGameMode().equals(GameMode.CREATIVE)) {
			
			e.setCancelled(true);
			
		}*/
		
	}
	
}
