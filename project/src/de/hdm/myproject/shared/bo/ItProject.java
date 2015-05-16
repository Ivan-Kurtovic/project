package de.hdm.myproject.shared.bo;

public class ItProject extends BusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	   * Name der Bank
	   */
	  private String verantwortlicher = "";

	  /**
	   * Straﬂe und Hausnummer der Bank.
	   */
	  private String bearbeiter = "";

	  /**
	   * Postleitzahl der Bank.
	   */
	  private int nummer = 0;

	  /**
	   * Ortsbezeichnung der Bank.
	   */
	  private String datum = "";

	  /**
	   * No Argument Constructor
	   */
	  public ItProject() {
	    super();
	  }

	public String getVerantwortlicher() {
		return verantwortlicher;
	}

	public void setVerantwortlicher(String verantwortlicher) {
		this.verantwortlicher = verantwortlicher;
	}

	public String getBearbeiter() {
		return bearbeiter;
	}

	public void setBearbeiter(String bearbeiter) {
		this.bearbeiter = bearbeiter;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

}
