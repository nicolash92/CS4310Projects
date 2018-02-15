package com.se.controller;

import java.util.Scanner;
import com.se.view.viewReminders;
import com.se.model.reminders.Reminder;
import com.se.model.reminders.ReminderList;
import com.se.model.reminders.TextReminder;
import com.se.model.reminders.TimedReminder;
import java.util.List;

public class conReminder {

	public static void main(String[] args) {
		viewReminders view = new viewReminders();
		ReminderList model = ReminderList.getInstance();
		
		int result;
		do {
			 result = view.menu(new Scanner(System.in));
			 
			 switch(result) {
			 case 1:
				 int turns = view.turns(new Scanner(System.in));
	
				 for(int i = 0; i < turns; i++) {
					 String list = view.add(new Scanner(System.in));
					 
					 if(view.getViewTime()){
						 int hour = Integer.parseInt(list.substring(0, 2));
						 int min = Integer.parseInt(list.substring(2,4));
						 list = list.substring(4, list.length());
						 
						 model.addReminder(TimedReminder.getInstance(hour, min, list));
						 
					 }
					 else 
						 model.addReminder(TextReminder.getInstance(list));
				 }
				 break;
				 
			 case 2:
				 	List<Reminder> textReminders = (model.getReminders(Reminder.TYPE.TEXT));
				 		for(Reminder tr: textReminders) {
				 			System.out.println(tr.toString());
				 		}
					
				 	List<Reminder> timedReminders = (model.getReminders(Reminder.TYPE.TIMED));
						for(Reminder tr: timedReminders) {
			 				System.out.println(tr.toString());
						}		
				 	
				 break;
			 }
		}while(result != -1);
		
	}
	
}
