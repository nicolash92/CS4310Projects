package com.se.view;

import java.util.Scanner;

public class viewReminders extends absReminder {
	
	private boolean viewTime;

	@Override
	public String add(Scanner list) {
		String result = new String();
		int hour, min;
		
		System.out.print("+: ");
		result = list.nextLine();
		
		System.out.print("Reminder Time [Y | N]: ");
		char eventTime = list.next().toUpperCase().charAt(0);
		
		if(eventTime == 'Y') {
			setViewTime(true);
			System.out.print("Hour: ");
			hour = list.nextInt();
			
			System.out.print("Min: ");
			min = list.nextInt();
			result = String.valueOf(hour) + String.valueOf(min) + result;
		}
		
		return result;
	}

	@Override
	public int menu(Scanner input) {
		System.out.print("ADD [1], VIEW [2], QUIT [-1] :");
	
		return input.nextInt();
	}
	
	public int turns(Scanner input) {
		System.out.print("Number of adds :");
		return input.nextInt();
	}
	
	public void setViewTime(boolean viewTime) {
		this.viewTime = viewTime;
	}
	
	public boolean getViewTime() {
		return viewTime;
	}

}
