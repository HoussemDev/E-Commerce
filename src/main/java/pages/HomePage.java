package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    @FindBy(css = "a.ico-register")
    WebElement registerLink;
    @FindBy(linkText = "Log in")
    WebElement loginLink;
    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;
    @FindBy(id = "customerCurrency")
    WebElement currencyDrpList;
    @FindBy(partialLinkText = "Computers")
    WebElement computerMenu;
    @FindBy(partialLinkText = "Notebooks")
    WebElement noteBooksMenu;

    public void openRegistrationPage(){
        clickButton(registerLink);
    }
    public void openLoginPage(){
        clickButton(loginLink);
    }
    public void openContactUsPage(){
        scrollToBottom();
        clickButton(contactUsLink);
    }
    public void changeCurrency(){
        select = new Select(currencyDrpList);
        select.selectByVisibleText("Euro");
    }
    public void selectNoteBooksMenu(){
        actions.moveToElement(computerMenu).moveToElement(noteBooksMenu).click().build().perform();
    }
}
