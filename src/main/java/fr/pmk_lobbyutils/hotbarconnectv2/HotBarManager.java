package fr.pmk_lobbyutils.hotbarconnectv2;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

import fr.pmk_lobbyutils.MainLobbyUtils;
import fr.pmk_lobbyutils.hotbarconnectv2.inventory.HotBarInventory;
import fr.pmk_lobbyutils.hotbarconnectv2.inventory.HotBarItemData;
import fr.pmk_lobbyutils.hotbarconnectv2.listener.GameMenuItemListener;
import fr.pmk_lobbyutils.hotbarconnectv2.listener.InfoMenuItemListener;

public class HotBarManager {

	private MainLobbyUtils main;
	private HotBarInventory hotBarInv;
	
	private HotBarManager(MainLobbyUtils m) {
		this.main = m;
	}
	
	public static HotBarManager getManager(MainLobbyUtils m) {
		
		return new HotBarManager(m);
		
	}
	
	public void setPlayerListener(Listener i) {
		this.main.getServer().getPluginManager().registerEvents(i, this.main);
		
	}
	
	public void setInventoryProtectListener(Listener i) {
		this.main.getServer().getPluginManager().registerEvents(i, this.main);
	}
	
	public void setDefaultInventory(HotBarInventory i) {
		this.hotBarInv = i;
		
	}
	
	public void setItemMenuLister(Listener l) {
		this.main.getServer().getPluginManager().registerEvents(l, this.main);
	}

	public MainLobbyUtils getMain() {
		return this.main;
	}

	public void setMain(MainLobbyUtils main) {
		this.main = main;
	}
	
	public void buildMenu() {
		InfoMenuItemListener.buildMenu();
	}

	public void setInventory(Player player) {
		// TODO Auto-generated method stub
		//Inventory inv = HotBarInventory.getBuilded();
		HotBarInventory hotBarInv = this.hotBarInv;
		
		Inventory i = player.getInventory();
		i.clear();
		
		for (HotBarItemData itemData : hotBarInv) {
			//System.out.println("set item " + itemData.getItemName());
			i.setItem(itemData.getItemSlot(), itemData.getItem());
			
		}
		
	}

	public HotBarInventory getHotBarInv() {
		return hotBarInv;
	}

	public void setHotBarInv(HotBarInventory hotBarInv) {
		this.hotBarInv = hotBarInv;
	}
	
}
