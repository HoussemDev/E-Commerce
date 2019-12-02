package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase {
    public ProductReviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "AddProductReview_Title")
    WebElement reviewTitleTxt;
    @FindBy(id = "AddProductReview_ReviewText")
    WebElement reviewTxt;
    @FindBy(id = "addproductrating_5")
    WebElement rating5RdoBtn;
    @FindBy(name = "add-review")
    WebElement submitReviewBtn;
    @FindBy(css = "div.result")
    public WebElement reviewNotifcation;

    public void AddProductReview(String reviewTitle, String reviewMsg){
        setTextElementText(reviewTitleTxt, reviewTitle);
        setTextElementText(reviewTxt, reviewMsg);
        clickButton(rating5RdoBtn);
        clickButton(submitReviewBtn);
    }

}
