package fr.pmk_lobbyutils.hotbarconnectv2.utils;

import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public interface IHotBarConnectPlayerListener{

	public void OnPlayerJoin(PlayerJoinEvent event);
	
	public void OnPlayerLeave(PlayerQuitEvent event);
	
	public void OnPlayerDeath(PlayerRespawnEvent event);
	
	public void OnPlayerUseItem(PlayerInteractEvent event);
	
}
