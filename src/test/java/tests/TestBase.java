package tests;

import Helper.Helper;
import org.openqa.selenium.WebDriver;
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
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
      else if (browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }

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
}
