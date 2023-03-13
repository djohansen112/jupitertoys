package src.org.djohansen.mediumtests;

import org.openqa.selenium.WebDriver;

import src.org.djohansen.pages.cartpage;
import src.org.djohansen.pages.coreFramework;
import src.org.djohansen.pages.homepage;
import src.org.djohansen.pages.shoppage;

public class Test1 {

    private static WebDriver driver = null;

    public static void main(String[] args) {

        // Setup driver
        driver = coreFramework.setupChromeFramework();

        // Page object setup
        shoppage shopDriver = new shoppage(driver);
        homepage homepageDriver = new homepage(driver);
        cartpage cartDriver = new cartpage(driver);

        // Begin Test Case 1

        // 1. Launch the above URL
        driver.get(homepageDriver.baseURL);

        // 2. Go to the Shop Page
        homepageDriver.btn_shop().click();

        // 3. Click buy for any 2 products
        shopDriver.btn_buyitem(0).click();
        String shoptoy1 = shopDriver.text_productTitle(0);
        
        shopDriver.btn_buyitem(1).click();
        String shoptoy2 = shopDriver.text_productTitle(1);

        // 4. Click the cart page
        shopDriver.btn_cart().click();

        // 5. Verify the items are in the cart
        if (shoptoy1.equalsIgnoreCase(cartDriver.text_cartItem(0)) && shoptoy2.equalsIgnoreCase(cartDriver.text_cartItem(1))) {
            System.out.println("Test 1 Medium PASSED");
        } else {
            System.out.println("Test 1 Medium FAILED");
        }

        System.out.println("Test Medium 1 completed");
        coreFramework.tearDown(driver);
    }

}
