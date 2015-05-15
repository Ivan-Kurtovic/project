package de.hdm.myproject.shared;

import com.google.gwt.user.client.rpc.RemoteService;

import de.hdm.myproject.shared.bo.Bauteil;

public interface StuecklistenAdministration extends RemoteService {
	
 	Bauteil createBauteil(String name, String bauteilBeschreibung,
			String materialBeschreibung) throws IllegalArgumentException;

}
