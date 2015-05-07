package de.hdm.myproject.shared.bo;

/**
 * Die Hilfsklasse <code>Tuple</code> stellt eine Hilfsklasse zur Darstellung
 * von Tuppeln (generic, int) dar. Objekte dieser Klasse repräsentieren
 * später das Mengenverhältnis von Bauteilen/Baugruppen-Objekten in Baugruppen.
 * 
 * @author Kerim
 *
 */
public class Tuple <T> {
	
	/**
	 * Das Bauteil/die Baugruppe die vom Tuppelobjekt gehalten wird.
	 */
	private T data = null;
	
	/**
	 * Die Menge des gehaltenen Objektes.
	 */
	private int amount = 0;
	
	/**
	 * Standardkonstruktor.
	 */
	public Tuple() {}
	
	/**
	 * Hauptkonstruktor über den Instanzen dieser Klasse erstellt werden.
	 * 
	 * @param data
	 * @param amount
	 */
	public Tuple(T data, int amount) {
		this.data = data;
		this.amount = amount;
	}
	
	/**
	 * Auslesen des gehaltenen Objekttyps.
	 * @return <code> Bauteil </code> oder <code> Baugruppe</code>.
	 */
	public T getData() {
		return this.data;
	}
	
	/**
	 * Setzen des gehaltenen Objekttyps.
	 */
	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * Auslesen der Menge.
	 * @return int
	 */
	public int getAmount() {
		return this.amount;
	}
	
	/**
	 * Setzen der Menge.
	 * @param amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
