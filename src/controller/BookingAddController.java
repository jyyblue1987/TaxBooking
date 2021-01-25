package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.DataAccess;
import services.Teleportation;

import java.sql.ResultSet;
import java.sql.SQLException;

// database


public class BookingAddController {

	Teleportation tele = new Teleportation();

	@FXML 
	private Button home = new Button();


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

}