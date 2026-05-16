package tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RouteTrafficThroughResidentialProxies {

	public static void main(String[] args) {
        Playwright playwright = Playwright.create();

        try {
            BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setProxy("http://username:password@192.168.1.158:8080");

            Browser browser = playwright.chromium().launch(launchOptions);

            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();
            page.navigate("https://www.google.com");
            System.out.println("Page title: " + page.title());

            browser.close();
            playwright.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            playwright.close();
        }
    }

}
