package edu.tridenttech.cpt237.lemons.finalproject.view;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.security.auth.callback.Callback;

import edu.tridenttech.cpt237.lemons.finalproject.model.School;
import edu.tridenttech.cpt237.lemons.finalproject.model.Student;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ViewStudentsController implements Initializable
{
	School school = School.getSchool();
	private ArrayList<Student> students = new ArrayList<Student>();
	private ObservableList<String> studentListing = FXCollections.observableArrayList();  
	private String[] studentName;
	private String firstName;
	private String lastName;

	@FXML
	private ListView<String> studentList;
	
	@FXML
	private Button cancel, addStudentBtn, deleteStudentBtn, viewStudentBtn;
	
	@FXML
	private void buttonHandler(ActionEvent event) throws IOException
	{
		
	     
	     
	     if(event.getSource() == cancel)
	     {
	    	 Stage stage = null; 
	 	     Parent root = null;
	    	 stage=(Stage) cancel.getScene().getWindow();
	    	 root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
	    	 Scene scene = new Scene(root);
	         stage.setScene(scene);
	         stage.show();
	 	    	 
	     }
	     else if(event.getSource() == addStudentBtn)
	     {
	    	 Stage stage = null; 
	 	     Parent root = null;
	    	 stage=(Stage) addStudentBtn.getScene().getWindow();
	    	 root = FXMLLoader.load(getClass().getResource("AddNewStudentWindow.fxml"));
	    	 Scene scene = new Scene(root);
	         stage.setScene(scene);
	         stage.show();
	 	    	 
	     }
	     else if(event.getSource() == deleteStudentBtn)
	     {

	    	 school.removeStudent(lastName, firstName);
	    	 studentListing.remove(studentList.getSelectionModel().getSelectedIndex());
	    	 
	    	 FileWriter writer = new FileWriter("C://Users/Public/Documents/Lunch Hero/LLCS-Students.txt");
	    	 
	    	 for(Student s : school.getStudents())
	    	 {
				writer.write(s.getLastName() + "," + s.getFirstName() + "," + s.getGradeLevel() + "," + s.getLunchStatus() + "," + s.getStudentNumber() + "\n");
	    	 }
				writer.close();


	     }
	     else if(event.getSource() == viewStudentBtn)
	     {

	    	 Stage stage = null; 
	 	     Parent root = null;
	    	 stage=(Stage) viewStudentBtn.getScene().getWindow();
	    	 root = FXMLLoader.load(getClass().getResource("ViewStudentInfoWindow.fxml"));
	    	 Scene scene = new Scene(root);
	         stage.setScene(scene);
	         stage.show();
	 	    	 
	     }
	     
	}
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		
		students.addAll(school.getStudents());
		for (Student s : students)
		{
			studentListing.add(s.getFirstName() + " " + s.getLastName());
		}
		studentList.setItems(studentListing);
		
		
		studentList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
   	 {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2)
			{
				studentName = (arg2.split("\\s+"));
				System.out.println(arg2);
				firstName = studentName[0];
		    	lastName = studentName[1];
		    	school.storeStudent(school.getStudentByName(lastName, firstName));
				

				
			}
   	 });
		
	}

}


