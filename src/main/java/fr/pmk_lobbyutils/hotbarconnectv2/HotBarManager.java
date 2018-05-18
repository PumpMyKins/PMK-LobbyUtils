package fr.pmk_lobbyutils.hotbarconnectv2;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

import fr.pmk_lobbyutils.MainLobbyUtils;
import fr.pmk_lobbyutils.hotbarconnectv2.inventory.HotBarInventory;

public class HotBarManager {

	private MainLobbyUtils main;
	private static Inventory defaultInv;
	
	private HotBarManager(MainLobbyUtils m) {
		this.main = m;
	}
	
	public static HotBarManager getManager(MainLobbyUtils m) {
		
		return new HotBarManager(m);
		
	}
	
	public void setPlayerListener(Listener i) {
		
		this.main.getServer().getPluginManager().registerEvents(i, this.main);
		
	}

	public MainLobbyUtils getMain() {
		return this.main;
	}

	public void setMain(MainLobbyUtils main) {
		this.main = main;
	}

	public void setInventory(Player player) {
		// TODO Auto-generated method stub
		Inventory inv = HotBarInventory.getBuilded();
		
	}
	
}
