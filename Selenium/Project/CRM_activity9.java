package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CRM_activity9 {
        WebDriver driver = new FirefoxDriver();
        @BeforeSuite
        public void beforeClass() {
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                WebDriverManager.firefoxdriver().setup();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                driver.get("http://alchemy.hguy.co/crm");

        }

        @Test
        public void traverseTable() throws InterruptedException {
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
//                sales.click();
                builder.moveToElement(sales).build().perform();
//                Thread.sleep(2000);
                WebElement leads = driver.findElement(By.id("moduleTab_9_Leads"));
                wait.until(ExpectedConditions.visibilityOf(leads));
                builder.moveToElement(leads).click().build().perform();
//                Thread.sleep(3000);
                System.out.println("*********** Navigating to Leads module *********");
//                Thread.sleep(3000);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='module-title-text']")));

                for(int r=1; r<11;r++)
                {
                        String name = driver.findElement (By.xpath("//table[contains(@class,'responsive')]/tbody/tr["+r+"]/td[3]")).getText();
                        String user = driver.findElement (By.xpath("//table[contains(@class,'responsive')]/tbody/tr["+r+"]/td[8]")).getText();

                        System.out.println("Name displayed in Row number "+r+" is: "+name+" and respective User ID is: "+user);
                }

                System.out.println("Run Completed");
        }
        @AfterClass
        public void afterClass(){
                driver.quit();
        }
}