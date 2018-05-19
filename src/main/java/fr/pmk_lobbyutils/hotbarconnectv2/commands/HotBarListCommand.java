package fr.pmk_lobbyutils.hotbarconnectv2.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pmk_lobbyutils.hotbarconnect.HotBarData;
import fr.pmk_lobbyutils.hotbarconnect.HotBarListener;

public class HotBarListCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
            Player p = (Player) sender;
            
            if(cmd.getName().equalsIgnoreCase("hbclist")) {
                
            	if(p.hasPermission("hbc.list")) {
            		
            		//permission accordé
            		p.sendMessage("§e§l[§r§6PumpMyConnect§r§e§l]§r §aRécupération de la liste des serveurs !");
            		
            		List<HotBarData> hList = HotBarListener.getHotBarList();
            		
            		for (HotBarData h : hList) {
            			
            			if(h.isServerState().equalsIgnoreCase("on") | h.isServerState().equalsIgnoreCase("prime")) {	
            				p.sendMessage("§e§l[§r§6" + h.getServerName() + "§r§e§l>§r §a state : " + h.isServerState());
            			}else {
            				p.sendMessage("§e§l[§r§6" + h.getServerName() + "§r§e§l>§r §a state : §c" + h.isServerState());
            				p.sendMessage("§e§l[§r§6" + h.getServerName() + "§r§e§l]§r §a raison : §c" + h.getDownRaison());
            			}
            			
            			p.sendMessage("§c==================");
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
