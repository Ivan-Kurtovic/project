package de.hdm.myproject.server.db;

import java.sql.*;

import de.hdm.myproject.shared.bo.Bauteil;


/**
 * Mapper-Klasse, die <code>Bauteil</code>-Objekte auf eine relationale
 * Datenbank abbildet. Hierzu wird eine Reihe von Methoden zur Verfügung
 * gestellt, mit deren Hilfe z.B. Objekte gesucht, erzeugt, modifiziert und
 * gelöscht werden können. Das Mapping ist bidirektional. D.h., Objekte können
 * in DB-Strukturen und DB-Strukturen in Objekte umgewandelt werden.
 * 
 */

public class BauteilMapper {
	
	
	/**
	 * Die Klasse bauteilMapper wird nur einmal instantiiert. Man spricht
	 * hierbei von einem sogenannten <b>Singleton</b>.
	 * <p>
	 * Diese Variable ist durch den Bezeichner <code>static</code> nur einmal
	 * für sämtliche eventuellen Instanzen dieser Klasse vorhanden. Sie
	 * speichert die einzige Instanz dieser Klasse.
	 * 
	 * @see bauteilMapper()
	 */
	private static BauteilMapper bauteilMapper = null;

	/**
	 * Geschützter/Protected Construktor - verhindert die Möglichkeit, mit
	 * <code>new</code> neue Instanzen dieser Klasse zu erzeugen.
	 */
	protected BauteilMapper() {
	}

	/**
	 * Diese statische Methode kann aufgrufen werden durch
	 * <code>BauteilMapper.bauteilMapper()</code>. Sie stellt die
	 * Singleton-Eigenschaft sicher, indem Sie dafür sorgt, dass nur eine
	 * einzige Instanz von <code>BauteilMapper</code> existiert.
	 * <p>
	 * 
	 * <b>Fazit:</b> BauteilMapper sollte nicht mittels <code>new</code>
	 * instantiiert werden, sondern stets durch Aufruf dieser statischen
	 * Methode.
	 * 
	 * @return <code>BauteilMapper</code>-Objekt.
	 * @see bauteilMapper
	 */
	public static BauteilMapper bauteilMapper() {
		if (bauteilMapper == null) {
			bauteilMapper = new BauteilMapper();
		}

		return bauteilMapper;
	}

	
	
	/**
	 * Einfügen eines <code>Bauteil</code>-Objekts in die Datenbank. Dabei wird
	 * auch der Primärschlüssel des übergebenen Objekts geprüft und ggf.
	 * berichtigt.
	 * 
	 */
	public Bauteil insert(Bauteil bauteil) {
		
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			/*
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid "
					+ "FROM bauteile ");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			if (rs.next()) {
				/*
				 * bauteil erhält den bisher maximalen, nun um 1 inkrementierten
				 * Primärschlüssel.
				 */
				bauteil.setId(rs.getInt("maxid") + 1);

				stmt = con.createStatement();

				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
				stmt.executeUpdate("INSERT INTO `bauteile` (`id`, `name`, `beschreibung`, `materialBeschreibung`) VALUES ('"
						+ bauteil.getId()
						+ "', '"
						+ bauteil.getName()
						+ "', '"
						+ bauteil.getBauteilBeschreibung()
						+ "', '"
						+ bauteil.getMaterialBeschreibung() + "');");

			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		
		
		
		/*
		 * Rückgabe, des evtl. korrigierten Bauteil.
		 * 
		 * HINWEIS: Da in Java nur Referenzen auf Objekte und keine physischen
		 * Objekte übergeben werden, wäre die Anpassung des bauteil-Objekts auch
		 * ohne diese explizite Rückgabe au�erhalb dieser Methode sichtbar. Die
		 * explizite Rückgabe von bauteil ist eher ein Stilmittel, um zu
		 * signalisieren, dass sich das Objekt evtl. im Laufe der Methode
		 * verändert hat.
		 */
		return bauteil;
	}
	
	
	
	
	
	
}
	  

