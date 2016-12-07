package bl.lunchhero.view;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import bl.lunchhero.model.School;
import bl.lunchhero.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ViewStudentInfoController implements Initializable
{
	School school = School.getSchool();
	private String firstName;
	private String lastName;
	private int studentNumber;
	private int lunchStatus;
	private int gradeLevel;
	
	
	@FXML
	TextField studentNumberField, firstNameField, lastNameField, gradeLevelField, lunchStatusField;
	
	@FXML
	Button cancel, updateStudentBtn;
	
	@FXML
	private void buttonHandler(ActionEvent event) throws IOException
	{
		 if(event.getSource() == cancel)
		 {
	    	 Stage stage = null; 
	 	     Parent root = null;
	    	 stage=(Stage) cancel.getScene().getWindow();
	    	 root = FXMLLoader.load(getClass().getResource("ViewStudentWindow.fxml"));
	    	 Scene scene = new Scene(root);
	         stage.setScene(scene);
	         stage.show();
	 	    	 
	     }
		 else if(event.getSource() == updateStudentBtn)
		 {
				 school.addStudent(lastNameField.getText(), firstNameField.getText(), Integer.parseInt(gradeLevelField.getText()), Integer.parseInt(gradeLevelField.getText()), Integer.parseInt(studentNumberField.getText()));
				 school.removeStudent(lastName, firstName);
				 
				 Alert alert = new Alert(AlertType.INFORMATION);
				 alert.setTitle("Student Updated");
				 alert.setHeaderText("Student Update Sucessful");
				 alert.setContentText(firstNameField.getText() + " " + lastNameField.getText() + " has been updated!");

				 alert.showAndWait();
				 
				 FileWriter writer = new FileWriter("C://Users/Public/Documents/Lunch Hero/LLCS-Students.txt");
		    	 
		    	 for(Student s : school.getStudents())
		    	 {
					writer.write(s.getLastName() + "," + s.getFirstName() + "," + s.getGradeLevel() + "," + s.getLunchStatus() + "," + s.getStudentNumber() + "\n");
		    	 }
					writer.close();
			 

			
			System.out.println("Working"); 
		 }
	}

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		
		
		for (Student student : school.getStoredStudent())
		{
			firstName = student.getFirstName();
			firstNameField.setText(firstName);
			
			lastName = student.getLastName();
			lastNameField.setText(lastName);
			
			studentNumber = student.getStudentNumber();
			studentNumberField.setText(Integer.toString(studentNumber));
			
			gradeLevel = student.getGradeLevel();
			gradeLevelField.setText(Integer.toString(gradeLevel));
			
			lunchStatus = student.getLunchStatus();
			lunchStatusField.setText(Integer.toString(lunchStatus));
			
		}
		
		
	}
}