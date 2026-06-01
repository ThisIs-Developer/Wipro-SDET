package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "hooks"},
        plugin = {
                "pretty",
                "html:target/htmlreports/report.html",
                "json:target/jsonreport/report.json"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {

}