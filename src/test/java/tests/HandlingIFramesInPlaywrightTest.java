package tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HandlingIFramesInPlaywrightTest {

	public static void main(String[] args) {
		// To handle IFrames (inline frames) in Playwright Java, you must switch from the main page context to a FrameLocator context [1, 2].
		// Playwright manages this automatically without requiring you to manually switch back to the default content afterward [2]. It keeps track of the frame context automatically [2].
		// page.frameLocator("css_selector"): Best for targeting an iframe via its id, name, or any valid CSS attribute [1].
		// page.mainFrame().childFrames(): Best if you need to loop through nameless frames via index positions.
		// FrameLocator nestedFrame = page.frameLocator("#parentIframe").frameLocator("#childIframe");
		// nestedFrame.locator("#targetButton").click();
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://w3schools.com");
		
		FrameLocator mainFrameLocator = page.frameLocator("iframe#howto_iframe");
		System.out.println("****************************");
		Locator image_RightArrow = mainFrameLocator.locator("a[onclick='plusSlides(1)']");
		page.pause();
		image_RightArrow.scrollIntoViewIfNeeded();
		System.out.println(image_RightArrow.textContent());
		Locator first_image_text = mainFrameLocator.locator("text=Caption Text");
		
		assertThat(first_image_text).hasText("Caption Text");
		image_RightArrow.click();
		page.waitForTimeout(2000);
		Locator second_image_text = mainFrameLocator.locator("text=Caption Two");
		assertThat(second_image_text).hasText("Caption Two");
		
		image_RightArrow.click();
		page.waitForTimeout(2000);
		Locator third_image_text = mainFrameLocator.locator("text=Caption Three");
		assertThat(third_image_text).hasText("Caption Three");
		image_RightArrow.click();
		page.waitForTimeout(2000);
		assertThat(first_image_text).hasText("Caption Text");
		System.out.println(">Clicked the right arrow in the IFrame successfully!");
	}

}
