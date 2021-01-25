package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import services.Teleportation;

// database


public class BookingConfirmController {

	Teleportation tele = new Teleportation();

	@FXML 
	private Button home = new Button();

	private boolean okClicked = false;

	@FXML
	private void initialize(){
	}


	/*
	routes home button to admin section
	*/
	@FXML
	public void Routing (ActionEvent e) throws Exception {
		tele.changeTo(home, "route.fxml");
	}

	public boolean isOkClicked() {
		return okClicked;
	}

}