package de.hdm.myproject.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.myproject.shared.StuecklistenAdministration;
import de.hdm.myproject.shared.bo.Bauteil;

public class StuecklistenAdministrationImpl extends RemoteServiceServlet
implements StuecklistenAdministration {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Bauteil createBauteil(String name, String bauteilBeschreibung,
			String materialBeschreibung) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

}
