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

public class CRM_activity5 {
        WebDriver driver = new FirefoxDriver();
        @BeforeSuite
        public void beforeClass() {
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                WebDriverManager.firefoxdriver().setup();
                driver.get("http://alchemy.hguy.co/crm");
        }

        @Test
        public void gettingColors(){
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

                WebElement navMenu = driver.findElement(By.id("toolbar"));
                String navMenuColor = navMenu.getCssValue("Color");
                System.out.println("The Color of the Navigation Menu bar is: "+navMenuColor);
//                WebElement Copyright1 = driver.findElement(By.id("admin_options"));
//                String copyright = Copyright1.getText();
//                System.out.println("The first copyright text in the footer is: \""+copyright+"\"");
                System.out.println("Run Completed");
        }
        @AfterClass
        public void afterClass(){
                driver.quit();
        }
}