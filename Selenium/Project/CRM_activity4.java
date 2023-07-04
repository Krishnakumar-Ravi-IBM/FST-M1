package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CRM_activity4 {
        WebDriver driver = new FirefoxDriver();
        @BeforeSuite
        public void beforeClass() {
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                WebDriverManager.firefoxdriver().setup();
                driver.get("http://alchemy.hguy.co/crm");
        }

        @Test
        public void loginToSite(){
                String pgelogin = driver.getTitle();
                System.out.println("The Page Title is: "+pgelogin);
                WebElement txtUname = driver.findElement(By.id("user_name"));
                WebElement txtPwd = driver.findElement(By.id("username_password"));
                WebElement btnLogin = driver.findElement(By.id("bigbutton"));
                txtUname.sendKeys("admin");
                txtPwd.sendKeys("pa$$w0rd");
                btnLogin.click();
                String pgeHome = driver.getTitle();
                System.out.println("The homePage title is: "+pgeHome);
                Assert.assertEquals(pgeHome, "SuiteCRM");
                System.out.println("Run Completed");
        }
        @AfterClass
        public void afterClass(){
                driver.quit();
        }
}