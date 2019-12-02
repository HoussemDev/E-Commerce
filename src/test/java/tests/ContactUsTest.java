package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {

    HomePage homeObject;
    ContactUsPage contactUsObject;

    String email = "test.test@gmail.com";
    String fullName = "Test User";
    String enquiry = "Hello Admin, This is for Test";

    @Test
    public void UserCanUseContactUs(){
        homeObject = new HomePage(driver);
        homeObject.openContactUsPage();
        contactUsObject = new ContactUsPage(driver);
        contactUsObject.ContactUs(fullName,email,enquiry);
        Assert.assertTrue(contactUsObject.successMsg.getText().contains("Your enquiry has been"));
    }
}
