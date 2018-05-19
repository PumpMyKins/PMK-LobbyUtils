package fr.pmk_lobbyutils.hotbarconnectv2.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import fr.pmk_lobbyutils.hotbarconnectv2.utils.IHotBarItemListener;

public class InfoMenuItemListener implements IHotBarItemListener {

	private static Inventory inv;
	
	private static String raison = "Surprise";
	private static boolean state = false;
	
	@Override
	public void callItem(PlayerInteractEvent event) {
		// TODO Auto-generated method stub
		//System.out.println("ouverture game menu " + this.getClass().getName());
		
		Player p = event.getPlayer();
		
		if(p.hasPermission("menu.info.over") | state ) {
			
			p.openInventory(inv);
			
		}else {
			
			//p.sendMessage("[PumpMyInfo] Impossible d'ouvrir le menu d'information actuellement");
			p.sendMessage("§5§kABCDEFG §r SURPISE §5§kABCDEFG");
		}
		
	}
	
	public static void buildMenu() {
		
		inv = Bukkit.createInventory(null, InventoryType.HOPPER , "§9§l§nMenu d'information");
		
	}

	public static Inventory getInv() {
		return inv;
	}

	public static void setInv(Inventory inv) {
		InfoMenuItemListener.inv = inv;
	}

	public static String getRaison() {
		return raison;
	}

	public static void setRaison(String raison) {
		InfoMenuItemListener.raison = raison;
	}

	public static boolean isState() {
		return state;
	}

	public static void setState(boolean state) {
		InfoMenuItemListener.state = state;
	}
}
