package src.org.djohansen.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class contactpage {

    static WebElement element = null;
    WebDriver driver = null;

    public contactpage(WebDriver driver) {
        this.driver = driver;
    }

    public String[] getErrorMessages() {

        String[] errorList = { "Forename is required",
                "Email is required",
                "telephone is required",
                "Type is required",
                "Message is required" };
        return errorList;

    }

    public Select selectorElement() {

        WebElement selectDriver = driver.findElement(By.name("type"));
        Select select = new Select(selectDriver);

        return select;

    }

    public WebElement btn_submit() {
        element = driver.findElement(By.cssSelector("button[type='submit']"));

        return element;
    }

    public WebElement field_forename() {
        element = driver.findElement(By.name("forename"));

        return element;
    }

    public WebElement field_email() {
        element = driver.findElement(By.name("email"));

        return element;
    }

    public WebElement field_telephone() {
        element = driver.findElement(By.name("telephone"));

        return element;
    }

    public WebElement field_message() {
        element = driver.findElement(By.name("message"));

        return element;
    }

    public List<WebElement> text_errorList() {

        List<WebElement> errorList = driver.findElements(By.tagName("mat-error"));

        return errorList;

    }

    public boolean is_emailError() {

        boolean emailError = false;

        List<WebElement> errorList = driver.findElements(By.id("email-err"));

        for (int i = 0; i < errorList.size(); i++) {

            if (errorList.get(i).getAttribute("innerText").contains("email"))
                emailError = true;
        }

        return emailError;

    }

    public boolean is_telephoneError() {

        boolean telephoneError = false;

        List<WebElement> errorList = driver.findElements(By.id("email-err"));

        for (int i = 0; i < errorList.size(); i++) {

            if (errorList.get(i).getAttribute("innerText").contains("telephone"))
                telephoneError = true;
        }

        return telephoneError;

    }
}