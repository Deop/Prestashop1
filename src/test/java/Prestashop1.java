import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Deop on 12.12.2015.
 */
public class Prestashop1 {

    WebDriver firefoxDriver;

    @BeforeClass
    public void setUp(){
        firefoxDriver = new FirefoxDriver();
    }

    @Test
    public void test() throws InterruptedException {
        log("Navigating to main page");
        firefoxDriver.navigate().to("http://prestashop.qatestlab.com.ua/en/");

        log("Checking if logo is displayed");
        boolean logoIsDisplayed = firefoxDriver.findElement(By.xpath("//*[@id=\"header_logo\"]/a/img")).isDisplayed();

        log("Logo is displayed - " + logoIsDisplayed);
        Assert.assertEquals(logoIsDisplayed, true, "Logo is not found.");

        log("Checking number of listed items in \"Popular\" tab");
        List<WebElement> allPopularItems = firefoxDriver.findElements(By.xpath("//*[@id=\"homefeatured\"]/li"));

        Assert.assertEquals(allPopularItems.size(), 8, "Unexpected number of listed items in \"Popular\" tab");
        log("Number of listed items is " + allPopularItems.size());

        Thread.sleep(3000);
    }

    @AfterClass
    public void tearDown(){
        firefoxDriver.quit();
    }

    public void log(String message){
        Reporter.log(message);
    }

}
