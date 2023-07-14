package activities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class activity1 {
    // Driver Declaration
    AndroidDriver driver;

    // Set up method
    @BeforeClass
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

    // Test method
    @Test
    public void multiplyTest() {
        // Perform the calculation
        driver.findElement(AppiumBy.id("btn_5_s")).click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("btn_8_s")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        // Find the result
        String result = driver.findElement(AppiumBy.id("result")).getText();
        System.out.println("The multiplication of 5 * 8 "+result);
        // Assertion
        Assert.assertEquals(result, "= 40");
    }


    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}