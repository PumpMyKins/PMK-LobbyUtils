package fr.pmk_lobbyutils;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import fr.pmk_lobbyutils.config.Config;
import fr.pmk_lobbyutils.hotbarconnect.HotBarListener;
import fr.pmk_lobbyutils.hotbarconnect.HotBarManager;
import fr.pmk_lobbyutils.hotbarconnect.commands.HotBarListCommand;
import fr.pmk_lobbyutils.hotbarconnect.commands.HotBarSetCommand;
import fr.pmk_lobbyutils.listener.PlayerListener;


public class MainLobbyUtils extends JavaPlugin{
	
	private static Config conf;
	private static MainLobbyUtils instance;

	@Override
	public void onEnable() {
		
		instance = this;
		// TODO Auto-generated method stub
		
		// init config
		conf = Config.getConfig(this);
								
		conf.initDataFolder();
		conf.initAndGetFile("config.yml");	// init config default file
		HotBarManager.initServerItem();
		
		this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		// Ajout du listener
		getServer().getPluginManager().registerEvents(new PlayerListener(), this);
		getServer().getPluginManager().registerEvents(new HotBarListener(), this);
		
		this.getCommand("hbclist").setExecutor(new HotBarListCommand());
		this.getCommand("hbcserver").setExecutor(new HotBarSetCommand());
		
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
	
}
