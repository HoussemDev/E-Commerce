package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase {
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    ShoppingCartPage cartObject;
    String productName= "Apple MacBook Pro 13-inch";


    @Test(priority = 1)
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

    @Test(priority = 2)
    public void userCanAddProductToShoppingCart() throws InterruptedException {
        productDetailsObject = new ProductDetailsPage(driver);
        productDetailsObject.addProductToCart();
        Thread.sleep(1000);
        driver.navigate().to("https://demo.nopcommerce.com/"+"cart");
    }

    @Test(priority = 3)
    public void userCanRemoveProductFromCart(){
        cartObject = new ShoppingCartPage(driver);
        cartObject.removeProductFromCart();
    }
}
