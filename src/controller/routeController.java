package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.*;
import javafx.event.EventHandler;

import model.Booking;
import services.Teleportation;
import services.DataAccess;
import services.routeModel;

//imports the main login file to 
// get the login info
import services.login; 

// date
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


// database
import java.sql.ResultSet;
import java.sql.SQLException;

public class routeController {

	Teleportation tele = new Teleportation();

	/*
	acts similer to session variable 
	takes these data to next page
	*/
	public static int daily_schedule_id; 
	public static String schedule_to; 
	public static String schedule_from; 
	public static String schedule_fare; 

	public static Scene schedule_scene;

	/*@FXML
	Button ticket = new Button();*/
	@FXML
	Button admin = new Button();
	@FXML
	Button bus = new Button();
	@FXML
	Button settings = new Button();
	@FXML
	Button logout = new Button();


	@FXML
	TextField search = new TextField();

	@FXML
	private TableView<Booking> table = new TableView<>();

	@FXML
	private TableColumn<routeModel,String> name = new TableColumn<>();
	@FXML
	private TableColumn<routeModel,String> phone = new TableColumn<>();
	@FXML
	private TableColumn<routeModel,String> email = new TableColumn<>();
	@FXML
	private TableColumn<routeModel,String> address = new TableColumn<>();
	@FXML
	private TableColumn<routeModel,String> city = new TableColumn<>();
	@FXML
	private TableColumn<routeModel,String> bus_id = new TableColumn<>();
	@FXML
	private TableColumn<routeModel,String> bus_name = new TableColumn<>();
	@FXML
	private TableColumn<routeModel,String> capacity = new TableColumn<>();


	@FXML
	private TableColumn<routeModel,String> departure = new TableColumn<>();
	@FXML
	private TableColumn<routeModel,String> return1 = new TableColumn<>();


	/*
	checks when thread will stop
	*/
	int checker = 0;

	@FXML
	private void initialize() {
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
		email.setCellValueFactory(new PropertyValueFactory<>("email"));
		address.setCellValueFactory(new PropertyValueFactory<>("address"));
		city.setCellValueFactory(new PropertyValueFactory<>("city"));
		bus_name.setCellValueFactory(new PropertyValueFactory<>("bus_name"));
		bus_id.setCellValueFactory(new PropertyValueFactory<>("bus_id"));
		capacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));
		departure.setCellValueFactory(new PropertyValueFactory<>("departure"));
		return1.setCellValueFactory(new PropertyValueFactory<>("return_date"));

		table.setItems(getBookingHisotry());


		/*
		new thread to check update in table
		calls getRoute()
		*/
		Thread t = new Thread(new Runnable() {
			@Override
			public void run(){
				while (checker != 1) {
					
					ObservableList<Booking> history = FXCollections.observableArrayList();
					history = getBookingHisotry();

					table.setItems(history);


					/*
					if the searchbox is filled then the table will update accordingly
					*/ 
					if (history.isEmpty() == false) {
						if (search.getText().equals("") == false) {
							updateTable();
						} else {
							table.setItems(history);
						}						
					}


					try{Thread.sleep(1000);}catch(Exception e){}				
				}
			}
		});

		t.start();




		/*
		handles double click 
		*/
		table.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
			}
		});
	}


	/*
	routes app to different pages
	*/

	@FXML	
	public void Routing (ActionEvent e) {
		if(e.getSource() == logout){
			Parent root;
			Stage stage;

			stage = (Stage) admin.getScene().getWindow();
			login l = new login();
			l.name = ""; 
			l.pass = ""; 
			l.start(stage);

		} else if(e.getSource() == admin){
			checker = 1;
			tele.changeTo(admin, "Admin.fxml");

		} else if(e.getSource() == bus){
			checker = 1;
			tele.changeTo(bus, "bus.fxml");

		} else if(e.getSource() == settings){
			checker = 1;
			tele.changeTo(settings, "Settings.fxml");
		} 	

	}


	/*
	geta all the routes from database and returns observable data for table 
	another thread calls this function periodically to check if any update occured in the table
	*/
	public ObservableList<Booking> getBookingHisotry(){
		ObservableList<Booking> routes = FXCollections.observableArrayList();

		DataAccess da=new DataAccess();
		ResultSet rs=null;

		String q = new String("SELECT a.*, b.* FROM booking_history as a left join buses as b on a.bus_id = b.model group by a.id");

		rs=da.getData(q);

		try {
			while(rs.next()){
				String name = rs.getString("name");
				String phone = rs.getString("name");
				String email = rs.getString("name");
				String address = rs.getString("name");
				String city = rs.getString("name");
				String bus_id = rs.getString("name");
				String bus_name = rs.getString("name");
				String capacity = rs.getString("name");
				String departure = rs.getString("departure");
				String return1 = rs.getString("return");


				routes.add(new Booking(name, phone, email, address, city, "", "", departure, return1, bus_id, bus_name, capacity));
			}

		} catch(SQLException a){
			System.out.println(a);			
		}
		
		/* 
		confirming that db closes 
		*/
		finally {
			try {
				da.close();
			} catch(SQLException exp){

			}
		}  
		return routes;
	}


	/*
	updates table according to user input	
	*/
	public void updateTable(){
		ObservableList<Booking> history = FXCollections.observableArrayList();

		for (Booking t : table.getItems()) {
			if (
					like(t.name, search.getText()) ||
							like(t.phone, search.getText()) ||
							like(t.email, search.getText()) ||
							like(t.address, search.getText()) ||
							like(t.city, search.getText()) ||
							like(t.departure, search.getText()) ||
							like(t.return_date, search.getText()) ||
							like(t.bus_id, search.getText()) ||
							like(t.bus_name, search.getText()) ||
							like(t.capacity, search.getText())
			)
			{
				history.add(new Booking(t.name, t.phone, t.email, t.address, t.city, t.card_number, t.card_code, t.departure, t.return_date, t.bus_id, t.bus_name, t.capacity));
			}

		}

		table.setItems(history);
	}


	/*
	simulates sql LIKE 
	*/
	public static boolean like(String str, String expr) {
		expr = expr.toLowerCase(); 
		str = str.toLowerCase();
		return str.matches("(.*)"+expr+"(.*)");
	}

}