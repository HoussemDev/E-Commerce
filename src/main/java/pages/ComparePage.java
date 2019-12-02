package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ComparePage extends PageBase {
    public ComparePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "a.clear-list")
    WebElement clearListLink;
    @FindBy(css = "div.no-data")
    WebElement noDataLbl;
    @FindBy(css = "table.compare-products-table")
    WebElement compareTable;
    @FindBy(tagName = "tr")
    public List<WebElement> allRows;
    @FindBy(tagName = "td")
    public List<WebElement> allCols;

    public void clearCompareList(){
        clickButton(clearListLink);
    }
    public void compareProducts(){
        // Get all Rows
        System.out.println(allRows.size());

        // Get data from each Row

        for (WebElement row : allRows){
            System.out.println(row.getText() + "\t");
            for (WebElement col : allCols){
                System.out.println(col.getText() + "\t");
            }

        }

    }
}
