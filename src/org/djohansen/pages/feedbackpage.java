package src.org.djohansen.pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class feedbackpage {

    WebDriver driver = null;

    public feedbackpage(WebDriver driver){
        this.driver = driver;
    }

    public boolean is_alertSuccess() {
     
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));  
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'we appreciate your feedback.')]")));
           
        if(driver.findElement(By.xpath("//div[contains(text(),'we appreciate your feedback.')]")).isDisplayed()) {
            return true;
        } else {
            return false;
        }

    }

}