package skp;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Staff_Page extends Stage{
	public  Staff_Page() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Staff.fxml"));
			Scene scene = new Scene(root,1200,650);
			scene.getStylesheets().add(getClass().getResource("Staff.css").toExternalForm());
			this.setScene(scene);
			this.show();
			
			this.setOnCloseRequest(event -> {
				event.consume();
			log_out(scene);
			});

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	 void log_out(Scene scene) {
	   	 
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	alert.setContentText("Are you sure you want to logout");
	    	if(alert.showAndWait().get()== ButtonType.OK) {
	    		//final Node Source=(Node)event.getSource();
		    	
	    		javafx.application.Platform.exit();
		    	new Main();
	    	}
	    }	
}
