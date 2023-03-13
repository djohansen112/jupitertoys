package src.org.djohansen.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class shoppage {

    static WebElement element = null;
    WebDriver driver = null;

    public shoppage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement btn_buyitem(int index){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));  
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='product-3']/div/p/a")));

       List<WebElement> saleitems = driver.findElements(By.className("btn"));
    
       element = saleitems.get(index);

       return element;
    
    }
    public WebElement btn_cart(){

element = driver.findElement(By.xpath("/html/body/app-root/app-responsive-toolbar/mat-toolbar/div[3]/button"));

        return element;
    }

    public String text_productTitle(int index){

        List<WebElement> elementList = driver.findElements(By.className("product-title"));

        String productTitle = elementList.get(index).getText();
        return productTitle;

    }
}