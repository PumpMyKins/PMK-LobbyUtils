package fr.pmk_lobbyutils.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pmk_lobbyutils.hotbarconnect.bungee.HotBarBungee;

public class PinioufCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		Player p = (Player) arg0;
		
		if(p.hasPermission("dev.dev1"))
			HotBarBungee.connectServer(p, "dev3");
		
		return false;
	}

}
