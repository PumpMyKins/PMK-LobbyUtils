package fr.pmk_lobbyutils.hotbarconnect;

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
		
		inv.clear();
		/*for (int i = 0; i < inv.getSize(); i++) {
			inv.setItem(i, nullBaseItem);
		}*/
		
		if(l != null & !l.isEmpty()) {
			for (HotBarData h : l) {
				
				if(p.hasPermission("server." + h.getServerName() + ".view")) {
					
					inv.setItem(h.getSlot(), h.getItemStack());	// set des items
					
				}
				
			}			
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

	public static void initServerItem() {
		List<HotBarData> h = new ArrayList<>();
		
		List<String> l = new ArrayList<>();
		
		ItemStack i = new ItemStack(Material.APPLE);
		ItemMeta iM = i.getItemMeta();
		
		iM.setDisplayName("§n§2PumpMyKins§9§o#1 §r§2§nRagnaMod-IV§4§l[OUVERT-BETA]");
		l.add("§n§2PumpMyKins§9§o#1 §r§2§nRagnaMod-IV §r§f#r1pmk");
		iM.setLore(l);
		i.setItemMeta(iM);
		
		
		HotBarData d = new HotBarData("#r1pmk","ragna1",2, i, "server.ragna1");
		
		h.add(d);
		
		l = new ArrayList<>();
		
		i = new ItemStack(Material.BREAD);
	    iM = i.getItemMeta();
		
	    iM.setDisplayName("§n§2PumpMyKins§9§o#2 §r§2§nRagnaMod-IV§4§l[FERME]");
		l.add("§n§2PumpMyKins§9§o#2 §r§2§nRagnaMod-IV §r§f#r2pmk");
		iM.setLore(l);
		i.setItemMeta(iM);
		
		d = new HotBarData("#r2pmk","ragna2",6, i, "server.ragna2");
		
		h.add(d);
		
		l = new ArrayList<>();
		
		i = new ItemStack(Material.ANVIL);
	    iM = i.getItemMeta();
		
	    iM.setDisplayName("§n§2PumpMyKins§9§o#DEV");
		l.add("§n§2PumpMyKins§9§o#DEV §r§f#devpmk");
		iM.setLore(l);
		i.setItemMeta(iM);
		
		d = new HotBarData("#devpmk","dev",4, i, "server.dev");
		
		h.add(d);
		
		HotBarListener.setHotBarList(h);
	}
	
}
