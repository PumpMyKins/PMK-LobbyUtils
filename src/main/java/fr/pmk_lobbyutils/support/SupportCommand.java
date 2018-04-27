package fr.pmk_lobbyutils.support;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import fr.pmk_lobbyutils.MainLobbyUtils;

public class SupportCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
            Player p = (Player) sender;
            
            if(cmd.getName().equalsIgnoreCase("support")) {
            	
            	if(args.length != 0) {
            		
            		String msg = "";
                	for (String s : args) {
    					msg += s;
    				}
                	
                	ByteArrayDataOutput out = ByteStreams.newDataOutput();
        			
        			out.writeUTF("support");
        			out.writeUTF("sendmsg");
        			out.writeUTF(msg);
        			
        			p.sendPluginMessage(MainLobbyUtils.get(), "BungeeCord", out.toByteArray());           		
            		
        			return true;
            	}
            	
            	return false;
            	
            }
            
		}
		
		return false;
	}

}
