package tests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SelectALanguageFromTheLanguagesDropdown {
	
	
	public static void selectLanguage(Page page, String languageName) {
	    // Click to open the Languages dropdown
	    Locator input_Languages = page.locator("div#msdd");
	    input_Languages.click();

	    // Wait for dropdown options to appear
	    page.waitForTimeout(1000);

	    // Locate and click the specific language option
	    Locator language_Option = page.locator("a:has-text('" + languageName + "')");
	    language_Option.click();

	    // Verify the language is selected
	    Locator selected_Language = page.locator("div.ui-autocomplete-multiselect-item");
	    assertThat(selected_Language).containsText(languageName);
	    System.out.println(">>>>>>>>>>>>>>Language selected: " + languageName);
	}
}
