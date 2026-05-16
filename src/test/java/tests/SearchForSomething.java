package tests;

import java.util.Arrays;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SearchForSomething {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions()
				.setHeadless(false)
				.setArgs(Arrays.asList("--disable-blink-features=AutomationControlled")));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://www.google.com");
		page.waitForTimeout(3000);
		
		Locator searchBoxLocator = page.locator("#APjFqb");
		//String searchBox = "textarea[name='q']";
		
		//page.fill(searchBox, "9/11 attack");
		//page.press(searchBox, "Enter");
		
		searchBoxLocator.fill("9/11 attack");
		searchBoxLocator.press("Enter");
		page.waitForTimeout(3000);
		
		page.close();
		browserContext.close();
		browser.close();
		playwright.close();
	}

}
