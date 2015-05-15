package de.hdm.myproject.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ReportGeneratorAsync {

	
	
	
	/**
	   * Initialisierung des Objekts. Diese Methode ist vor dem Hintergrund von GWT
	   * RPC zusätzlich zum No Argument Constructor der implementierenden Klasse
	   *BankAdministrationImpltungImpl} notwendig. Bitte diese Methode direkt nach der
	   * Instantiierung aufrufen.
	   * 
	   * @throws IllegalArgumentException
	   */
	void init(AsyncCallback<Void> initReportGeneratorCallback);

}
