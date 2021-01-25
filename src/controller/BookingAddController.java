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
import services.Admins;
import services.DataAccess;
import services.Teleportation;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
	private TextField txtCardNumber = new TextField();

	@FXML
	private TextField txtCode = new TextField();

	@FXML
	private DatePicker dtDeparture = new DatePicker();

	@FXML
	private DatePicker dtReturn = new DatePicker();

	@FXML
	private void initialize(){
		dtDeparture.setValue(LocalDate.now());
		dtReturn.setValue(LocalDate.now());
	}


	/*
	routes home button to admin section
	*/
	@FXML
	public void onClear (ActionEvent e) throws Exception {
		clearInput();
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

			String bus_id = "";
            DataAccess da=new DataAccess();
            ResultSet rs = null;

            String query = "SELECT * from buses where active = 1 limit 1";

            rs = da.getData(query);

            try {
                if (rs.next()) {
                    bus_id = rs.getString("model");
                }
                da.close();
            } catch(SQLException q){
                tele.pop("Error: Please contact developers");
            }

            BookingConfirmController controller = loader.getController();
			Booking booking = new Booking(
					txtName.getText(),
					txtPhone.getText(),
					txtEmail.getText(),
					txtCardNumber.getText(),
					txtCode.getText(),
					dtDeparture.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
					dtReturn.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                    bus_id,
                    "", ""
			);

			controller.initBooking(booking);
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			if( controller.isOkClicked() )
			{
				clearInput();
			}



		} catch(Exception exp){
			System.out.println(exp);
		}

	}


	private void clearInput() {
		txtName.setText("");
		txtPhone.setText("");
		txtEmail.setText("");
		txtCardNumber.setText("");
		txtCode.setText("");
		dtDeparture.setValue(LocalDate.now());
		dtReturn.setValue(LocalDate.now());
	}

}