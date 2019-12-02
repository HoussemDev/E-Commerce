package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase {

    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    WishListPage wishListObject;
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
    public void userCanAddProductToWishList(){
        productDetailsObject = new ProductDetailsPage(driver);
        productDetailsObject.addProductToWishList();
        driver.navigate().to("https://demo.nopcommerce.com/"+"wishlist");
        wishListObject = new WishListPage(driver);
        Assert.assertTrue(wishListObject.wishListHeader.isDisplayed());
        Assert.assertTrue(wishListObject.productCell.getText().contains(productName));

    }

    @Test(priority = 3)
    public void userCanRemoveProductFromCart(){
        wishListObject = new WishListPage(driver);
        wishListObject.removeProductFromWishList();
        Assert.assertTrue(wishListObject.emptyCartLbl.getText().contains("The wishlist is empty"));
    }

}
