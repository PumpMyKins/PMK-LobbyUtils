package fr.pmk_lobbyutils;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg3) {

		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(cmd.getName().equalsIgnoreCase("spawn")) {
				p.teleport(new Location(p.getWorld(), -537, 29, 1372));
			}
			
		}

		return false;
	}

}
