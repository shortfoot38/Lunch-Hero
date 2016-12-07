package bl.lunchhero.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import bl.lunchhero.model.Calculator;
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

public class FRCalculatorController implements Initializable
{
	
	Calculator calculator;
	
	private boolean snapQuestion = false;
	private ObservableList<String> options = FXCollections.observableArrayList(
			"Yes",
			"No"
			);
	
	@FXML
	Button cancel, calculateBtn;
	
	@FXML
	TextField houseHoldSizeField,  weeklyIncomeField, yearlyIncomeField, monthlyIncomeField, bimonthlyIncomeField, biweeklyIncomeField;
	
	@FXML
	ComboBox<String> snapQuestionBx;
	
	
	@FXML
	private void buttonHandler(ActionEvent event) throws IOException
	{
		Stage stage = null; 
	    Parent root = null;
	    
	    if(event.getSource() == cancel)
	    {
	    	stage=(Stage) cancel.getScene().getWindow();
	    	root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
	    }
	    else if(event.getSource() == calculateBtn)
	    {
	    	calculator = new Calculator(Integer.parseInt(houseHoldSizeField.getText()), Integer.parseInt(yearlyIncomeField.getText()), Integer.parseInt(monthlyIncomeField.getText()), 
			Integer.parseInt(bimonthlyIncomeField.getText()), Integer.parseInt(biweeklyIncomeField.getText()), Integer.parseInt(weeklyIncomeField.getText()));
	    	
	    	
	    }
	    
	    Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}


	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		snapQuestionBx.setItems(options);
		
		snapQuestionBx.valueProperty().addListener(new ChangeListener<String>()
		{

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
			{
				if (newValue.equals("yes"))
				{
					snapQuestion = true;
				}
				else if (newValue.equals("no"))
				{
					snapQuestion = false;
				}
				
			}
			
		});
		
	}
}
