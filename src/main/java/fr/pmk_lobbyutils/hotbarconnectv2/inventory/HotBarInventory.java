package fr.pmk_lobbyutils.hotbarconnectv2.inventory;

import java.util.HashMap;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.pmk_lobbyutils.hotbarconnectv2.utils.IHotBarItemListener;

public class HotBarInventory {

	private static HashMap<String,HotBarItemData> hashItem = new HashMap<>();
	
	public void addInventoryItem(String itemName, ItemStack item, IHotBarItemListener l) {
		
	}
	
	public static void build() {
		
	}
	
	public static Inventory getBuilded() {
		// TODO Auto-generated method stub
		return null;
	}

	public static HashMap<String,HotBarItemData> getHashItem() {
		return hashItem;
	}

	public static void setHashItem(HashMap<String,HotBarItemData> hashItem) {
		HotBarInventory.hashItem = hashItem;
	}

}
