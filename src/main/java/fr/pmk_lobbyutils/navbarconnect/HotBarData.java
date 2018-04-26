package fr.pmk_lobbyutils.navbarconnect;

import org.bukkit.inventory.ItemStack;

public class HotBarData {

	
	private int slot;
	private ItemStack itemStack;
	private boolean serverState = true;
	private String downRaison = "";
	private String permission = "";

	
	public HotBarData(int s, ItemStack i) {
		this.setSlot(s);
		this.itemStack = i;
	}
	
	public HotBarData(int s, ItemStack i, String perm) {
		this.setSlot(s);
		this.itemStack = i;
		this.permission = perm;
	}
	
	public HotBarData(int s, ItemStack i, boolean state, String raison) {
		this.setSlot(s);
		this.itemStack = i;
		this.serverState = state;
		this.downRaison = raison;
	}
	
	public HotBarData(int s, ItemStack i, boolean state, String raison, String perm) {
		this.setSlot(s);
		this.itemStack = i;
		this.serverState = state;
		this.downRaison = raison;
		this.permission = perm;
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

	public boolean isServerState() {
		return serverState;
	}

	public void setServerState(boolean serverState) {
		this.serverState = serverState;
	}

	public String getDownRaison() {
		return downRaison;
	}

	public void setDownRaison(String downRaison) {
		this.downRaison = downRaison;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
	
}
