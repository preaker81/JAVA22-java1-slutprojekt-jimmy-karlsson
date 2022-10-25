package javaSlutproject;

import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;

class Date {

	public static String getDate(int x) {
		LocalDate now = LocalDate.now();

		TemporalField fieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
		LocalDate date = now.with(fieldISO, x);

		String dateString = date.toString();
		return dateString;
	}

	public static String getWeekDay(int x) {
		LocalDate now = LocalDate.now();
		TemporalField fieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
		LocalDate date = now.with(fieldISO, x);

		String weekday = date.getDayOfWeek().toString();
		return weekday;
	}

}