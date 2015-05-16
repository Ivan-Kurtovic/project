package de.hdm.myproject.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.myproject.shared.bo.ItProject;


public interface ReportGeneratorAsync {

	void init(AsyncCallback<Void> initReportGeneratorCallback);


	void setItProject(ItProject project, AsyncCallback<Void> callback);

	
		
	}


