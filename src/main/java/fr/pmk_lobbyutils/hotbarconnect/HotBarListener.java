package fr.pmk_lobbyutils.hotbarconnect;

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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.pmk_lobbyutils.hotbarconnect.bungee.HotBarBungee;


public class HotBarListener implements Listener {

	private static List<Player> playerList = new ArrayList<Player>(); 
	private static List<HotBarData> hotBarList;
	private static boolean isInit = false;
	
	private void removeQueuePlayer(Player p) {
		if(playerList.contains(p)) {
			playerList.remove(p);
		}
	}
	
	@EventHandler
	public void OnPlayerJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		/*if(!isInit & p.getServer().getOnlinePlayers().size() == 1) {
			
			// alors premier lancement, donc initialisation
			HotBarBungee.initItemServer(p);
			
		}*/
		
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
		
		ItemStack item = e.getItem();
		ItemMeta itemMeta = item.getItemMeta();
		String itemLore = "";
		
		Player p = e.getPlayer();
		
		if(itemMeta.hasLore()) {
			
			for (String l : itemMeta.getLore()) {
				itemLore += l;
			}
			
			for (HotBarData hotBarData : hotBarList) {
				if(itemLore.contains(hotBarData.getCode())) {
					
					if(p.hasPermission(hotBarData.getPermission() + ".join")) {
						
						if((hotBarData.isServerState().equals("prime") & p.hasPermission("server."+hotBarData.getServerName()+".primejoin")) | hotBarData.isServerState().equals("on")) {
							
							// requete de connexion
							p.sendMessage("§e§l[§r§6PumpMyCord§r§e§l]§r §aRequête de connexion au serveur §2§o§n" + hotBarData.getServerName() + "§r§a bien envoyé !");
							HotBarBungee.connectServer(p, hotBarData.getServerName());
							
						}else if(hotBarData.isServerState().equals("off")) {
							
							//pas dispo
							p.sendMessage("§e§l[§r§6PumpMyCord§r§e§l]§r §cRequête de connexion au serveur §4§o§n" + hotBarData.getServerName() + "§r§c non envoyé, serveur indisponible !");
							p.sendMessage("§e§l[§r§6PumpMyCord§r§e§l]§r §cRaison : §4§o§n" + hotBarData.getDownRaison());
							
							removeQueuePlayer(p);
							e.setCancelled(true);
							return;
							
						}else {
							
							//pas la permission
							p.sendMessage("§e§l[§r§6PumpMyCord§r§e§l]§r §cRequête de connexion au serveur §4§o§n" + hotBarData.getServerName() + "§r§c non envoyé, permission insuffisante !");
							
							removeQueuePlayer(p);
							e.setCancelled(true);
							return;
							
						}
						
					}else {
						//pas la permission
						p.sendMessage("§e§l[§r§6PumpMyCord§r§e§l]§r §cRequête de connexion au serveur §4§o§n" + hotBarData.getServerName() + "§r§c non envoyé, permission insuffisante !");
						
						removeQueuePlayer(p);
						e.setCancelled(true);
						return;
					}
				}
			}
			removeQueuePlayer(p);
			e.setCancelled(true);				
			
		}
		
		removeQueuePlayer(p);
		e.setCancelled(true);
		
	}
	
	@EventHandler
	public void OnPlayerQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		removeQueuePlayer(p);
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

	public static boolean isInit() {
		return isInit;
	}

	public static void setInit(boolean isInit) {
		HotBarListener.isInit = isInit;
	}
	
}
