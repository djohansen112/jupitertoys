package src.org.djohansen.basictests;

import org.openqa.selenium.WebDriver;

import src.org.djohansen.pages.contactpage;
import src.org.djohansen.pages.coreFramework;
import src.org.djohansen.pages.homepage;

public class Test2 {

    private static WebDriver driver = null;

    public static void main(String[] args) {

        //Browser object setup
        driver = coreFramework.setupChromeFramework();
        
        //Page object setup
        contactpage contactDriver = new contactpage(driver);
        homepage homepageDriver = new homepage(driver);

        //Begin Test Case 2

        // 1. Launch the URL
        driver.get(homepageDriver.baseURL);

        // 2. Go to Contact Page
        homepageDriver.btn_threeDots().click();
        homepageDriver.btn_contact().click();

        // 3. Click Submit
        contactDriver.btn_submit().click();

        // 4. Fill in the mandatory fields
        contactDriver.field_forename().sendKeys("bob");
        contactDriver.field_email().sendKeys("bob@mail.com");
        contactDriver.field_telephone().sendKeys("0400123123");
        contactDriver.field_message().sendKeys("Message test");
        contactDriver.selectorElement().selectByIndex(0);

        // 5. Verify the error messages are no longer displayed
        contactDriver.getErrorMessages();

        for (int i = 0; i < contactDriver.text_errorList().size(); i++) {
            if (contactDriver.text_errorList().get(i).getAttribute("innerText") != null) {
                System.out.println("Test Failed - error was displayed");
            }
        }

        System.out.println("Test Case 2 completed");
        coreFramework.tearDown(driver);

    }
}
