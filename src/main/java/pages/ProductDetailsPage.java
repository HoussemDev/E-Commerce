package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "strong.current-item")
    public WebElement productNameThreadCrumb;
    @FindBy(css = "input.button-2.email-a-friend-button.valid")
    public WebElement emailFriendBtn;
    @FindBy(css = "span.price-value-4")
    public WebElement productPriceLbl;
    @FindBy(linkText = "Add your review")
    WebElement addReviewLink;
    @FindBy(id = "add-to-wishlist-button-4")
    WebElement addToWishListBtn;
    @FindBy(css = "div.compare-products")
    WebElement addToCompareBnt;
    @FindBy(id = "add-to-cart-button-4")
    WebElement addToCartBtn;
    public void openSendEmailPage(){
        clickButton(emailFriendBtn);
    }
    public void openAddReviewPage(){ clickButton(addReviewLink);}
    public void addProductToWishList(){
        clickButton(addToWishListBtn);
    }
    public void addProductToCompare(){
        clickButton(addToCompareBnt);
    }
    public void addProductToCart(){
        clickButton(addToCartBtn);
    }
}
