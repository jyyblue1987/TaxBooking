package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Booking;
import services.DataAccess;
import services.Teleportation;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

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

	@FXML
	private Label txtTotalCost = new Label();

	@FXML
	private Label txtTotalFees = new Label();

	private boolean okClicked = false;

	private Stage dialogStage;

	private float m_fCosts = 0;
	private float m_fFees = 0;


	@FXML
	private void initialize(){
		okClicked = false;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
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

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			Date firstDate = sdf.parse(booking.departure);
			Date secondDate = sdf.parse(booking.return_date);

			long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
			long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS) + 1;

			if( diff < 1 )
				diff = 1;

			m_fCosts = diff * 50;
			m_fFees = m_fCosts * 0.1f;

			txtTotalCost.setText(m_fCosts + "$");
			txtTotalFees.setText(m_fFees + "$");
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	/*
	routes home button to admin section
	*/
	@FXML
	public void onSave(ActionEvent e) throws Exception {
		DataAccess da=new DataAccess();

		String sql = String.format("INSERT INTO booking_history (name, phone, email, address, city, card_number, card_code, departure, `return`, bus_id, costs, fees) " +
				"VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s',%.1f,%.1f)",
				txtName.getText(),
				txtPhone.getText(),
				txtEmail.getText(),
				txtAddress.getText(),
				txtCity.getText(),
				txtCardNumber.getText(),
				txtCode.getText(),
				txtDeparture.getText(),
				txtReturn.getText(),
				txtBusID.getText(),
				m_fCosts, m_fFees
				);
		try {
			da.updateDB(sql);
			da.close();

			tele.pop("Inserted!!!");
			okClicked = true;

			dialogStage.close();
		} catch(SQLException a){
			tele.pop("Error: Please contact developers");
		}


	}

	@FXML
	public void onCancel(ActionEvent e) throws Exception {
		dialogStage.close();
	}



	public boolean isOkClicked() {
		return okClicked;
	}

}