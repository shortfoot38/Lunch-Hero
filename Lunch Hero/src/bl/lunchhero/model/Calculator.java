package bl.lunchhero.model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Calculator
{
	private static final int FREE = 2;
	private static final int REDUCE = 3;
	private static final int PAID = 4;
	private static final int MONTHLY_CONVERSION = 12;
	private static final int BIMONTHLY_CONVERSION = 24;
	private static final int BIWEEKLY_CONVERSION = 26;
	private static final int WEEKLY_CONVERSION = 52;
	private static final int ADDITIONAL_FREE_INCOME = 5408;
	private static final int ADDITIONAL_REDUCE_INCOME = 7696;
	
	private int householdSize;
	private int yearlyIncome;
	private int monthlyIncome;
	private int bimonthlyIncome;
	private int biweeklyIncome;
	private int weeklyIncome;
	private int totalHouseIncome;
	private int lunchStatus;
	
	public Calculator(int householdSize, int yearlyIncome, int monthlyIncome, int bimonthlyIncome, int biweeklyIncome, int weeklyIncome)
	{
		this.bimonthlyIncome = bimonthlyIncome;
		this.monthlyIncome = monthlyIncome;
		this.weeklyIncome = weeklyIncome;
		this.biweeklyIncome = biweeklyIncome;
		this.yearlyIncome = yearlyIncome;
		this.householdSize = householdSize;
		
		System.out.println("Working");
		
		totalHouseIncome = calculateYearlyIncome();
		
		calculateLunchStatus();
		announceStatus();
		
		
	}
	
	public void announceStatus()
	{
		if (lunchStatus == FREE)
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Lunch Status");
			alert.setHeaderText("Student Lunch Status");
			alert.setContentText("Student lunch status is Free. Please put a (2) in the lunch status field. Yearly Income is: " + + totalHouseIncome);

			alert.showAndWait();
		}
		
		else if (lunchStatus == REDUCE)
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Lunch Status");
			alert.setHeaderText("Student Lunch Status");
			alert.setContentText("Student lunch status is Reduced. Please put a (3) in the lunch status field. Yearly Income is: " + totalHouseIncome);

			alert.showAndWait();
		}
		else if (lunchStatus == PAID)
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Lunch Status");
			alert.setHeaderText("Student Lunch Status");
			alert.setContentText("Student lunch status is Paid. Please put a (4) in the lunch status field. Yearly Income: " + totalHouseIncome);

			alert.showAndWait();
		}
	}
	
	public int calculateYearlyIncome()
	{
		int totalIncome;
		totalIncome = calculateMonthlyIncome() + calculateBimonthlyIncome() + calculateWeeklyIncome() + calculateBiweeklyIncome() + yearlyIncome;
		System.out.println(totalIncome);
		return totalIncome;
	}
	
	public int calculateMonthlyIncome()
	{
		int totalIncome;
		totalIncome = MONTHLY_CONVERSION * monthlyIncome;
		return totalIncome;
	}
	
	public int calculateBimonthlyIncome()
	{
		int totalIncome;
		totalIncome = BIMONTHLY_CONVERSION * bimonthlyIncome;
		return totalIncome;
	}
	
	public int calculateBiweeklyIncome()
	{
		int totalIncome;
		totalIncome = BIWEEKLY_CONVERSION * biweeklyIncome;
		return totalIncome;
	}
	public int calculateWeeklyIncome()
	{
		int totalIncome;
		totalIncome = WEEKLY_CONVERSION * weeklyIncome;
		return totalIncome;
	}
	
	public int calculateLunchStatus()
	{
		int incomeLimitFree;
		int incomeLimitReduce;
		
	
		
		switch(householdSize)
		{
		case 1:
			incomeLimitFree = 1544;
			incomeLimitReduce = 21978;
			break;
			
		case 2:
			incomeLimitFree = 20826;
			incomeLimitReduce = 29637;
			break;
			
		case 3: 
			incomeLimitFree = 26208;
			incomeLimitReduce = 37296;
			break;
			
		case 4:
			incomeLimitFree = 31590;
			incomeLimitReduce = 44955;
			break;
			
		case 5:
			incomeLimitFree = 36972;
			incomeLimitReduce = 52614;
			break;
		
		case 6:
			incomeLimitFree = 42354;
			incomeLimitReduce = 60273;
			break;
			
		case 7:
			incomeLimitFree = 47749;
			incomeLimitReduce = 67951;
		
		case 8:
			incomeLimitFree = 53157;
			incomeLimitReduce = 75647;
			break;
			
		default:
			int houseMultipler = 8;
			houseMultipler = householdSize - houseMultipler;
			
			incomeLimitFree = houseMultipler * ADDITIONAL_FREE_INCOME + 53157;
			incomeLimitReduce = houseMultipler * ADDITIONAL_REDUCE_INCOME + 75647;
			break;
		}
		
		
		if (totalHouseIncome <= incomeLimitFree)
		{
			lunchStatus = FREE;
		}
		else if (totalHouseIncome <= incomeLimitReduce)
		{
			lunchStatus = REDUCE;
		}
		else if (totalHouseIncome > incomeLimitFree && totalHouseIncome > incomeLimitReduce) 
		{
			lunchStatus = PAID;
		}
		
		return lunchStatus;
	}
	
}
