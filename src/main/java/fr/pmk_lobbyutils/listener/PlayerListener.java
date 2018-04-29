package fr.pmk_lobbyutils.listener;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPreLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.pmk_lobbyutils.config.Config;

public class PlayerListener implements Listener {
	
	private static HashMap<Player, String> hPlayerFlight = new HashMap<>();
	
	@EventHandler
	public void OnPlayerJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		/*String pUUID = p.getUniqueId().toString();
		String pName = p.getDisplayName();
		
		List<String> listPlayer = Config.getPlayerList();
		
		if(!listPlayer.contains(pUUID)) {
			
			listPlayer.add(pUUID);
			//affichage du message de bienvenue
			e.setJoinMessage("§2§kab§r" + "§6Bienvenue à §e§l" + pName + "§r§6, le §b§l" + (listPlayer.size()-1) + "§r§6ème joueurs ! §2§kab");
			
			// set un grade
			
		}else {

			e.setJoinMessage("");	// pas de message
			
		}*/
		
		p.teleport(new Location(p.getWorld(), -537, 29, 1372));
		e.setJoinMessage("");
		p.setAllowFlight(true);
		//hPlayerFlight.put(p, "2222223");
		
		
	}
	
	@EventHandler
	public void OnPlayerQuit(PlayerQuitEvent e) {
		e.getPlayer().setAllowFlight(false);
		e.setQuitMessage("");		//pas de message
	}

	public static HashMap<Player, String> gethPlayerFlight() {
		return hPlayerFlight;
	}

	public static void sethPlayerFlight(HashMap<Player, String> hPlayerFlight) {
		PlayerListener.hPlayerFlight = hPlayerFlight;
	}
}
