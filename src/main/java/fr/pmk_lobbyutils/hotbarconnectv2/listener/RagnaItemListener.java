package fr.pmk_lobbyutils.hotbarconnectv2.listener;

import org.bukkit.event.player.PlayerInteractEvent;

import fr.pmk_lobbyutils.hotbarconnectv2.utils.IHotBarItemListener;

public class RagnaItemListener implements IHotBarItemListener {

	@Override
	public void callItem(PlayerInteractEvent event) {
		// TODO Auto-generated method stub
		
		// item ragnamod connexion
		System.out.println("connexion à ragna " + this.getClass().getName());
	}

}
