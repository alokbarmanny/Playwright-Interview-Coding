package tests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SelectASkillFromTheSkillsDropdown {
	
	/**
     * Selects a skill option from the dropdown menu by its visible text or value attribute.
     * 
     * @param page      The active Playwright Page instance.
     * @param skillName The exact text or value of the skill to select (e.g., "Adobe InDesign", "Android").
     */
    public static void selectSkill(Page page, String skillName) {
        // 1. Target the element using its unique ID attribute 'Skills'
        String dropdownSelector = "select#Skills";
        
        // 2. Ensure the element is visible on the DOM before interacting
        page.waitForSelector(dropdownSelector);
        
        // 3. Select the option cleanly using Playwright's built-in selectOption handler
        page.locator(dropdownSelector).selectOption(new SelectOption().setLabel(skillName));
        //page.locator(dropdownSelector).selectOption(new SelectOption().setValue(skillName));
        
     // Verify the Skill is selected
	    Locator selected_Skil = page.locator("select#Skills option:checked");
	    assertThat(selected_Skil).containsText(skillName);
	    System.out.println(">>>>>>>>>>>>>>>>Skill selected: " + skillName);
    }
}
