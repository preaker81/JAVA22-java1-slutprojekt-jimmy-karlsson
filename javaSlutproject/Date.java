package javaSlutproject;

import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;

class Date {

	//method for getting the date from specific day of week. Expected argument: day(day of week 1-7)
	protected static String getDate(int x) {
		LocalDate now = LocalDate.now();

		TemporalField fieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
		LocalDate date = now.with(fieldISO, x);

		String dateString = date.toString();
		return dateString;
		
		
	}

	//method for getting the weekday from specific day of week. Expected argument: day(day of week 1-7)
	protected static String getWeekDay(int x) {
		LocalDate now = LocalDate.now();
		TemporalField fieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
		LocalDate date = now.with(fieldISO, x);

		String weekday = date.getDayOfWeek().toString();
		return weekday;
	}

}