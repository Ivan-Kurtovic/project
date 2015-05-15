package de.hdm.myproject.shared.bo;

public class Bauteil extends BusinessObject {

	
	private static final long serialVersionUID = 1L;
	private String name = "Bauteiltest";
	private String bauteilBeschreibung = "testtext";
	private String materialBeschreibung = "testtext";

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getBauteilBeschreibung() {
		return this.bauteilBeschreibung;
	}
	
	
	public void setBauteilBeschreibung(String bauteilBeschreibung) {
		this.bauteilBeschreibung = bauteilBeschreibung;
	}

	
	
	public String getMaterialBeschreibung() {
		return this.materialBeschreibung;
	}
	
	
	public void setMaterialBeschreibung(String materialBeschreibung) {
		this.materialBeschreibung = materialBeschreibung;
	}
	
	
	
	/**
	   * Erzeugen einer einfachen textuellen Darstellung der jeweiligen Instanz.
	   * Diese besteht aus dem Text, der durch die <code>toString()</code>-Methode
	   * der Superklasse erzeugt wird, ergänzt durch den Name  und Teilbeschreibung des 
	   * jeweiligen Bauteils.
	   */
	@Override
	public String toString() {
	    return super.toString() + "Teilbeschreibung:" + this.bauteilBeschreibung
	    		+ "Materialbeschreibung" + this.materialBeschreibung;
	  }


	
}


