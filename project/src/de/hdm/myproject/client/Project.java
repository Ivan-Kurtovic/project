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
	   * zusichert, benötigen wir eine Methode
	   * <code>public void onModuleLoad()</code>. Diese ist das GWT-Pendant der
	   * <code>main()</code>-Methode normaler Java-Applikationen.
	   */
	
	public void onModuleLoad() {
   
		/*
	     * Zunächst weisen wir der BankAdministration eine Bank-Instanz zu, die das
	     * Kreditinstitut repräsentieren soll, für das diese Applikation arbeitet.
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
	     * für die Darstellung der Adressdaten des Kreditinstituts benötigt.
	     */
	    ReportGeneratorAsync reportGenerator = ClientsideSettings
	        .getReportGenerator();
	    reportGenerator.setItProject(project, new SetItProjectCallback());
	    
	    
	    /*
	     * Wir bereiten nun die Erstellung eines bescheidenen Navigators vor, der
	     * einige Schaltflächen (Buttons) für die Ausführung von Unterprogrammen
	     * enthalten soll.
	     * 
	     * Die jeweils ausgeführten Unterprogramme sind Demonstratoren
	     * exemplarischer Anwendungsfälle des Systems. Auf eine professionelle
	     * Gestaltung der Benutzungsschnittstelle wurde bewusst verzichtet, um den
	     * Blick nicht von den wesentlichen Funktionen abzulenken. Eine
	     * exemplarische GUI-Realisierung findet sich separat.
	     * 
	     * Die Demonstratoren werden nachfolgend als Showcase bezeichnet. Aus diesem
	     * Grund existiert auch eine Basisklasse für sämtliche Showcase-Klassen
	     * namens Showcase.
	     */

	    /*
	     * Der Navigator ist als einspaltige Aneinanderreihung von Buttons
	     * realisiert. Daher bietet sich ein VerticalPanel als Container an.
	     */
	    
	    
	    
	    
	    VerticalPanel navPanel = new VerticalPanel();

	    /*
	     * Das VerticalPanel wird einem DIV-Element namens "Navigator" in der
	     * zugehörigen HTML-Datei zugewiesen und erhält so seinen Darstellungsort.
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
	     * Unter welchem Namen können wir den Button durch die CSS-Datei des
	     * Projekts formatieren?
	     */
	    findBauteilButton.setStylePrimaryName("project-menubutton");

	    /*
	     * Hinzufügen des Buttons zum VerticalPanel.
	     */
	    navPanel.add(findBauteilButton);
	    
	    
	    /*
	     * Natürlich benötigt der Button auch ein Verhalten, wenn man mit der Maus
	     * auf ihn klickt. Hierzu registrieren wir einen ClickHandler, dessen
	     * onClick()-Methode beim Mausklick auf den zugehörigen Button aufgerufen
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
	         * Für die Ausgaben haben wir ein separates DIV-Element namens "Details"
	         * in die zugehörige HTML-Datei eingefügt. Bevor wir den neuen Showcase
	         * dort einbetten, löschen wir vorsichtshalber sämtliche bisherigen
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
	     * Da das Muster dazu sich mehrfach wiederholt, könnte man hier schon von
	     * einem unerwünschte Code Clone sprechen. Um dies stilistisch zu optimieren
	     * wäre z.B. die Verwendung des Factory oder Builder Pattern denkbar. 
	     * Hierauf wurde jedoch bewusst verzichtet, um den Komplexitätsgrad dieses
	     * Demonstrators nicht unnötig zu erhöhen. 
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
		
	 // Nächste Button-Definition
	    final Button deleteBauteilButton = new Button("Bauteil löschen");
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

	    // Nächste Button-Definition
	    final Button deleteBaugruppeButton = new Button("Baugruppe löschen");
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

	    // Nächste Button-Definition
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

	    // Nächste Button-Definition
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
 * Diese Nested Class wird als Callback für das Setzen des ItProject-Objekts bei
 * der StuecklistenAdministration und bei dem ReportGenerator benötigt.
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

