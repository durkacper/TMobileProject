package stepDefinitions;

import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementClickInterceptedException;
import pages.SmartphonesPage;
import utils.TestContextSetup;

public class SmartphonesPageStepDefinitions {

    TestContextSetup testContextSetup;
    SmartphonesPage smartphonesPage;

    private static final Logger logger = LogManager.getLogger(SmartphonesPageStepDefinitions.class);

    public SmartphonesPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.smartphonesPage = testContextSetup.pageObjectManager.getSmartphonesPage();
    }

    @When("Open a device")
    public void open_a_device() {
        logger.info("Opening a device");
        try {
            int attempts = 0;
            while (attempts < 5) {
                try {
                    smartphonesPage.goToDevicePage();
                    break;
                } catch (ElementClickInterceptedException e) {
                    attempts++;
                    if (attempts == 5) {
                        throw e;
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Error while opening a device: ", e);
        }
    }
}
