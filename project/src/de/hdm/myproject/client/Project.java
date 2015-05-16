package de.hdm.myproject.client;


import com.google.gwt.core.client.*;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import de.hdm.myproject.shared.ReportGeneratorAsync;
import de.hdm.myproject.shared.StuecklistenAdministrationAsync;
import de.hdm.myproject.shared.bo.ItProject;





/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Project implements EntryPoint {
	
	
	/**
	   * Da diese Klasse die Implementierung des Interface <code>EntryPoint</code>
	   * zusichert, ben�tigen wir eine Methode
	   * <code>public void onModuleLoad()</code>. Diese ist das GWT-Pendant der
	   * <code>main()</code>-Methode normaler Java-Applikationen.
	   */
	
	public void onModuleLoad() {
   
		/*
	     * Zun�chst weisen wir der BankAdministration eine Bank-Instanz zu, die das
	     * Kreditinstitut repr�sentieren soll, f�r das diese Applikation arbeitet.
	     */
	    StuecklistenAdministrationAsync projectVerwaltung = ClientsideSettings.getItProjectVerwaltung();
	    ItProject project = new ItProject();
	    project.setVerantwortlicher("Team2");
	    project.setBearbeiter("WI7");
	    project.setNummer(1234);
	    project.setDatum("01.07.2015");
	    projectVerwaltung.setItProject(project, new SetItProjectCallback());

		
	    /*
	     * Auch dem Report-Generator weisen wir dieses ItProject-Objekt zu. Es wird dort
	     * f�r die Darstellung der Adressdaten des Kreditinstituts ben�tigt.
	     */
	    ReportGeneratorAsync reportGenerator = ClientsideSettings
	        .getReportGenerator();
	    reportGenerator.setItProject(project, new SetItProjectCallback());
	    
	    
	    /*
	     * Wir bereiten nun die Erstellung eines bescheidenen Navigators vor, der
	     * einige Schaltfl�chen (Buttons) f�r die Ausf�hrung von Unterprogrammen
	     * enthalten soll.
	     * 
	     * Die jeweils ausgef�hrten Unterprogramme sind Demonstratoren
	     * exemplarischer Anwendungsf�lle des Systems. Auf eine professionelle
	     * Gestaltung der Benutzungsschnittstelle wurde bewusst verzichtet, um den
	     * Blick nicht von den wesentlichen Funktionen abzulenken. Eine
	     * exemplarische GUI-Realisierung findet sich separat.
	     * 
	     * Die Demonstratoren werden nachfolgend als Showcase bezeichnet. Aus diesem
	     * Grund existiert auch eine Basisklasse f�r s�mtliche Showcase-Klassen
	     * namens Showcase.
	     */

	    /*
	     * Der Navigator ist als einspaltige Aneinanderreihung von Buttons
	     * realisiert. Daher bietet sich ein VerticalPanel als Container an.
	     */
	    
	    
	    
	    
	    VerticalPanel navPanel = new VerticalPanel();

	    /*
	     * Das VerticalPanel wird einem DIV-Element namens "Navigator" in der
	     * zugeh�rigen HTML-Datei zugewiesen und erh�lt so seinen Darstellungsort.
	     */
	    RootPanel.get("Navigator").add(navPanel);

	    /*
	     * Ab hier bauen wir sukzessive den Navigator mit seinen Buttons aus.
	     */

	    /*
	     * Neues Button Widget erzeugen und eine Beschriftung festlegen.
	     */
	    final Button findBauteilButton = new Button("Finde Bauteil");

	    /*
	     * Unter welchem Namen k�nnen wir den Button durch die CSS-Datei des
	     * Projekts formatieren?
	     */
	    findBauteilButton.setStylePrimaryName("project-menubutton");

	    /*
	     * Hinzuf�gen des Buttons zum VerticalPanel.
	     */
	    navPanel.add(findBauteilButton);
	    
	    
	    /*
	     * Nat�rlich ben�tigt der Button auch ein Verhalten, wenn man mit der Maus
	     * auf ihn klickt. Hierzu registrieren wir einen ClickHandler, dessen
	     * onClick()-Methode beim Mausklick auf den zugeh�rigen Button aufgerufen
	     * wird.
	     */
	    findBauteilButton.addClickHandler(new ClickHandler() {
	      @Override
		public void onClick(ClickEvent event) {
	        /*
	         * Showcase instantiieren.
	         */
	        Showcase showcase = new FindBauteilByNameDemo();

	        /*
	         * F�r die Ausgaben haben wir ein separates DIV-Element namens "Details"
	         * in die zugeh�rige HTML-Datei eingef�gt. Bevor wir den neuen Showcase
	         * dort einbetten, l�schen wir vorsichtshalber s�mtliche bisherigen
	         * Elemente dieses DIV.
	         */
	        RootPanel.get("Details").clear();
	        RootPanel.get("Details").add(showcase);
	      }
	    });
		
	    
	    
	    /*
	     * Ab hier folgen weitere Button-Definitionen, die nach exakt der gleichen
	     * Methode erfolgen wie beim ersten Button.
	     * 
	     * Da das Muster dazu sich mehrfach wiederholt, k�nnte man hier schon von
	     * einem unerw�nschte Code Clone sprechen. Um dies stilistisch zu optimieren
	     * w�re z.B. die Verwendung des Factory oder Builder Pattern denkbar. 
	     * Hierauf wurde jedoch bewusst verzichtet, um den Komplexit�tsgrad dieses
	     * Demonstrators nicht unn�tig zu erh�hen. 
	     */
	    final Button createBauteilButton = new Button("Bauteil anlegen");
	    createBauteilButton.setStylePrimaryName("project-menubutton");
	    navPanel.add(createBauteilButton);

	    createBauteilButton.addClickHandler(new ClickHandler() {
	      @Override
		public void onClick(ClickEvent event) {
	        Showcase showcase = new CreateBauteilDemo();
	        RootPanel.get("Details").clear();
	        RootPanel.get("Details").add(showcase);
	      }
	    });
		
	 // N�chste Button-Definition
	    final Button deleteBauteilButton = new Button("Bauteil l�schen");
	    deleteBauteilButton.setStylePrimaryName("project-menubutton");
	    navPanel.add(deleteBauteilButton);

	    deleteBauteilButton.addClickHandler(new ClickHandler() {
	      @Override
		public void onClick(ClickEvent event) {
	        Showcase showcase = new DeleteBauteilDemo();
	        RootPanel.get("Details").clear();
	        RootPanel.get("Details").add(showcase);
	      }
	    });

	    // N�chste Button-Definition
	    final Button deleteBaugruppeButton = new Button("Baugruppe l�schen");
	    deleteBaugruppeButton.setStylePrimaryName("project-menubutton");
	    navPanel.add(deleteBaugruppeButton);

	    deleteBaugruppeButton.addClickHandler(new ClickHandler() {
	      @Override
		public void onClick(ClickEvent event) {
	        Showcase showcase = new DeleteBaugruppeDemo();
	        RootPanel.get("Details").clear();
	        RootPanel.get("Details").add(showcase);
	      }
	    });

	    // N�chste Button-Definition
	    final Button showAllBaugruppeAndBauteilButton = new Button(
	        "Baugruppe & Bauteil zeigen");
	    showAllBaugruppeAndBauteilButton
	        .setStylePrimaryName("project-menubutton");
	    navPanel.add(showAllBaugruppeAndBauteilButton);

	    showAllBaugruppeAndBauteilButton.addClickHandler(new ClickHandler() {
	      @Override
		public void onClick(ClickEvent event) {
	        Showcase showcase = new ShowAllBaugruppeAndTheirBauteilDemo();
	        RootPanel.get("Details").clear();
	        RootPanel.get("Details").add(showcase);
	      }
	    });

	    // N�chste Button-Definition
	    final Button showReportButton = new Button("Report zu Kd. 1");
	    showReportButton.setStylePrimaryName("project-menubutton");
	    navPanel.add(showReportButton);

	    showReportButton.addClickHandler(new ClickHandler() {
	      @Override
		public void onClick(ClickEvent event) {
	        Showcase showcase = new ShowReportDemo();
	        RootPanel.get("Details").clear();
	        RootPanel.get("Details").add(showcase);
	      }
	    });
	}
}
	    
	    
/**
 * Diese Nested Class wird als Callback f�r das Setzen des ItProject-Objekts bei
 * der StuecklistenAdministration und bei dem ReportGenerator ben�tigt.
 * 
 * 
 */
class SetItProjectCallback implements AsyncCallback<Void> {

  @Override
  public void onFailure(Throwable caught) {
    /*
     * Wenn ein Fehler auftritt, dann geben wir eine kurze Log Message aus.
     */
    ClientsideSettings.getLogger().severe("Setzen des Project fehlgeschlagen!");
  }

  @Override
  public void onSuccess(Void result) {
    /*
     * Wir erwarten diesen Ausgang, wollen aber keine Notifikation ausgeben.
     */
  }


}

