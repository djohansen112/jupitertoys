package src.org.djohansen.basictests;

import org.openqa.selenium.WebDriver;

import src.org.djohansen.pages.contactpage;
import src.org.djohansen.pages.coreFramework;
import src.org.djohansen.pages.homepage;


public class Test4 {

    private static WebDriver driver = null;

    public static void main(String[] args) {

        //Browser object setup
        driver = coreFramework.setupChromeFramework();

        //Page object setup
        contactpage contactDriver = new contactpage(driver);
        homepage homepageDriver = new homepage(driver);

        //Begin Test Case 4

        // 1. Launch the URL
        driver.get(homepageDriver.baseURL);

        // 2. Go to Contact Page
        homepageDriver.btn_threeDots().click();
        homepageDriver.btn_contact().click();

        // 3. Fill in an invalid email address and phone number
        contactDriver.field_forename().sendKeys("Bob");
        contactDriver.field_email().sendKeys("bobmailcom");
        contactDriver.field_telephone().sendKeys("bob");
        contactDriver.field_message().sendKeys("Message test");
        contactDriver.selectorElement().selectByIndex(0);
        contactDriver.btn_submit().click();

        // 4. Verify the error messages displayed
        if (contactDriver.is_emailError() 
            && contactDriver.is_telephoneError()) {
            System.out.println("Test 4 PASSED");
        } else {
            System.out.println("Test 4 FAILED");
        }

        System.out.println("Test Case 4 completed");
        coreFramework.tearDown(driver);

    }
}