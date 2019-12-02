package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AddProductReviewTest extends TestBase {

    HomePage homeObject;
    UserRegistrationPage registrationObject;
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    ProductReviewPage reviewObject;
    String productName= "Apple MacBook Pro 13-inch";

    @Test(priority = 1, alwaysRun = true)
    public void UserCanRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        registrationObject = new UserRegistrationPage(driver);
        homeObject.openRegistrationPage();
        registrationObject.userRegistration("Houssem", "Mhamdi", "Houssss223ds2333@gmail.com", "123456");
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
    public void RegisteredUserCanReviewProduct(){
        productDetailsObject.openAddReviewPage();
        reviewObject = new ProductReviewPage(driver);
        reviewObject.AddProductReview("new review", "This product is very good");
        Assert.assertTrue(reviewObject.reviewNotifcation.getText().contains("Product review is successfully"));
    }

    @Test(priority = 4)
    public void RegisteredUserCanLogout(){
        registrationObject.userLogout();
    }

}
