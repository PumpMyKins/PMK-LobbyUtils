package fr.pmk_lobbyutils.hotbarconnectv2;

import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public interface IHotBarConnectPlayerListener {

	public void OnPlayerJoin(PlayerJoinEvent event);
	
	public void OnPlayerLeave(PlayerQuitEvent event);
	
	public void OnPlayerDeath(PlayerDeathEvent event);
	
}
