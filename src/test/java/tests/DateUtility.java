package tests;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateUtility {

    /**
     * Calculates the year that was exactly 30 years before the current year.
     * 
     * @return The 4-digit year as an integer (e.g., if current year is 2026, returns 1996).
     */
    public static int getThirtyYearsBackYear(int expectedBackYears) {
        // 1. Get the current year
        Year currentYear = Year.now();
        
        // 2. Subtract 30 years from it
        Year pastYear = currentYear.minusYears(expectedBackYears);
        
        // 3. Return the result as an integer value
        return pastYear.getValue();
    }
    
    /**
     * Gets the full text name of the current month in English.
     * 
     * @return The capitalized month name (e.g., "January", "May", "December").
     */
    public static String getCurrentMonthFullName() {
        // 1. Get the current date instance
        LocalDate currentDate = LocalDate.now();
        
        // 2. Extract the month and format it to its full text presentation style
        return currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }
    
    /**
     * Gets the current day of the month as a String, excluding leading zeroes.
     * 
     * @return The single or double-digit day string (e.g., "5", "16", "28").
     */
    public static String getCurrentDayExcludingLeadingZero() {
        // 1. Get the current local date
        LocalDate currentDate = LocalDate.now();
        
        // 2. Extract the integer day value (e.g., 5 or 16)
        int dayValue = currentDate.getDayOfMonth();
        
        // 3. Convert the integer directly to a String to drop any leading zero
        return String.valueOf(dayValue);
    }
}
