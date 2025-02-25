package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefinitions",
        plugin = {"pretty", "html: target/cucumberReport.html", "json: target/cucumberReport.json"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
