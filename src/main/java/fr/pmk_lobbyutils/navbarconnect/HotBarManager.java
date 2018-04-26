package fr.pmk_lobbyutils.navbarconnect;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HotBarManager {
	
	
	private static final ItemStack nullBaseItem = makeItem("null",Material.STAINED_GLASS_PANE, new ArrayList<>());
	
	
	public static void setPlayerItem(Player p, List<HotBarData> l) {
		
		Inventory inv = p.getInventory();	// récupération de l'inventaire
		
		for (int i = 0; i < inv.getSize(); i++) {
			inv.setItem(i, nullBaseItem);
		}
		
		for (HotBarData h : l) {
			
		}
		
	}
	
	public static void updateAllPlayerItem() {
		
		
		
	}
	
	public static ItemStack makeItem(String dName , Material m, List<String> l) {
		
		ItemStack i = new ItemStack(m);		// création de l'item
		ItemMeta iMeta= i.getItemMeta();	// récupération de l'itemMeta
		
		iMeta.setDisplayName(dName); 	// set du nom
		if(l != null) {
			iMeta.setLore(l);				// set du lore
		}
		
		i.setItemMeta(iMeta);			// set itemMeta sur l'item
		
		return i;	 //return de l'item
	}

	public ItemStack getNullBaseItem() {
		return nullBaseItem;
	}
	
}
