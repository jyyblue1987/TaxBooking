import javafx.application.Application;
import javafx.stage.Stage;

import services.login;

public class Start extends Application {
	public static void main(String args[]){
		launch(args);
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {        
		/*
		Calles the login file to start the program.
		*/	

		Stage stage = new Stage(); 
		login l = new login();
		l.start(stage);	
	}
	
}	
