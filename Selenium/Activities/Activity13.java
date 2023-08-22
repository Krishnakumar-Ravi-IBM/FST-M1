package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity13 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        //launch url
        driver.get("https://training-support.net/selenium/tables");
        //title of pgae
        System.out.println("page titile is :"+driver.getTitle());
        // Get rows count
        List<WebElement> rows =driver.findElements(By.xpath("//table[1]/tbody/tr"));
        System.out.println("row size is  :"+ rows.size());
        // Get columns count
        List<WebElement> colums =driver.findElements(By.xpath("//table[1]/tbody/tr[1]/td"));
        System.out.println("row size is  :"+ colums.size());


    }
}
