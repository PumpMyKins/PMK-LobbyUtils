package fr.pmk_lobbyutils.support;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import fr.pmk_lobbyutils.MainLobbyUtils;

public class SupportListener implements Listener {

	public void OnStaffJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		if(p.hasPermission("support.view")) {
			
			ByteArrayDataOutput out = ByteStreams.newDataOutput();
			
			out.writeUTF("support");
			out.writeUTF("addsupport");
			
			p.sendPluginMessage(MainLobbyUtils.get(), "BungeeCord", out.toByteArray());
			
		}
		
		
	}	
}
