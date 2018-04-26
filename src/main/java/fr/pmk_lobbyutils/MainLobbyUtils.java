package fr.pmk_lobbyutils;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pmk_lobbyutils.config.Config;

public class MainLobbyUtils extends JavaPlugin{
	
	private static Config conf;

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		
		// init config
		conf = Config.getConfig(this);
								
		conf.initDataFolder();
		conf.initAndGetFile("config.yml");	// init config default file
		conf.initAndGetFile("player.yml");	// init config default file
		
		Config.setPlayerList(conf.getKnowPlayerList()); 	// init de la variable playerList
		
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
	
}
