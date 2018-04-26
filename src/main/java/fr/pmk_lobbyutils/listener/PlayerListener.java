package fr.pmk_lobbyutils.listener;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.pmk_lobbyutils.config.Config;

public class PlayerListener implements Listener {

	@EventHandler
	public void OnPlayerJoin(PlayerJoinEvent e) {
		System.out.println(e.getEventName());
		
		Player p = e.getPlayer();
		String pName = p.getDisplayName();
		
		List<String> listPlayer = Config.getPlayerList();
		
		if(listPlayer.contains(pName)) {
			
			//affichage du message de bienvenue
			e.setJoinMessage(ChatColor.MAGIC + "" + ChatColor.GOLD + "abcd" + ChatColor.RESET + "" + ChatColor.BOLD + "" + ChatColor.YELLOW + " " + pName + " " 
							+ ChatColor.RESET + "" + ChatColor.GOLD + " bienvenue à vous sur le serveur PumpMyKins " + ChatColor.MAGIC + "abcd");
			
		}else {

			e.setJoinMessage("Souhaitez un bon retour à {player} sur le serveur");
			
		}
	}	
}
