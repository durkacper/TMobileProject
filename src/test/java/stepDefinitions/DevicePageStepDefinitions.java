package stepDefinitions;

import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.DevicePage;
import utils.TestContextSetup;

public class DevicePageStepDefinitions {

    TestContextSetup testContextSetup;
    DevicePage devicePage;
    public static String priceOnDevicePage;
    public static String instalmentOnDevicePage;

    private static final Logger logger = LogManager.getLogger(DevicePageStepDefinitions.class);

    public DevicePageStepDefinitions(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        this.devicePage = testContextSetup.pageObjectManager.getDevicePage();
    }

    @When("Add a device to the cart")
    public void add_a_device_to_the_cart() {
        logger.info("Adding a device to the cart");
        try {
            priceOnDevicePage = devicePage.getStartPrice();
            instalmentOnDevicePage = devicePage.getInstalment();
            devicePage.addToCart();
        } catch (Exception e) {
            logger.error("Error while adding a device to the cart: ", e);
        }
    }
}
