package edu.tridenttech.cpt237.lemons.finalproject.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class School
{
	private static School theSchool = new School();
	private ArrayList<Student> students = new ArrayList();
	private ArrayList<Student> storedStudent = new ArrayList();
	
	
	private School()
	{
		theSchool = this;
	}
	
	public static School getSchool()
	{
		return theSchool;
	}
	
	public List<Student> getStudents()
	{
		return Collections.unmodifiableList(students);
	}
	
	public List<Student> getStoredStudent()
	{
		return Collections.unmodifiableList(storedStudent);
	}
	
	public boolean removeStudent(String lastName, String firstName)
	{
		
		for(Student student : students)
		{
			if(student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
			{
				students.remove(student);
				return true;
			}
		}
		return false;
		
	}

	public Student getStudentByNumber(int studentNumber)
	{
		for (Student student : students)
		{
			if (student.getStudentNumber() == studentNumber)
			{
				return student;
			}
		}
		System.out.println("Did not find");
		return null;
	}
	
	public Student getStudentByName(String lastName, String firstName)
	{
		for (Student student : students)
		{
			if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
			{
				return student;
			}
		}
		System.out.println("Did not find");
		return null;
	}
	
	public Student addStudent(String lastName, String firstName, int gradeLevel, int lunchStatus, int studentNumber)
	{
		Student newStudent = new Student( lastName, firstName, gradeLevel, lunchStatus, studentNumber);
		students.add(newStudent);
		return newStudent;
		
	}
	
	public void storeStudent(Student student)
	{
		storedStudent.clear();
		storedStudent.add(student);
	}

	
	public void loadStudents(String fileName) throws FileNotFoundException
	{
		String lastName;
		String firstName;
		int gradeLevel;
		int lunchStatus;
		int studentNumber;
		
		Scanner input = new Scanner(new File(fileName));
		Student student;
		
		while (input.hasNext())
		{
			String line = input.nextLine();
			String[] fields = line.split(",");
			
			lastName = fields[0];
			firstName = fields[1];
			gradeLevel = Integer.parseInt(fields[2]);
			lunchStatus = Integer.parseInt(fields[3]);
			studentNumber = Integer.parseInt(fields[4]);
			
			
			student = new Student(fields[0], fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), Integer.parseInt(fields[4]));
			students.add(student);
			;
			
			System.out.println("Student " + student.getFirstName() + " " + student.getLastName() + " has been added.");
		}
		
		input.close();
		
		
	}
	
}
