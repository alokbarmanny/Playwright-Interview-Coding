package tests;

import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class MultiWindowHandlingTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            // 1. Launch a visible Chrome instance
            Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
            );
            
            // 2. Initialize the BrowserContext session
            BrowserContext context = browser.newContext();
            
            // 3. Open the main parent test page
            Page parentPage = context.newPage();
            parentPage.navigate("https://demo.automationtesting.in/Windows.html");

            // Locators on the main parent page
            Locator newTabButton = parentPage.locator("#Tabbed button");
            Locator parentHeader = parentPage.locator("h1");

            // 4. Capture the creation of the new window/tab asynchronously
            // waitForPage() listens for the exact event where a click triggers a popup window
            Page popupPage = context.waitForPage(() -> {
                newTabButton.click(); // This execution triggers the new tab to load
            });

            // 5. Interact directly with the newly opened Popup window
            // Wait for the new page DOM to become fully interactive
            popupPage.waitForLoadState();
            
            System.out.println("Popup Page Title: " + popupPage.title());
            System.out.println("Popup Page URL: " + popupPage.url());
            
            // Assert that the popup window successfully navigated to the target URL domain
            assertThat(popupPage).hasURL("https://www.selenium.dev/");

            // Close the child window explicitly when finished
            popupPage.close();

            // 6. Return control to the main Parent page immediately
            // No custom switch rules are required—simply reuse your 'parentPage' variable reference
            parentPage.bringToFront(); // Focuses visual window view back onto the parent tab
            assertThat(parentHeader).hasText("Frames & windows");
            
            System.out.println("Returned to parent page: " + parentPage.title());

            browser.close();
        }
    }
}
