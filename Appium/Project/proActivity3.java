package Projects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
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
import java.util.ArrayList;
import java.util.List;

public class proActivity3 {
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
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void toDoListTest() throws InterruptedException {
// Go to the following URL: https://www.training-support.net/selenium
        driver.get("https://v1.training-support.net/selenium");
        String text4Xpath = "text(\"Training Support - Selenium\")";
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator(text4Xpath)));
        WebElement pageTitle = driver.findElement(AppiumBy.androidUIAutomator(text4Xpath));
        String pgeTitle = pageTitle.getText();
        System.out.println("The Page Title is: "+pgeTitle);

// Scroll to find the To-Do List card and click it.
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator("text(\"To-Do List\")")));
        WebElement toDoCard = driver.findElement(AppiumBy.androidUIAutomator("text(\"To-Do List\")"));
        toDoCard.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator("text(\"Add Task\")")));
// find the input field
        WebElement taskTextBox = driver.findElement(AppiumBy.androidUIAutomator("resourceId(\"taskInput\")"));
//        WebElement taskTextBox = driver.findElement(AppiumBy.id("taskInput"));
        String tasks[] = new String[]{
                "Add tasks to list",
                "Get number of tasks",
                "Clear the list"};
        for (int i=0; i< tasks.length;i++){
            taskTextBox.sendKeys(tasks[i]);
            WebElement btnAddTask = driver.findElement(AppiumBy.androidUIAutomator("text(\"Add Task\")"));
            btnAddTask.click();
        }

// Click on each of the tasks added to strike them out.
        for (int j=0; j< tasks.length;j++){
            String text4Xpath2 = "text(\""+tasks[j]+"\")";
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator(text4Xpath2)));
            WebElement taskToComp = driver.findElement(AppiumBy.androidUIAutomator(text4Xpath2));
            taskToComp.click();
        }

        Thread.sleep(2000);

// Add assertions to verify that the test has passed or failed
        for (int k=0; k< tasks.length;k++){
            String text4Xpath2 = "text(\""+tasks[k]+"\")";
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator(text4Xpath2)));
            WebElement taskToAssert = driver.findElement(AppiumBy.androidUIAutomator(text4Xpath2));
            String strTaskToAssert = taskToAssert.getText();
            Assert.assertEquals(tasks[k],strTaskToAssert);
        }

// Finally, clear the list
        WebElement clrList = driver.findElement(AppiumBy.androidUIAutomator("text(\" Clear List\")"));
        clrList.click();
    }
    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
