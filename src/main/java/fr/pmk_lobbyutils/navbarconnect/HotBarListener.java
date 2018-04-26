package fr.pmk_lobbyutils.navbarconnect;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HotBarListener implements Listener {

	private static List<Player> playerList = new ArrayList<Player>(); 
	private static List<HotBarData> hotBarList;
	
	@EventHandler
	public void OnPlayerJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 99999999, 12, true), true);	
		p.setGameMode(GameMode.SURVIVAL);
		
		HotBarManager.setPlayerItem(e.getPlayer(), hotBarList);
	}
	
	@EventHandler
	public void OnPlayerUseNavItem(PlayerInteractEvent e) {
		if(e.getPlayer().getGameMode().equals(GameMode.CREATIVE) | e.getPlayer().getGameMode().equals(GameMode.SPECTATOR))
			return;
		
		if(e.getItem() == null)
			return;
		
		if(playerList.contains(e.getPlayer())) {
			e.getPlayer().sendMessage(ChatColor.RED + "Patientez ! Requete déjà en cours");
			return;
		}else {
			playerList.add(e.getPlayer());
		}
		
		// envoie des requètes
		
		
	}
	
	@EventHandler
	public void OnPlayerQuit(PlayerQuitEvent e) {
		
	}
	
	@EventHandler
	public void OnPlayerDeath(PlayerDeathEvent e) {
		HotBarManager.setPlayerItem(e.getEntity(),hotBarList);
	}

	public static List<HotBarData> getHotBarList() {
		return hotBarList;
	}

	public static void setHotBarList(List<HotBarData> hotBarList) {
		HotBarListener.hotBarList = hotBarList;
	}
	
}
