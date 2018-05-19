package fr.pmk_lobbyutils.hotbarconnectv2.inventory;

import java.util.HashMap;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.pmk_lobbyutils.hotbarconnectv2.utils.IHotBarItemListener;

public class HotBarInventory {

	private HashMap<String,HotBarItemData> hashItem = new HashMap<>();
	
	public void addInventoryItem(String itemName, HotBarItemData h) {
		if(hashItem.containsKey(itemName))
			return;
		
		hashItem.put(itemName, h);
	}
	
	public static HotBarInventory build(HotBarItemData... barItemDatas) {
		
		HotBarInventory hBI = new HotBarInventory();
		
		for (HotBarItemData hotBarItemData : barItemDatas) {
			
			if(!(hBI.getHashItem().size() <= 9)) {
				
				hBI.addInventoryItem(hotBarItemData.getItemName(), hotBarItemData);
				
			}
			
		}	
		
		return hBI;
	}

	public HashMap<String,HotBarItemData> getHashItem() {
		return hashItem;
	}

	public void setHashItem(HashMap<String,HotBarItemData> hashItem) {
		this.hashItem = hashItem;
	}

}
