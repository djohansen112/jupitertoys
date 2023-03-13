package src.org.djohansen.basictests;

import org.openqa.selenium.WebDriver;

import src.org.djohansen.pages.contactpage;
import src.org.djohansen.pages.coreFramework;
import src.org.djohansen.pages.homepage;
import src.org.djohansen.pages.feedbackpage;

public class Test3 {

    private static WebDriver driver = null;

    public static void main(String[] args) {

        //Browser object setup
        driver = coreFramework.setupChromeFramework();

        //Page object setup
        contactpage contactDriver = new contactpage(driver);
        homepage homepageDriver = new homepage(driver);
        feedbackpage feedbackDriver = new feedbackpage(driver);
        
        //Begin Test Case 3

        // 1. Launch the URL
        driver.get(homepageDriver.baseURL);

        // 2. Go to Contact Page
        homepageDriver.btn_threeDots().click();
        homepageDriver.btn_contact().click();

        // 3. Click Submit
        contactDriver.btn_submit().click();

        // 4. Fill in the mandatory fields
        contactDriver.field_forename().sendKeys("Bob");
        contactDriver.field_email().sendKeys("bob@mail.com");
        contactDriver.field_telephone().sendKeys("0400123123");
        contactDriver.field_message().sendKeys("Message test");
        contactDriver.selectorElement().selectByIndex(0);

        // 5. Verify the feedback has been submitted
        contactDriver.btn_submit().click();
        if (feedbackDriver.is_alertSuccess()) {
            System.out.println("Test 3 PASSED");
        } else {
            System.out.println("Test 3 FAILED");
        }

        System.out.println("Test Case 3 completed");
        coreFramework.tearDown(driver);

    }
}
