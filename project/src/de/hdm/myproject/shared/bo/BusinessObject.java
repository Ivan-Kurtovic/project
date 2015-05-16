package de.hdm.myproject.shared.bo;

import java.io.Serializable;


public abstract class BusinessObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Eindeutige id von allen BusinessObjekten 
	 */
	private int id = 0;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @author Ivan Kurtovic 
	 * Erzeugen einer einfachen textuellen Darstellung der jeweiligen Instanz.
	 * Dies kann selbstverst�ndlich in Subklassen �berschrieben werden.
	 */
	@Override
	public String toString() {
		/*
		 * Wir geben den Klassennamen gefolgt von der ID des Objekts zur�ck.
		 */
		return this.getClass().getName() + " #" + this.id;
	}
	
	
	/**
	 * Feststellen der <em>inhaltlichen</em> Gleichheit zweier <code>BusinessObject</code>-Objekte. Die Gleichheit ist
	 * hier auf eine identische ID beschr�nkt.
	 */
	
	public boolean equals(Object o) {
	    /*
	     * Abfragen, ob ein Objekt ungleich NULL ist und ob ein Objekt gecastet
	     * werden kann, sind immer wichtig!
	     */
	    if (o != null && o instanceof BusinessObject) {
	      BusinessObject bo = (BusinessObject) o;
	      try {
	        if (bo.getId() == this.id)
	          return true;
	      }
	      catch (IllegalArgumentException e) {
	        /*
	         * Wenn irgendetwas schief geht, dann geben wir sicherheitshalber false
	         * zur�ck.
	         */
	        return false;
	      }
	    }
	    /*
	     * Wenn bislang keine Gleichheit bestimmt werden konnte, dann m�ssen
	     * schlie�lich false zur�ckgeben.
	     */
	    return false;
	  }
	  
	
	
	/**
	 * Erzeugen einer ganzen Zahl, die f�r das <code>BusinessObject</code> charakteristisch ist.
	 */
	public int hashCode() {
		  return this.id;
	  }


}
