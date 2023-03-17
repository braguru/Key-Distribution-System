package kds;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.JOptionPane;

import application.ConnectionClass;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DashboardController implements Initializable{
	   @FXML
	    private Pane Dash;

	    @FXML
	    private Button add1btn;

	    @FXML
	    private Button cls1btn;

	    @FXML
	    private AnchorPane dashboard_page;


	    @FXML
	    private Button del1btn;

	    @FXML
	    private Button edit1btn;
	    
	    @FXML
	    private TableView<StudentsTbl> studentsTable;

	    @FXML
	    private TableColumn<StudentsTbl, String> emailCol;

	    @FXML
	    private TableColumn<StudentsTbl, String> idCol;

	    @FXML
	    private TableColumn<StudentsTbl, String> levelCol;

	    @FXML
	    private TableColumn<StudentsTbl, String> nameCol;

	    @FXML
	    private TableColumn<StudentsTbl, String> phoneCol;
	    
	    @FXML
	    private TableColumn<StudentsTbl, String> dateCol;
	    
	    @FXML
	    private TableColumn<StudentsTbl, String> DepCol;

	    @FXML
	    private TableColumn<StudentsTbl, String> RoomCol;
	    
	    @FXML
	    private TableColumn<StudentsTbl, String> blockCol;

	    @FXML
	    private Pane rooms;

	    @FXML
	    private AnchorPane rooms_page;

	    @FXML
	    private Pane staff;

	    @FXML
	    private AnchorPane staff_page;

	    @FXML
	    private Pane students;

	    @FXML
	    private AnchorPane students_page;

	    @FXML
	    private TextField txt_Dep;

	    @FXML
	    private TextField txt_block;

	    @FXML
	    private TextField txt_email;

	    @FXML
	    private TextField txt_level;

	    @FXML
	    private TextField txt_stuPhone;

	    @FXML
	    private TextField txt_stuRoom;

	    @FXML
	    private TextField txt_studate;

	    @FXML
	    private TextField txt_stuid;

	    @FXML
	    private TextField txt_stuname;
	    
	    @FXML
	    private TextField Search_field;
	    
	    @FXML
	    private Button Add_staff;
	    
	    @FXML
	    private Button ClearStaff;
	    
	    @FXML
	    private Button DeleteStaff;
	    
	    @FXML
	    private TextField staffname;
	    
	    @FXML
	    private Button UpdateStaff;
	    
	    @FXML
	    private TextField staffDOB;

	    @FXML
	    private TextField staffPhone_number;
	    
	    @FXML
	    private TextField StaffEmail;

	    @FXML
	    private TextField Staffgender;

	    @FXML
	    private TextField StaffSearhfld;

	    @FXML
	    private TableView<StaffTable> staffTable;

	    @FXML
	    private TableColumn<StaffTable, String> Staff_DOB_Col;

	    @FXML
	    private TableColumn<StaffTable, String> Staff_Email_Col;

	    @FXML
	    private TextField Staff_ID;

	    @FXML
	    private TableColumn<StaffTable, String> Staff_ID_Col;

	    @FXML
	    private TableColumn<StaffTable, String> Staff_Phone_Col;

	    @FXML
	    private TableColumn<StaffTable, String> Staff_gender_Col;

	    
	    @FXML
	    private TableColumn<StaffTable, String> Staff_name_Col;
	    
	    
	    


	    @FXML
	    void getAdd(MouseEvent event) {
	    	AddStudent();
	    	loadData();
	    }

	    @FXML
	    void getClear(MouseEvent event) {
	    		ClearStudentFields();
	    }

	    @FXML
	    void getDel(MouseEvent event) {
	    	DeleteStudent();
	    }

	    @FXML
	    void getEdit(MouseEvent event) {
	    	UpdateStudent();
	    }
	    
	    @FXML
	    void Add_Staff_Clicked(MouseEvent event) {
	    	AddStaff();
	    }
	    
	    @FXML
	    void Delete_staff_clicked(MouseEvent event) {
	    	DeleteStaff();
	    }
	    
	    @FXML
	    void StaffGender_clicked(MouseEvent event) {

	    }
	    
	    @FXML
	    void Update_Staff_clicked(MouseEvent event) {
	    	UpdateStaff();
	    }
	    
	    @FXML
	    void Clear_staff_clicked(MouseEvent event) {
	    	ClearStaffFields();
	    }
	    
	    @FXML
	    void log_out(MouseEvent event) {
	    	 
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	alert.setContentText("Are you sure you want to logout");
	    	if(alert.showAndWait().get()== ButtonType.OK) {
	    		final Node Source=(Node)event.getSource();
		    	final Stage stage=(Stage)Source.getScene().getWindow();
		    	stage.close();
		    	new Main();
	    	}
	    	
	    }
	    
	    @FXML
	    void RoomSearch_clicked(MouseEvent event) {

	    }
	    
	 
	    @FXML
	    private Button Delete_room;


	    @FXML
	    private TextField Room_search;

	    @FXML
	    private Button Update_room;

	    @FXML
	    private Button add_room;

	    @FXML
	    private TextField block;


	    @FXML
	    private TableColumn<RoomTable, String> block_col;

	    @FXML
	    private Button clear_room;

	    @FXML
	    private AnchorPane logOut;

	    @FXML
	    private TextField num_occ;

	    @FXML
	    private TableColumn<RoomTable, String> num_occ_col;


	    @FXML
	    private TextField room_num;

	    @FXML
	    private TableColumn<RoomTable, String> room_number_col;

	    @FXML
	    private TableView<RoomTable> room_table;

	    @FXML
	    private TextField room_type;
	    
	    @FXML
	    private TextField txt_username;
	    
	    @FXML
	    private TextField txt_password;

	    @FXML
	    private TableColumn<RoomTable, String> room_type_col;
	    
	    @FXML
	    private Circle Settings;
	    
	    @FXML
	    private AnchorPane settings_page;
	    

	    @FXML
	    private Button savebtn;
	    
	    @FXML
	    private Text txt_totalstaff;
	    
	    @FXML
	    private Text txt_totalstudents;
	    
	    @FXML
	    private Text txt_totalrooms;
	    
	    @FXML
	    private Text txt_level100s;
	    
	    @FXML
	    private Text txt_level200s;
	    
	    @FXML
	    private Text txt_level300s;
	    
	    @FXML
	    private Text txt_level400s;
	    
	    @FXML
	    private Text txt_totalflats;
	    
	    @FXML
	    private Text txt_totalflatlets;
	    
	    @FXML
	    private Text txt_totalnormals;

	    @FXML
	    void AddRoom_clicked(MouseEvent event) {
	    	AddRoom();
	    }


	    @FXML
	    void DeleteRoom_clicked(MouseEvent event) {
	    	DeleteRoom();
	    }

	   

	    @FXML
	    void UpdateRoom_clicked(MouseEvent event) {
	    	UpdateRoom();
	    }

	  

	    @FXML
	    void clear_clicked(MouseEvent event) {
	    	ClearRoomFields();
	    }


    @FXML
    void dashboard_clicked(MouseEvent event) {
    	dashboard_page.setVisible(true);
    	staff_page.setVisible(false);
    	students_page.setVisible(false);
    	rooms_page.setVisible(false);
    	settings_page.setVisible(false);
    	
    }

    @FXML
    void rooms_clicked(MouseEvent event) {
    	dashboard_page.setVisible(false);
    	staff_page.setVisible(false);
    	students_page.setVisible(false);
    	rooms_page.setVisible(true);
    	settings_page.setVisible(false);
    }

    @FXML
    void staff_clicked(MouseEvent event) {
    	dashboard_page.setVisible(false);
    	staff_page.setVisible(true);
    	students_page.setVisible(false);
    	rooms_page.setVisible(false);
    	settings_page.setVisible(false);
    }

    @FXML
    void students_clicked(MouseEvent event) {
    	dashboard_page.setVisible(false);
    	staff_page.setVisible(false);
    	students_page.setVisible(true);
    	rooms_page.setVisible(false);
    	settings_page.setVisible(false);
    }
    

    @FXML
    void settings(MouseEvent event) {
    	settings_page.setVisible(true);
    	dashboard_page.setVisible(false);
    	staff_page.setVisible(false);
    	students_page.setVisible(false);
    	rooms_page.setVisible(false);
    }
    

    @FXML
    void save(ActionEvent event) {
    	SaveAdmin();
    }

  
    
    String query=null;
    Connection connection =null;
    PreparedStatement preparedstatement = null;
    ResultSet resultSet = null;
    StudentsTbl student = null;
    
   // ObservableList<StudentsTbl> StudentList = FXCollections.observableArrayList();
    //Populate the observableList
    ObservableList<StudentsTbl> StudentList = FXCollections.observableArrayList();
    
    
    
    public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		loadData();
		
		//StaffGender.setItems(list);
		
		loadStaffData();
		
		loadRoomTable();
		
		CountStaff();
		
		DisplayTotalStaff();
		
		DisplayTotalStudents();
		
		DisplayTotalRooms();
		
		DisplayTotalLevel100s();
		
		DisplayTotalLevel200s();
		
		DisplayTotalLevel300s();
		
		DisplayTotalLevel400s();
		
		DisplayTotalFlatlets();
		
		DisplayTotalFlats();
		
		DisplayTotalNormalRooms();
	}

	private void loadData() {
		// TODO Auto-generated method stub
		StudentList.clear();
		
		connection = ConnectionClass.getConnection();
		
		//SQL query - Execute in the backend database
    	query = "SELECT * FROM students";
		try {
			preparedstatement = connection.prepareStatement(query);
			resultSet = preparedstatement.executeQuery();
			while(resultSet.next()) {
				String name = resultSet.getString("Name");
				String DOB = resultSet.getString("Date_Of_Birth");
				String student_id = resultSet.getString("Student_ID");
				String department = resultSet.getString("Department");
				int level = resultSet.getInt("Level");
				String email = resultSet.getString("Email");
				String phone_number = resultSet.getString("Phone_Number");
				String block = resultSet.getString("Block");
				String room = resultSet.getString("Room");
				
				StudentList.add(new StudentsTbl(name, DOB, student_id, department, level, email, phone_number, block, room));
				
				//propertyValueFactory corresponds to the StudentsTbl fields
				//The table column is the one you annotate above
				nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
				dateCol.setCellValueFactory(new PropertyValueFactory<>("Date_Of_Birth"));
				idCol.setCellValueFactory(new PropertyValueFactory<>("Student_ID"));
				DepCol.setCellValueFactory(new PropertyValueFactory<>("Department"));
				levelCol.setCellValueFactory(new PropertyValueFactory<>("Level"));
				emailCol.setCellValueFactory(new PropertyValueFactory<>("Email"));
				phoneCol.setCellValueFactory(new PropertyValueFactory<>("Phone_Number"));
				blockCol.setCellValueFactory(new PropertyValueFactory<>("Block"));
				RoomCol.setCellValueFactory(new PropertyValueFactory<>("Room"));
				
				studentsTable.setItems(StudentList);
				
				idCol.setCellValueFactory(new PropertyValueFactory<>("student_id"));
				nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
				dateCol.setCellValueFactory(new PropertyValueFactory<>("birth"));
				emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
				levelCol.setCellValueFactory(new PropertyValueFactory<>("level"));
				phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
				DepCol.setCellValueFactory(new PropertyValueFactory<>("department"));
				RoomCol.setCellValueFactory(new PropertyValueFactory<>("room"));
				blockCol.setCellValueFactory(new PropertyValueFactory<>("block"));
				
				
				
				//Initial filtered List
				FilteredList<StudentsTbl> filteredData = new FilteredList<>(StudentList, b -> true);
				
				//If no search value then displays all records or whatever records it currently has.
				Search_field.textProperty().addListener((observable, oldValue, newValue) -> {
					filteredData.setPredicate(StudentList ->{
						if(newValue.isEmpty() || newValue.isBlank() || newValue == null) {
							return true;
						}
						
						String searchKeyword = newValue.toLowerCase();
						
						if(StudentList.getName().toLowerCase().indexOf(searchKeyword) > -1) {
							return true; //There is a match in Name
						}else if(StudentList.getStudent_id().toLowerCase().indexOf(searchKeyword) > -1) {
							return true; //There is a match by student Id
						}else if(StudentList.getEmail().toLowerCase().indexOf(searchKeyword) > -1) {
							return true; //There is a match by Email
						}else if(Integer.toString(StudentList.getLevel()).indexOf(searchKeyword) > -1) {
							return true; //There is a match by Level
						}else if(StudentList.getBirth().toLowerCase().indexOf(searchKeyword) > -1) {
							return true; //There is a match by Birth
						}else if(StudentList.getPhone_number().toLowerCase().indexOf(searchKeyword) > -1) {
							return true; //There is a match by Phone Number
						}else if(StudentList.getDepartment().toLowerCase().indexOf(searchKeyword) > -1) {
							return true; //There is a match by Department
						}else if(StudentList.getRoom().toLowerCase().indexOf(searchKeyword) > -1) {
							return true; //There is a match by Room Number
						}else if(StudentList.getBlock().toLowerCase().indexOf(searchKeyword) > -1) {
							return true; //There is a match by Block
						}else
							return false; // no match found
					});		
				});
			
				SortedList<StudentsTbl> sortedData = new SortedList<>(filteredData);
				// Bind sorted result with table view
				sortedData.comparatorProperty().bind(studentsTable.comparatorProperty());
				
				//Apply filtered and sorted data to the Table View
				studentsTable.setItems(sortedData);
			}
			}catch (SQLException e) {
			Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, e);
		}
	
		studentsTable.setRowFactory(a -> {
			TableRow<StudentsTbl> myRow = new TableRow<>();
			myRow.setOnMouseClicked (event -> {
				if(event.getClickCount()== 1 && (!myRow.isEmpty())) {
					int myIndex = studentsTable.getSelectionModel().getSelectedIndex();
					
					txt_stuid.setText(studentsTable.getItems().get(myIndex).getStudent_id());
					txt_stuname.setText(studentsTable.getItems().get(myIndex).getName());
					txt_studate.setText(studentsTable.getItems().get(myIndex).getBirth());
					txt_Dep.setText(studentsTable.getItems().get(myIndex).getDepartment());
					Integer.parseInt(String.valueOf((studentsTable.getItems().get(myIndex).getLevel())));
					txt_stuPhone.setText(studentsTable.getItems().get(myIndex).getPhone_number());
					txt_email.setText(studentsTable.getItems().get(myIndex).getEmail());
					txt_stuRoom.setText(studentsTable.getItems().get(myIndex).getRoom());
					txt_block.setText(studentsTable.getItems().get(myIndex).getBlock());				}	
				});
			return myRow;
		});

	}
	
	
	public void AddStudent() {
		connection = ConnectionClass.getConnection();
		 query = "INSERT INTO students (Name, Date_Of_Birth, Student_ID, Department, Level, Email, Phone_Number, Block, Room) VALUES (?,?,?,?,?,?,?,?,?) ";
		 
		 String name = txt_stuname.getText();
		 String birth = txt_studate.getText();
		 String id = txt_stuid.getText();
		 String department = txt_Dep.getText();
		 String level = txt_level.getText();
		 String email = txt_email.getText();
		 String phone = txt_stuPhone.getText();
		 String block = txt_block.getText();
		 String room = txt_stuRoom.getText();
		 
		 if(name.isEmpty() || birth.isEmpty() || id.isEmpty() || department.isEmpty() || level.isEmpty() || email.isEmpty() || phone.isEmpty() || block.isEmpty() || room.isEmpty()) {
			 JOptionPane.showMessageDialog(null, "Please enter all details");
		 }else {
			 try {
				preparedstatement = connection.prepareStatement(query);
				preparedstatement.setString(1, name);
				preparedstatement.setString(2, birth);
				preparedstatement.setString(3, id);
				preparedstatement.setString(4, department);
				preparedstatement.setString(5, level);
				preparedstatement.setString(6, email);
				preparedstatement.setString(7, phone);
				preparedstatement.setString(8, block);
				preparedstatement.setString(9, room);
				
				preparedstatement.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Student added successfully");
				
				loadData();
				DisplayTotalStudents();
				DisplayTotalLevel100s();
				DisplayTotalLevel200s();
				DisplayTotalLevel300s();
				DisplayTotalLevel400s();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, e);
			}
		 }
	}
	
	public void UpdateStudent() {
		
		int myIndex = studentsTable.getSelectionModel().getSelectedIndex();
		 
		 String name = txt_stuname.getText();
		 String birth = txt_studate.getText();
		 String id = txt_stuid.getText();
		 String department = txt_Dep.getText();
		 String level = txt_level.getText();
		 String email = txt_email.getText();
		 String phone = txt_stuPhone.getText();
		 String block = txt_block.getText();
		 String room = txt_stuRoom.getText();
		 
		 query = "UPDATE students set Name = ?, Date_Of_Birth = ?, Student_ID = ?, Department= ?, Level = ?, Email = ?, Phone_Number = ?, Block = ?, Room = ? WHERE Student_ID= '"+ txt_stuid.getText() + "'";
		// "Update Beverages set Name='" + txt_stuname.getText())+"'"+",Date_Of_Birth='"+txt_studate.getText();+"'"+",Student_IDe='"+txt_stuid.getText();+"'"+"where Id="+proId.getText();
         
		 try {
				preparedstatement = connection.prepareStatement(query);
				
				preparedstatement.setString(1, name);
				preparedstatement.setString(2, birth);
				preparedstatement.setString(3, id);
				preparedstatement.setString(4, department);
				preparedstatement.setString(5, level);
				preparedstatement.setString(6, email);
				preparedstatement.setString(7, phone);
				preparedstatement.setString(8, block);
				preparedstatement.setString(9, room);
				
				preparedstatement.executeUpdate(); 
				
				JOptionPane.showMessageDialog(null, "Updated successfully");
				
				loadData();
				DisplayTotalStudents();
				DisplayTotalLevel100s();
				DisplayTotalLevel200s();
				DisplayTotalLevel300s();
				DisplayTotalLevel400s();
			} catch (SQLException e) {
				//System.err.println(e.getMessage());
				// TODO Auto-generated catch block
				Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, e);
			}
	}
	
	
	public void DeleteStudent() {

		query = "DELETE FROM students WHERE Name = ?";
		 String name = txt_stuname.getText();
		 
		 
			try {
				preparedstatement = connection.prepareStatement(query);
				preparedstatement.setString(1, name);
				preparedstatement.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Deleted");
				
				loadData();
				DisplayTotalStaff();
				DisplayTotalLevel100s();
				DisplayTotalLevel200s();
				DisplayTotalLevel300s();
				DisplayTotalLevel400s();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, e);
			}
		 
	}
	
	 
	public void ClearStudentFields() {
		txt_stuid.clear();
		txt_block.clear();
		txt_Dep.clear();
		txt_email.clear();
		txt_level.clear();
		txt_studate.clear();
		txt_stuname.clear();
		txt_stuPhone.clear();
		txt_stuRoom.clear();
	}
	
	ObservableList<StaffTable> StaffList = FXCollections.observableArrayList();
	// ObservableList<String> list = FXCollections.observableArrayList("Male", "Female");
	 
	 
	public void loadStaffData() {
		StaffList.clear();
		
		connection = ConnectionClass.getConnection();
		
		//SQL query - Execute in the backend database
    	query = "SELECT * FROM staff";
		try {
			preparedstatement = connection.prepareStatement(query);
			resultSet = preparedstatement.executeQuery();
			while(resultSet.next()) {
				String name = resultSet.getString("Name");
				String DOB = resultSet.getString("Password");
				String staff_id = resultSet.getString("Staff_ID");
				String gender = resultSet.getString("Gender");
				String email = resultSet.getString("Email");
				String phone_number = resultSet.getString("Phone");
				
				StaffList.add(new StaffTable(name, gender, DOB, staff_id, phone_number, email));
				
				//propertyValueFactory corresponds to the StudentsTbl fields
				//The table column is the one you annotate above
				Staff_name_Col.setCellValueFactory(new PropertyValueFactory<>("Name"));
				Staff_gender_Col.setCellValueFactory(new PropertyValueFactory<>("Gender"));
				Staff_DOB_Col.setCellValueFactory(new PropertyValueFactory<>("Password"));
				Staff_ID_Col.setCellValueFactory(new PropertyValueFactory<>("Staff_ID"));
				Staff_Phone_Col.setCellValueFactory(new PropertyValueFactory<>("Phone"));
				Staff_Email_Col.setCellValueFactory(new PropertyValueFactory<>("Email"));
	
				staffTable.setItems(StaffList);
				
				Staff_name_Col.setCellValueFactory(new PropertyValueFactory<>("name"));
				Staff_gender_Col.setCellValueFactory(new PropertyValueFactory<>("gender"));
				Staff_DOB_Col.setCellValueFactory(new PropertyValueFactory<>("birth"));
				Staff_ID_Col.setCellValueFactory(new PropertyValueFactory<>("staff_id"));
				Staff_Phone_Col.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
				Staff_Email_Col.setCellValueFactory(new PropertyValueFactory<>("Email"));
				
				
				
				//Initial filtered List
				FilteredList<StaffTable> filteredData = new FilteredList<>(StaffList, b -> true);
				
				//If no search value then displays all records or whatever records it currently   has.
				StaffSearhfld.textProperty().addListener((observable, oldValue, newValue) -> {
					filteredData.setPredicate(StaffList ->{
						if(newValue.isEmpty() || newValue.isBlank() || newValue == null) {
							return true;
						}
						
						String searchKeyword = newValue.toLowerCase();
						
						if(StaffList.getName().toLowerCase().indexOf(searchKeyword) > -1) {
							return true; //There is a match in Name
						}else if(StaffList.getBirth().toLowerCase().indexOf(searchKeyword) > -1) {
							return true; //There is a match by Birth
						}else if(StaffList.getEmail().toLowerCase().indexOf(searchKeyword) > -1) {
							return true; //There is a match by Email
						}else if(StaffList.getStaff_id().toLowerCase().indexOf(searchKeyword) > -1) {
							return true; //There is a match by Id
						}else if(StaffList.getPhone_number().toLowerCase().indexOf(searchKeyword) > -1) {
							return true; //There is a match by Phone Number
						}else if(StaffList.getGender().toLowerCase().indexOf(searchKeyword) > -1) {
							return true; //There is a match by Gender
						}else
							return false; // no match found
					});		
				});
			
				SortedList<StaffTable> sortedData = new SortedList<>(filteredData);
				// Bind sorted result with table view
				sortedData.comparatorProperty().bind(staffTable.comparatorProperty());
				
				//Apply filtered and sorted data to the Table View
				staffTable.setItems(sortedData);
			}
			}catch (SQLException e) {
			Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, e);
		}
	
		staffTable.setRowFactory(a -> {
			TableRow<StaffTable> myRow = new TableRow<>();
			myRow.setOnMouseClicked (event -> {
				if(event.getClickCount()== 1 && (!myRow.isEmpty())) {
					int myIndex = staffTable.getSelectionModel().getSelectedIndex();
					
					staffname.setText(staffTable.getItems().get(myIndex).getName());
					Staffgender.setText(staffTable.getItems().get(myIndex).getGender());
					staffDOB.setText(staffTable.getItems().get(myIndex).getBirth());
					staffPhone_number.setText(staffTable.getItems().get(myIndex).getPhone_number());
					//Integer.parseInt(String.valueOf((staffTable.getItems().get(myIndex).getLevel())));
					Staff_ID.setText(staffTable.getItems().get(myIndex).getStaff_id());
					StaffEmail.setText(staffTable.getItems().get(myIndex).getEmail());
								}	
				});
			return myRow;
		});

	
	}
	
	public void AddStaff() {
		connection = ConnectionClass.getConnection();
		 query = "INSERT INTO staff (Name, Gender, Password, Staff_ID, Phone, Email) VALUES (?,?,?,?,?,?) ";
		 
		 String name = staffname.getText();
		 String birth = staffDOB.getText();
		 String id = Staff_ID.getText();
		 String email = StaffEmail.getText();
		 String phone = staffPhone_number.getText();
		 String gender = Staffgender.getText();
				 //StaffGender.getSelectionModel().getSelectedItem().toString();
		 
		 if(name.isEmpty() || birth.isEmpty() || id.isEmpty() ||  email.isEmpty() || phone.isEmpty() || gender.isEmpty()) {
			 JOptionPane.showMessageDialog(null, "Please enter all details");
		 }else {
			 try {
				preparedstatement = connection.prepareStatement(query);
				preparedstatement.setString(1, name);
				preparedstatement.setString(2, gender);
				preparedstatement.setString(3, birth);
				preparedstatement.setString(4, id);
				preparedstatement.setString(5, phone);
				preparedstatement.setString(6, email);
				
				
				preparedstatement.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Student added successfully");
				
				loadStaffData();
				DisplayTotalStaff();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, e);
			}
		 }
	}
	
	public void DeleteStaff() {
		query = "DELETE FROM staff WHERE Name = ?";
		 String name = staffname.getText();
		 
		 
			try {
				preparedstatement = connection.prepareStatement(query);
				preparedstatement.setString(1, name);
				preparedstatement.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Deleted");
				
				loadStaffData();
				DisplayTotalStaff();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, e);
			}
	}
	
	public void UpdateStaff() {
		connection = ConnectionClass.getConnection();
		int myIndex = staffTable.getSelectionModel().getSelectedIndex();
		 String name = staffname.getText();
		 String birth = staffDOB.getText();
		 String id = Staff_ID.getText();
		 String email = StaffEmail.getText();
		 String phone = staffPhone_number.getText();
		 String gender = Staffgender.getText();
				 //StaffGender.getSelectionModel().getSelectedItem().toString();
		 
		 query = "UPDATE staff set Name = ?, Gender= ?, Password = ?, Staff_ID = ?, Phone = ?, Email = ? WHERE Staff_ID = '" +Staff_ID.getText() + "'";
		 
		 try {
				preparedstatement = connection.prepareStatement(query);
				preparedstatement.setString(1, name);
				preparedstatement.setString(2, gender);
				preparedstatement.setString(3, birth);
				preparedstatement.setString(4, id);
				preparedstatement.setString(5, phone);
				preparedstatement.setString(6, email);
				
				preparedstatement.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Updated successfully");
				
				loadStaffData();
				DisplayTotalStaff();
			} catch (SQLException e) {   
				//System.err.println(e.getMessage());
				// TODO Auto-generated catch block
				Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, e);
			}
	}
	
	
	public void ClearStaffFields() {
		staffname.clear();
		Staffgender.clear();
		staffDOB.clear();
		staffPhone_number.clear();
		Staff_ID.clear();
		StaffEmail.clear();
	}

	public void AddRoom() {
		connection = ConnectionClass.getConnection();
		 query = "INSERT INTO room (room_type, block, number_of_occupants, room_number) VALUES (?,?,?,?) ";
		 
		 String roomType = room_type.getText();
		 String Block = block.getText();
		 String occupants = num_occ.getText();
		 String number = room_num.getText();
		
				 //StaffGender.getSelectionModel().getSelectedItem().toString();
		 
		 if(roomType.isEmpty() || Block.isEmpty() || occupants.isEmpty() ||  number.isEmpty()) {
			 JOptionPane.showMessageDialog(null, "Please enter all details");
		 }else {
			 try {
				preparedstatement = connection.prepareStatement(query);
				preparedstatement.setString(1, roomType);
				preparedstatement.setString(2, Block);
				preparedstatement.setString(3, occupants);
				preparedstatement.setString(4, number);
				
				
				preparedstatement.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Room added successfully");
				
				loadRoomTable();
				DisplayTotalRooms();
				DisplayTotalFlatlets();
				DisplayTotalFlats();
				DisplayTotalNormalRooms();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, e);
			}
		 }
	}
	
	
	
	ObservableList<RoomTable> RoomList = FXCollections.observableArrayList();
	

	public void loadRoomTable() {
		RoomList.clear();
		
		connection = ConnectionClass.getConnection();
		
		//SQL query - Execute in the backend database
    	query = "SELECT * FROM room";
		try {
			preparedstatement = connection.prepareStatement(query);
			resultSet = preparedstatement.executeQuery();
			while(resultSet.next()) {
				String roomType = resultSet.getString("room_type");
				String Block = resultSet.getString("block");
				String occupants = resultSet.getString("number_of_occupants");
				String number = resultSet.getString("room_number");
				
				
				RoomList.add(new RoomTable(roomType, Block, occupants, number));
				
				//propertyValueFactory corresponds to the StudentsTbl fields
				//The table column is the one you annotate above
				room_type_col.setCellValueFactory(new PropertyValueFactory<>("room_type"));
				block_col.setCellValueFactory(new PropertyValueFactory<>("block"));
				num_occ_col.setCellValueFactory(new PropertyValueFactory<>("number_of_occupants"));
				room_number_col.setCellValueFactory(new PropertyValueFactory<>("room_number"));
				
	
				room_table.setItems(RoomList);
				
				room_type_col.setCellValueFactory(new PropertyValueFactory<>("room_type"));
				block_col.setCellValueFactory(new PropertyValueFactory<>("block"));
				num_occ_col.setCellValueFactory(new PropertyValueFactory<>("number_of_occupants"));
				room_number_col.setCellValueFactory(new PropertyValueFactory<>("room_number"));
			
				
				
				
				//Initial filtered List
				FilteredList<RoomTable> filteredData = new FilteredList<>(RoomList, b -> true);
				
				//If no search value then displays all records or whatever records it currently   has.
				Room_search.textProperty().addListener((observable, oldValue, newValue) -> {
					filteredData.setPredicate(RoomList ->{
						if(newValue.isEmpty() || newValue.isBlank() || newValue == null) {
							return true;
						}
						
						String searchKeyword = newValue.toLowerCase();
						
						if(RoomList.getRoom_type().toLowerCase().indexOf(searchKeyword) > -1) {
							return true; //There is a match in Name
						}else if(RoomList.getRoom_number().toLowerCase().indexOf(searchKeyword) > -1) {
							return true; //There is a match by Birth
						}else if(RoomList.getNumber_of_occupants().toLowerCase().indexOf(searchKeyword) > -1) {
							return true; //There is a match by Email
						}else if(RoomList.getBlock().toLowerCase().indexOf(searchKeyword) > -1) {
							return true; //There is a match by Id
						}else
							return false; // no match found
					});		
				});
			
				SortedList<RoomTable> sortedData = new SortedList<>(filteredData);
				// Bind sorted result with table view
				sortedData.comparatorProperty().bind(room_table.comparatorProperty());
				
				//Apply filtered and sorted data to the Table View
				room_table.setItems(sortedData);
			}
			}catch (SQLException e) {
			Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, e);
		}
	
		room_table.setRowFactory(a -> {
			TableRow<RoomTable> myRow = new TableRow<>();
			myRow.setOnMouseClicked (event -> {
				if(event.getClickCount()== 1 && (!myRow.isEmpty())) {
					int myIndex = room_table.getSelectionModel().getSelectedIndex();
					
					room_type.setText(room_table.getItems().get(myIndex).getRoom_type());
					block.setText(room_table.getItems().get(myIndex).getBlock());
					num_occ.setText(room_table.getItems().get(myIndex).getNumber_of_occupants());
					room_num.setText(room_table.getItems().get(myIndex).getRoom_number());
				
								}	
				});
			return myRow;
		});
	}

	public void DeleteRoom() {
		query = "DELETE FROM room WHERE room_type = ?";
		 String Room_type = room_type.getText();
		 
		 
			try {
				preparedstatement = connection.prepareStatement(query);
				preparedstatement.setString(1, Room_type);
				preparedstatement.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Deleted");
				
				loadRoomTable();
				DisplayTotalRooms();
				DisplayTotalFlatlets();
				DisplayTotalFlats();
				DisplayTotalNormalRooms();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, e);
			}
		
	}

	private void UpdateRoom() {
		connection = ConnectionClass.getConnection();
		int myIndex = room_table.getSelectionModel().getSelectedIndex();
		 String Room_type = room_type.getText();
		 String Block = block.getText();
		 String occupants = num_occ.getText();
		 String number = room_num.getText();
		
		 
		 query = "UPDATE room set room_type= ?, block= ?, number_of_occupants = ?, room_number = ? WHERE room_type ='"+ room_type.getText() + "'" ;
		 
		 try {
				preparedstatement = connection.prepareStatement(query);
				preparedstatement.setString(1, Room_type);
				preparedstatement.setString(2, Block);
				preparedstatement.setString(3, occupants);
				preparedstatement.setString(4, number);
				
				
				preparedstatement.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Updated successfully");
				
				loadRoomTable();
				DisplayTotalRooms();
				DisplayTotalFlatlets();
				DisplayTotalFlats();
				DisplayTotalNormalRooms();
			} catch (SQLException e) {
				//System.err.println(e.getMessage());
				// TODO Auto-generated catch block
				Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, e);
			}

	}
	
	public void ClearRoomFields() {
		room_type.clear();
		block.clear();
		num_occ.clear();
		room_num.clear();
	}

	
	public void SaveAdmin() {
		connection = ConnectionClass.getConnection();
		query = "UPDATE login set Name = ?, Password= ? WHERE ID = 1";
		String name = txt_username.getText();
		String password = txt_password.getText();
		
		 try {
				preparedstatement = connection.prepareStatement(query);
				preparedstatement.setString(1, name);
				preparedstatement.setString(2, password);
				
				
				preparedstatement.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Saved");
				
				
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				// TODO Auto-generated catch block
				//Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, e);
			}
	}

	public String CountStaff() {
		connection = ConnectionClass.getConnection();
		
		query = "SELECT count(ID) as totalnumber from staff";
		int totalnumber = 0;
		
		try {
			
			preparedstatement = connection.prepareStatement(query);
			resultSet = preparedstatement.executeQuery();
			while(resultSet.next()) {
				totalnumber=resultSet.getInt("totalnumber");
			}
			
			preparedstatement.execute();
		}catch (SQLException e) {
			Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, e);
		}
//		txt_totalstaff.setText(query);
		return String.valueOf(totalnumber);
	}
	
	
	private void DisplayTotalStaff() {
		txt_totalstaff.setText(CountStaff());
		CountStaff();
	}
	
	
	public String CountTotalStudent() {
		connection = ConnectionClass.getConnection();
		
		query = "SELECT count(ID) as totalnumber from students";
		int totalnumber = 0;
		
		try {
			
			preparedstatement = connection.prepareStatement(query);
			resultSet = preparedstatement.executeQuery();
			while(resultSet.next()) {
				totalnumber=resultSet.getInt("totalnumber");
			}
			
			preparedstatement.execute();
		}catch (SQLException e) {
			Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, e);
		}
//		txt_totalstaff.setText(query);
		return String.valueOf(totalnumber);
	}
	
	private void DisplayTotalStudents() {
		txt_totalstudents.setText(CountTotalStudent());
		CountTotalStudent();
	}

	public String CountTotalRooms() {
connection = ConnectionClass.getConnection();
		
		query = "SELECT count(ID) as totalnumber from room";
		int totalnumber = 0;
		
		try {
			
			preparedstatement = connection.prepareStatement(query);
			resultSet = preparedstatement.executeQuery();
			while(resultSet.next()) {
				totalnumber=resultSet.getInt("totalnumber");
			}
			
			preparedstatement.execute();
		}catch (SQLException e) {
			Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, e);
		}
//		txt_totalstaff.setText(query);
		return String.valueOf(totalnumber);
	}
	
	private void DisplayTotalRooms() {
		txt_totalrooms.setText(CountTotalRooms());
		CountTotalRooms();
	}
	
	public String CountTotalLevel100s() {
		connection = ConnectionClass.getConnection();
		
		query = "SELECT count(ID) as totalnumber from students WHERE Level = \"100\"";
		int totalnumber = 0;
		
		try {
			
			preparedstatement = connection.prepareStatement(query);
			resultSet = preparedstatement.executeQuery();
			while(resultSet.next()) {
				totalnumber=resultSet.getInt("totalnumber");
			}
			
			preparedstatement.execute();
		}catch (SQLException e) {
			Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, e);
		}
//		txt_totalstaff.setText(query);
		return String.valueOf(totalnumber);
	}
	
	private void DisplayTotalLevel100s() {
		txt_level100s.setText(CountTotalLevel100s());
		CountTotalLevel100s();
	}
	
	public String CountTotalLevel200s() {
connection = ConnectionClass.getConnection();
		
		query = "SELECT count(ID) as totalnumber from students WHERE Level = \"200\"";
		int totalnumber = 0;
		
		try {
			
			preparedstatement = connection.prepareStatement(query);
			resultSet = preparedstatement.executeQuery();
			while(resultSet.next()) {
				totalnumber=resultSet.getInt("totalnumber");
			}
			
			preparedstatement.execute();
		}catch (SQLException e) {
			Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, e);
		}
//		txt_totalstaff.setText(query);
		return String.valueOf(totalnumber);
	}
	
	private void DisplayTotalLevel200s() {
		txt_level200s.setText(CountTotalLevel200s());
		CountTotalLevel200s();
	}
	
	public String CountTotalLevel300s() {
		connection = ConnectionClass.getConnection();
		
		query = "SELECT count(ID) as totalnumber from students WHERE Level = \"300\"";
		int totalnumber = 0;
		
		try {
			
			preparedstatement = connection.prepareStatement(query);
			resultSet = preparedstatement.executeQuery();
			while(resultSet.next()) {
				totalnumber=resultSet.getInt("totalnumber");
			}
			
			preparedstatement.execute();
		}catch (SQLException e) {
			Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, e);
		}
//		txt_totalstaff.setText(query);
		return String.valueOf(totalnumber);
	}
	
	private void DisplayTotalLevel300s() {
		txt_level300s.setText(CountTotalLevel300s());
		CountTotalLevel300s();
	}
	
	public String CountTotalLevel400s() {
connection = ConnectionClass.getConnection();
		
		query = "SELECT count(ID) as totalnumber from students WHERE Level = \"400\"";
		int totalnumber = 0;
		
		try {
			
			preparedstatement = connection.prepareStatement(query);
			resultSet = preparedstatement.executeQuery();
			while(resultSet.next()) {
				totalnumber=resultSet.getInt("totalnumber");
			}
			
			preparedstatement.execute();
		}catch (SQLException e) {
			Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, e);
		}
//		txt_totalstaff.setText(query);
		return String.valueOf(totalnumber);
	}
	
	private void DisplayTotalLevel400s() {
		txt_level400s.setText(CountTotalLevel400s());
		CountTotalLevel400s();
	}
	
	public String CountTotalFlats() {
		connection = ConnectionClass.getConnection();
		
		query = "SELECT count(ID) as totalnumber from room WHERE room_type = \"Flat\"";
		int totalnumber = 0;
		
		try {
			
			preparedstatement = connection.prepareStatement(query);
			resultSet = preparedstatement.executeQuery();
			while(resultSet.next()) {
				totalnumber=resultSet.getInt("totalnumber");
			}
			
			preparedstatement.execute();
		}catch (SQLException e) {
			Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, e);
		}
//		txt_totalstaff.setText(query);
		return String.valueOf(totalnumber);
	}
	
	private void DisplayTotalFlats() {
		txt_totalflats.setText(CountTotalFlats());
		CountTotalFlats();
	}
	
	public String CountTotalFlatlets() {
		connection = ConnectionClass.getConnection();
		
		query = "SELECT count(ID) as totalnumber from room WHERE room_type = \"Flatlet\"";
		int totalnumber = 0;
		
		try {
			
			preparedstatement = connection.prepareStatement(query);
			resultSet = preparedstatement.executeQuery();
			while(resultSet.next()) {
				totalnumber=resultSet.getInt("totalnumber");
			}
			
			preparedstatement.execute();
		}catch (SQLException e) {
			Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, e);
		}
//		txt_totalstaff.setText(query);
		return String.valueOf(totalnumber);
	}
	
	private void DisplayTotalFlatlets() {
		txt_totalflatlets.setText(CountTotalFlatlets());
		CountTotalFlatlets();
	}
	
	public String CountTotalNormaRooms() {
		connection = ConnectionClass.getConnection();
		
		query = "SELECT count(ID) as totalnumber from room WHERE room_type = \"Normal\"";
		int totalnumber = 0;
		
		try {
			
			preparedstatement = connection.prepareStatement(query);
			resultSet = preparedstatement.executeQuery();
			while(resultSet.next()) {
				totalnumber=resultSet.getInt("totalnumber");
			}
			
			preparedstatement.execute();
		}catch (SQLException e) {
			Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, e);
		}
//		txt_totalstaff.setText(query);
		return String.valueOf(totalnumber);
	}
	
	private void DisplayTotalNormalRooms() {
		txt_totalnormals.setText(CountTotalNormaRooms());
		CountTotalNormaRooms();
	}
	
	
	
	
	
	
	
}

