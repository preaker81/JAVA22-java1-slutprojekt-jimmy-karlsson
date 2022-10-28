package javaSlutproject;

/**
 * class whit methods for getting date or weekday from WeekField of cutrrent date.
 */

import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;

class Date {

	// Expected argument: day(day of week 1-7)
	protected static String getDate(int x) {
		LocalDate now = LocalDate.now();
		TemporalField weekFieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
		LocalDate date = now.with(weekFieldISO, x);

		String dateString = date.toString();
		return dateString;

	}

	// Expected argument: day(day of week 1-7)
	protected static String getWeekDay(int x) {
		LocalDate now = LocalDate.now();
		TemporalField weekFieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
		LocalDate date = now.with(weekFieldISO, x);

		String weekday = date.getDayOfWeek().toString();
		return weekday;
	}

}