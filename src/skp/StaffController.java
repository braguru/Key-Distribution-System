package skp;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import application.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import kds.DashboardController;



public class StaffController implements Initializable {
		@FXML
	    private Button Addbtn;

	    @FXML
	    private AnchorPane acc_tab;

	    @FXML
	    private CheckBox check;

	    @FXML
	    private Button clearbtn;

	    @FXML
	    private Button clearbtn1;

	    @FXML
	    private AnchorPane issue_page;

	    @FXML
	    private AnchorPane issue_tab;

	    @FXML
	    private TableView<Staff_Stu_Table> issue_table;

	    @FXML
	    private AnchorPane log_page;

	    @FXML
	    private TextField log_search;

	    @FXML
	    private AnchorPane log_tab;
	    
	    @FXML
	    private TableView<LogTable> log_table;

	    @FXML
	    private TableColumn<LogTable, String> log_tab1;

	    @FXML
	    private TableColumn<LogTable, String> log_tab2;
	    
	    @FXML
	    private TableColumn<LogTable, String> log_tab3;
	    
	    @FXML
	    private TableColumn<LogTable, String> log_tab4;

	    @FXML
	    private TableColumn<Staff_Stu_Table, String> name_col;

	    @FXML
	    private TableColumn<Staff_Stu_Table, String> room_col;

	    @FXML
	    private TextField room_search;

	    @FXML
	    private AnchorPane settings_page;

	    @FXML
	    private TextField txt_id;

	    @FXML
	    private TextField txt_name;
	    
	    @FXML
	    private TextField txt_time;

	    @FXML
	    private TextField txt_password;

	    @FXML
	    private TextField txt_room;

	    @FXML
	    private TextField txt_username;

	    @FXML
	    private Button updatebtn;

	    @FXML
	    void add_log(ActionEvent event) {
	    	addLog();
	    }
	    
//	    @FXML
//	    void update(ActionEvent event) {
//	    	UpdateStaff();
//	    }
	    
	    @FXML
	    void update(MouseEvent event) {
	    	UpdateStaff();
	    }
	    
	    @FXML
	    void clear(MouseEvent event) {
	    	ClearUpdateFields();
	    }

	    @FXML
	    void check_room(ActionEvent event) {
	    	check();
	    }

	    @FXML
	    void clear_room(ActionEvent event) {
	    	ClearLogFiels();
	    }
	    
	    @FXML
	    void issue_clicked(MouseEvent event) {
	    	issue_page.setVisible(true);
	    	log_page.setVisible(false);
	    	settings_page.setVisible(false);
	    }
	    
	    @FXML
	    void log_clicked(MouseEvent event) {
	    	issue_page.setVisible(false);
	    	log_page.setVisible(true);
	    	settings_page.setVisible(false);
	    }
	    
	    @FXML
	    void acc_clicked(MouseEvent event) {
	    	issue_page.setVisible(false);
	    	log_page.setVisible(false);
	    	settings_page.setVisible(true);
	    }
	    
	    String query=null;
	    Connection connection =null;
	    PreparedStatement preparedstatement = null;
	    ResultSet resultSet = null;
	    
	    
	    public void initialize(URL arg0, ResourceBundle arg1) {
	    	loadtable();
	    	check();
	    	LoadLog();
	    }
	    
	    
	    ObservableList<Staff_Stu_Table> LoadList = FXCollections.observableArrayList();
	    
	    public void loadtable() {
	    	// TODO Auto-generated method stub
			LoadList.clear();
			
			connection = ConnectionClass.getConnection();
			
			//SQL query - Execute in the backend database
	    	query = "SELECT room, name FROM students";
			try {
				preparedstatement = connection.prepareStatement(query);
				resultSet = preparedstatement.executeQuery();
				while(resultSet.next()) {
					String name = resultSet.getString("Name");
					String room = resultSet.getString("Room");
					
					LoadList.add(new Staff_Stu_Table(name, room));
					
					//propertyValueFactory corresponds to the StudentsTbl fields
					//The table column is the one you annotate above
					name_col.setCellValueFactory(new PropertyValueFactory<>("Name"));
					room_col.setCellValueFactory(new PropertyValueFactory<>("Room"));
					
					issue_table.setItems(LoadList);
					
					name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
					room_col.setCellValueFactory(new PropertyValueFactory<>("room"));
					
					
					
					
					//Initial filtered List
					FilteredList<Staff_Stu_Table> filteredData = new FilteredList<>(LoadList, b -> true);
					
					//If no search value then displays all records or whatever records it currently has.
					room_search.textProperty().addListener((observable, oldValue, newValue) -> {
						filteredData.setPredicate(LoadList ->{
							if(newValue.isEmpty() || newValue.isBlank() || newValue == null) {
								return true;
							}
							
							String searchKeyword = newValue.toLowerCase();
							
							if(LoadList.getName().toLowerCase().indexOf(searchKeyword) > -1) {
								return true; //There is a match in Name
							}else if(LoadList.getRoom().toLowerCase().indexOf(searchKeyword) > -1) {
								return true; //There is a match by Room Number
							}else
								return false; // no match found
						});		
					});
				
					SortedList<Staff_Stu_Table> sortedData = new SortedList<>(filteredData);
					// Bind sorted result with table view
					sortedData.comparatorProperty().bind(issue_table.comparatorProperty());
					
					//Apply filtered and sorted data to the Table View
					issue_table.setItems(sortedData);
				}
				}catch (SQLException e) {
				Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, e);
			}
		
			issue_table.setRowFactory(a -> {
				TableRow<Staff_Stu_Table> myRow = new TableRow<>();
				myRow.setOnMouseClicked (event -> {
					if(event.getClickCount()== 1 && (!myRow.isEmpty())) {
						int myIndex = issue_table.getSelectionModel().getSelectedIndex();
			
						txt_name.setText(issue_table.getItems().get(myIndex).getName());
					
						txt_room.setText(issue_table.getItems().get(myIndex).getRoom());
						}	
					});
				return myRow;
			});
		}

	    
	    public void addLog() {
	    	connection = ConnectionClass.getConnection();
			 query = "INSERT INTO log (name, room, date, status) VALUES (?,?,?,?)";
			 
			 String name = txt_name.getText();
			 String date = txt_time.getText();
			 String room = txt_room.getText();
			 String status = check();
			 
			 if(name.isEmpty() ||  room.isEmpty()) {
				 JOptionPane.showMessageDialog(null, "Please enter all details");
			 }else {
				 try {
					preparedstatement = connection.prepareStatement(query);
					preparedstatement.setString(1, name); 
					preparedstatement.setString(2, room);
					preparedstatement.setString(3, date);
					preparedstatement.setString(4, status);
					
					preparedstatement.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Added successfully");
					
					check();
					loadtable();
					LoadLog();
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, e);
				}
			 }
	    }

	 
//	    public static String getTime() {
//	    		  LocalDate date = LocalDate.now();
//	    		  return date.toString();
//		
//		}
	 
	  
	    public void ClearLogFiels() {
			txt_room.clear();
			txt_name.clear();
			txt_time.clear();
		}

	    public void UpdateStaff() {
			connection = ConnectionClass.getConnection();
		//	int myIndex = staffTable.getSelectionModel().getSelectedIndex();
			 String name = txt_username.getText();
			 String password = txt_password.getText();
			
			 
			 query = "UPDATE staff set Name = ?, Password = ? WHERE Staff_ID = '" +txt_id.getText() + "'";
			 
			 try {
					preparedstatement = connection.prepareStatement(query);
					preparedstatement.setString(1, name);
					preparedstatement.setString(2, password);
				
					
					preparedstatement.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Updated successfully");
					
					
				} catch (SQLException e) {   
					//System.err.println(e.getMessage());
					// TODO Auto-generated catch block
					Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, e);
				}
		}

	    
	   public void ClearUpdateFields() {
		txt_id.clear();
		txt_username.clear();
		txt_password.clear();
	}
	   
	  
	   public String check() {
		   String status = "taken";
		if (check.isSelected()) {
			status = "taken";
			
		}else {
			status = "brought";
			
		}
		return status;
	}
	   
	   
	   ObservableList<LogTable> Loadlog = FXCollections.observableArrayList();
	   public void LoadLog() {
			// TODO Auto-generated method stub
			Loadlog.clear();
			
			connection = ConnectionClass.getConnection();
			
			//SQL query - Execute in the backend database
	    	query = "SELECT * FROM log";
			try {
				preparedstatement = connection.prepareStatement(query);
				resultSet = preparedstatement.executeQuery();
				while(resultSet.next()) {
					String name = resultSet.getString("Name");
					String room = resultSet.getString("Room");
					String date = resultSet.getString("Date");
					String status = resultSet.getString("Status");
					
					Loadlog.add(new LogTable(name, room, date, status));
					
					//propertyValueFactory corresponds to the StudentsTbl fields
					//The table column is the one you annotate above
					log_tab1.setCellValueFactory(new PropertyValueFactory<>("Name"));
					log_tab2.setCellValueFactory(new PropertyValueFactory<>("Room"));
					log_tab3.setCellValueFactory(new PropertyValueFactory<>("Date"));
					log_tab4.setCellValueFactory(new PropertyValueFactory<>("Status"));
					
					log_table.setItems(Loadlog);
					
					log_tab1.setCellValueFactory(new PropertyValueFactory<>("name"));
					log_tab2.setCellValueFactory(new PropertyValueFactory<>("room"));
					log_tab3.setCellValueFactory(new PropertyValueFactory<>("date"));
					log_tab4.setCellValueFactory(new PropertyValueFactory<>("status"));
					
					
					
					//Initial filtered List
					FilteredList<LogTable> filteredData = new FilteredList<>(Loadlog, b -> true);
					
					//If no search value then displays all records or whatever records it currently has.
					log_search.textProperty().addListener((observable, oldValue, newValue) -> {
						filteredData.setPredicate(Loadlog ->{
							if(newValue.isEmpty() || newValue.isBlank() || newValue == null) {
								return true;
							}
							
							String searchKeyword = newValue.toLowerCase();
							
							if(Loadlog.getName().toLowerCase().indexOf(searchKeyword) > -1) {
								return true; //There is a match in Name
							}else if(Loadlog.getRoom().toLowerCase().indexOf(searchKeyword) > -1) {
								return true; //There is a match by Room Number
							}else if(Loadlog.getDate().toLowerCase().indexOf(searchKeyword) > -1) {
								return true; //There is a match by Room Number
							}else if(Loadlog.getStatus().toLowerCase().indexOf(searchKeyword) > -1) {
								return true; //There is a match by Room Number
							}else
								return false; // no match found
						});		
					});
				
					SortedList<LogTable> sortedData = new SortedList<>(filteredData);
					// Bind sorted result with table view
					sortedData.comparatorProperty().bind(log_table.comparatorProperty());
					
					//Apply filtered and sorted data to the Table View
					log_table.setItems(sortedData);
				}
				}catch (SQLException e) {
				Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, e);
			}
		
	}
	   
	   
	   
}

