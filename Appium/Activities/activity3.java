package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class activity3 {
    AndroidDriver driver;

    // Set up method
    @BeforeClass(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
//        options.setAppPackage("com.android.calculator2");//"com.miui.calculator"
        options.setAppPackage("com.miui.calculator");
//        options.setAppActivity(".Calculator");//".cal.CalculatorActivity"
        options.setAppActivity(".cal.CalculatorActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }

    @Test (priority = 0)
    public void testAdd(){
        driver.findElement(AppiumBy.id("btn_5_s")).click();
        driver.findElement(AppiumBy.accessibilityId("plus")).click();
        driver.findElement(AppiumBy.id("btn_9_s")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        // Find the result
        String result = driver.findElement(AppiumBy.id("result")).getText();
        System.out.println("The Addition of 5 and 9 is: "+result);
        // Assertion
        Assert.assertEquals(result, "= 14");
        driver.findElement(AppiumBy.accessibilityId("clear")).click();
    }
    @Test(dependsOnMethods = {"testAdd"}, priority = 1)
    public void testSub(){
        driver.findElement(AppiumBy.id("btn_1_s")).click();
        driver.findElement(AppiumBy.id("btn_0_s")).click();
        driver.findElement(AppiumBy.accessibilityId("minus")).click();
        driver.findElement(AppiumBy.id("btn_5_s")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        // Find the result
        String result = driver.findElement(AppiumBy.id("result")).getText();
        System.out.println("The result of negating 5 from 10 is: "+result);
        // Assertion
        Assert.assertEquals(result, "= 5");
        driver.findElement(AppiumBy.accessibilityId("clear")).click();
    }
    @Test(dependsOnMethods = {"testSub"}, priority = 2)
    public void testMultiply(){
        driver.findElement(AppiumBy.id("btn_5_s")).click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("btn_1_s")).click();
        driver.findElement(AppiumBy.id("btn_0_s")).click();
        driver.findElement(AppiumBy.id("btn_0_s")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        // Find the result
        String result = driver.findElement(AppiumBy.id("result")).getText();
        System.out.println("The result of multiplying 5 and 100 is: "+result);
        // Assertion
        Assert.assertEquals(result, "= 500");
        driver.findElement(AppiumBy.accessibilityId("clear")).click();
    }
    @Test(dependsOnMethods = {"testMultiply"},priority = 3)
    public void testDiv(){
        driver.findElement(AppiumBy.id("btn_5_s")).click();
        driver.findElement(AppiumBy.id("btn_0_s")).click();
        driver.findElement(AppiumBy.accessibilityId("divide")).click();
        driver.findElement(AppiumBy.id("btn_2_s")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        // Find the result
        String result = driver.findElement(AppiumBy.id("result")).getText();
        System.out.println("The result of dividing 50 by 2 is: "+result);
        // Assertion
        Assert.assertEquals(result, "= 25");
        driver.findElement(AppiumBy.accessibilityId("clear")).click();
    }
}
