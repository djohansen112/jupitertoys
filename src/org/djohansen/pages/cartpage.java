package src.org.djohansen.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cartpage {

    WebElement element = null;
    WebDriver driver = null;


    public cartpage(WebDriver driver) {
        this.driver = driver;
    }


    public String text_cartItem(int index){

        List<WebElement> elementList = driver.findElements(By.className("mat-column-item"));

        //Find the element text, starting at index + 1 because of the table title row
        String cartItem = elementList.get(index+1).getText();

        return cartItem;

    }
    
}
