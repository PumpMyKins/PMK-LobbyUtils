package fr.pmk_lobbyutils;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import fr.pmk_lobbyutils.config.Config;
import fr.pmk_lobbyutils.interchat.BungeeChatCommand;
import fr.pmk_lobbyutils.interchat.BungeeChatListCommand;
import fr.pmk_lobbyutils.listener.PlayerListener;
import fr.pmk_lobbyutils.navbarconnect.HotBarListener;
import fr.pmk_lobbyutils.navbarconnect.HotBarManager;
import fr.pmk_lobbyutils.navbarconnect.commands.HotBarListCommand;
import fr.pmk_lobbyutils.navbarconnect.commands.HotBarSetCommand;
import fr.pmk_lobbyutils.support.SupportCommand;

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
		conf.initAndGetFile("player.yml");	// init config default file
		
		Config.setPlayerList(conf.getKnowPlayerList()); 	// init de la variable playerList
		
		//bungeecord init
		this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
	    //this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new HotBarBungee());
		
		
		HotBarManager.initServerItem();
		
		this.getCommand("hbclist").setExecutor(new HotBarListCommand());
		this.getCommand("hbcserver").setExecutor(new HotBarSetCommand());
		
		this.getCommand("support").setExecutor(new SupportCommand());
		
		this.getCommand("bchatlist").setExecutor(new BungeeChatListCommand());
		this.getCommand("bchat").setExecutor(new BungeeChatCommand());
		
		// Ajout du listener
		getServer().getPluginManager().registerEvents(new PlayerListener(), this);
		getServer().getPluginManager().registerEvents(new HotBarListener(), this);
		
	}
	
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		conf.setKnowPlayerList(Config.getPlayerList()); // sauvegarde de la variable playerList
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
