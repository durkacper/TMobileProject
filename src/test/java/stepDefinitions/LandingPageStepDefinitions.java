package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinitions {

    TestContextSetup testContextSetup;
    LandingPage landingPage;

    private static final Logger logger = LogManager.getLogger(LandingPageStepDefinitions.class);

    public LandingPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("T-Mobile landing page is open")
    public void t_mobile_landing_page_is_open() {
        logger.info("Opening T-Mobile landing page");
        try {
            landingPage.goToLandingPage("https://www.t-mobile.pl/");
        } catch (Exception e) {
            logger.error("Error while opening T-Mobile landing page: ", e);
        }
    }

    @When("Go to smartphones")
    public void go_to_smartphones() {
        logger.info("Going to smartphones");
        try {
            landingPage.acceptCookies();
            landingPage.goToSmartphones();
        } catch (Exception e) {
            logger.error("Error while going to smartphones: ", e);
        }
    }

    @Then("The quantity of products in the cart is displayed next to the cart icon on the landing page")
    public void the_quantity_of_products_in_the_cart_is_displayed_next_to_the_cart_icon_on_the_landing_page() {
        logger.info("Checking the quantity of products in the cart");
        try {
            String cartCounter = landingPage.getCartCounterValue();
            Assert.assertEquals(cartCounter, "1");
        } catch (Exception e) {
            logger.error("Error while checking the quantity of products in the cart: ", e);
        }
    }
}
