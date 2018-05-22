package fr.pmk_lobbyutils.hotbarconnectv2.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class HotBarInventory implements Iterable<HotBarItemData>{

	private HashMap<String,HotBarItemData> hashItem = new HashMap<>();
	
	public void addInventoryItem(String itemName, HotBarItemData h) {
		if(hashItem.containsKey(itemName))
			return;
		
		hashItem.put(itemName, h);
	}
	
	public static HotBarInventory build(HotBarItemData... barItemDatas) {
		
		HotBarInventory hBI = new HotBarInventory();
		
		for (HotBarItemData hotBarItemData : barItemDatas) {
			
			if(!(hBI.getHashItem().size() > 9)) {
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

	@Override
	public Iterator<HotBarItemData> iterator() {
		List<HotBarItemData> l = new ArrayList<>();
		
		for (Entry<String, HotBarItemData> hotBarItemData : hashItem.entrySet()) {
			l.add(hotBarItemData.getValue());
		}
		
		return l.iterator();
	}
	
	public boolean contains(String n) {
		return hashItem.containsKey(n);
	}

}
