package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {

    HomePage homeObject;
    UserRegistrationPage registrationObject;
    LoginPage loginObject;

    @Test(priority = 1, alwaysRun = true)
    public void UserCanRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        registrationObject = new UserRegistrationPage(driver);
        homeObject.openRegistrationPage();
        registrationObject.userRegistration("Houssem", "Mhamdi", "Houssss223ds21@gmail.com", "123456");
    }

    @Test(dependsOnMethods = {"UserCanRegisterSuccessfully"})
    public void RegisteredUserCanLogout(){
        registrationObject.userLogout();
    }
    @Test(dependsOnMethods = {"RegisteredUserCanLogout"})
    public void RegisteredUserCanLogin(){
        loginObject = new LoginPage(driver);
        homeObject.openLoginPage();
        loginObject.userLogin("Houssss223ds21@gmail.com", "123456");
        Assert.assertTrue(registrationObject.logoutLink.isDisplayed());




    }


}
