package fr.pmk_lobbyutils.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

	@EventHandler
	public void OnPlayerJoin(PlayerJoinEvent e) {
		e.setJoinMessage("");	// pas de message
	}
	
	@EventHandler
	public void OnPlayerQuit(PlayerQuitEvent e) {
		e.setQuitMessage("");		//pas de message
	}
}
