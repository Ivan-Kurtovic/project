package de.hdm.myproject.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.myproject.server.db.BauteilMapper;
import de.hdm.myproject.shared.StuecklistenAdministration;
import de.hdm.myproject.shared.bo.Bauteil;

public class StuecklistenAdministrationImpl extends RemoteServiceServlet
implements StuecklistenAdministration {

	
	private static final long serialVersionUID = 1L;
	
	
	
	private BauteilMapper bauteilMapper = null;
	
	
	
	/**
	   * Initialsierungsmethode. Siehe dazu Anmerkungen zum No-Argument-Konstruktor
	   * {@link #ReportGeneratorImpl()}. Diese Methode muss für jede Instanz von
	   * <code>StuecklistenAdministrationImpl</code> aufgerufen werden.
	   * 
	   * 
	   */
	  @Override
	public void init() throws IllegalArgumentException {
	    /*
	     * Ganz wesentlich ist, dass die BankAdministration einen vollständigen Satz
	     * von Mappern besitzt, mit deren Hilfe sie dann mit der Datenbank
	     * kommunizieren kann.
	     */
	    this.bauteilMapper = BauteilMapper.bauteilMapper();
	  }

	
	  
	  
	  // Methode createBauteil
	  public Bauteil createBauteil(String name, String bauteilBeschreibung, String materialBeschreibung)
		      throws IllegalArgumentException {
		    Bauteil b = new Bauteil();
		    b.setName(name);
		    b.setBauteilBeschreibung(bauteilBeschreibung);
		    b.setMaterialBeschreibung(materialBeschreibung);

		    // Objekt in der DB speichern.
		    return this.bauteilMapper.insert(b);
		  }
	

}
