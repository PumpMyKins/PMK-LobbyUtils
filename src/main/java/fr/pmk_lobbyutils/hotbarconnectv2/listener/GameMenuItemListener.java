package fr.pmk_lobbyutils.hotbarconnectv2.listener;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.pmk_lobbyutils.hotbarconnect.bungee.HotBarBungee;
import fr.pmk_lobbyutils.hotbarconnectv2.inventory.HotBarItemData;
import fr.pmk_lobbyutils.hotbarconnectv2.utils.IHotBarItemListener;

public class GameMenuItemListener implements IHotBarItemListener {

	private Inventory inv;
	
	private String state = "off";
	private String raison = "Serveur non ouvert ...";
	
	@Override
	public void callItem(PlayerInteractEvent event) {
		// TODO Auto-generated method stub
		//System.out.println("ouverture game menu " + this.getClass().getName());
		
		Player p = event.getPlayer();
		
		if(p.hasPermission("menu.game.over") | state.equals("on") ) {
			
			buildMenu();
			p.openInventory(inv);
			
		}else {
			
			p.sendMessage("§c[PumpMyInfo] Impossible d'ouvrir le menu de jeu actuellement");
			//p.sendMessage("§5§kABCDEFG §r SURPRISE §5§kABCDEFG");
		}
		
	}
	
	public void buildMenu() {
		
		inv = Bukkit.createInventory(null, InventoryType.HOPPER , "§6§l§nMenu de jeux");
		
	
		
		ItemStack iGravityWarsRapid = new ItemStack(Material.BEACON);
		ItemMeta iGravityWarsRapidM = iGravityWarsRapid.getItemMeta();
		
		iGravityWarsRapidM.setDisplayName("§n§3GravityWars§d§o#1 §kC§l§dEpicMode§kC");
		
		List<String> loreGravityWarsRapid = new ArrayList<>();
		loreGravityWarsRapid.add("§2Eliminez vos adversaires en les faisant exploser !");
		loreGravityWarsRapid.add("§3§lPetite map, partie très rapide, maximum §r§n4 §r§3§ljoueurs par équipe.");
		loreGravityWarsRapid.add("§l§6Bonus garantie toutes les §r§l§310 §r§l§6secondes");
		loreGravityWarsRapid.add("§5Serveur : §a_#en ligne §r/;/ §5Nombre de joueurs : §a_#0");
		
		iGravityWarsRapidM.setLore(loreGravityWarsRapid);
		
		iGravityWarsRapid.setItemMeta(iGravityWarsRapidM);
		
		inv.setItem(1, iGravityWarsRapid);
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		ItemStack iGravityWarsBig = new ItemStack(Material.BEACON);
		ItemMeta iGravityWarsBigM = iGravityWarsBig.getItemMeta();
		
		iGravityWarsBigM.setDisplayName("§n§3GravityWars§d§o#2 §kC§l§dNormal§kC");
		
		List<String> loreGravityWarsBig = new ArrayList<>();
		loreGravityWarsBig.add("§2Eliminez vos adversaires en les faisant exploser !");
		loreGravityWarsBig.add("§3§lMap moyenne, partie très rapide, maximum §r§n4 §r§3§ljoueurs par équipe.");
		loreGravityWarsBig.add("§l§6Bonus toutes les §r§l§320 §r§l§6secondes (50% de chance )");
		loreGravityWarsBig.add("§5Serveur : §a_#en ligne §r/;/ §5Nombre de joueurs : §a_#0");
		
		
		iGravityWarsBigM.setLore(loreGravityWarsBig);
		
		iGravityWarsBig.setItemMeta(iGravityWarsBigM);
		
		inv.setItem(3, iGravityWarsBig);
		
	}
	
	public void refreshMenu() {
		
	}

	public Inventory getInv() {
		return this.inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
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
