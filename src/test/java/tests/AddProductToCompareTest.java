package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompareTest extends TestBase {

    String firstProductName="Apple MacBook Pro 13-inch";
    String secondProductName="Asus N551JK-XO076H Laptop";

    // 1- Search for product One
    // 2- Search for product Two
    // 3- Add to compare
    // 4- Clear List

    ProductDetailsPage detailsObject;
    HomePage homeObject;
    ComparePage compareObject;
    SearchPage searchObject;

    @Test(priority = 1)
    public void userCanCompareProducts(){
        searchObject = new SearchPage(driver);
        detailsObject = new ProductDetailsPage(driver);
        compareObject = new ComparePage(driver);

        searchObject.productSearchAutoSuggest("MacB");
        //Assert.assertTrue(detailsObject.productNameThreadCrumb.getText().contains(firstProductName));
        detailsObject.addProductToCompare();

        searchObject.productSearchAutoSuggest("Asus");
       // Assert.assertTrue(detailsObject.productNameThreadCrumb.getText().contains(secondProductName));
        detailsObject.addProductToCompare();

        driver.navigate().to("https://demo.nopcommerce.com"+"/compareproducts");
        compareObject.compareProducts();

    }

    @Test(priority = 2)
    public void userCanClearCompareList(){
        compareObject.clearCompareList();
    }


}
