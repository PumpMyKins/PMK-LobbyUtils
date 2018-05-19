package fr.pmk_lobbyutils.hotbarconnectv2.inventory;

import org.bukkit.inventory.ItemStack;

import fr.pmk_lobbyutils.hotbarconnectv2.utils.IHotBarItemListener;

public class HotBarItemData {

	private ItemStack item;
	private IHotBarItemListener listener;
	private String itemName;
	private int itemSlot;
	
	public HotBarItemData(String iN , int s, ItemStack i, IHotBarItemListener l) {
		
		this.itemName = iN;
		this.item = i;
		this.listener = l;
		this.itemSlot = s;
		
	}
	
	public ItemStack getItem() {
		return item;
	}
	public void setItem(ItemStack item) {
		this.item = item;
	}
	public IHotBarItemListener getListener() {
		return listener;
	}
	public void setListener(IHotBarItemListener listener) {
		this.listener = listener;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemSlot() {
		return itemSlot;
	}

	public void setItemSlot(int itemSlot) {
		this.itemSlot = itemSlot;
	}
	
	
	
}
