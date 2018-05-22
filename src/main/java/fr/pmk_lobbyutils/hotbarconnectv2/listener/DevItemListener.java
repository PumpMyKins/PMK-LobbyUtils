package fr.pmk_lobbyutils.hotbarconnectv2.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.pmk_lobbyutils.hotbarconnect.bungee.HotBarBungee;
import fr.pmk_lobbyutils.hotbarconnectv2.utils.IHotBarItemListener;

public class DevItemListener implements IHotBarItemListener {

	private String raison = "r";
	private String state = "on";
	
	@Override
	public void callItem(PlayerInteractEvent event) {
		// TODO Auto-generated method stub
		Player p = event.getPlayer();
		
		if(p.hasPermission("server.dev")) {
			
			HotBarBungee.connectServer(p, "dev");
		}else {
			event.setCancelled(true);
			return;
		}
		
	}

	@Override
	public String getState() {
		// TODO Auto-generated method stub
		return state;
	}

	@Override
	public String getRaison() {
		// TODO Auto-generated method stub
		return raison;
	}

	@Override
	public void setState(String s) {
		// TODO Auto-generated method stub
		this.state = s;
	}

	@Override
	public void setRasion(String r) {
		// TODO Auto-generated method stub
		this.raison = r;
	}

}
