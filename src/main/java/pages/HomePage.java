package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.ico-register")
    WebElement registerLink;

    public void openRegistrationPage(){
        registerLink.click();
    }

}
