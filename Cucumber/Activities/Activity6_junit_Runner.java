package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"StepDefinitions"},
        tags = "@SimpleAlert",
        plugin = {"junit: test-reports/junit-report.junit"},
        monochrome = true
)

public class Activity6_xml_Runner {
    //empty
}