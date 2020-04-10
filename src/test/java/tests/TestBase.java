package tests;

import Helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
            driver = new ChromeDriver();
        }
//      else if (browserName.equalsIgnoreCase("firefox")){
//            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
//            driver = new FirefoxDriver();
//        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    // Take ScreenShot when test case fail and add it in the Screenshots folder
    @AfterMethod
    public void screenShotOnFailure(ITestResult result){
        if(result.getStatus()== ITestResult.FAILURE){
            System.out.println("Failed");
            System.out.println("Taking ScreenShot for the failed test case...");
            Helper.captureScreenShot(driver, result.getName());
        }

    }

    @AfterSuite
    public void stopDriver(){
        driver.quit();

    }

    public void goToAuditFamiQSMenu() {
        WebElement organisationButton = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[2]/a"));
        organisationButton.click();

        WebElement OrganisationProfile = driver.findElement(By.xpath("//a[contains(text(),'Test Auto org')]"));
        OrganisationProfile.click();
        WebElement auditMenu = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/aside[1]/div[1]/div[1]/div[1]/a[2]"));

        //WebElement auditMenu = driver.findElement(By.xpath("//a[contains(text(),'Audits')]"));
        auditMenu.click();

        //	WebElement auditFolderAutomation = driver.findElement(By.xpath("//a[contains(text(),'Audit FAMI-QS Automation')]"));
        WebElement auditFolderAutomation = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/section[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]"));

        try {
            //auditFolderAutomation.click();
            auditFolderAutomation.click();

        } catch (Exception e) {
            auditFolderAutomation.click();

        }
    }
}
