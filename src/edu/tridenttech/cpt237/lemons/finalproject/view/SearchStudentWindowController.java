package edu.tridenttech.cpt237.lemons.finalproject.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.management.OperationsException;

import edu.tridenttech.cpt237.lemons.finalproject.model.School;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class SearchStudentWindowController implements Initializable
{
	School school = School.getSchool();
	
	private String firstName;
	private String lastName;
	private int studentNumber;
	private boolean searchType = true;
	
	private ObservableList<String> options = FXCollections.observableArrayList(
			"Search by name",
			"Search by student number"
			);
	
	@FXML
	ComboBox<String> searchSelection;
	
	@FXML 
	TextField searchBoxUp, searchBoxDown;
	
	@FXML
	Button cancel, searchBtn;
	
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
	     
	     else if (event.getSource() == searchBtn)
	     {
	    	 if (searchType == true)
	    	 {
	    		 if (school.getStudentByName(searchBoxDown.getText(), searchBoxUp.getText()) != null)
	    		 {
	    			 Alert alert = new Alert(AlertType.INFORMATION);
					 alert.setTitle("Student Found");
					 alert.setHeaderText("Student Search Sucessful");
					 alert.setContentText(searchBoxUp.getText() + " " + searchBoxDown.getText() + " has been found!");
					 alert.showAndWait();
					 
					 school.storeStudent(school.getStudentByName(searchBoxDown.getText(), searchBoxUp.getText()));

					 alert.showAndWait();
					 
					 Stage stage = null; 
			 	     Parent root = null;
			    	 stage=(Stage) cancel.getScene().getWindow();
			    	 root = FXMLLoader.load(getClass().getResource("ViewStudentInfoWindow.fxml"));
			    	 Scene scene = new Scene(root);
			         stage.setScene(scene);
			         stage.show();
	    		 }
	    		 else
	    		 {
	    			 Alert alert = new Alert(AlertType.INFORMATION);
					 alert.setTitle("Student Not Found");
					 alert.setHeaderText("Student Search Unsucessful");
					 alert.setContentText(searchBoxUp.getText() + " " + searchBoxDown.getText() + " was not found!");

					 alert.showAndWait();
	    		 }
	    		  
	    	 }
	    	 else if (searchType == false)
	    	 {
	    		 if (school.getStudentByNumber(Integer.parseInt(searchBoxUp.getText())) != null)
	    		 {
	    			 Alert alert = new Alert(AlertType.INFORMATION);
					 alert.setTitle("Student Found");
					 alert.setHeaderText("Student Search Sucessful");
					 alert.setContentText(searchBoxUp.getText() + " " + searchBoxDown.getText() + " has been found!");
					 
					 school.storeStudent(school.getStudentByNumber(Integer.parseInt(searchBoxUp.getText())));
					 
					 Stage stage = null; 
			 	     Parent root = null;
			    	 stage=(Stage) cancel.getScene().getWindow();
			    	 root = FXMLLoader.load(getClass().getResource("ViewStudentInfoWindow.fxml"));
			    	 Scene scene = new Scene(root);
			         stage.setScene(scene);
			         stage.show();
	    		 }
	    		 else
	    		 {
	    			 Alert alert = new Alert(AlertType.INFORMATION);
					 alert.setTitle("Student Not Found");
					 alert.setHeaderText("Student Search Unsucessful");
					 alert.setContentText(searchBoxUp.getText() + " " + searchBoxDown.getText() + " was not found!");

					 alert.showAndWait();
	    		 }
	    	 }
	    	 
	    	 
	  
	     }
	}
	
		
	     
	   
	     
	    

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		searchSelection.setItems(options);
		searchSelection.setValue("Search by name");
		searchBoxDown.setPromptText("Last Name");
		
		searchBoxUp.setPromptText("First Name");
		
		searchSelection.valueProperty().addListener(new ChangeListener<String>()
		{
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
			{
				if(newValue.equals("Search by name"))
				{
					searchBoxDown.setVisible(true);
					searchBoxDown.setPromptText("Last Name");
					
					searchBoxUp.setPromptText("First Name");
					searchType = true;
				}
				else
				{
					searchBoxUp.setPromptText("Student Number");
					searchBoxDown.setVisible(false);
					searchType = false;
				}
				
			}
		});
		
	}
	
	
}
