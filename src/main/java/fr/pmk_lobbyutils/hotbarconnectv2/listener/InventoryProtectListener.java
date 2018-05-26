package fr.pmk_lobbyutils.hotbarconnectv2.listener;

import java.awt.TextComponent;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Server.Spigot;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.pmk_lobbyutils.MainLobbyUtils;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;

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

		e.setCancelled(true);
		
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
			
			if(i.getType().equals(InventoryType.PLAYER)) {
				
				if(!p.getGameMode().equals(GameMode.CREATIVE)) {
					
					e.setCancelled(true);
					MainLobbyUtils.getHotBarManager().setInventory(p);
					return;
					
				}else {
					
					
					ItemStack item = e.getCurrentItem();
					String name = item.getItemMeta().getDisplayName();
					
						if(name.equals("§cRègles")) {
						//Règles
						p.chat("/rules");
					}else if(name.equals("§6Forum")) {
						//Forum
						net.md_5.bungee.api.chat.TextComponent forumMenu = new net.md_5.bungee.api.chat.TextComponent("§a[PumpMyKins] Tu peux aller voir notre §cForum");
						forumMenu.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "http://pumpmykins.eu/forum/"));
						p.spigot().sendMessage(forumMenu);
					}else if(name.equals("§cSupport")) {
						//Support
						p.sendMessage("§c[PumpMyKins] Pour contacter le support veuillez faire : /support <Votre Message>");
					}else if(name.equals("§6Site")) {
						//Site
						net.md_5.bungee.api.chat.TextComponent siteMenu = new net.md_5.bungee.api.chat.TextComponent("§a[PumpMyKins] Tu peux aller voir note §cSite");
						siteMenu.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "http://pumpmykins.eu"));
						p.spigot().sendMessage(siteMenu);
					}else if(name.equals("§9Discord")) {
						//Discord
						net.md_5.bungee.api.chat.TextComponent discordMenu = new net.md_5.bungee.api.chat.TextComponent("§d[Discord] Tu peux rejoindre notre §cDiscord");
						discordMenu.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/VedSyV7"));
						p.spigot().sendMessage(discordMenu);
					}else if(name.equals("§aBoutique")) {
						//Boutique
						net.md_5.bungee.api.chat.TextComponent boutiqueMenu = new net.md_5.bungee.api.chat.TextComponent("§e[Boutique] Tu peux aller voir notre §cBoutique");
						boutiqueMenu.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "http://pumpmykins.buycraft.net"));
						p.spigot().sendMessage(boutiqueMenu);
					}else if(name.equals("§2Pets")) {
						//Pets
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
	
}}
