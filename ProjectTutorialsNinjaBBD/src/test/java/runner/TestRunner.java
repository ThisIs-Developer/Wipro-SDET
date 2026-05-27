package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepDefinitions", "hooks"},
    plugin = {
        "pretty",
        "html:target/htmlreports/report.html",
        "json:target/jsonreport/report.json",
        "testng:target/testngreport/report.xml"
    }
)
public class TestRunner extends AbstractTestNGCucumberTests{
}