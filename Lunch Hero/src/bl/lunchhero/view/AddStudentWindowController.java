package bl.lunchhero.view;

import java.io.FileWriter;
import java.io.IOException;

import bl.lunchhero.model.School;
import bl.lunchhero.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AddStudentWindowController
{
	
	School school = School.getSchool();
	
	@FXML
	Button createStudentBtn, goBackBtn, calculateStatusBtn;
	
	@FXML
	TextField lastNameField, firstNameField, studentNumberField, gradeLevelField, lunchStatusField;
	
	@FXML
	private void buttonHandler(ActionEvent event) throws IOException
	{
		
	    
	    if(event.getSource() == createStudentBtn)
	    {
	    	if (lastNameField.getText().trim().isEmpty() || firstNameField.getText().trim().isEmpty() || gradeLevelField.getText().trim().isEmpty() || lunchStatusField.getText().trim().isEmpty() || studentNumberField.getText().trim().isEmpty())
	    	{
	    		Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Missing Information");
				alert.setHeaderText("Student Add Unsucessful");
				alert.setContentText("Please add required information");

				alert.showAndWait();
	    	}
	    	else if (Integer.parseInt(lunchStatusField.getText()) > 1 && Integer.parseInt(lunchStatusField.getText()) < 5 && Integer.parseInt(gradeLevelField.getText()) <= 12)
	    	{
	    		
		    	String lastName = lastNameField.getText();
		    	String firstName = firstNameField.getText();
		    	int gradeLevel = Integer.parseInt(gradeLevelField.getText());
		    	int lunchStatus = Integer.parseInt(lunchStatusField.getText());
		    	int studentNumber = Integer.parseInt(studentNumberField.getText());
		    	
		    	if (school.getStudentByName(lastName, firstName) == null)
		    	{
		    		if(school.getStudentByNumber(studentNumber) != null)
		    		{
		    			Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Student Exists");
						alert.setHeaderText("Duplicate Entry");
						alert.setContentText("Student Number: " + studentNumber + " already exists");
						
						alert.showAndWait();
		    		}
		    		else if (school.getStudentByNumber(studentNumber) == null) 
		    		{
		    			school.addStudent(lastName, firstName, gradeLevel, lunchStatus, studentNumber);
				    	
				    	Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Student Added");
						alert.setHeaderText("Student Add Sucessful");
						alert.setContentText(firstNameField.getText() + " " + lastNameField.getText() + " has been added!");

						alert.showAndWait();
						
						FileWriter writer = new FileWriter("C://Users/Public/Documents/Lunch Hero/LLCS-Students.txt");
						for(Student s : school.getStudents())
						{
							writer.write(s.getLastName() + "," + s.getFirstName() + "," + s.getGradeLevel() + "," + s.getLunchStatus() + "," + s.getStudentNumber() + "\n");
						}
						writer.close();
		    		}
		    		
		    	}
		    	else 
		    	{
		    		Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Student Exists");
					alert.setHeaderText("Duplicate Entry");
					alert.setContentText(firstNameField.getText() + " " + lastNameField.getText() + " already exists");

					alert.showAndWait();
		    	}
	
				
	    	}
	    	else
	    	{
	    		Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Missing Information");
				alert.setHeaderText("Student Add Unsucessful");
				alert.setContentText("Lunch Status must be either a 2, 3, 4. Grade Level must be 0-12");

				alert.showAndWait();
	    	}
	    	
	    	
			
	    }
	    else if(event.getSource() == goBackBtn)
	     {
	    	 Stage stage; 
		     Parent root;
	    	 stage=(Stage) goBackBtn.getScene().getWindow();
	    	 root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
	    	 
	    	 Scene scene = new Scene(root);
	         stage.setScene(scene);
	         stage.show();
	     }
	    else if(event.getSource() == calculateStatusBtn)
	     {
	    	Stage stage; 
		    Parent root;
	    	stage=(Stage) calculateStatusBtn.getScene().getWindow();
	    	root = FXMLLoader.load(getClass().getResource("FRCalculatorWindow.fxml"));
	    	
	    	Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	     }

	}
}
