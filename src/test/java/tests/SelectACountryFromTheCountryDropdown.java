package tests;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

public class SelectACountryFromTheCountryDropdown {

	public static void selectCountry(Page page, String countryName) {
		// 1. Target the element using its unique ID attribute 'countries'
		String dropdownSelector = "select#country";

		// 2. Ensure the element is visible on the DOM before interacting
		page.waitForSelector(dropdownSelector);

		// 3. Select the option cleanly using Playwright's built-in selectOption handler
		//page.locator(dropdownSelector).selectOption(new SelectOption().setLabel(countryName));
		page.locator(dropdownSelector).selectOption(new SelectOption().setValue(countryName));
		
		// Verify the Country is selected
		Locator selected_Country = page.locator("span#select2-country-container");
	    assertThat(selected_Country).containsText(countryName);
	    System.out.println(">>>>>>>>>>>>>>>>>>>Country selected: " + countryName);
	}
}
