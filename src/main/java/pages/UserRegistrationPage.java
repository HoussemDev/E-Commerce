package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {
    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gender-male")
    WebElement genderRdoBtn;
    @FindBy(id = "FirstName")
    WebElement firstNameTxt;
    @FindBy(id = "LastName")
    WebElement lastNameTxt;
    @FindBy(id = "Email")
    WebElement emailTxt;
    @FindBy(id = "Password")
    WebElement pswdTxt;
    @FindBy(id = "ConfirmPassword")
    WebElement pswdConfirmTxt;
    @FindBy(id="register-button")
    WebElement registerBtn;

    public void userRegistration(String name, String lastName, String email, String pswd){
        genderRdoBtn.click();
        firstNameTxt.sendKeys(name);
        lastNameTxt.sendKeys(lastName);
        emailTxt.sendKeys(email);
        pswdTxt.sendKeys(pswd);
        pswdConfirmTxt.sendKeys(pswd);
        registerBtn.click();
    }

}
