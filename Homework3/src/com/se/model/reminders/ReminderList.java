package com.se.model.reminders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReminderList {
	private Map<Reminder.TYPE, List<Reminder>> reminderLists;
	
	private ReminderList() {
		reminderLists = new HashMap<>();
		for (Reminder.TYPE type : Reminder.TYPE.values()) {
			reminderLists.put(type, new ArrayList<>());
		}
	}
	
	
	
	public static ReminderList getInstance() {
		return new ReminderList();
	}

	public List<Reminder> getReminders(Reminder.TYPE type){
		return reminderLists.get(type);
	}

	public void addReminder(TextReminder textReminder){
		reminderLists.get(Reminder.TYPE.TEXT).add(textReminder);
	}

	public void addReminder(TimedReminder timedReminder){
		reminderLists.get(Reminder.TYPE.TIMED).add(timedReminder);
	}
	
}