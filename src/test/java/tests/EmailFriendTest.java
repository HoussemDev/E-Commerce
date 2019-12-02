package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class EmailFriendTest extends TestBase {

    HomePage homeObject;
    UserRegistrationPage registrationObject;
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    EmailPage emailObject;
    String productName= "Apple MacBook Pro 13-inch";

    @Test(priority = 1, alwaysRun = true)
    public void UserCanRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        registrationObject = new UserRegistrationPage(driver);
        homeObject.openRegistrationPage();
        registrationObject.userRegistration("Houssem", "Mhamdi", "Houssss223ds231@gmail.com", "123456");
        Assert.assertTrue(registrationObject.successMsg.getText().contains("Your registration completed"));
    }


    @Test(priority = 2)
    public void userCanSearchAutoSuggest(){
        try {
            searchObject = new SearchPage(driver);
            searchObject.productSearchAutoSuggest("MacB");
            productDetailsObject = new ProductDetailsPage(driver);
            Assert.assertEquals(productDetailsObject.productNameThreadCrumb.getText(), productName);

        }catch (Exception e){
            System.out.println("Error occured " + e.getMessage() );
        }
    }

    @Test(priority = 3)
    public void registeredUserCanSendProductToFriend(){
        productDetailsObject.openSendEmailPage();
        emailObject = new EmailPage(driver);
        emailObject.SendEmailToFriend("houss.sword@gmail.com", "Hello houssem from Automation Test");
        Assert.assertTrue(emailObject.msgNotification.getText().contains("Your message has been sent"));

    }

    @Test(priority = 4)
    public void RegisteredUserCanLogout(){
        registrationObject.userLogout();
    }

}
