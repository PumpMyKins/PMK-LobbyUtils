package fr.pmk_lobbyutils.hotbarconnectv2.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import fr.pmk_lobbyutils.hotbarconnectv2.utils.IHotBarItemListener;

public class InfoMenuItemListener implements IHotBarItemListener {

	private static Inventory inv;
	
	private String raison = "Surprise";
	private String state = "off";
	
	@Override
	public void callItem(PlayerInteractEvent event) {
		// TODO Auto-generated method stub
		//System.out.println("ouverture game menu " + this.getClass().getName());
		
		Player p = event.getPlayer();
		
		if(p.hasPermission("menu.info.over") | state.equals("on") ) {
			
			p.openInventory(inv);
			
		}else {
			
			//p.sendMessage("[PumpMyInfo] Impossible d'ouvrir le menu d'information actuellement");
			p.sendMessage("§5§kABCDEFG §r SURPRISE §5§kABCDEFG");
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

	@Override
	public String getState() {
		// TODO Auto-generated method stub
		return state;
	}

	@Override
	public String getRaison() {
		// TODO Auto-generated method stub
		return raison;
	}

	@Override
	public void setState(String s) {
		this.state = s;
		
	}

	@Override
	public void setRasion(String r) {
		// TODO Auto-generated method stub
		this.raison = r;
	}
	
}
