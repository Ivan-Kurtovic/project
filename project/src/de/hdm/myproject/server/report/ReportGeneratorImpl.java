package de.hdm.myproject.server.report;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.myproject.shared.ReportGenerator;
import de.hdm.myproject.shared.StuecklistenAdministration;
import de.hdm.myproject.server.StuecklistenAdministrationImpl;


public class ReportGeneratorImpl extends RemoteServiceServlet 
implements ReportGenerator {

	
	
/**
   * Ein ReportGenerator benötigt Zugriff auf die SteucklistenAdministration, da diese die
   * essentiellen Methoden für die Koexistenz von Datenobjekten (vgl.
   * bo-Package) bietet.
   */
	private StuecklistenAdministration administration = null;
	 
	private static final long serialVersionUID = 1L;
	
	public void init() throws IllegalArgumentException {
	    /*
	     * Ein ReportGeneratorImpl-Objekt instantiiert für seinen Eigenbedarf eine
	     * BankVerwaltungImpl-Instanz.
	     */
	    StuecklistenAdministrationImpl a = new StuecklistenAdministrationImpl();
	    a.init();
	    this.administration = a;
	  }
	
	
	

}
