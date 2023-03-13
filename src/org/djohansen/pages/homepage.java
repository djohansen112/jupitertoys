package src.org.djohansen.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homepage {

    WebDriver driver = null;
    WebElement element = null;
    public String baseURL = "https://ec2-54-206-101-9.ap-southeast-2.compute.amazonaws.com:5200";
    
    public homepage(WebDriver driver){
        this.driver = driver;

    }

    public WebElement btn_threeDots() {

        element = driver.findElement(By.xpath("/html/body/app-root/app-responsive-toolbar/mat-toolbar/button"));

        return element;
    }

    public WebElement btn_contact() {

        element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[4]/button"));

        return element;
    }

    public WebElement btn_shop(){
        element = driver.findElement(By.xpath("/html/body/app-root/app-responsive-toolbar/mat-toolbar/div[2]/button"));
       
        return element;

    }

}