package fr.pmk_lobbyutils.listener;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.meta.FireworkMeta;

import fr.pmk_lobbyutils.MainLobbyUtils;

public class PlayerListener implements Listener {
	
	private static HashMap<Player, String> hPlayerFlight = new HashMap<>();
	
	@EventHandler
	public void OnPlayerJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		p.teleport(new Location(p.getWorld(), -537, 29, 1372));
		e.setJoinMessage("");
		p.setAllowFlight(true);
		//hPlayerFlight.put(p, "2222223");
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainLobbyUtils.get(), new Runnable() {
            public void run() {
                    Firework f = (Firework) e.getPlayer().getWorld().spawn(e.getPlayer().getLocation(), Firework.class);
                   
                    FireworkMeta fm = f.getFireworkMeta();
                    fm.addEffect(FireworkEffect.builder()
                                    .flicker(false)
                                    .trail(true)
                                    .with(Type.BALL_LARGE)
                                    .withColor(Color.GREEN)
                                    .withFade(Color.LIME)
                                    .build());
                    f.setFireworkMeta(fm);
            }
		}, 10);
		
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
