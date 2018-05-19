package fr.pmk_lobbyutils.hotbarconnectv2.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pmk_lobbyutils.hotbarconnect.HotBarData;
import fr.pmk_lobbyutils.hotbarconnect.HotBarListener;

public class HotBarSetCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
            Player p = (Player) sender;
            
            if(cmd.getName().equalsIgnoreCase("hbcserver")) {
                
            	if(p.hasPermission("hbc.server")) {
            		
            		p.sendMessage("§4[ Staff help ] : il y a 4 états pour les serveurs ( on / prime / dev / off ) ");
            		p.sendMessage("§4[ Staff help ] : pour autres états que \"on/prime\", merci d'ajouter une raison ");
            		
            		if(args.length == 0) {
            			p.sendMessage("§4[ Staff help ] : Vous devez mettre spécifier un serveur, l'état et la raison ");
            			return false;
            		}
            		
            		
            		List<HotBarData> hList = HotBarListener.getHotBarList();
            		
            		for (HotBarData h : hList) {
            			
            			if(h.getServerName().equalsIgnoreCase(args[0])) {
            				
            				//System.out.println(args[0]);
            				
            				if(!(args.length >= 2)) {
            					p.sendMessage("§4[ Staff help ] : Vous devez mettre spécifier un serveur, et l'état");
                    			return false;
                    			
            				}
            				
            				if(!args[1].equalsIgnoreCase("on") & !args[1].equalsIgnoreCase("prime") & !args[1].equalsIgnoreCase("dev") & !args[1].equalsIgnoreCase("off")) {
            					
            					p.sendMessage("§4[ Staff help ] : Vous devez mettre spécifier un état valable");
                    			return false;
            					
            				}
            				
            				//System.out.println(args[1]);
            				
            				if(args[1].equalsIgnoreCase("on") | args[1].equalsIgnoreCase("prime")) {
            					
            					//System.out.println("on prime");
            					h.setServerState(args[1]);
            					
            				}else {
            					
            					//System.out.println("off dev");
            					h.setServerState(args[1]);
            					
            					String raison = "";
            					for (int i = 2; i < args.length; i++) {
									raison += args[i] + " ";
								}  
            					
            					h.setDownRaison(raison);
            					System.out.println(raison);
            					
            					
            				}
            				
            				
            			}
            			
            		}
            		
            		
            		/*//permission accordé
            		p.sendMessage("§e§l[§r§6PumpMyConnect§r§e§l]§r §aRécupération de la liste des serveurs !");
            		
            		List<HotBarData> hList = HotBarListener.getHotBarList();
            		
            		for (HotBarData h : hList) {
            			
            			if(h.isServerState().equalsIgnoreCase("on")) {	
            				p.sendMessage("§e§l[§r§6" + h.getServerName() + "§r§e§l>§r §a state : " + h.isServerState());
            			}else {
            				p.sendMessage("§e§l[§r§6" + h.getServerName() + "§r§e§l>§r §a state : §c" + h.isServerState());
            				p.sendMessage("§e§l[§r§6" + h.getServerName() + "§r§e§l]§r §a raison : §c" + h.getDownRaison());
            			}	
					}*/
            		
            	}else {
            		// pas la permission
            	}
            	
            	return true;
            }
        }		
		return false;
	}

}
