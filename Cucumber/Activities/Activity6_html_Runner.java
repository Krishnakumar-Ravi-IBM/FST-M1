package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"StepDefinitions"},
        tags = "@SimpleAlert",
        plugin = {"html: test-reports/html-report.html"},
        monochrome = true
)

public class Activity6_html_Runner {
    //empty
}