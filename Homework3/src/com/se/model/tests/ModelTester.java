package com.se.model.tests;

import java.util.List;

import com.se.model.reminders.Reminder;
import com.se.model.reminders.ReminderList;
import com.se.model.reminders.TextReminder;
import com.se.model.reminders.TimedReminder;

public class ModelTester {

	public static void main(String[] args) {
		ReminderList rl = ReminderList.getInstance();
		rl.addReminder(TextReminder.getInstance("Need to get Groceries"));
		rl.addReminder(TextReminder.getInstance("get Groceries again"));
		rl.addReminder(TextReminder.getInstance("clean bedroom"));
		rl.addReminder(TextReminder.getInstance("visit jeff"));
		

		rl.addReminder(TimedReminder.getInstance(12, 23, "visit jeff tomorow around noon"));
		
		List<Reminder> textReminders = (rl.getReminders(Reminder.TYPE.TEXT));
		for(Reminder tr: textReminders) {
			System.out.println(tr.toString());
		}
		
		List<Reminder> timedReminders = (rl.getReminders(Reminder.TYPE.TIMED));
		for(Reminder tr: timedReminders) {
			System.out.println(tr.toString());
		}
	}
}
