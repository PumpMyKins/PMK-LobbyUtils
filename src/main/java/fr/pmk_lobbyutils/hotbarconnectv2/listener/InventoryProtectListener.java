package fr.pmk_lobbyutils.hotbarconnectv2.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.pmk_lobbyutils.MainLobbyUtils;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import fr.pmk_lobbyutils.hotbarconnect.bungee.HotBarBungee;

public class InventoryProtectListener implements Listener {

	@EventHandler
	public void OnPlayerDropItem(PlayerDropItemEvent e) {
		
		Player p = e.getPlayer();
		
		e.getItemDrop().remove();
		
		if(!p.getGameMode().equals(GameMode.CREATIVE)) {
			
			MainLobbyUtils.getHotBarManager().setInventory(p);
			
		}
		
	}
	
	@EventHandler
	public void OnPlayerMoveItem(InventoryMoveItemEvent e) {

		System.out.println();
		
	}
	
	@EventHandler
	public void OnPlayerDragItem(InventoryDragEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		
		if(!p.getGameMode().equals(GameMode.CREATIVE)) {
			e.setCancelled(true);
			MainLobbyUtils.getHotBarManager().setInventory(p);
			
		}
		
	}
	
	@EventHandler
	public void OnPlayerClickItem(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		
		Inventory i = e.getClickedInventory();
		
		if(i == null) {
			return;
		}else {
			
			if(p.getGameMode().equals(GameMode.CREATIVE))
				return;
			
			if(i.getType().equals(InventoryType.PLAYER)) {
					
				e.setCancelled(true);
				MainLobbyUtils.getHotBarManager().setInventory(p);
				return;
					
			}else {
				
				ItemStack item = e.getCurrentItem();
				
				if(item == null)
					return;
				
				String name = item.getItemMeta().getDisplayName();
				
				if(name.equals("§n§3GravityWars§d§o#1 §kC§l§dEpicMode§kC")) {
					// gravity epic mod
					
					p.sendMessage("§b[PumpMyInfo] Connexion à  :§r" + name);
					p.closeInventory();
					HotBarBungee.connectServer(p, "gravity1");
					
					
				}else if(name.equals("§n§3GravityWars§d§o#2 §kC§l§dNormal§kC")) {
					// gravity normal mod
					
					p.sendMessage("§b[PumpMyInfo] Connexion à  :§r" + name);
					p.closeInventory();
					HotBarBungee.connectServer(p, "gravity2");
					
					
				}else if(name.equals("§cRègles")) {
						//RÃ¨gles
						p.chat("/rules");
						p.closeInventory();
				}else if(name.equals("§6Forum")) {
						//Forum
						TextComponent forumMenu = new TextComponent("§a[PumpMyKins] Tu peux aller voir notre §cForum");
						forumMenu.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "http://pumpmykins.eu/forum/"));
						p.spigot().sendMessage(forumMenu);
						p.closeInventory();
				}else if(name.equals("§cSupport")) {
						//Support
						p.closeInventory();
						p.sendMessage("§c[PumpMyKins] Pour contacter le support veuillez faire : /support <Votre Message>");
				}else if(name.equals("§6Site")) {
						//Site
						TextComponent siteMenu = new TextComponent("§a[PumpMyKins] Tu peux aller voir note §cSite");
						siteMenu.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "http://pumpmykins.eu"));
						p.spigot().sendMessage(siteMenu);
						p.closeInventory();
				}else if(name.equals("§9Discord")) {
						//Discord
						TextComponent discordMenu = new TextComponent("§d[Discord] Tu peux rejoindre notre §cDiscord");
						discordMenu.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/VedSyV7"));
						p.spigot().sendMessage(discordMenu);
						p.closeInventory();
				}else if(name.equals("§aBoutique")) {
						//Boutique
						TextComponent boutiqueMenu = new TextComponent("§e[Boutique] Tu peux aller voir notre §cBoutique");
						boutiqueMenu.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "http://pumpmykins.buycraft.net"));
						p.spigot().sendMessage(boutiqueMenu);
						p.closeInventory();
				}else if(name.equals("§2Pets")) {
						//Pets
						p.closeInventory();
						p.chat("/pet");
				}	
				
				e.setCancelled(true);
			}
			
			
		}
		/*
		if(!p.getGameMode().equals(GameMode.CREATIVE)) {
			
			e.setCancelled(true);
			
		}*/
		
	}
	
}
