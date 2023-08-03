package StepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class parameterization {

    @Given("^user is on the Amazon website$")
    public void user_is_on_Home_Page() throws Throwable {
        //Actions to perform
    }

    @When("^user logs in with \"(.*)\" and \"(.*)\"$")
    public void user_logs_in(String username, String password) {
        System.out.println(username + password);
    }

    @When("^user searches for \"(.*)\"$")
    public void user_searches_a_product(String productID) {
        //Actions to perform
    }
}
