package hooks;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import base.BrowserSetup;
import utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestHooks {

    private BrowserSetup factoryInstance;
    private WebDriver browserDriver;
    private Properties appConfig;

    @Before(order = 0)
    public void loadConfiguration() {
        appConfig = ConfigReader.init_prop();
    }

    @Before(order = 1)
    public void setupBrowser() {
        String targetBrowser = appConfig.getProperty("browser");
        factoryInstance = new BrowserSetup();
        browserDriver = factoryInstance.init_driver(targetBrowser);
    }

    @After(order = 0)
    public void terminateSession() {
        if (browserDriver != null) {
            browserDriver.quit();
            BrowserSetup.removeDriver(); 
        }
    }
    
    @AfterStep
    public void captureEvidence(Scenario currentScenario) {
        try {
            String timestamp = String.valueOf(System.currentTimeMillis());
            String cleanScenarioName = currentScenario.getName().replace(" ", "_");
            String imageTag = cleanScenarioName + "_" + timestamp;
            
            byte[] screenshotData = ((TakesScreenshot) BrowserSetup.getDriver()).getScreenshotAs(OutputType.BYTES);
            
            // Evaluated status for reporting
            String statusPrefix = currentScenario.isFailed() ? "FAILED_" : "PASSED_SKIPPED_";
            
            if (currentScenario.isFailed()) {
                System.out.println("Execution halted. Saving error screenshot...");
            }
            
            currentScenario.attach(screenshotData, "image/png", statusPrefix + imageTag);
            
        } catch (Exception ex) {
            System.err.println("Unable to record screenshot evidence: " + ex.getMessage());
        }
    }
}