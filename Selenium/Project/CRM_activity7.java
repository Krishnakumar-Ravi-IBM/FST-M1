package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.List;

import java.time.Duration;

public class CRM_activity7 {
        WebDriver driver = new FirefoxDriver();
        @BeforeSuite
        public void beforeClass() {
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                WebDriverManager.firefoxdriver().setup();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                driver.get("http://alchemy.hguy.co/crm");
        }

        @Test
        public void readAdditionalInfo() throws InterruptedException {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                Actions builder = new Actions(driver);
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

                WebElement sales = driver.findElement(By.id("grouptab_0"));

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='My Open Cases']")));
                builder.moveToElement(sales).build().perform();
                WebElement leads = driver.findElement(By.id("moduleTab_9_Leads"));
                wait.until(ExpectedConditions.visibilityOf(leads));
                builder.moveToElement(leads).click().build().perform();
                System.out.println("*********** Navigating to leads module *********");
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='module-title-text']")));

                WebElement ele = driver.findElement(By.xpath("//tr[2]/td[10]"));
                wait.until(ExpectedConditions.visibilityOf(ele));
                ele.click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='Additional Details']")));
                WebElement phone = driver.findElement(By.xpath("//span[@class='phone']"));
                String strPhone = phone.getText();

                System.out.println("The Phone number displayed in the pop up is: "+strPhone);

                System.out.println("Run Completed");
        }
        @AfterClass
        public void afterClass(){
                driver.quit();
        }
}