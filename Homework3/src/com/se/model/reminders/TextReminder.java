package com.se.model.reminders;

public class TextReminder extends Reminder {

	public static TextReminder getInstance(String reminder) {
		TextReminder tr = new TextReminder();
		tr.reminderText = reminder;
		return tr;
	}

	@Override
	public String toString() {
		return this.reminderText;
	}
	
}
