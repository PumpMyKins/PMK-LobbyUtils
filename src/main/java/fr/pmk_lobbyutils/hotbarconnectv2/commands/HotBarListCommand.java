package fr.pmk_lobbyutils.hotbarconnectv2.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pmk_lobbyutils.MainLobbyUtils;
import fr.pmk_lobbyutils.hotbarconnectv2.inventory.HotBarItemData;
import fr.pmk_lobbyutils.hotbarconnectv2.utils.IHotBarItemListener;

public class HotBarListCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
            Player p = (Player) sender;
            
            if(cmd.getName().equalsIgnoreCase("hbclist")) {
                
            	if(p.hasPermission("hbc.list")) {
            		
            		//permission accordé
            		p.sendMessage("§e§l[§r§6PumpMyConnect§r§e§l]§r §aRécupération de la liste items et leurs états !");
            		
            		for (HotBarItemData h : MainLobbyUtils.getHotBarManager().getHotBarInv()) {
            			
            			IHotBarItemListener l = h.getListener();
            			
            			if(l.getState().equals("on") | l.getState().equalsIgnoreCase("prime")) {	
            				p.sendMessage("§e§l[§r" + h.getItemName() + "§r / §r" + h.getCompactName() + "§r§e§l>§r §a state : " + l.getState());
            			}else {
            				p.sendMessage("§e§l[§r" + h.getItemName() + "§r / §r" + h.getCompactName() + "§r§e§l>§r §a state : §c" + l.getState());
            				p.sendMessage("§e§l[§r" + h.getItemName() + "§r / §r" + h.getCompactName() + "§r§e§l]§r §a raison : §c" + l.getRaison());
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
