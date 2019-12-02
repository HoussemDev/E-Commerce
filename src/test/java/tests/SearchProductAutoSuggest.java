package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductAutoSuggest extends TestBase {
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    String productName= "Apple MacBook Pro 13-inch";


    @Test
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

}
