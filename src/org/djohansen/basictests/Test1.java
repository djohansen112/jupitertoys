package src.org.djohansen.basictests;

import org.openqa.selenium.WebDriver;

import src.org.djohansen.pages.contactpage;
import src.org.djohansen.pages.coreFramework;
import src.org.djohansen.pages.homepage;

public class Test1 {

    private static WebDriver driver = null;

    public static void main(String[] args) {

       
        //Setup driver
        driver = coreFramework.setupChromeFramework();

        //Page object setup
        contactpage contactDriver = new contactpage(driver);
        homepage homepageDriver = new homepage(driver);

        //Begin Test Case 1

        // 1. Launch the URL
        driver.get(homepageDriver.baseURL);

        // 2. Go to Contact Page
        homepageDriver.btn_threeDots().click();
        homepageDriver.btn_contact().click();

        
        // 3. Click Submit
        contactDriver.btn_submit().click();

        // 4. Verify the error messages displayed
        for (int i = 0; i < contactDriver.text_errorList().size(); i++) {
            String errortext = contactDriver.text_errorList().get(i).getAttribute("innerText");

            if (contactDriver.getErrorMessages()[i].equals(errortext)) {
                System.out.println("Error message " + (i+1) + " is correct");
            } else {
                System.out.println("Test Case 1 FAILED");
            }
        }

        System.out.println("Test Case 1 completed");
        coreFramework.tearDown(driver);
    }

}
