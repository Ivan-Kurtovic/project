package de.hdm.myproject.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.myproject.server.db.BauteilMapper;
import de.hdm.myproject.shared.StuecklistenAdministration;
import de.hdm.myproject.shared.bo.Bauteil;



/**
 * <p>
 * Implementierungsklasse des Interface <code>StuecklistenAdministration</code>. Diese
 * Klasse ist <em>die</em> Klasse, die neben {@link ReportGeneratorImpl}
 * s�mtliche Applikationslogik (oder engl. Business Logic) aggregiert. Sie ist
 * wie eine Spinne, die s�mtliche Zusammenh�nge in ihrem Netz (in unserem Fall
 * die Daten der Applikation) �berblickt und f�r einen geordneten Ablauf und
 * dauerhafte Konsistenz der Daten und Abl�ufe sorgt.
 * </p>
 * <p>
 * Die Applikationslogik findet sich in den Methoden dieser Klasse. Jede dieser
 * Methoden kann als <em>Transaction Script</em> bezeichnet werden. Dieser Name
 * l�sst schon vermuten, dass hier analog zu Datenbanktransaktion pro
 * Transaktion gleiche mehrere Teilaktionen durchgef�hrt werden, die das System
 * von einem konsistenten Zustand in einen anderen, auch wieder konsistenten
 * Zustand �berf�hren. Wenn dies zwischenzeitig scheitern sollte, dann ist das
 * jeweilige Transaction Script daf�r verwantwortlich, eine Fehlerbehandlung
 * durchzuf�hren.
 * </p>
 * <p>
 * Diese Klasse steht mit einer Reihe weiterer Datentypen in Verbindung. Dies
 * sind:
 * <ol>
 * <li>{@link StuecklistenAdministration}: Dies ist das <em>lokale</em> - also
 * Server-seitige - Interface, das die im System zur Verf�gung gestellten
 * Funktionen deklariert.</li>
 * <li>{@link StuecklistenAdministrationAsync}: <code>StuecklistenAdministrationImpl</code> und
 * <code>StuecklistenAdministration</code> bilden nur die Server-seitige Sicht der
 * Applikationslogik ab. Diese basiert vollst�ndig auf synchronen
 * Funktionsaufrufen. Wir m�ssen jedoch in der Lage sein, Client-seitige
 * asynchrone Aufrufe zu bedienen. Dies bedingt ein weiteres Interface, das in
 * der Regel genauso benannt wird, wie das synchrone Interface, jedoch mit dem
 * zus�tzlichen Suffix "Async". Es steht nur mittelbar mit dieser Klasse in
 * Verbindung. Die Erstellung und Pflege der Async Interfaces wird durch das
 * Google Plugin semiautomatisch unterst�tzt. Weitere Informationen unter
 * {@link StuecklistenAdministrationAsync}.</li>
 * <li> {@link RemoteServiceServlet}: Jede Server-seitig instantiierbare und
 * Client-seitig �ber GWT RPC nutzbare Klasse muss die Klasse
 * <code>RemoteServiceServlet</code> implementieren. Sie legt die funktionale
 * Basis f�r die Anbindung von <code>StuecklistenAdminstrationImpl</code> an die Runtime
 * des GWT RPC-Mechanismus.</li>
 * </ol>
 * </p>
 * <p>
 * <b>Wichtiger Hinweis:</b> Diese Klasse bedient sich sogenannter
 * Mapper-Klassen. Sie geh�ren der Datenbank-Schicht an und bilden die
 * objektorientierte Sicht der Applikationslogik auf die relationale
 * organisierte Datenbank ab. Zuweilen kommen "kreative" Zeitgenossen auf die
 * Idee, in diesen Mappern auch Applikationslogik zu realisieren. Siehe dazu
 * auch die Hinweise in {@link #delete(Bauteil)} Einzig nachvollziehbares
 * Argument f�r einen solchen Ansatz ist die Steigerung der Performance
 * umfangreicher Datenbankoperationen. Doch auch dieses Argument zieht nur dann,
 * wenn wirklich gro�e Datenmengen zu handhaben sind. In einem solchen Fall
 * w�rde man jedoch eine entsprechend erweiterte Architektur realisieren, die
 * wiederum s�mtliche Applikationslogik in der Applikationsschicht isolieren
 * w�rde. Also, keine Applikationslogik in die Mapper-Klassen "stecken" sondern
 * dies auf die Applikationsschicht konzentrieren!
 * </p>
 * <p>
 * Beachten Sie, dass s�mtliche Methoden, die mittels GWT RPC aufgerufen werden
 * k�nnen ein <code>throws IllegalArgumentException</code> in der
 * Methodendeklaration aufweisen. Diese Methoden d�rfen also Instanzen von
 * {@link IllegalArgumentException} auswerfen. Mit diesen Exceptions k�nnen z.B.
 * Probleme auf der Server-Seite in einfacher Weise auf die Client-Seite
 * transportiert und dort systematisch in einem Catch-Block abgearbeitet werden.
 * </p>
 * <p>
 * 
 * </p>
 * 
 * @see StuecklistenAdministration
 * @see StuecklistenAdministrationAsync
 * @see RemoteServiceServlet
 * 
 */



public class StuecklistenAdministrationImpl extends RemoteServiceServlet
implements StuecklistenAdministration {

	
	private static final long serialVersionUID = 1L;
	
	
	/**
	   * Referenz auf den DatenbankMapper, der Bauteilobjekte mit der Datenbank
	   * abgleicht.
	   */
	private BauteilMapper bauteilMapper = null;
	
	
	
	
	
	/*
	   * Da diese Klasse ein gewisse Gr��e besitzt - dies ist eigentlich ein
	   * Hinweise, dass hier eine weitere Gliederung sinnvoll ist - haben wir zur
	   * besseren �bersicht Abschnittskomentare eingef�gt. Sie leiten ein Cluster in
	   * irgeneinerweise zusammengeh�riger Methoden ein. Ein entsprechender
	   * Kommentar steht am Ende eines solchen Clusters.
	   */

	  /*
	   * ***************************************************************************
	   * ABSCHNITT, Beginn: Initialisierung
	   * ***************************************************************************
	   */
	
	public StuecklistenAdministrationImpl() throws IllegalArgumentException {
	    /*
	     * Eine weitergehende Funktion muss der No-Argument-Constructor nicht haben.
	     * Er muss einfach vorhanden sein.
	     */
	  }
	
	
	/**
	   * Initialsierungsmethode. Siehe dazu Anmerkungen zum No-Argument-Konstruktor
	   * {@link #ReportGeneratorImpl()}. Diese Methode muss f�r jede Instanz von
	   * <code>StuecklistenAdministrationImpl</code> aufgerufen werden.
	   * 
	   * 
	   */
	  @Override 
	public void init() throws IllegalArgumentException {
	    /*
	     * Ganz wesentlich ist, dass die BankAdministration einen vollst�ndigen Satz
	     * von Mappern besitzt, mit deren Hilfe sie dann mit der Datenbank
	     * kommunizieren kann.
	     */
	    this.bauteilMapper = BauteilMapper.bauteilMapper();
	  }

	  /*
	   * ***************************************************************************
	   * ABSCHNITT, Ende: Initialisierung
	   * ***************************************************************************
	   */

	  /*
	   * ***************************************************************************
	   * ABSCHNITT, Beginn: Methoden f�r Customer-Objekte
	   * ***************************************************************************
	   */
	  
	  /**
	   * <p>
	   * Anlegen eines neuen Bauteils. Dies f�hrt implizit zu einem Speichern des
	   * neuen Bauteils in der Datenbank.
	   * </p>
	   * 
	   */
	  @Override
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
