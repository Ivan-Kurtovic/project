package de.hdm.myproject.shared;

import com.google.gwt.user.client.rpc.RemoteService;

import de.hdm.myproject.shared.bo.ItProject;



public interface ReportGenerator extends RemoteService {

	void init();
	
	
	/**
	   * Setzen der zugeordneten ItProject.
	   * 
	   * @para Bank-Objekt
	   * @throws IllegalArgumentException
	   */
	void setItProject(ItProject project);

}
