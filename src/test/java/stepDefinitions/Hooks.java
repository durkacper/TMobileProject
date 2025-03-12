package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.TestContextSetup;

public class Hooks {

    TestContextSetup testContextSetup;

    private static final Logger logger = LogManager.getLogger(Hooks.class);

    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            logger.error("Scenario failed: " + scenario.getName());
            logger.error("Scenario status: " + scenario.getStatus());
            testContextSetup.testBase.driver.quit();
        }
    }

    @After
    public void afterScenarrio() {
        testContextSetup.testBase.driver.quit();
    }
}