/*
 * Student has these attributes:
 * First Name
 * Last Name
 * Grade
 * Student Number
 * Lunch Status
 * */


package edu.tridenttech.cpt237.lemons.finalproject.model;

public class Student
{
	private String lastName;
	private String firstName;
	private int gradeLevel;
	private int studentNumber;
	private int lunchStatus;
	
	
	public Student(String lastName, String firstName, int gradeLevel, int lunchStatus, int studentNumber)
	{
		this.lastName = lastName;
		this.firstName = firstName;
		this.gradeLevel = gradeLevel;
		this.studentNumber = studentNumber;
		this.lunchStatus = lunchStatus;

	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}


	public void setGradeLevel(int gradeLevel)
	{
		this.gradeLevel = gradeLevel;
	}


	public void setStudentNumber(int studentNumber)
	{
		this.studentNumber = studentNumber;
	}


	public void setLunchStatus(int lunchStatus)
	{
		this.lunchStatus = lunchStatus;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getLastName()
	{
		return lastName;
	}


	public String getFirstName()
	{
		return firstName;
	}


	public int getGradeLevel()
	{
		return gradeLevel;
	}


	public int getStudentNumber()
	{
		return studentNumber;
	}


	public int getLunchStatus()
	{
		return lunchStatus;
	}
	
	
}
