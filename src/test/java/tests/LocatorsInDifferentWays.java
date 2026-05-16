package tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;

public class LocatorsInDifferentWays {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://demo.automationtesting.in/Register.html");
		// Register Page
		// ===================================Blue navigation panel==========================================
		// 1. User-Facing Locators (Best Practice)
		Locator homeByRole = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Home").setExact(true));
		Locator homeByText = page.getByText("Home", new Page.GetByTextOptions().setExact(true));
		// 2. Standard CSS Attribute Selector Locators
		Locator homeByHref = page.locator("a[href='Index.html']");
		Locator homeByHrefContains = page.locator("a[href*='Index']");
		Locator homeByCssText = page.locator("a:has-text('Home')");
		// 3. DOM Hierarchy Path Locators
		Locator homeByChain = page.locator("nav.navbar-inverse").locator("ul.navbar-nav").getByRole(AriaRole.LINK,
				new Locator.GetByRoleOptions().setName("Home"));
		Locator homeByChain2 = page.locator("nav.navbar-inverse").locator("ul.navbar-nav")
				.locator("a:has-text('Home')");
		Locator homeByXpath = page.locator("//nav[contains(@class, 'navbar')]//li//a[text()='Home']");
		// ===================================================================================================
		Locator registerByRole = page.getByRole(AriaRole.LINK,
				new Page.GetByRoleOptions().setName("Register").setExact(true));
		Locator webTableByRole = page.getByRole(AriaRole.LINK,
				new Page.GetByRoleOptions().setName("WebTable").setExact(true));
		Locator switchToByRole = page.getByRole(AriaRole.LINK,
				new Page.GetByRoleOptions().setName("SwitchTo").setExact(true));
		Locator widgetsByRole = page.getByRole(AriaRole.LINK,
				new Page.GetByRoleOptions().setName("Widgets").setExact(true));
		Locator interactionsByRole = page.getByRole(AriaRole.LINK,
				new Page.GetByRoleOptions().setName("Interactions ").setExact(true));
		Locator videoByRole = page.getByRole(AriaRole.LINK,
				new Page.GetByRoleOptions().setName("Video").setExact(true));
		Locator wYSIWYGByRole = page.getByRole(AriaRole.LINK,
				new Page.GetByRoleOptions().setName("WYSIWYG").setExact(true));
		Locator moreByRole = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("More").setExact(true));
		Locator practiceSiteByRole = page.getByRole(AriaRole.LINK,
				new Page.GetByRoleOptions().setName("Practice Site").setExact(true));

		// ===================================================Body=============================================
		Locator header_Register = page.getByRole(AriaRole.HEADING,
				new Page.GetByRoleOptions().setName("Register").setExact(true));
		// Option 1: Use getByText (Recommended for Labels)
		Locator label_FullName = page.getByText("Full Name*");
		// Alternative approach if getByRole is strictly required
		Locator label_FullName_ByRole = page.getByRole(AriaRole.GENERIC,
				new Page.GetByRoleOptions().setName("Full Name*"));
		Locator input_FirstName = page.getByRole(AriaRole.TEXTBOX,
				new Page.GetByRoleOptions().setName("First Name").setExact(true));
		Locator input_Lastname = page.getByRole(AriaRole.TEXTBOX,
				new Page.GetByRoleOptions().setName("Last Name").setExact(true));
		Locator label_Address = page.getByText("Address");
		Locator label_address_ByRole = page.getByRole(AriaRole.GENERIC,
				new Page.GetByRoleOptions().setName("Address").setExact(true));
		Locator input_Address = page.getByRole(AriaRole.TEXTBOX,
				new Page.GetByRoleOptions().setName("Address").setExact(true));
		Locator label_EmailAddress = page.getByText("Email address*");
		Locator label_EmailAddress_ByRole = page.getByRole(AriaRole.GENERIC,
				new Page.GetByRoleOptions().setName("Email address*").setExact(true));
		Locator input_EmailAddress = page.getByRole(AriaRole.TEXTBOX,
				new Page.GetByRoleOptions().setName("Email address*").setExact(true));
		Locator label_Phone = page.getByText("Phone*");
		Locator label_Phone_ByRole = page.getByRole(AriaRole.GENERIC,
				new Page.GetByRoleOptions().setName("Phone*").setExact(true));
		Locator label_Gender = page.getByText("Gender*");
		Locator label_Gender_ByRole = page.getByRole(AriaRole.GENERIC,
				new Page.GetByRoleOptions().setName("Gender*").setExact(true));
		// Matches the Male radio input circle
		Locator radio_Male = page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Male"));
		// Matches the FeMale radio input circle
		Locator radio_FeMale = page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("FeMale"));
		Locator label_Male = page.getByText("Male");
		Locator label_Male_ByRole = page.getByRole(AriaRole.GENERIC, new Page.GetByRoleOptions().setName("Male"));
		Locator label_FeMale = page.getByText("FeMale");
		Locator label_FeMale_ByRole = page.getByRole(AriaRole.GENERIC, new Page.GetByRoleOptions().setName("FeMale"));
		Locator label_Hobbies = page.getByText("Hobbies");
		Locator label_Cricket = page.getByText("Cricket");
		Locator label_Movies = page.getByText("Movies");
		Locator label_Hockey = page.getByText("Hockey");
		Locator checkbox_Cricket = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Cricket"));
		Locator checkbox_Movies = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Movies"));
		Locator checkbox_Hockey = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Hockey"));
		// Languages-- Multi-Select Dropdown
		Locator label_Languages = page.getByText("Languages");
		Locator multiSelectContainer = page.locator("multi-select");
		Locator languageDropdown = page.locator("div.form-group")
				.filter(new Locator.FilterOptions().setHasText("Languages")).locator("multi-select");
		Locator interactiveDropdownField = page.locator("div#msdd");
		Locator label_Skills = page.getByText("Skills");
		Locator dd_Skills_ByRole = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Skills"));
		Locator dd_Skills = page.locator("select#Skills");
		// ==========================Select Value from drop
		// down===================================================

		// Option A: Select by the visible text displayed to the user
		dd_Skills_ByRole.selectOption("Adobe Photoshop");

		// Option B: Select using the value attribute assigned in the DOM
		dd_Skills_ByRole.selectOption(new SelectOption().setValue("Android"));

		// ========================================================================================================
		Locator label_Country = page.getByText("Country");
		Locator dd_Country_readOnly = page.locator("select#countries");
		Locator dd_Country_ByRole_readOnly = page.getByRole(AriaRole.COMBOBOX,
				new Page.GetByRoleOptions().setName("Select Country"));
		Locator label_SelectCountry = page.getByTestId("Select Country");
		Locator countryDropdownContainer = page.locator("span.select2-container");
		Locator interactiveDropdown = page.getByRole(AriaRole.COMBOBOX,
				new Page.GetByRoleOptions().setName("Select Country"));
		Locator countryDropdown = page.locator("div.form-group")
				.filter(new Locator.FilterOptions().setHasText("Select Country :")).locator("span.select2-container");

		Locator label_DateOfBirth = page.getByText("Date Of Birth");
		Locator dd_year = page.locator("select#yearbox");
		Locator dd_year_ByRole = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("year"));
		// Method 1: Using the Custom ng-model Attribute (Recommended)
		Locator dd_Month = page.locator("select[ng-model='monthbox']");
		// Method 2: Using the Placeholder Attribute
		Locator monthDropdown = page.locator("select[placeholder='Month']");
		// Method 3: Using getByRole (Accessibility Approach)
		Locator monthDropdown_ByRole = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Month"));
		// How to Select a Month
		// Select by the visible option text (e.g., "April")
		monthDropdown.selectOption("April");
		Locator dd_day = page.locator("select#daybox");
		Locator dd_day_ByRole = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Day"));
		dd_day_ByRole.selectOption("30");
		Locator label_Password = page.getByText("Password");
		Locator input_Password_ByRole = page.getByRole(AriaRole.TEXTBOX,
				new Page.GetByRoleOptions().setName("Password"));
		Locator input_Password = page.locator("input#firstpassword");

		Locator label_ConfirmPassword = page.getByText("Confirm Password");
		Locator input_ConfirmPassword_ByRole = page.getByRole(AriaRole.TEXTBOX,
				new Page.GetByRoleOptions().setName("Confirm Password"));
		Locator input_ConfirmPassword = page.locator("input#secondpassword");

		Locator btn_Submit = page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Submit").setExact(true));
		Locator button_Refresh = page.getByRole(AriaRole.BUTTON,
				new Page.GetByRoleOptions().setName("Refresh").setExact(true));
	}

}
