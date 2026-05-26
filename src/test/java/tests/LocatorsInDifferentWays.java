package tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.options.AriaRole;

public class LocatorsInDifferentWays {
	/*
	 * generic is a role reserved for elements like <div> or <span> that have no
	 * semantic meaning. <label> elements are treated as text providers for form
	 * inputs. They do not have a "generic" role in the accessibility tree; they are
	 * often transparent containers for text.
	 */
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://demo.automationtesting.in/Register.html");
		// Register Page
		// =====Home locator in different ways============
		// 1. User-Facing Locators (Best Practice)
		Locator homeByRole = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Home").setExact(true));
		assertThat(homeByRole).isVisible();
		assertThat(homeByRole).hasText("Home");
		// 2. Using page.getByText() (Simplest Alternative)
		Locator homeByText = page.getByText("Home", new Page.GetByTextOptions().setExact(true));
		// 1. Assert visibility
		assertThat(homeByText).isVisible();

		// 2. Assert text content
		assertThat(homeByText).hasText("Home");
		// 3. Using CSS Text Matching Selector (:has-text or text=)// Match based on text fragments
		Locator homeByCssText = page.locator("a:has-text('Home')");
		// 1. Assert visibility
		assertThat(homeByCssText).isVisible();

		// 2. Assert text content
		assertThat(homeByCssText).hasText("Home");
		// 4. Alternative native Playwright engine prefix syntax
		Locator homeByTextEngine = page.locator("text=Home");
		// 1. Assert visibility
		assertThat(homeByTextEngine).isVisible();

		// 2. Assert text content
		assertThat(homeByTextEngine).hasText("Home");
		// 5. Standard CSS Attribute Selector Locators
		Locator homeByHref = page.locator("a[href='Index.html']");
		assertThat(homeByHref).isVisible();
		// 6. Partial match
		Locator homeByHrefContains = page.locator("a[href*='Index']");
		assertThat(homeByHrefContains).isVisible();
		// 1. Assert visibility
		assertThat(homeByHrefContains).isVisible();

		// 2. Assert text content
		assertThat(homeByHrefContains).hasText("Home");
		// 7. Using XPath (Strict Structural Match)// Matches an anchor tag whose text
		// content is exactly 'Home'
		Locator homeByXpath = page.locator("//nav[contains(@class, 'navbar')]//li//a[text()='Home']");
		// 1. Assert visibility
		assertThat(homeByXpath).isVisible();

		// 2. Assert text content
		assertThat(homeByXpath).hasText("Home");
		
		// 8. Using page.getByTitle() (If title attribute is present)
		Locator homeInHeader = page.locator("div.navbar-collapse.navbar-right")
		                       .locator("a")
		                       .filter(new Locator.FilterOptions().setHasText("Home"));
		// 1. Assert visibility
		assertThat(homeInHeader).isVisible();
		
		// 2. Assert text content
		assertThat(homeInHeader).hasText("Home");
		Locator homeByChain = page.locator("nav.navbar-inverse").locator("ul.navbar-nav").getByRole(AriaRole.LINK,
				new Locator.GetByRoleOptions().setName("Home"));
		// 1. Assert visibility
		assertThat(homeByChain).isVisible();

		// 2. Assert text content
		assertThat(homeByChain).hasText("Home");
		Locator homeByChain2 = page.locator("nav.navbar-inverse").locator("ul.navbar-nav")
				.locator("a:has-text('Home')");
		// 1. Assert visibility
		assertThat(homeByChain2).isVisible();

		// 2. Assert text content
		assertThat(homeByChain2).hasText("Home");

		// ================Blue navigation panel============
		
		Locator webTableByRole = page.getByRole(AriaRole.LINK,
				new Page.GetByRoleOptions().setName("WebTable").setExact(true));
		// 1. Assert visibility
		assertThat(webTableByRole).isVisible();

		// 2. Assert text content
		assertThat(webTableByRole).hasText("WebTable");
		
		Locator switchToByRole = page.getByRole(AriaRole.LINK,
				new Page.GetByRoleOptions().setName("SwitchTo").setExact(true));
		// 1. Assert visibility
		assertThat(switchToByRole).isVisible();

		// 2. Assert text content
		assertThat(switchToByRole).hasText("SwitchTo");
		
		Locator widgetsByRole = page.getByRole(AriaRole.LINK,
				new Page.GetByRoleOptions().setName("Widgets").setExact(true));
		// 1. Assert visibility
		assertThat(widgetsByRole).isVisible();

		// 2. Assert text content
		assertThat(widgetsByRole).hasText("Widgets");
		
		Locator interactionsByRole = page.getByRole(AriaRole.LINK,
				new Page.GetByRoleOptions().setName("Interactions ").setExact(true));
		// 1. Assert visibility
		assertThat(interactionsByRole).isVisible();

		// 2. Assert text content
		assertThat(interactionsByRole).hasText("Interactions");
		
		Locator videoByRole = page.getByRole(AriaRole.LINK,
				new Page.GetByRoleOptions().setName("Video").setExact(true));
		// 1. Assert visibility
		assertThat(videoByRole).isVisible();

		// 2. Assert text content
		assertThat(videoByRole).hasText("Video");
		
		Locator wYSIWYGByRole = page.getByRole(AriaRole.LINK,
				new Page.GetByRoleOptions().setName("WYSIWYG").setExact(true));
		// 1. Assert visibility
		assertThat(wYSIWYGByRole).isVisible();

		// 2. Assert text content
		assertThat(wYSIWYGByRole).hasText("WYSIWYG");
		
		Locator moreByRole = page.getByRole(AriaRole.LINK, 
				new Page.GetByRoleOptions().setName("More").setExact(true));
		// 1. Assert visibility
		assertThat(moreByRole).isVisible();

		// 2. Assert text content
		assertThat(moreByRole).hasText("More");
		
		Locator practiceSiteByRole = page.getByRole(AriaRole.LINK,
				new Page.GetByRoleOptions().setName("Practice Site").setExact(true));
		// 1. Assert visibility
		assertThat(practiceSiteByRole).isVisible();

		// 2. Assert text content
		assertThat(practiceSiteByRole).hasText("Practice Site");

		// =============================Body====================
		Locator registerByRole = page.getByRole(AriaRole.LINK,
				new Page.GetByRoleOptions().setName("Register").setExact(true));
		// 1. Assert visibility
		assertThat(registerByRole).isVisible();

		// 2. Assert text content
		assertThat(registerByRole).hasText("Register");
		
		// 1. Maintain your highly accurate ARIA role locator
		Locator header_Register = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Register").setExact(true));

		// 2. Fix the text string to match the page content exactly
		assertThat(header_Register).hasText("Register");

		// 1. Assert visibility
		assertThat(header_Register).isVisible();

		// 2. Assert text content
		assertThat(header_Register).hasText("Register");

		// Option 1: Use getByText (Recommended for Labels)
		Locator label_FullName = page.getByText("Full Name*");
		assertThat(label_FullName).isVisible();
		
		/*generic is a role reserved for elements like <div> or <span> that have no semantic meaning.*/
		Locator input_FirstName = page.getByRole(AriaRole.TEXTBOX,
				new Page.GetByRoleOptions().setName("First Name").setExact(true));
		assertThat(input_FirstName).isVisible();
		Locator input_Lastname = page.getByRole(AriaRole.TEXTBOX,
				new Page.GetByRoleOptions().setName("Last Name").setExact(true));
		assertThat(input_Lastname).isVisible();
		
		Locator label_Address = page.getByText("Address", new Page.GetByTextOptions().setExact(true));
		assertThat(label_Address).isVisible();
		// 1. Confirm the field label exists on the page
		assertThat(page.getByText("Address", new Page.GetByTextOptions().setExact(true))).isVisible();

		// 2. Locate and check the specific input field box
		Locator input_Address = page.locator("//textarea[@class='form-control ng-pristine ng-untouched ng-valid']");
		assertThat(input_Address).isVisible();
		
		Locator label_EmailAddress = page.getByText("Email address*");
		assertThat(label_EmailAddress).isVisible();

		Locator input_EmailAddress = page.locator("input[type='email']");
		assertThat(input_EmailAddress).isVisible();
		
		Locator label_Phone = page.getByText("Phone*");
		assertThat(label_Phone).isVisible();
		
		Locator input_Phone = page.locator("input[type='tel']");
		assertThat(input_Phone).isVisible();

		Locator label_Gender = page.getByText("Gender*");
		assertThat(label_Gender).isVisible();

		// 1. Radio Input Circles (Correct - keeping your working role locators)
		Locator radio_Male = page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Male").setExact(true));
		assertThat(radio_Male).isVisible();

		Locator radio_FeMale = page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("FeMale").setExact(true));
		assertThat(radio_FeMale).isVisible();

		// 2. Text Labels (Fixed - setExact(true) added to Male to prevent matching FeMale)
		Locator label_Male = page.getByText("Male", new Page.GetByTextOptions().setExact(true));
		assertThat(label_Male).isVisible();

		Locator label_FeMale = page.getByText("FeMale");
		assertThat(label_FeMale).isVisible();
		
		Locator label_Hobbies = page.getByText("Hobbies");
		assertThat(label_Hobbies).isVisible();
		
		Locator label_Cricket = page.getByText("Cricket");
		assertThat(label_Cricket).isVisible();
		Locator label_Movies = page.getByText("Movies");
		assertThat(label_Movies).isVisible();
		Locator label_Hockey = page.getByText("Hockey");
		assertThat(label_Hockey).isVisible();
		
		// 1. Cricket Checkbox
		Locator checkbox_Cricket = page.locator("input[type='checkbox'][value='Cricket']");
		assertThat(checkbox_Cricket).isVisible();

		// 2. Movies Checkbox
		Locator checkbox_Movies = page.locator("input[type='checkbox'][value='Movies']");
		assertThat(checkbox_Movies).isVisible();

		// 3. Hockey Checkbox
		Locator checkbox_Hockey = page.locator("input[type='checkbox'][value='Hockey']");
		assertThat(checkbox_Hockey).isVisible();

		// Languages-- Multi-Select Dropdown
		Locator label_Languages = page.getByText("Languages");
		
		assertThat(label_Languages).isVisible();
		Locator multiSelectContainer = page.locator("multi-select");
		assertThat(multiSelectContainer).isVisible();
		Locator languageDropdown = page.locator("div.form-group")
				.filter(new Locator.FilterOptions().setHasText("Languages")).locator("multi-select");
		assertThat(languageDropdown).isVisible();
		
//		Locator interactiveDropdownField = page.locator("div#msdd");
//		assertThat(interactiveDropdownField).isVisible();
//		Locator label_Skills = page.getByText("Skills");
//		assertThat(label_Skills).isVisible();
//		Locator dd_Skills_ByRole = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Skills"));
//		assertThat(dd_Skills_ByRole).isVisible();
//		Locator dd_Skills = page.locator("select#Skills");
//		assertThat(dd_Skills).isVisible();
		// ==========================Select Value from drop
		// down===================================================

		// Option A: Select by the visible text displayed to the user
//		dd_Skills_ByRole.selectOption("Adobe Photoshop");
//
//		// Option B: Select using the value attribute assigned in the DOM
//		dd_Skills_ByRole.selectOption(new SelectOption().setValue("Android"));
		
		// --- 1. SKILLS DROPDOWN (Standard <select>) ---
		// Use the ID directly as the label association is broken in the DOM
		Locator dd_Skills = page.locator("select#Skills");
		assertThat(dd_Skills).isVisible();

		// Select an option by value (e.g., "Adobe InDesign")
		dd_Skills.selectOption("Adobe InDesign");


		// --- 2. LANGUAGES DROPDOWN (Custom Multi-Select) ---
		// This is the 'div#msdd' element you were trying to locate
		Locator dd_Languages = page.locator("div#msdd");
		assertThat(dd_Languages).isVisible();

		// To interact with Languages, you must click the div first
		dd_Languages.click();
		// Then click the specific language option from the list that appears
		page.locator("a").filter(new Locator.FilterOptions().setHasText("English")).click();



		// ========================================================================================================
		
		// --- 1. FIRST COUNTRY FIELD ("Country :") ---
		// This label is visible, but the accompanying dropdown select#countries is HIDDEN by the website.
		Locator label_Country = page.getByText("Country", new Page.GetByTextOptions().setExact(true));
		assertThat(label_Country).isVisible();

		// If you must assert the hidden element exists in the DOM, use isAttached instead of isVisible:
		Locator dd_Country_hidden = page.locator("select#countries");
		assertThat(dd_Country_hidden).isAttached(); 


		// --- 2. SECOND COUNTRY FIELD ("Select Country :") ---
		// Step A: Target the structural span wrapper box of the Select2 dropdown
		Locator countryDropdownContainer = page.locator("span.select2-container");
		assertThat(countryDropdownContainer).isVisible();

		// Step B: Target the specific interactive click target inside that Select2 widget
		Locator interactiveDropdown = page.locator("span.select2-selection--single");
		assertThat(interactiveDropdown).isVisible();

		// Step C: To select a country, you must click it, search, and press Enter
		interactiveDropdown.click();
		page.locator("input.select2-search__field").fill("Japan");
		page.keyboard().press("Enter");


		Locator label_DateOfBirth = page.getByText("Date Of Birth");
		assertThat(label_DateOfBirth).isVisible();
		Locator dd_year = page.locator("select#yearbox");
		assertThat(dd_year).isVisible();
		Locator dd_year_ByRole = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("year"));
		assertThat(dd_year_ByRole).isVisible();

		// Method 1: Using the Custom ng-model Attribute (Recommended)
		Locator dd_Month = page.locator("select[ng-model='monthbox']");
		assertThat(dd_Month).isVisible();
		// Method 2: Using the Placeholder Attribute
		Locator monthDropdown = page.locator("select[placeholder='Month']");
		assertThat(monthDropdown).isVisible();
		// Method 3: Using getByRole (Accessibility Approach)
		Locator monthDropdown_ByRole = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Month"));
		assertThat(monthDropdown_ByRole).isVisible();
		// How to Select a Month
		// Select by the visible option text (e.g., "April")
		monthDropdown.selectOption("April");
		// (no assertions after selectOption to avoid chaining on void)
		Locator dd_day = page.locator("select#daybox");
		assertThat(dd_day).isVisible();
		Locator dd_day_ByRole = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Day"));
		assertThat(dd_day_ByRole).isVisible();
		dd_day_ByRole.selectOption("30");
		Locator label_Password = page.getByText("Password");

		assertThat(label_Password).isVisible();
		Locator input_Password_ByRole = page.getByRole(AriaRole.TEXTBOX,
				new Page.GetByRoleOptions().setName("Password"));
		assertThat(input_Password_ByRole).isVisible();
		Locator input_Password = page.locator("input#firstpassword");
		assertThat(input_Password).isVisible();

		Locator label_ConfirmPassword = page.getByText("Confirm Password");
		assertThat(label_ConfirmPassword).isVisible();
		Locator input_ConfirmPassword_ByRole = page.getByRole(AriaRole.TEXTBOX,
				new Page.GetByRoleOptions().setName("Confirm Password"));
		assertThat(input_ConfirmPassword_ByRole).isVisible();
		Locator input_ConfirmPassword = page.locator("input#secondpassword");
		assertThat(input_ConfirmPassword).isVisible();

		Locator btn_Submit = page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Submit").setExact(true));
		// 1. Assert visibility
		assertThat(btn_Submit).isVisible();

		// 2. Assert text content
		assertThat(btn_Submit).hasText("Submit");

		Locator button_Refresh = page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Refresh").setExact(true));
		// 1. Assert visibility
		assertThat(button_Refresh).isVisible();

		// 2. Assert text content
		assertThat(button_Refresh).hasText("Refresh");

	}

}
