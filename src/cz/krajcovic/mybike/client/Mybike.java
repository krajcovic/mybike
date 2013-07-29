package cz.krajcovic.mybike.client;

import cz.krajcovic.mybike.client.service.BikeCallback;
import cz.krajcovic.mybike.client.service.BikeService;
import cz.krajcovic.mybike.client.service.BikeServiceAsync;
import cz.krajcovic.mybike.client.table.FormatedTable;
import cz.krajcovic.mybike.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Mybike implements EntryPoint {

	private FormatedTable table;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		createBikeTable();

		createWelcomeDialogBox();

		createAboutButton();
	}

	private void createWelcomeDialogBox() {
		// Create the dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Welcome to GWT Server Communication!");
		dialogBox.setAnimationEnabled(true);
		Button closeButton = new Button("Close");
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.setWidth("100%");
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
		dialogVPanel.add(closeButton);

		closeButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent arg0) {
				dialogBox.hide();

			}
		});

		dialogBox.setWidget(dialogVPanel);
	}

	private void createBikeTable() {
		table = new FormatedTable(null);

		Button button = new Button("Click me");

		// We can add style names
		button.addStyleName("pc-template-btn");

		VerticalPanel vPanel = new VerticalPanel();
		vPanel.setWidth("100%");
		vPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
		vPanel.add(button);

		vPanel.add(table);

		RootPanel.get().add(vPanel);
		
		button.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent arg0) {
				BikeServiceAsync bikeService = GWT.create(BikeService.class);
				ServiceDefTarget serviceDef = (ServiceDefTarget) bikeService;
				serviceDef.setServiceEntryPoint(GWT.getModuleBaseURL()+"bikeservice");
				BikeCallback bikeCallback = new BikeCallback(table);
				bikeService.getUserBikes(bikeCallback);
				
			}
		});
	}

	private void createAboutButton() {
		Button buttonAbout = new Button("About");
		buttonAbout.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent arg0) {
				Window.alert("Application MyBike under development");
			}
		});

		RootPanel.get().add(buttonAbout);
	}
}
