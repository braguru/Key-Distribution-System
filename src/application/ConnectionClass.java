package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import kds.Dashboard;

public class ConnectionClass {
	public Connection connection;
			
	
	public static Connection getConnection(){
	String dbName = "kds";
	String userName = "root";
	String password = "Sherry";
	
	try {
		//Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,userName,password);
		return connection;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	

	
}
	
}
