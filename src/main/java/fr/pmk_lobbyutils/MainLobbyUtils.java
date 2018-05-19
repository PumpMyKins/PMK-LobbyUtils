package fr.pmk_lobbyutils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import fr.pmk_lobbyutils.config.Config;
import fr.pmk_lobbyutils.hotbarconnect.commands.HotBarListCommand;
import fr.pmk_lobbyutils.hotbarconnect.commands.HotBarSetCommand;
import fr.pmk_lobbyutils.hotbarconnectv2.HotBarManager;
import fr.pmk_lobbyutils.hotbarconnectv2.inventory.HotBarInventory;
import fr.pmk_lobbyutils.hotbarconnectv2.inventory.HotBarItemData;
import fr.pmk_lobbyutils.hotbarconnectv2.listener.HotBarListener;
import fr.pmk_lobbyutils.hotbarconnectv2.listener.RagnaItemListener;
import fr.pmk_lobbyutils.listener.PlayerListener;


public class MainLobbyUtils extends JavaPlugin{
	
	private static Config conf;
	private static MainLobbyUtils instance;
	
	private static HotBarManager hotBarManager;

	@Override
	public void onEnable() {
		
		instance = this;
		// TODO Auto-generated method stub
		
		// init config
		conf = Config.getConfig(this);
								
		conf.initDataFolder();
		conf.initAndGetFile("config.yml");	// init config default file
		
		this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		// Ajout du listener
		getServer().getPluginManager().registerEvents(new PlayerListener(), this);
		
		hotBarManager = HotBarManager.getManager(this);
		
		hotBarManager.setDefaultInventory(createHotBarInv(hotBarManager));
		hotBarManager.setPlayerListener(new HotBarListener());
		
		
		//getServer().getPluginManager().registerEvents(new HotBarListener(), this); hold hotbar system
		
		this.getCommand("hbclist").setExecutor(new HotBarListCommand());
		this.getCommand("hbcserver").setExecutor(new HotBarSetCommand());
		
	}
	
	private HotBarInventory createHotBarInv(HotBarManager h) {
		
		ItemStack iragna = new ItemStack(Material.APPLE);
		ItemMeta iragnaM = iragna.getItemMeta();
		
		iragnaM.setDisplayName("§n§2PumpMyKins§9§o#1 §r§2§nRagnaMod-IV§4§l");
		
		List<String> l = new ArrayList<>();
		l.add("§n§2PumpMyKins§9§o#1 §r§2§nRagnaMod-IV §r§f#r1pmk");
		
		iragnaM.setLore(l);
		
		iragna.setItemMeta(iragnaM);
		
		HotBarItemData itemDataRagna = new HotBarItemData("§n§2PumpMyKins§9§o#1 §r§2§nRagnaMod-IV§4§l", 2 , iragna , new RagnaItemListener());
		
		HotBarInventory inv = HotBarInventory.build(itemDataRagna);
		
		return inv;
		
	}

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void onLoad() {
		// TODO Auto-generated method stub
	}

	public static Config getConf() {
		return conf;
	}

	public static void setConf(Config conf) {
		MainLobbyUtils.conf = conf;
	}

	public static Plugin get() {
		return instance;
	}

	public static HotBarManager getHotBarManager() {
		return hotBarManager;
	}

	public static void setHotBarManager(HotBarManager hotBarManager) {
		MainLobbyUtils.hotBarManager = hotBarManager;
	}
	
}
