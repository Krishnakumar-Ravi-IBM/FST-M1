package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class activity7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @Test(dataProvider = "Authenticator")
    public void testLogin(String username, String password){
        WebElement uName= driver.findElement(By.id("username"));
        WebElement pWord = driver.findElement(By.id("password"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[text()='Log in']"));
        uName.sendKeys(username);
        pWord.sendKeys(password);
        btnLogin.click();
        WebElement messageDisp = driver.findElement(By.xpath("//div[contains(text(),'Welcome Back, admin')]"));
        String strMsg = messageDisp.getText();
        Assert.assertEquals(strMsg, "Welcome Back, admin");
    }

    @DataProvider(name = "Authenticator")
    public Object[][] credentials(){
        return new Object[][] {{"admin","password"}};
    }
    @AfterTest(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }
}
