package stepDefinitions;

import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.CartPage;
import utils.TestContextSetup;

public class CartPageStepDefinitions {

    TestContextSetup testContextSetup;
    CartPage cartPage;

    private static final Logger logger = LogManager.getLogger(CartPageStepDefinitions.class);

    public CartPageStepDefinitions(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        this.cartPage = testContextSetup.pageObjectManager.getCartPage();
    }

    @Then("The price and instalment values on the cart page are the same as on the device page")
    public void the_price_and_instalment_values_on_the_cart_page_are_the_same_as_on_the_device_page() {
        logger.info("Comparing the prices and instalments on the cart page and the device page");
        try {
            String priceInCart = cartPage.getStartPriceInCart();
            String instalmentInCart = cartPage.getInstalmentInCart();
            Assert.assertEquals(priceInCart, DevicePageStepDefinitions.priceOnDevicePage);
            Assert.assertEquals(instalmentInCart, DevicePageStepDefinitions.instalmentOnDevicePage);
            cartPage.goToLandingPage();
        } catch (Exception e) {
            logger.error("Error while comparing the prices and instalments on the cart page and the device page: ", e);
        }
    }
}
