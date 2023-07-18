package Projects;

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

public class proActivity2 {
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
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

// Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

// Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void testGoogleKeepAdd() throws InterruptedException {
        String keepTitleText = "This is TestTitle1 in GoogleKeep";
        String keepNoteText = "This is a sample Note1 in GoogleKeep";
// Click the Create New Note button to add a new Note.
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("New text note")));
        WebElement addNewKeep = driver.findElement(AppiumBy.accessibilityId("New text note"));
        addNewKeep.click();

// Add a title for the note
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("editable_title")));
        WebElement keepTitle = driver.findElement(AppiumBy.id("editable_title"));
        keepTitle.sendKeys(keepTitleText);

// Add a note as small description.
        WebElement keepNote = driver.findElement(AppiumBy.id("edit_note_text"));
        keepNote.sendKeys(keepNoteText);

// Press the back button
        WebElement goBack = driver.findElement(AppiumBy.accessibilityId("Navigate up"));
        goBack.click();

// Add Assertion
        String text4Xpath = "text(\""+keepTitleText+"\")";
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator(text4Xpath)));
        WebElement addedKeep = driver.findElement(AppiumBy.androidUIAutomator(text4Xpath));
        String addedKeepText = addedKeep.getText();
        Assert.assertEquals(addedKeepText,keepTitleText);
    }

// Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
