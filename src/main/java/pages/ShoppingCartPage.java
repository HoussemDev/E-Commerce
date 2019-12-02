package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "removefromcart")
    WebElement removeCheck;
    @FindBy(name = "updatecart")
    WebElement updateCartBtn;
    @FindBy(css = "input.qty-input.valid")
    public WebElement quantityTxt;
    @FindBy(css = "td.subtotal")
    public WebElement totalLbl;
    @FindBy(id="checkout")
    WebElement checkoutBtn;
    @FindBy(id = "termsofservice")
    WebElement agreeCheckBox;

    public void removeProductFromCart(){
        clickButton(removeCheck);
        clickButton(updateCartBtn);
    }
    public void updateProductQuantityInCart(String quantity){
        clearText(quantityTxt);
        setTextElementText(quantityTxt,quantity);
        clickButton(updateCartBtn);
    }
    public void openCheckOutPage(){
        clickButton(agreeCheckBox);
        clickButton(checkoutBtn);
    }
}
