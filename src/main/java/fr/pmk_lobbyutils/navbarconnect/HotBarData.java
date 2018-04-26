package fr.pmk_lobbyutils.navbarconnect;

import org.bukkit.inventory.ItemStack;

public class HotBarData {

	
	private int slot;
	private ItemStack itemStack;
	private boolean serverState = true;
	private String downRaison = "§4Serveur fermé ou en maintenance, informez grâce au forum/teamspeak/staff !";
	private String permission = "";
	private String code;
	private String serverName;

	
	public HotBarData(String code, String s, int sl, ItemStack i) {
		this.code = code;
		this.serverName = s;
		this.slot = sl;
		this.itemStack = i;
	}
	
	public HotBarData(String code, String s, int sl, ItemStack i, String perm) {
		this.code = code;
		this.serverName = s;
		this.slot = sl;
		this.itemStack = i;
		this.permission = perm;
	}
	
	public HotBarData(String code, String s, int sl, ItemStack i, boolean state , String raison) {
		this.code = code;
		this.serverName = s;
		this.slot = sl;
		this.itemStack = i;
		this.serverState = state;
		this.downRaison = raison;
	}
	
	public HotBarData(String code, String s, int sl, ItemStack i , boolean state , String raison , String perm) {
		this.code = code;
		this.serverName = s;
		this.slot = sl;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	
}
