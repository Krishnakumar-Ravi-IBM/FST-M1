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

public class CRM_activity2 {
        WebDriver driver = new FirefoxDriver();
        @BeforeSuite
        public void beforeClass() {
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                WebDriverManager.firefoxdriver().setup();
                driver.get("http://alchemy.hguy.co/crm");
        }

        @Test
        public void headerImageURL(){
                String pgeTitle = driver.getTitle();
                System.out.println("The Page Title is: "+pgeTitle);
//                WebElement logo = driver.findElement(By.tagName("src"));
                WebElement logo1 = driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));

                String strLogo = logo1.getAttribute("src");

                System.out.println("The URL of the Header Image is: "+strLogo);
                System.out.println("Run Completed");
        }
        @AfterClass
        public void afterClass(){
                driver.quit();
        }
}
