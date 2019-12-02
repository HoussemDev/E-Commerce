package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends PageBase {

    public SearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "small-searchterms")
    WebElement searchTxtBox;
    @FindBy(css = "input.button-1.search-box-button")
    WebElement searchBtn;
    @FindBy(id = "ui-id-1")
    List<WebElement> productList;
    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    WebElement productTitle;
    public void productSearch(String productName){
        setTextElementText(searchTxtBox, productName);
        clickButton(searchBtn);

    }
    public void openProductDetailsPage(){
        clickButton(productTitle);
    }
    public void productSearchAutoSuggest(String searchTxt ){
        setTextElementText(searchTxtBox, searchTxt);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productList.get(0).click();
    }

}
