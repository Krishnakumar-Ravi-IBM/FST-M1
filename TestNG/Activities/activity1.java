package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class activity1 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver =  new FirefoxDriver();
        driver.get("https://www.training-support.net");
    }
    @Test
    public void testMethod(){
        System.out.println("This is Test Method");
        String pageTitle = driver.getTitle();
        System.out.println("The Page Title is: "+pageTitle);
        Assert.assertEquals(pageTitle, "Training Support");
        WebElement abtUs = driver.findElement(By.xpath("//a[@id='about-link']"));
        abtUs.click();
        String newPageTitle = driver.getTitle();
        System.out.println("The new Page Title is: "+newPageTitle);
        Assert.assertEquals(newPageTitle,"About Training Support");
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
