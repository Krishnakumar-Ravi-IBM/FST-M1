package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.IReporter;
import org.testng.ITestListener;
//import org.openqa.selenium.Alert;

public class activity9 implements ITestListener,IReporter{
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/Alerts");
        String pgeTitle = driver.getTitle();
        System.out.println("The Page Title is: "+pgeTitle);
    }

    @BeforeMethod
    public void focusBack(){
        driver.switchTo().defaultContent();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-200)", "");
    }

    @Test(priority = 0)
    public void simpleAlertTestCase(){
        Reporter.log("Simple Alert Validation started");
        WebElement simple = driver.findElement(By.id("simple"));
        Reporter.log("clicking Simple Alert button");
        simple.click();
        Reporter.log("Simple Alert opened");
        Reporter.log("Thanks for your patience! Now switching to simple alert");
        Alert simpleAlert = driver.switchTo().alert();
        String strSimpleAlert = simpleAlert.getText();
        Reporter.log("The simple alert text capturing completed");
        simpleAlert.accept();
        Reporter.log("The alert message is read and accepted");
        System.out.println("The Simple Alert text is: "+strSimpleAlert);
        Reporter.log("Captured simple alert text is printed to console");
        Reporter.log("Simple alert validation complete and closing this test case");
        WebElement simpRes = driver.findElement(By.id("result"));
        String strSimpResult = simpRes.getText();
        System.out.println("Message after closing Simple Alert: "+strSimpResult);
        Assert.assertEquals(strSimpResult,"You just accepted a simple alert!");
    }
    @Test(priority = 1)
    public void confirmAlertTestCase() throws InterruptedException {
        Reporter.log("Confirmation Alert Validation started");
        WebElement confirmation = driver.findElement(By.id("confirmation"));
        confirmation.click();
        Reporter.log("Confirmation Alert opened");
        Alert confAlert = driver.switchTo().alert();
        String strConfirmationAlert = confAlert.getText();
        confAlert.accept();
        Reporter.log("The alert message is read and accepted");
        System.out.println("The Confirmation Alert text is: "+strConfirmationAlert);
        Reporter.log("Confirmation alert validation complete and closing this test case");
        WebElement confRes = driver.findElement(By.id("result"));
        String strConfResult = confRes.getText();
        Assert.assertEquals(strConfResult,"You just accepted a confirmation alert!");
        Thread.sleep(5000);
    }
    @Test(priority = 2)
    public void promptAlertTestCase(){
        Reporter.log("Confirmation Alert Validation started");
//        js.executeScript("window.scrollBy(0,-250)", "");
        WebElement prompt = driver.findElement(By.id("prompt"));
// Scrolling down the page till the element is found
//        js.executeScript("arguments[0].scrollIntoView(true);", prompt);
        prompt.click();
        Reporter.log("Prompt Alert opened");
        Alert promptAlert = driver.switchTo().alert();
        String strPrompt = promptAlert.getText();
        promptAlert.sendKeys("sample text");
        Assert.assertEquals(strPrompt,"This is a JavaScript Prompt!");
        promptAlert.accept();
        Reporter.log("The alert message is read and accepted");
        System.out.println("The Prompt Alert text is: "+strPrompt);
        Reporter.log("Confirmation alert validation complete and closing this test case");
        WebElement propmtRes = driver.findElement(By.id("result"));
        String strPromptResult = propmtRes.getText();
        System.out.println("The message displayed after prompt alert is closed: "+strPromptResult);
//        Assert.assertEquals(strPromptResult,"You typed \"sample text\" into the prompt!");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        Reporter.log("Quiting the browser");
        driver.quit();
    }
}
