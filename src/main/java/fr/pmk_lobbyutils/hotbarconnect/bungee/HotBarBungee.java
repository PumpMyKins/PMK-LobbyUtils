package fr.pmk_lobbyutils.hotbarconnect.bungee;

import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import fr.pmk_lobbyutils.MainLobbyUtils;

public class HotBarBungee implements PluginMessageListener {

	/*public static void initItemServer(Player p) {
		// TODO Auto-generated method stub
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		
		out.writeUTF("hotbar");
		out.writeUTF("initItem");
		
		p.sendPluginMessage(MainLobbyUtils.get(), "BungeeCord", out.toByteArray());
	}*/
	
	public static void initFinishItemServer(String[] string) {
		
		/*for (String j : string) {
			
			JSONParser parser = new JSONParser();
			HotBarData h = new HotBarData(0, null);
			
			FileReader fileReader;
			try {
				
				fileReader = new FileReader(j);
				JSONObject json = (JSONObject) parser.parse(fileReader);
				
				boolean state = (boolean) json.get("state");
				
				if(state) {
					
				}else {
					
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
		
		HotBarListener.setHotBarList(null);
		HotBarListener.setInit(true);*/
	}

	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
		
		if (channel.equals("BungeeCord")) {
			ByteArrayDataInput in = ByteStreams.newDataInput(message);
			
		    String subchannel = in.readUTF();
		    
		    if (subchannel.equals("initItem")) {
		    	
		    	String reponse = in.readUTF();
		    	
		    	initFinishItemServer(reponse.split("{;!;}"));
		    	
		    }
		    
		}
		
	}
	
	public static void connectServer(Player p,String name) {
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		
		out.writeUTF("Connect");
		out.writeUTF(name);
		
		p.sendPluginMessage(MainLobbyUtils.get(), "BungeeCord" , out.toByteArray());
	}

}
