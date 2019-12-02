package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase{

    HomePage homeObject;
    UserRegistrationPage registrationObject;
    MyAccountPage myAccountObject;
    LoginPage loginObject;

    String oldPassword = "1234567";
    String newPassword ="12345678";
    String firstName= "Houssem";
    String lastName= "Mhamdi";
    String email = "Houssss223ds216@gmail.com";

    @Test(priority = 1)
    public void UserCanRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        registrationObject = new UserRegistrationPage(driver);
        homeObject.openRegistrationPage();
        registrationObject.userRegistration(firstName, lastName, email, oldPassword);
        Assert.assertTrue(registrationObject.successMsg.getText().contains("Your registration completed"));
    }

    @Test(priority = 2 )
    public void RegisteredUserCanChangePassword(){
        myAccountObject = new MyAccountPage(driver);
        registrationObject.openMyAccountPage();
        myAccountObject.openChangePasswordPage();
        myAccountObject.changePassword(oldPassword, newPassword);
        Assert.assertTrue(myAccountObject.resultLbl.getText().contains("Password was changed"));

    }

    @Test(priority = 3)
    public void RegisteredUserCanLogout(){
        registrationObject.userLogout();
    }
    @Test(priority = 4)
    public void RegisteredUserCanLogin(){
        loginObject = new LoginPage(driver);
        homeObject.openLoginPage();
        loginObject.userLogin(email, newPassword);
        Assert.assertTrue(registrationObject.logoutLink.isDisplayed());




    }

}
