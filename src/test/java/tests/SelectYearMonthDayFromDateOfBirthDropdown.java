package tests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SelectYearMonthDayFromDateOfBirthDropdown {
	
	public static void selectYear(Page page, String expectedYear) {
		// 1. Target the element using its unique ID attribute 'year'
		String dd_year = "select[placeholder='Year']";
		// 2. Ensure the element is visible on the DOM before interacting
		page.waitForSelector(dd_year);
		// 3. Select the option cleanly using Playwright's built-in selectOption handler
		page.locator(dd_year).selectOption(new SelectOption().setValue(expectedYear));
		// Verify the Country is selected		
		Locator selected_Year = page.locator("select[placeholder='Year']");
	    assertThat(selected_Year).containsText(expectedYear);
	    System.out.println(">>>>>>>>>>>>>>>>>>>>>" + expectedYear);
	}
	
	public static void selectMonth(Page page, String expectedMonth) {
		// 1. Target the element using its unique ID attribute 'year'
		String dd_Month = "select[placeholder='Month']";
		// 2. Ensure the element is visible on the DOM before interacting
		page.waitForSelector(dd_Month);
		// 3. Select the option cleanly using Playwright's built-in selectOption handler
		page.locator(dd_Month).selectOption(new SelectOption().setValue(expectedMonth));
		// Verify the Country is selected		
		Locator selected_Month = page.locator("select[placeholder='Month']");
	    assertThat(selected_Month).containsText(expectedMonth);
	    System.out.println(">>>>>>>>>>>>>>>>>>>>>>" + expectedMonth);
	}
	
	public static void selectDay(Page page, String expectedDay) {
		// 1. Target the element using its unique ID attribute 'year'
		String dd_Day = "select[placeholder='Day']";
		// 2. Ensure the element is visible on the DOM before interacting
		page.waitForSelector(dd_Day);
		// 3. Select the option cleanly using Playwright's built-in selectOption handler
		page.locator(dd_Day).selectOption(new SelectOption().setValue(expectedDay));
		// Verify the Country is selected		
		Locator selected_Day = page.locator("select[placeholder='Day']");
	    assertThat(selected_Day).containsText(expectedDay);
	    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>" + expectedDay);
	}
}
