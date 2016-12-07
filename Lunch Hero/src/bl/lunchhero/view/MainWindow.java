package bl.lunchhero.view;

import java.io.IOException;

import bl.lunchhero.model.School;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainWindow
{
	private Stage myStage;
	private AnchorPane mainLayout;
	School school = School.getSchool();
	
	

	
	
	public MainWindow(Stage stage) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(MainWindow.class.getResource("MainWindow.fxml"));
		
		
		
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		
		myStage = stage;
		myStage.setScene(scene);
		myStage.setTitle("Lunch Hero");
	}
	
	
	
	public void show()
	{
		myStage.show();
	}
	
}
