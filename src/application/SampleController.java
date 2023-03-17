package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import kds.Dashboard;
import skp.Staff_Page;




public class SampleController implements Initializable {
	@FXML
    private Button sign;
	
	  @FXML
	    private TextField passwd;

	    @FXML
	    private TextField uname;
	    
	    @FXML
	    private CheckBox checkbox;
	    
	    @FXML
	    private PasswordField pwd;

    @FXML
    void sign_in(ActionEvent event) {
    	//JOptionPane.showMessageDialog(null, "event");
    	validateLogin();

    	final Node Source=(Node)event.getSource();
    	final Stage stage=(Stage)Source.getScene().getWindow();
    	stage.close();

      
        }
    
    @FXML
    void check_clicked(MouseEvent event) {
    	if(checkbox.isSelected()) {
    		passwd.setText(pwd.getText());
    		passwd.setVisible(true);
    		pwd.setVisible(false);
    	}else {
    	pwd.setText(passwd.getText());
    	pwd.setVisible(true);
    	passwd.setVisible(false);}
    }
    
    
    
    
    public void validateLogin() {
    	 ConnectionClass conn = new ConnectionClass();
         Connection connectDb = conn.getConnection();
         String query = "SELECT count(1) FROM login WHERE Name = '" + uname.getText() + "' AND Password = '" + pwd.getText()+"'";
         String query1 = "SELECT count(1) FROM staff WHERE Name = '" + uname.getText() + "' AND Password = '" + pwd.getText()+"'";
         
          try {
			Statement st = connectDb.createStatement();
			Statement st1 = connectDb.createStatement();
			ResultSet queryOutput = st.executeQuery(query);
			ResultSet queryOutput1 = st1.executeQuery(query1);
			
			
			while(queryOutput.next() && queryOutput1.next()) {
				if(queryOutput.getInt(1)==1) {
					//JOptionPane.showMessageDialog(null, "Login Successfully");
					new Dashboard();
					
				}else if(queryOutput1.getInt(1)==1) {
					new Staff_Page();
					
				}else {
					JOptionPane.showMessageDialog(null, "Wrong Credentials");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    	

	@Override
	public  void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
