package fr.pmk_lobbyutils.hotbarconnectv2.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.pmk_lobbyutils.hotbarconnect.bungee.HotBarBungee;
import fr.pmk_lobbyutils.hotbarconnectv2.utils.IHotBarItemListener;

public class OzoneItemListener implements IHotBarItemListener {

	private String state = "dev";
	private String raison = "Serveur non ouvert";
	
	@Override
	public void callItem(PlayerInteractEvent event) {
		// TODO Auto-generated method stub
		Player p = event.getPlayer();
		
		// item ragnamod connexion
		
		if(state.equals("on")) {
			
			// requete de connexion
			p.sendMessage("�e�l[�r�6PumpMyCord�r�e�l]�r �aRequ�te de connexion au serveur �2�o�n" + "ozone" + "�r�a bien envoy� !");
			p.sendMessage("�e�l[�r�6PumpMyCord�r�e�l]�r �aMerci de patienter le temps que le serveur confirme la connexion ...");
			HotBarBungee.connectServer(p, "ozone");
			
		}else if(state.equals("prime")) {
			
			if(p.hasPermission("server.ozone.prime")) {
				// connexion accept�
				// requete de connexion
				p.sendMessage("�e�l[�r�6PumpMyCord�r�e�l]�r �aRequ�te de connexion au serveur �2�o�n" + "ozone" + "�r�a bien envoy� !");
				p.sendMessage("�e�l[�r�6PumpMyCord�r�e�l]�r �aMerci de patienter le temps que le serveur confirme la connexion ...");
				HotBarBungee.connectServer(p, "ozone");
				
			}else {
				// connexion refus�
				p.sendMessage("�e�l[�r�6PumpMyCord�r�e�l]�r �cRequ�te de connexion au serveur �4�o�n" + "ozone" + "�r�c non envoy�, permission insuffisante !");
			}
			
		}else if(state.equals("dev")) {
			
			if(p.hasPermission("server.ozone.dev")) {
				// connexion accept�
				// requete de connexion
				p.sendMessage("�e�l[�r�6PumpMyCord�r�e�l]�r �aRequ�te de connexion au serveur �2�o�n" + "ozone" + "�r�a bien envoy� !");
				p.sendMessage("�e�l[�r�6PumpMyCord�r�e�l]�r �aMerci de patienter le temps que le serveur confirme la connexion ...");
				HotBarBungee.connectServer(p, "ozone");
				
			}else {
				// connexion refus�
				p.sendMessage("�e�l[�r�6PumpMyCord�r�e�l]�r �cRequ�te de connexion au serveur �4�o�n" + "ozone" + "�r�c non envoy�, serveur indisponible !");
				p.sendMessage("�e�l[�r�6PumpMyCord�r�e�l]�r �cRaison : �4�o�n" + raison);
				
			}
			
		}else if(state.equals("off")) {
			
			// connexion refus�
			p.sendMessage("�e�l[�r�6PumpMyCord�r�e�l]�r �cRequ�te de connexion au serveur �4�o�n" + "ozone" + "�r�c non envoy�, serveur indisponible !");
			p.sendMessage("�e�l[�r�6PumpMyCord�r�e�l]�r �cRaison : �4�o�n" + raison);
		}
	}

	@Override
	public String getState() {
		// TODO Auto-generated method stub
		return state;
	}

	@Override
	public String getRaison() {
		// TODO Auto-generated method stub
		return raison;
	}

	@Override
	public void setState(String s) {
		// TODO Auto-generated method stub
		this.state = s;
	}

	@Override
	public void setRasion(String r) {
		// TODO Auto-generated method stub
		this.raison = r;
	}

}
