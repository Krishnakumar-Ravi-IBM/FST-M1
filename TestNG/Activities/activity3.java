package activities;

//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;

//@BeforeMethod
public class activity3 {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/login-form");
    }

    @Test
    public void actualTest(){
        WebElement uName = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement btnLogin = driver.findElement(By.cssSelector("button[class='ui button']"));
        uName.sendKeys("admin");
        pwd.sendKeys("password");
        btnLogin.click();
        WebElement msgWelcome = driver.findElement(By.xpath("//div[@id='action-confirmation']"));
        String welcomeMessage = msgWelcome.getText();
        Assert.assertEquals(welcomeMessage, "Welcome Back, admin");
    }

    @AfterClass
    public void afterClass(){
        driver.close();
    }
}
