package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CRM_activity3 {
        WebDriver driver = new FirefoxDriver();
        @BeforeSuite
        public void beforeClass() {
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                WebDriverManager.firefoxdriver().setup();
                driver.get("http://alchemy.hguy.co/crm");
        }

        @Test
        public void testMethod(){
                String pgeTitle = driver.getTitle();
                System.out.println("The Page Title is: "+pgeTitle);
                WebElement Copyright1 = driver.findElement(By.id("admin_options"));
                String copyright = Copyright1.getText();
                System.out.println("The first copyright text in the footer is: \""+copyright+"\"");
                System.out.println("Run Completed");
        }
        @AfterClass
        public void afterClass(){
                driver.quit();
        }
}