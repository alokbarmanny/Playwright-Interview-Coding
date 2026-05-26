package tests;

import com.microsoft.playwright.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class VisualTest {
	
    public static void main(String[] args) throws IOException {
    	
    	try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext();
			Page page = context.newPage();
            page.navigate("https://automationtesting.in");

         // 1. Capture the live screenshot bytes of the locator
            Locator registrationForm = page.locator("#main");
            byte[] liveScreenshot = registrationForm.screenshot();

            // 2. Load your reference baseline image bytes
            byte[] baselineScreenshot = Files.readAllBytes(Paths.get("registration-form-baseline.png"));

            // 3. Assert they are identical
            boolean isMatch = Arrays.equals(liveScreenshot, baselineScreenshot);
            if (!isMatch) {
                // Optional: Save the failed live screenshot to a diff folder
                Files.write(Paths.get("failed-diff.png"), liveScreenshot);
                throw new AssertionError("Visual test failed: Screenshots do not match!");
            }
            System.out.println("Visual test passed: Screenshots match!");
        }
    }
}

