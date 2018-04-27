package fr.pmk_lobbyutils.navbarconnect.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pmk_lobbyutils.navbarconnect.HotBarData;
import fr.pmk_lobbyutils.navbarconnect.HotBarListener;

public class HotBarListCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
            Player p = (Player) sender;
            
            if(cmd.getName().equalsIgnoreCase("hbclist")) {
                
            	if(p.hasPermission("hbc.list")) {
            		
            		//permission accordé
            		p.sendMessage("§e§l[§r§6PumpMyConnect§r§e§l]§r §aRécupération de la liste des serveurs !");
            		
            		List<HotBarData> h = HotBarListener.getHotBarList();
            		
            		for (HotBarData hotBarData : h) {
						
            			p.sendMessage("§e§l[§r§6" + hotBarData.getServerName() + "§r§e§l]§r §a state : " + hotBarData.isServerState() + " / raison " + hotBarData.getDownRaison());
            			
					}
            		
            	}else {
            		// pas la permission
            	}
            	
            	return true;
            }
        }		
		return false;
	}

}
