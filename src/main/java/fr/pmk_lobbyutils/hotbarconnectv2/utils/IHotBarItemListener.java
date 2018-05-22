package fr.pmk_lobbyutils.hotbarconnectv2.utils;

import org.bukkit.event.player.PlayerInteractEvent;

public interface IHotBarItemListener {

	public void callItem(PlayerInteractEvent event);
	
	public String getState();
	public String getRaison();
	
	public void setState(String s);
	public void setRasion(String r);
	
}
