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

public class proActivity1 {
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
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testGoogleTaskAdd() throws InterruptedException {
        String tasks[] = new String[]{
                "Complete Activity with Google Tasks",
                "Complete Activity with Google Keep",
                "Complete the second Activity Google Keep"};

        for (int i=0; i<tasks.length; i++){
// Click the button to add a new task.
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Create new task")));
            WebElement addNewTask = driver.findElement(AppiumBy.accessibilityId("Create new task"));
            addNewTask.click();

// Add the required tasks from the String Array defined in this class
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
            WebElement taskDesc = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"));
            taskDesc.sendKeys(tasks[i]);

// After each task is added, the Save button should be clicked
            WebElement saveTask = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done"));
            saveTask.click();
            String text4Xpath = "text(\""+tasks[i]+"\")";

// Assertions to ensure all three tasks have been added to the list
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator(text4Xpath)));
            WebElement addedTask = driver.findElement(AppiumBy.androidUIAutomator(text4Xpath));
            String addedTaskText = addedTask.getText();
            Assert.assertEquals(addedTaskText,tasks[i]);
        }
    }
    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}