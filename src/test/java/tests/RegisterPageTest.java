package tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RegisterPageTest {

	public static void main(String[] args) {
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
		input_FirstName.fill("Alok");
		
		// after entering how to verify input text
		
		// Last Name
		// Locator input_LastName = page.getByRole(AriaRole.TEXTBOX, new
		// Page.GetByRoleOptions().setName("Last Name").setExact(true));
		Locator input_LastName = page.getByPlaceholder("Last Name");
		assertThat(input_LastName).isVisible();
		input_LastName.fill("Barman");
		
		// Address
		Locator label_Address = page.getByText("Address", new Page.GetByTextOptions().setExact(true));
		// Locator label_Address = page.getByText("Address");
		System.out.println(">>>" + label_Address.textContent());
		assertThat(label_Address).isVisible();
		assertThat(label_Address).hasText("Address");
		Locator input_Address = page.locator("textarea");
		input_Address.fill("3 Marshall Street, Irvington, NJ 07111");
		
		// Email address
		Locator label_EmailAddress = page.getByText("Email address*");
		System.out.println(">>>>" + label_EmailAddress.textContent());
		assertThat(label_EmailAddress).isVisible();
		assertThat(label_EmailAddress).hasText("Email address*");
		Locator input_EmailAddress = page.locator("input[ng-model='EmailAdress']");
		input_EmailAddress.fill("alokbarmanqa@gmail.com");
		
		// Phone
		Locator label_Phone = page.getByText("Phone*");
		System.out.println(">>>>>" + label_Phone.textContent());
		assertThat(label_Phone).isVisible();
		assertThat(label_Phone).hasText("Phone*");
		Locator input_Phone = page.locator("input[ng-model='Phone']");
		input_Phone.fill("1234567890");
		
		// Gender
		Locator label_Gender = page.getByText("Gender*");
		System.out.println(">>>>>>" + label_Gender.textContent());
		assertThat(label_Gender).isVisible();
		assertThat(label_Gender).hasText("Gender*");
		
		// FeMale radio button
		Locator radio_FeMale = page.getByLabel("FeMale", new Page.GetByLabelOptions().setExact(true));
		radio_FeMale.click();
		assertThat(radio_FeMale).isChecked();
		// FeMale label
		Locator label_FeMale = page.getByText("FeMale", new Page.GetByTextOptions().setExact(true));
		System.out.println(">>>>>>>" + label_FeMale.textContent());
		assertThat(label_FeMale).isVisible();
		assertThat(label_FeMale).hasText("FeMale");
		
		// Male rdio button
		Locator radio_Male = page.getByLabel("Male", new Page.GetByLabelOptions().setExact(true));
		radio_Male.click();
		assertThat(radio_Male).isChecked();
		// Male label
		Locator label_Male = page.getByText("Male", new Page.GetByTextOptions().setExact(true));
		System.out.println(">>>>>>>>" + label_Male.textContent());
		assertThat(label_Male).isVisible();
		assertThat(label_Male).hasText("Male");
		
		// Hobbies
		Locator label_Hobbies = page.getByText("Hobbies");
		System.out.println(">>>>>>>>>"+ label_Hobbies.textContent());
		assertThat(label_Hobbies).isVisible();
		assertThat(label_Hobbies).hasText("Hobbies");
		// Cricket checkbox
		Locator checkbox_Cricket = page.locator("#checkbox1");
		//checkbox_Cricket.check();
		checkbox_Cricket.click();
		//how to verify checkbox is checked or not?
		assertThat(checkbox_Cricket).isChecked();
		Locator label_Cricket = page.getByText("Cricket");
		System.out.println(">>>>>>>>>>" + label_Cricket.textContent());
		assertThat(label_Cricket).isVisible();
		assertThat(label_Cricket).hasText("Cricket");
		// Movies checkbox
		Locator checkbox_Movies = page.locator("#checkbox2");
		checkbox_Movies.check();
		assertThat(checkbox_Movies).isVisible();
		assertThat(checkbox_Movies).isChecked();
		Locator label_Movies = page.getByText("Movies");
		System.out.println(">>>>>>>>>>>" + label_Movies.textContent());
		assertThat(label_Movies).isVisible();
		assertThat(label_Movies).hasText("Movies");
		// Hockey checkbox
		Locator checkbox_Hockey = page.locator("#checkbox3");
		checkbox_Hockey.check();
		assertThat(checkbox_Hockey).isVisible();
		assertThat(checkbox_Hockey).isChecked();
		Locator label_Hockey = page.getByText("Hockey");
		System.out.println(">>>>>>>>>>>>" + label_Hockey.textContent());
		assertThat(label_Hockey).isVisible();
		assertThat(label_Hockey).hasText("Hockey");
		
		// Languages
		Locator label_Languages = page.getByText("Languages");
		System.out.println(">>>>>>>>>>>>>"+label_Languages.textContent());
		assertThat(label_Languages).isVisible();
		assertThat(label_Languages).hasText("Languages");

//		Locator input_Languages = page.locator("div#msdd");
//		input_Languages.click();
		SelectALanguageFromTheLanguagesDropdown.selectLanguage(page, "English");
		label_Languages.click();
		
		//Skills
		Locator label_Skills = page.getByText("Skills", new Page.GetByTextOptions().setExact(true));
		System.out.println(">>>>>>>>>>>>>>>"+label_Skills.textContent());
		assertThat(label_Skills).isVisible();
		assertThat(label_Skills).hasText("Skills");

		Locator select_Skills = page.locator("select#Skills");
		assertThat(select_Skills).isVisible();
		SelectASkillFromTheSkillsDropdown.selectSkill(page, "Java");
		
		// Country
		Locator label_Country = page.getByText("Country*", new Page.GetByTextOptions().setExact(true));
		System.out.println(">>>>>>>>>>>>>>>>>"+label_Country.textContent());
		assertThat(label_Country).isVisible();
		assertThat(label_Country).hasText("Country*");

		Locator select_Country_readOnly = page.locator("select#countries");
		assertThat(select_Country_readOnly).isVisible();

		Locator label_SelectCountry = page.getByText("Select Country", new Page.GetByTextOptions().setExact(true));
		System.out.println(">>>>>>>>>>>>>>>>>>"+label_SelectCountry.textContent());
		assertThat(label_SelectCountry).isVisible();
		assertThat(label_SelectCountry).hasText("Select Country");
		
		SelectACountryFromTheCountryDropdown.selectCountry(page, "United States of America");
		
		
		
		
		
		
		
		
		
		
		
		
		
//		page.close();
//		browserContext.close();
//		browser.close();
//		playwright.close();
		System.out.println("Test Execution is completed successfully.");
	}

}
