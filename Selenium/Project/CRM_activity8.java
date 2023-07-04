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

public class CRM_activity8 {
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
                builder.moveToElement(sales).build().perform();
                WebElement account = driver.findElement(By.id("moduleTab_9_Accounts"));
                builder.moveToElement(account).click().build().perform();
//                Thread.sleep(3000);
                System.out.println("*********** Navigating to Accounts module *********");
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='module-title-text']")));
//                Thread.sleep(2000);
//                List<WebElement> elements = driver.findElements(By.xpath("//table[contains(@class,'responsive')]/tbody/tr[position() mod 2 =1]/td[3]"));
                List<WebElement> elements = driver.findElements(By.xpath("//table[contains(@class,'responsive')]/tbody/tr[position() mod 2 =1][position()<6]/td[3]"));

                System.out.println("The size of the list elements is: "+elements.size());

                for(WebElement ele : elements){
                                String name = ele.getText();
                                        System.out.println("The Names of the first 5 Odd Rows are: " + name);
                }

                System.out.println("Run Completed");
        }
        @AfterClass
        public void afterClass(){
                driver.quit();
        }
}