package com.view;

import java.util.Scanner;

public class View extends Views{
	public boolean timeEvent, dateEvent;
	private int year, month, day, hour, min;
	private String text;
	
	@Override
	public int menu(Scanner in) {
		System.out.print("ADD[1], Display[2], Quit[-1]: ");
		return in.nextInt();
	}

	@Override
	public String event(Scanner in) {
		timeEvent = dateEvent = false;
		
		System.out.print("Date Time [1], Timed [2], Texted [3]: ");
		int caseNum = in.nextInt();
		in.reset();
		
		//"Date Time[1], Timed[2], Texted[3]"
		switch(caseNum){
			case 1:
				dateEvent = true;
				System.out.print("Year: ");
				setYear(in);
				
				System.out.print("Month: ");
				setMonth(in);
				
				System.out.print("Day: ");
				setDay(in);
					
			case 2:
				timeEvent = true;
				System.out.print("Hour: ");
				setHour(in);
		
				System.out.print("Min: ");
				setMin(in);
				
			case 3:
				System.out.print("Text: ");
				setText(new Scanner(System.in));
		}
		
		return getText();
	}

	
	//How many items you will like to add to the list of reminders
	public int numReminders(Scanner in) {
		System.out.print("Number of items: ");
		return in.nextInt();
	}
	
	public int reminderIndex(Scanner in) {
		System.out.print("Enter reminder index: ");
		return in.nextInt();
	}

	public int getYear() {return year;}

	public void setYear(Scanner in) {
		String year = in.next();
		
		while(year.length() != 4) {
			System.out.print("[ex: 2000 exactly 4 numbers]Try again: ");
			year = in.next();
		}
			
		int numYear = Integer.parseInt(year);
		this.year = numYear;
	}

	public int getMonth() {return month;}

	public void setMonth(Scanner in) {
		String month = in.next();
		
		while(month.length() != 2) {
			System.out.print("[ex: 12 exactly 2 numbers]Try again: ");
			month = in.next();
		}
			
		int numMonth = Integer.parseInt(month);
		this.month = numMonth;
	}

	public int getHour() {return hour;}

	public void setHour(Scanner in) {
		String hour = in.next();
		
		while(hour.length() != 2) {
			System.out.print("[ex: 12 exactly 2 numbers]Try again: ");
			hour = in.next();
		}
			
		int numHour = Integer.parseInt(hour);
		this.hour = numHour;
	}

	public int getMin() {return min;}

	public void setMin(Scanner in) {
		String min = in.next();
		
		while(min.length() != 2) {
			System.out.print("[ex: 12 exactly 2 numbers]Try again: ");
			min = in.next();
		}
			
		int numMin = Integer.parseInt(min);
		this.min = numMin;
	}
	
	public int getDay() {return day;}
	
	public void setDay(Scanner in) {
		String day = in.next();
		
		while(day.length() != 2) {
			System.out.print("[ex: 12 exactly 2 numbers]Try again: ");
			day = in.next();
		}
			
		int numDay = Integer.parseInt(day);
		this.day = numDay;
	}
	
	public String getText(){return text;}
	
	public void setText(Scanner in) {
		text = in.nextLine();
	}
	
	
	
	
	

}
