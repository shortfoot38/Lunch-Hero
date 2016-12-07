package edu.tridenttech.cpt237.lemons.finalproject.view;

import java.io.IOException;
import java.util.ArrayList;

import edu.tridenttech.cpt237.lemons.finalproject.model.School;
import edu.tridenttech.cpt237.lemons.finalproject.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class MainItemsController
{
	
	private MainWindow mainWindow;
	

	@FXML
	private Button addStudentBtn, viewStudentBtn, calculateStatusBtn, searchStudentBtn; 
	
	
	
	

	

	 @FXML
	 private void buttonHandler(ActionEvent event) throws IOException
	 {
	     
	     
	     if(event.getSource() == addStudentBtn)
	     {
	    	 Stage stage; 
			 Parent root;
	    	 stage=(Stage) addStudentBtn.getScene().getWindow();
	    	 root = FXMLLoader.load(getClass().getResource("AddNewStudentWindow.fxml"));
	    	 Scene scene = new Scene(root);
	         stage.setScene(scene);
	         stage.show();

	     }
	     
	     else if(event.getSource() == viewStudentBtn)
	     {
	    	 Stage stage; 
			 Parent root;
	    	 stage=(Stage) viewStudentBtn.getScene().getWindow();
	    	 root = FXMLLoader.load(getClass().getResource("ViewStudentWindow.fxml"));
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
	     
	     else if(event.getSource() == searchStudentBtn)
	     {
	    	 Stage stage; 
			 Parent root;
	    	 stage=(Stage) viewStudentBtn.getScene().getWindow();
	    	 root = FXMLLoader.load(getClass().getResource("SearchStudentWindow.fxml"));
	    	 Scene scene = new Scene(root);
	         stage.setScene(scene);
	         stage.show();

	    	 
	     }
	     

	    }
	 

		
	
	     

	 
}
