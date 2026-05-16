package tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.regex.Pattern;

public class HandlingWaitInPlaywright {
//	Action									Visible	Stable	Receives Events	Enabled	Editable
//	Locator.check()							Yes		Yes		Yes				Yes		-
//	Locator.click()							Yes		Yes		Yes				Yes		-
//	Locator.dblclick()						Yes		Yes		Yes				Yes		-
//	Locator.setChecked()					Yes		Yes		Yes				Yes		-
//	Locator.tap()							Yes		Yes		Yes				Yes		-
//	Locator.uncheck()						Yes		Yes		Yes				Yes		-
//	Locator.hover()							Yes		Yes		Yes				-		-
//	Locator.dragTo()						Yes		Yes		Yes				-		-
//	Locator.screenshot()					Yes		Yes		-				-		-
//	Locator.fill()							Yes		-		-				Yes		Yes
//	Locator.clear()							Yes		-		-				Yes		Yes
//	Locator.selectOption()					Yes		-		-				Yes		-
//	Locator.selectText()					Yes		-		-				-		-
//	Locator.scrollIntoViewIfNeeded()	-	Yes		-		-				-

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://playwright.dev/java/docs/actionability");
		
		Locator label_TimeoutError = page.locator("code:has-text('TimeoutError')");
		
		label_TimeoutError.click();
		page.waitForTimeout(3000);
		System.out.println("Clicked on TimeoutError label");
		
		//1. Basic Element & State Waits (3 Core Methods)
        // waitForSelector()
		page.waitForSelector("selector");
		
		//pauses until the page reaches.
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		
		//waitForFunction()
		page.waitForFunction("() => window.innerWidth > 0");
		
		//2. Time-Based Delay (1 Method)
		page.waitForTimeout(1000);
		
		//3. Network & Application Event Waits (4 Core Methods)

		// waitForResponse() - Wait for a specific API response
		page.waitForResponse(response -> response.url().contains("api.example.com"), () -> {
		    page.click("button#submit");
		});

		// waitForRequest() - Wait for a specific network request
		page.waitForRequest(request -> request.url().contains("data.json"), () -> {
		    page.click("button#load-data");
		});

		// waitForURL() - Wait for URL to match a pattern
		page.waitForURL(Pattern.compile(".*success.*"));

		// waitForPopup() - Wait for a popup window to open
		Page popup = page.waitForPopup(() -> {
		    page.click("a[target='_blank']");
		});
		System.out.println("Popup URL: " + popup.url());
		
		//4. Web-First Assertions (Dynamic Waiting)
		assertThat(label_TimeoutError).isVisible();//automatically checks and retries for a default 5-second window without needing an explicit waitFor... statement.
		
		page.close();
		browserContext.close();
		browser.close();
		playwright.close();
	}

}
