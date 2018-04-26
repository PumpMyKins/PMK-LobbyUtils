package fr.pmk_lobbyutils.config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import fr.pmk_lobbyutils.MainLobbyUtils;

public class Config {

	private static Config config = new Config();
	private static MainLobbyUtils main;
	
	private static List<String> playerList = new ArrayList<>();
	
	public static Config getConfig(MainLobbyUtils m) {
		main = m;
		return config;
	}

	public void initDataFolder() {
		
		if(!main.getDataFolder().exists()) {
			main.getDataFolder().mkdir();
		}
		
	}
	
	public File initAndGetFile(String fileName) {
		
		File file = new File(main.getDataFolder(),fileName);
		
		if(!file.exists()) {
			file.getParentFile().mkdirs();
            main.saveResource(fileName, false);    
		}
		return file;
	}
	
	public YamlConfiguration getConfiguration(String fileName){
		
		File file = new File(main.getDataFolder(),fileName);
		
		if(file.exists()) {
			YamlConfiguration conf = new YamlConfiguration();
			
			try {
				conf.load(file);	// chargement du fichier
				return conf;
			} catch (IOException | InvalidConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return null;		
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getKnowPlayerList(){
		return (List<String>) getConfiguration("player.yml").getList("player");
	}
	
	public void setKnowPlayerList(List<String> l) {
		try {
			YamlConfiguration c = getConfiguration("player.yml");
			
			c.set("player", l);
			c.save(initAndGetFile("player.yml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static List<String> getPlayerList() {
		return playerList;
	}

	public static void setPlayerList(List<String> list) {
		Config.playerList = list;
	}
}