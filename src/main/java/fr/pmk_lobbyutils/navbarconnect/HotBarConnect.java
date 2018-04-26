package fr.pmk_lobbyutils.navbarconnect;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HotBarConnect {
	
	
	private static final ItemStack nullBaseItem = makeItem("",Material.STAINED_GLASS_PANE, null);
	
	
	public static void setPlayerItem(Player p) {
		
		Inventory inv = p.getInventory();	// récupération de l'inventaire
		
		// set item dans hotbar
		inv.setItem(0, nullBaseItem);
		inv.setItem(1, nullBaseItem);
		inv.setItem(2, nullBaseItem);
		inv.setItem(3, nullBaseItem);
		inv.setItem(4, nullBaseItem);
		inv.setItem(5, nullBaseItem);
		inv.setItem(6, nullBaseItem);
		inv.setItem(7, nullBaseItem);
		inv.setItem(8, nullBaseItem);
		
	 
	 
		
		
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
