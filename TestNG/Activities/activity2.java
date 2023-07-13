package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class activity2 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test(priority = 0)
    public void testMethod1(){
    String homePageTitle = driver.getTitle();
        System.out.println("The Home Page Title is: "+homePageTitle);
        Assert.assertEquals(homePageTitle,"Target Practice");
    }

    @Test(priority = 1)
    public void testMethod2(){
        WebElement btnBlack = driver.findElement(By.xpath("//button[contains(@class,'black button')]"));
        Assert.assertTrue(btnBlack.isDisplayed());
        Assert.assertEquals(btnBlack.getText(), "black");
    }

    @Test(priority = 2, enabled = false)
    public void testMethod3(){
        System.out.println("This is Third Method which will be skipped");
    }

    @Test(priority = 3)
    public void testMethod4() throws SkipException{
        String cond = "skip test";
        if (cond.equals("skip test")) {
            throw new SkipException("Skipping, this module is yet to be developed");
        }else {
            System.out.println("Executing this code as the required condition is being satisfied");
        }
    }
    @AfterClass
    public void afterClass(){
        driver.close();
    }
}
