package com.se.model.reminders;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimedReminder extends Reminder {
	private LocalTime alarmTime;
	private LocalDateTime time;
	private boolean isRinging;

	public TimedReminder() {
		this.isRinging= false;
	}
	
	public static TimedReminder getInstance(int hour, int minute) {
		TimedReminder tr = new TimedReminder();
		tr.alarmTime = LocalTime.of(hour, minute);
		tr.time= LocalDateTime.now();
		tr.reminderText = "";
		return tr;
	}
	
	public static TimedReminder getInstance(int hour, int minute, String reminderText) {
		TimedReminder tr = new TimedReminder();
		tr.alarmTime = LocalTime.of(hour, minute);
		tr.time= LocalDateTime.now();
		tr.reminderText = reminderText;
		return tr;
	}
	
	public boolean shouldRing() {
		if(!isRinging && LocalDateTime.now().isAfter(time) && LocalDateTime.now().isBefore(time.withMinute(time.getMinute()+1))) {
			return isRinging=true;
		}
		return false;
	}
	
	public void dismiss() {
		time = LocalDateTime.of(LocalDate.now().plusDays(1), alarmTime);
		isRinging = false;
	}
	
	public void snooz() {
		time = LocalDateTime.now().plusMinutes(10);
		isRinging = false;
	}

	@Override
	public String toString() {
		return this.reminderText +" at: "+ this.alarmTime.toString();
	}
}
