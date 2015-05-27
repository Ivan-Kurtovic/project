package de.hdm.myproject.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.myproject.shared.bo.Bauteil;

public interface StuecklistenAdministrationAsync {

	void createBauteil(String name, String bauteilBeschreibung,
			String materialBeschreibung, AsyncCallback<Bauteil> callback);

}
