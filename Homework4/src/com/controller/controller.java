package com.controller;

import java.util.Scanner;
import java.util.List;

import com.view.View;

import com.se.model.reminders.DateTimeReminder;
import com.se.model.reminders.Reminder;
import com.se.model.reminders.ReminderList;
import com.se.model.reminders.TextReminder;
import com.se.model.reminders.TimedReminder;
import com.se.model.reminders.Reminder.TYPE;

public class controller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		ReminderList rl;
		List<Reminder> dtl;
		rl =  ReminderList.getInstance();
		rl.addReminder(DateTimeReminder.getInstance(2018, 1, 18, 12, 25, "test"));
		
		dtl = rl.getReminders(TYPE.DATE_TIME);
		System.out.print(((DateTimeReminder)dtl.get(0)).toString());
		
		*/
		View view = new View();
		ReminderList model = ReminderList.getInstance();
		
		int result = -1;
		
		
		do {
			result = view.menu(new Scanner(System.in));
			
			//ADD [1], Display[2], Remove[3], Quit[-1]
			switch(result) {
			case 1:
				int turns = view.numReminders(new Scanner(System.in));
				
				for(int i = 0; i < turns; i++) {
					String list = view.event(new Scanner(System.in));
					
					if(view.dateEvent) 
						model.addReminder(DateTimeReminder.getInstance(view.getYear(), view.getMonth(), view.getDay(), view.getHour(), view.getMin(), list));
					else if(view.timeEvent)
						model.addReminder(TimedReminder.getInstance(view.getHour(), view.getMin(), list));
					else 
						model.addReminder(TextReminder.getInstance(list));
				}
				break;
				
			case 2:
				List<Reminder> dateReminders;
				List<Reminder> textReminders;
				List<Reminder> timeReminders;
				
				//date
				dateReminders = model.getReminders(TYPE.DATE_TIME);
				for(Reminder rim: dateReminders)
					System.out.println(rim.toString());
				//text
				textReminders = model.getReminders(TYPE.TEXT);
				for(Reminder rim: textReminders)
					System.out.println(rim.toString());
				//time
				timeReminders = model.getReminders(TYPE.TIMED);
				for(Reminder rim: timeReminders)
					System.out.println(rim.toString());

				break;
				
			case 3:
				//Remove Area
				
				break;
			}
		}while(result != -1);
		
		
		

	}

}
