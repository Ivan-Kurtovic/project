package de.hdm.myproject.shared;

import com.google.gwt.user.client.rpc.RemoteService;

import de.hdm.myproject.shared.bo.Bauteil;
import de.hdm.myproject.shared.bo.ItProject;

public interface StuecklistenAdministration extends RemoteService {
	
	
	
	
	/**
	 * Ein Bauteil anlegen
	 * 
	 * @param bauteilBeschreibung
	 *            BauteilBeschreibung
	 * @param materialBeschreibung
	 *            MaterialBeschreibung
	 * @return Ein fertiges Kunden-Objekt
	 * @throws IllegalArgumentException
	 */
 	Bauteil createBauteil(String name, String bauteilBeschreibung,
			String materialBeschreibung) throws IllegalArgumentException;

	void setItProject(ItProject project);
 	
 	


}
