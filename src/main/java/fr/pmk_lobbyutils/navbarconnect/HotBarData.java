package fr.pmk_lobbyutils.navbarconnect;

import org.bukkit.inventory.ItemStack;

public class HotBarData {

	private int slot;
	private ItemStack itemStack;

	public HotBarData(int s, ItemStack i) {
		this.setSlot(s);
		this.itemStack = i;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public ItemStack getItemStack() {
		return itemStack;
	}

	public void setItemStack(ItemStack itemStack) {
		this.itemStack = itemStack;
	}
	
}
