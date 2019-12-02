package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{
    ProductDetailsPage productDetailsObject;
    HomePage homeObject;
    SearchPage searchObject;
    String productName= "Apple MacBook Pro 13-inch";

    @Test(priority = 1)
    public void UserCanChangeCurrency(){
        homeObject = new HomePage(driver);
        homeObject.changeCurrency();
    }

    @Test(priority = 2)
    public void userCanSearchAutoSuggest(){
        try {
            searchObject = new SearchPage(driver);
            searchObject.productSearchAutoSuggest("MacB");
            productDetailsObject = new ProductDetailsPage(driver);
            Assert.assertTrue(productDetailsObject.productPriceLbl.getText().contains("Ђ"));
            System.out.println(productDetailsObject.productPriceLbl.getText());

        }catch (Exception e){
            System.out.println("Error occured " + e.getMessage() );
        }
    }
}
