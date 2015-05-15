package de.hdm.myproject.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Project implements EntryPoint {
	
	
	
 	HorizontalPanel menuPanel = new HorizontalPanel();
	Button bauteilButton = new Button(" Bauteil ");
	Button baugruppeButton = new Button(" Baugruppe ");
	Button enderzeugnisButton = new Button(" Enderzeugnis ");
	Button stuecklistenButton = new Button(" Stueckliste ");
	
	
	public void onModuleLoad() {
   
		menuPanel.add(bauteilButton);
		menuPanel.add(baugruppeButton);
		menuPanel.add(enderzeugnisButton);
		menuPanel.add(stuecklistenButton);
		
		
		
		
  }
}
