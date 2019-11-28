package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {

    HomePage homeObject;
    UserRegistrationPage registrationObject;

    @Test
    public void UserCanRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        registrationObject = new UserRegistrationPage(driver);
        homeObject.openRegistrationPage();
        registrationObject.userRegistration("Houssem", "Mhamdi", "Houss2321@gmail.com", "123456");


    }
}
