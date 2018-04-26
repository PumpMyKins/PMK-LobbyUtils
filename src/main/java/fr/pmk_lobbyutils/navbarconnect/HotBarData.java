package fr.pmk_lobbyutils.navbarconnect;

import org.bukkit.inventory.ItemStack;

public class HotBarData {

	private int slot;
	private ItemStack itemStack;

	public HotBarData(int s, ItemStack i) {
		this.slot = s;
		this.itemStack = i;
	}
	
}
