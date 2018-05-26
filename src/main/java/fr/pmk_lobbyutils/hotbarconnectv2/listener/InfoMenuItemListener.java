package fr.pmk_lobbyutils.hotbarconnectv2.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import fr.pmk_lobbyutils.hotbarconnectv2.utils.IHotBarItemListener;

public class InfoMenuItemListener implements IHotBarItemListener {

	private static Inventory inv;
	
	private String raison = "Surprise";
	private String state = "off";
	
	@Override
	public void callItem(PlayerInteractEvent event) {
		// TODO Auto-generated method stub
		//System.out.println("ouverture game menu " + this.getClass().getName());
		
		Player p = event.getPlayer();
		
		if(p.hasPermission("menu.info.over") | state.equals("on") ) {
			
			p.openInventory(inv);
			
		}else {
			
			//p.sendMessage("[PumpMyInfo] Impossible d'ouvrir le menu d'information actuellement");
			p.sendMessage("§5§kABCDEFG §r SURPRISE §5§kABCDEFG");
		}
		
	}
	
	public static void buildMenu() {
		
		inv = Bukkit.createInventory(null, 18 , "§9§l§nMenu d'information");
		
		//Règles
		ItemStack regles = new ItemStack(Material.BARRIER);
		ItemMeta reglesM = regles.getItemMeta();
		reglesM.setDisplayName("§cRègles");
		regles.setItemMeta(reglesM);
		inv.setItem(3, new ItemStack(regles));
		
		//Forum
		ItemStack forum = new ItemStack(Material.SIGN);
		ItemMeta forumM = forum.getItemMeta();
		forumM.setDisplayName("§6Forum");
		forum.setItemMeta(forumM);
		inv.setItem(5, new ItemStack(forum));
		
		//Support
		ItemStack support = new ItemStack(Material.BOOK_AND_QUILL);
		ItemMeta supportM = support.getItemMeta();
		supportM.setDisplayName("§cSupport");
		support.setItemMeta(supportM);
		inv.setItem(8, new ItemStack(support));
		
		//Site
		ItemStack site = new ItemStack(Material.SIGN);
		ItemMeta siteM = site.getItemMeta();
		siteM.setDisplayName("§6Site");
		site.setItemMeta(siteM);
		inv.setItem(10, new ItemStack(site));
		
		//Discord
		ItemStack discord = new ItemStack(Material.BEACON);
		ItemMeta discordM = discord.getItemMeta();
		discordM.setDisplayName("§9Discord");
		discord.setItemMeta(discordM);
		inv.setItem(12, new ItemStack(discord));
		
		//Boutique
		ItemStack boutique = new ItemStack(Material.GRASS);
		ItemMeta boutiqueM = boutique.getItemMeta();
		boutiqueM.setDisplayName("§aBoutique");
		boutique.setItemMeta(boutiqueM);
		inv.setItem(14, new ItemStack(boutique));
		
		//Pet
		ItemStack pet = new ItemStack(Material.MOB_SPAWNER);
		ItemMeta petM = pet.getItemMeta();
		petM.setDisplayName("§2Pets");
		pet.setItemMeta(petM);
		inv.setItem(16, new ItemStack(pet));
		
		
		
		
		
	}

	public static Inventory getInv() {
		return inv;
	}

	public static void setInv(Inventory inv) {
		InfoMenuItemListener.inv = inv;
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
		this.state = s;
		
	}

	@Override
	public void setRasion(String r) {
		// TODO Auto-generated method stub
		this.raison = r;
	}
	
}
