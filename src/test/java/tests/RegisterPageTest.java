package tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.LocatorAssertions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RegisterPageTest {

	@org.testng.annotations.Test
	public void registerPageTest() {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://demo.automationtesting.in/Register.html");
		// Register
		Locator label_Register = page.locator("h2:has-text('Register')");
		System.out.println(">" + label_Register.textContent());
		assertThat(label_Register).isVisible();
		assertThat(label_Register).hasText("Register");

		// Full Name
		Locator label_FullName = page.getByText("Full Name* ");
		System.out.println(">>" + label_FullName.textContent());
		assertThat(label_FullName).isVisible();
		assertThat(label_FullName).hasText("Full Name*");

		// First Name
		// Locator input_FirstName = page.getByRole(AriaRole.TEXTBOX, new
		// Page.GetByRoleOptions().setName("First Name").setExact(true));
		Locator input_FirstName = page.getByPlaceholder("First Name");
		assertThat(input_FirstName).isVisible();
		String firstName = "Alok";
		input_FirstName.fill(firstName);
		// after entering how to verify input text
		assertThat(input_FirstName).hasValue(firstName);

		// Last Name
		// Locator input_LastName = page.getByRole(AriaRole.TEXTBOX, new
		// Page.GetByRoleOptions().setName("Last Name").setExact(true));
		Locator input_LastName = page.getByPlaceholder("Last Name");
		assertThat(input_LastName).isVisible();
		String lastName = "Barman";
		input_LastName.fill(lastName);
		// after entering verify input text
		assertThat(input_LastName).hasValue(lastName);

		// Address
		Locator label_Address = page.getByText("Address", new Page.GetByTextOptions().setExact(true));
		// Locator label_Address = page.getByText("Address");
		System.out.println(">>>" + label_Address.textContent());
		assertThat(label_Address).isVisible();
		assertThat(label_Address).hasText("Address");
		String memoryAddress = "3 Marshall Street, Irvington, NJ 07111";
		Locator input_Address = page.locator("textarea");
		input_Address.fill(memoryAddress);
		// verification
		assertThat(input_Address).hasValue(memoryAddress);

		// Email address
		Locator label_EmailAddress = page.getByText("Email address*");
		System.out.println(">>>>" + label_EmailAddress.textContent());
		assertThat(label_EmailAddress).isVisible();
		assertThat(label_EmailAddress).hasText("Email address*");
		Locator input_EmailAddress = page.locator("input[ng-model='EmailAdress']");
		String emailAddress = "alokbarmanqa@gmail.com";
		input_EmailAddress.fill(emailAddress);
		assertThat(input_EmailAddress).hasValue(emailAddress);

		// Phone
		Locator label_Phone = page.getByText("Phone*");
		System.out.println(">>>>>" + label_Phone.textContent());
		assertThat(label_Phone).isVisible();
		assertThat(label_Phone).hasText("Phone*");
		Locator input_Phone = page.locator("input[ng-model='Phone']");
		String phoneNumber = "1234567890";
		input_Phone.fill(phoneNumber);
		assertThat(input_Phone).hasValue(phoneNumber);

		// Gender
		Locator label_Gender = page.getByText("Gender*");
		System.out.println(">>>>>>" + label_Gender.textContent());
		assertThat(label_Gender).isVisible();
		assertThat(label_Gender).hasText("Gender*");

		// FeMale radio button
		Locator radio_FeMale = page.getByLabel("FeMale", new Page.GetByLabelOptions().setExact(true));
		assertThat(radio_FeMale).not().isChecked();
		// 2. Correct syntax if you want to include a custom failure message
		assertThat(radio_FeMale).not().isChecked(
				new LocatorAssertions.IsCheckedOptions().setTimeout(3000));
		radio_FeMale.click();
		assertThat(radio_FeMale).isChecked();
		// FeMale label
		Locator label_FeMale = page.getByText("FeMale", new Page.GetByTextOptions().setExact(true));
		System.out.println(">>>>>>>" + label_FeMale.textContent());
		assertThat(label_FeMale).isVisible();
		assertThat(label_FeMale).hasText("FeMale");

		// Male rdio button
		Locator radio_Male = page.getByLabel("Male", new Page.GetByLabelOptions().setExact(true));
		assertThat(radio_Male).not().isChecked();
		radio_Male.click();
		assertThat(radio_Male).isChecked();
		// Male label
		Locator label_Male = page.getByText("Male", new Page.GetByTextOptions().setExact(true));
		System.out.println(">>>>>>>>" + label_Male.textContent());
		assertThat(label_Male).isVisible();
		assertThat(label_Male).hasText("Male");

		// Hobbies
		Locator label_Hobbies = page.getByText("Hobbies");
		System.out.println(">>>>>>>>>" + label_Hobbies.textContent());
		assertThat(label_Hobbies).isVisible();
		assertThat(label_Hobbies).hasText("Hobbies");
		// Cricket checkbox
		Locator checkbox_Cricket = page.locator("#checkbox1");
		assertThat(checkbox_Cricket).not().isChecked();
		// checkbox_Cricket.check();
		checkbox_Cricket.click();
		// how to verify checkbox is checked or not?
		assertThat(checkbox_Cricket).isChecked();
		Locator label_Cricket = page.getByText("Cricket");
		System.out.println(">>>>>>>>>>" + label_Cricket.textContent());
		assertThat(label_Cricket).isVisible();
		assertThat(label_Cricket).hasText("Cricket");
		// Movies checkbox
		Locator checkbox_Movies = page.locator("#checkbox2");
		assertThat(checkbox_Movies).not().isChecked();
		checkbox_Movies.check();
		assertThat(checkbox_Movies).isVisible();
		assertThat(checkbox_Movies).isChecked();
		Locator label_Movies = page.getByText("Movies");
		System.out.println(">>>>>>>>>>>" + label_Movies.textContent());
		assertThat(label_Movies).isVisible();
		assertThat(label_Movies).hasText("Movies");
		// Hockey checkbox
		Locator checkbox_Hockey = page.locator("#checkbox3");
		assertThat(checkbox_Hockey).not().isChecked();
		checkbox_Hockey.check();
		assertThat(checkbox_Hockey).isVisible();
		assertThat(checkbox_Hockey).isChecked();
		Locator label_Hockey = page.getByText("Hockey");
		System.out.println(">>>>>>>>>>>>" + label_Hockey.textContent());
		assertThat(label_Hockey).isVisible();
		assertThat(label_Hockey).hasText("Hockey");

		// Languages
		Locator label_Languages = page.getByText("Languages");
		System.out.println(">>>>>>>>>>>>>" + label_Languages.textContent());
		assertThat(label_Languages).isVisible();
		assertThat(label_Languages).hasText("Languages");

		// Locator input_Languages = page.locator("div#msdd");
		// input_Languages.click();
		SelectALanguageFromTheLanguagesDropdown.selectLanguage(page, "English");
		label_Languages.click();

		// Skills
		Locator label_Skills = page.getByText("Skills", new Page.GetByTextOptions().setExact(true));
		System.out.println(">>>>>>>>>>>>>>>" + label_Skills.textContent());
		assertThat(label_Skills).isVisible();
		assertThat(label_Skills).hasText("Skills");

		Locator select_Skills = page.locator("select#Skills");
		assertThat(select_Skills).isVisible();
		SelectASkillFromTheSkillsDropdown.selectSkill(page, "Java");

		// Country
		Locator label_Country = page.getByText("Country*", new Page.GetByTextOptions().setExact(true));
		System.out.println(">>>>>>>>>>>>>>>>>" + label_Country.textContent());
		assertThat(label_Country).isVisible();
		assertThat(label_Country).hasText("Country*");

		Locator select_Country_readOnly = page.locator("select#countries");
		assertThat(select_Country_readOnly).isVisible();

		Locator label_SelectCountry = page.getByText("Select Country", new Page.GetByTextOptions().setExact(true));
		System.out.println(">>>>>>>>>>>>>>>>>>" + label_SelectCountry.textContent());
		Locator label_SelectCountry_Exact = page.getByText("Select Country :");
		assertThat(label_SelectCountry_Exact).isVisible();
		assertThat(label_SelectCountry).hasText("Select Country");

		SelectACountryFromTheCountryDropdown.selectCountry(page, "United States of America");

		// Date Of Birth
		Locator label_DateOfBirth = page.getByText("Date Of Birth", new Page.GetByTextOptions().setExact(true));
		System.out.println(">>>>>>>>>>>>>>>>>>>>" + label_DateOfBirth.textContent());
		assertThat(label_DateOfBirth).isVisible();
		assertThat(label_DateOfBirth).hasText("Date Of Birth");

		int expectedYear = DateUtility.getThirtyYearsBackYear(30);
		SelectYearMonthDayFromDateOfBirthDropdown.selectYear(page, String.valueOf(expectedYear));

		String expectedMonth = DateUtility.getCurrentMonthFullName();
		SelectYearMonthDayFromDateOfBirthDropdown.selectMonth(page, expectedMonth);

		String expectedDay = DateUtility.getCurrentDayExcludingLeadingZero();
		SelectYearMonthDayFromDateOfBirthDropdown.selectDay(page, expectedDay);

		// Password
		Locator label_Password = page.getByText("Password", new Page.GetByTextOptions().setExact(true));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>" + label_Password.textContent());
		assertThat(label_Password).isVisible();
		assertThat(label_Password).hasText("Password");

		Locator input_Password = page.locator("input#firstpassword");
		assertThat(input_Password).isVisible();
		input_Password.fill("Password@1234");
		assertThat(input_Password).hasValue("Password@1234");

		Locator label_ConfirmPassword = page.getByText("Confirm Password", new Page.GetByTextOptions().setExact(true));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>" + label_ConfirmPassword.textContent());
		assertThat(label_ConfirmPassword).isVisible();
		assertThat(label_ConfirmPassword).hasText("Confirm Password");

		Locator input_ConfirmPassword = page.locator("input#secondpassword");
		input_ConfirmPassword.fill("Password@1234");
		assertThat(input_ConfirmPassword).hasValue("Password@1234");

		// Submit
		Locator button_Submit = page.locator("button#submitbtn");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>" + button_Submit.textContent());
		assertThat(button_Submit).isVisible();
		assertThat(button_Submit).hasText("Submit");

		Locator button_Refresh = page.locator("button#Button1");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>" + button_Refresh.textContent());
		assertThat(button_Refresh).isVisible();
		assertThat(button_Refresh).hasText("Refresh");

		// Click on Refresh
		button_Refresh.click();
		page.waitForTimeout(2000);

		page.close();
		browserContext.close();
		browser.close();
		playwright.close();
		System.out.println("Test Execution is completed successfully.");
	}

}
