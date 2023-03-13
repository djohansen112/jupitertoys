package src.org.djohansen.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class coreFramework {

    public static WebDriver setupChromeFramework(){

         //Browser object setup
         String absPath = System.getProperty("user.dir");
         String chromePath = new File(absPath + "/src/resources/chromedriver.exe").getAbsolutePath();
         System.setProperty("webdriver.chrome.driver", chromePath);
         ChromeOptions handlingSSL = new ChromeOptions();
         handlingSSL.setAcceptInsecureCerts(true);
         WebDriver driver = new ChromeDriver(handlingSSL);
        return driver;

    }
    
    public static void tearDown(WebDriver driver){
        
        //4 second cooldown to verify completed results
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println("An error has occured.");
            e.printStackTrace();
            System.exit(0);
        }

        //Clean up open objects
        driver.close();
        driver.quit();

    }

    }
