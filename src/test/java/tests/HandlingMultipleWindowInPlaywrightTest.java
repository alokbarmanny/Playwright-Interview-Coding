
package tests;

import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HandlingMultipleWindowInPlaywrightTest {
	/*
	 * To handle multiple windows, tabs, or pop-ups in Playwright Java, you must
	 * utilize the BrowserContext.waitForPage() method.
	 */
	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext();
			Page page = context.newPage();
			page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			page.waitForLoadState();
			assertThat(page.locator("button[type='submit']")).containsText("Login");

			Page linkedinPage = context.waitForPage(() -> page.locator("a[href*='linkedin']").first().click());
			linkedinPage.waitForLoadState();
			assertThat(linkedinPage.locator("h2:has-text('About us')")).containsText("About us");
			// linkedinPage.close();
			page.bringToFront();

			Page facebookPage = context.waitForPage(() -> page.locator("a[href*='facebook']").first().click());
			facebookPage.waitForLoadState();
			assertThat(facebookPage.locator("span:has-text('Intro')").first()).containsText("Intro");
			// facebookPage.close();
			page.bringToFront();

			Page twitterPage = context.waitForPage(() -> page.locator("a[href*='twitter']").first().click());
			twitterPage.waitForLoadState();
			assertThat(twitterPage.locator("body")).containsText("orangehrm");
			// twitterPage.close();
			page.bringToFront();

			assertThat(page.locator(
					"//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header' and text()='Forgot your password? ']"))
					.containsText("Forgot your password?");

			System.out.println("All verifications passed successfully!");
			browser.close();
		}
	}
}
