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
    @FindBy(css = "div.result")
    public WebElement successMsg;
    @FindBy(linkText = "Log out")
    public WebElement logoutLink;
    @FindBy(linkText = "My account")
    WebElement myAccountLink;

    public void userRegistration(String name, String lastName, String email, String pswd){
        clickButton(genderRdoBtn);
        setTextElementText(firstNameTxt, name);
        setTextElementText(lastNameTxt, lastName);
        setTextElementText(emailTxt, email);
        setTextElementText(pswdTxt, pswd);
        setTextElementText(pswdConfirmTxt, pswd);
        clickButton(registerBtn);
    }

    public void userLogout(){
        clickButton(logoutLink);
    }
    public void openMyAccountPage(){
        clickButton(myAccountLink);
    }


}
