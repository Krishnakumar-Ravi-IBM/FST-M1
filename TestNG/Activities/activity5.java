package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.Color;

public class activity5 {
    WebDriver driver;
    @BeforeClass(alwaysRun = true)
    public void setup(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test(groups = {"HeaderTests", "ButtonTests"})
    public void pgeTitle(){
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,"Target Practice");
    }
    @Test(dependsOnMethods = {"pgeTitle"}, groups = {"HeaderTests"})
    public void thirdHeader(){
        WebElement thirdHeader = driver.findElement(By.xpath("//h3[@id='third-header']"));
        String strThirdHeader = thirdHeader.getText();
        Assert.assertEquals(strThirdHeader,"Third header");//(actual,expected)

    }
    @Test(dependsOnMethods = {"pgeTitle"}, groups = {"HeaderTests"})
    public void fifthHeader(){
        WebElement fifthHeader = driver.findElement(By.xpath("//h5[normalize-space()='Fifth header']"));
        String strFifthHeader = fifthHeader.getCssValue("color");
//        Assert.assertEquals(strFifthHeader,"#21ba45 !important");
//        Color colFifthHeader = Color.fromString((fifthHeader).getCssValue("color"));
//        assert colFifthHeader.asHex().equals("rgba(33, 186, 69, 1)");
//        assert colFifthHeader.asHex().equals("#21ba45 !important");
        System.out.println(strFifthHeader);
        Assert.assertEquals(strFifthHeader, "rgb(33, 186, 69)");
    }
    @Test(dependsOnMethods = {"pgeTitle"}, groups = {"ButtonTests"})
    public void classOlive(){
        WebElement btnOlive = driver.findElement(By.xpath("//button[normalize-space()='Olive']"));
        String btnText = btnOlive.getText();
        Assert.assertEquals(btnText,"Olive");
    }
    @Test(dependsOnMethods = {"pgeTitle"}, groups = {"ButtonTests"})
    public void firstButton(){
        WebElement btnFirst = driver.findElement(By.xpath("//button[normalize-space()='Brown']"));
        String strFirstButton = btnFirst.getCssValue("color");
        Assert.assertEquals(strFirstButton,"rgb(255, 255, 255)");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        driver.close();
    }
}
