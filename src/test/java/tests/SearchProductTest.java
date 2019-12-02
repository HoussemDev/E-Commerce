package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase {
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;

    String productName= "Apple MacBook Pro 13-inch";

    @Test
    public void UserCanSearchForProducts(){
        searchObject = new SearchPage(driver);
        productDetailsObject = new ProductDetailsPage(driver);
        searchObject.productSearch(productName);
        searchObject.openProductDetailsPage();
       // Assert.assertTrue(productDetailsObject.productNameThreadCrumd.getText().equalsIgnoreCase(productName));
        Assert.assertEquals(productDetailsObject.productNameThreadCrumb.getText(), productName);

    }
}
