package fr.pmk_lobbyutils.hotbarconnectv2.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import fr.pmk_lobbyutils.hotbarconnectv2.utils.IHotBarItemListener;

public class GameMenuItemListener implements IHotBarItemListener {

	private static Inventory inv;
	
	private static String raison = "Surprise";
	private static boolean state = false;
	
	@Override
	public void callItem(PlayerInteractEvent event) {
		// TODO Auto-generated method stub
		//System.out.println("ouverture game menu " + this.getClass().getName());
		
		Player p = event.getPlayer();
		
		if(p.hasPermission("menu.game.over") | state ) {
			
			p.openInventory(inv);
			
		}else {
			
			//p.sendMessage("[PumpMyGames] Impossible d'ouvrir le menu de jeux actuellement");
			p.sendMessage("§5§kABCDEFG §r SURPISE §5§kABCDEFG");
		}
		
	}
	
	public static void buildMenu() {
		
		inv = Bukkit.createInventory(null, InventoryType.HOPPER , "§6§l§nMenu de jeux");
		
	}

	public static Inventory getInv() {
		return inv;
	}

	public static void setInv(Inventory inv) {
		GameMenuItemListener.inv = inv;
	}

	public static String getRaison() {
		return raison;
	}

	public static void setRaison(String raison) {
		GameMenuItemListener.raison = raison;
	}

	public static boolean isState() {
		return state;
	}

	public static void setState(boolean state) {
		GameMenuItemListener.state = state;
	}

}
