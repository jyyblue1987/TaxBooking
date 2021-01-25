package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Booking;
import services.Teleportation;

// database


public class BookingConfirmController {

	Teleportation tele = new Teleportation();

	@FXML
	private TextField txtName = new TextField();

	@FXML 
	private Button home = new Button();

	@FXML
	private TextField txtPhone = new TextField();

	@FXML
	private TextField txtEmail = new TextField();

	@FXML
	private TextField txtAddress = new TextField();

	@FXML
	private TextField txtCity = new TextField();

	@FXML
	private TextField txtCardNumber = new TextField();

	@FXML
	private TextField txtCode = new TextField();

	@FXML
	private Label txtDeparture = new Label();

	@FXML
	private Label txtReturn = new Label();

	@FXML
	private Label txtBusID = new Label();

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

	public void initBooking(Booking booking) {
		txtName.setText(booking.name);
		txtPhone.setText(booking.phone);
		txtEmail.setText(booking.email);
		txtAddress.setText(booking.address);
		txtCity.setText(booking.city);
		txtCardNumber.setText(booking.card_number);
		txtCode.setText(booking.card_code);
		txtDeparture.setText(booking.departure);
		txtReturn.setText(booking.return_date);
		txtBusID.setText(booking.bus_id);
	}

	public boolean isOkClicked() {
		return okClicked;
	}

}