package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class activity4 {
    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;
    // Set up method
    @BeforeClass(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.contacts");
        options.setAppActivity(".activities.TwelveKeyDialer");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Test method
    @Test
    public void addContactsTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Contacts")).click();
        driver.findElement(AppiumBy.id("android:id/icon")).click();
        Thread.sleep(2000);
        WebElement phone = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']"));
        phone.sendKeys("999148292");
        driver.findElement(AppiumBy.accessibilityId("Expand name")).click();
        Thread.sleep(2000);
//        wait().until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@text='Given name']")));
        WebElement fName = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Given name']"));
        fName.sendKeys("Aaditya");
        WebElement lName = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Family name']"));
        lName.sendKeys("Varma");
        driver.findElement(AppiumBy.accessibilityId("OK")).click();
        Thread.sleep(2000);
        //Assertions:
        WebElement addedName = driver.findElement(AppiumBy.id("com.android.contacts:id/custom_title"));
        String strAddedName = addedName.getText();
        System.out.println("The newly added contact name is: "+strAddedName);
//        WebElement addedPhone = driver.findElement(AppiumBy.xpath("(//com.android.contacts:id/data)[0]"));
//        String strAddedPhone = addedPhone.getText();
//        System.out.println("Newly added Phone Number is: "+strAddedPhone);
        Assert.assertEquals(strAddedName, "Aaditya Varma");
//        Assert.assertEquals(strAddedPhone, "999148292");
        WebElement backOption = driver.findElement(AppiumBy.accessibilityId("Go back"));
        backOption.click();
    }
    // Tear down method
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}