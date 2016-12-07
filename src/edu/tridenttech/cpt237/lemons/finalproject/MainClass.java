package edu.tridenttech.cpt237.lemons.finalproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import edu.tridenttech.cpt237.lemons.finalproject.model.School;
import edu.tridenttech.cpt237.lemons.finalproject.view.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainClass extends Application
{

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		new MainWindow(primaryStage).show();
		
	}
	
	public static void main(String[] args) throws IOException
	{
		School school = School.getSchool();
		File studentFiles = new File("C://Users/Public/Documents/Lunch Hero/LLCS-Students.txt");
		if(!studentFiles.exists())
		{
			studentFiles.getParentFile().mkdirs();
			studentFiles.createNewFile();
		}
		school.loadStudents("C://Users/Public/Documents/Lunch Hero/LLCS-Students.txt");
		Application.launch(args);
		

	}

	

}
