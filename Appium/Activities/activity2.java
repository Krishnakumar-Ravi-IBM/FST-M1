package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class activity2 {
    AndroidDriver driver;
    WebDriverWait wait;
    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
// Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");

// Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");
// Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void browserPageTest() throws InterruptedException {
        driver.get("https://www.v1.training-support.net/");
//        String pgeTitle = driver.findElement(AppiumBy.id())
        String pageTitle = driver.getTitle();
        System.out.println("The Page Heading is: "+pageTitle);
        Thread.sleep(10000);
//        wait.until(ExpectedConditions.presenceOfElementLocated())
        String pgeTitle = driver.findElement(AppiumBy.xpath("//android.view.View[@text='Training Support']")).getText();
        System.out.println("The Page Heading is: "+pageTitle);

        WebElement btnAboutUs = driver.findElement(AppiumBy.accessibilityId("About Us"));
        btnAboutUs.click();
        String pgeAboutUs = driver.findElement(AppiumBy.xpath("//android.view.View[@text='About Us']")).getText();
        System.out.println("The about Page heading is: "+pgeAboutUs);
    }
    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
