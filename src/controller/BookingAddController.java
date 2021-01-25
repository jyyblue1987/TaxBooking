package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Booking;
import services.DataAccess;
import services.Teleportation;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

// database


public class BookingAddController {

	Teleportation tele = new Teleportation();

	@FXML 
	private Button home = new Button();

	@FXML
	private TextField txtName = new TextField();

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
	private DatePicker dtDeparture = new DatePicker();

	@FXML
	private DatePicker dtReturn = new DatePicker();

	@FXML
	private TextField txtBusID = new TextField();


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

	@FXML
	public void onSubmit (ActionEvent e) throws Exception {
		Parent root;

		String fxml = "/fxml/booking_confirm.fxml";

		try {
			FXMLLoader loader = new FXMLLoader();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Confirmation");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			loader.setLocation(getClass().getResource(fxml));

			root = loader.load();

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/css/app.css").toExternalForm());

			dialogStage.setScene(scene);

			BookingConfirmController controller = loader.getController();
			Booking booking = new Booking(
					txtName.getText(),
					txtPhone.getText(),
					txtEmail.getText(),
					txtAddress.getText(),
					txtCity.getText(),
					txtCardNumber.getText(),
					txtCode.getText(),
					dtDeparture.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
					dtReturn.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
					txtBusID.getText()
			);

			controller.initBooking(booking);

			dialogStage.showAndWait();

			if( controller.isOkClicked() )
			{
				boolean isOK = false;
			}



		} catch(Exception exp){
			System.out.println(exp);
		}

	}


}