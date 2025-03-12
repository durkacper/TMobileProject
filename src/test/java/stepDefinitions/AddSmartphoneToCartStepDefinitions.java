package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.CartPage;
import pages.DevicePage;
import pages.LandingPage;
import pages.SmartphonesPage;
import utils.TestContextSetup;

public class AddSmartphoneToCartStepDefinitions {

    TestContextSetup testContextSetup;
    LandingPage landingPage;
    SmartphonesPage smartphonesPage;
    DevicePage devicePage;
    CartPage cartPage;

    private static final Logger logger = LogManager.getLogger(AddSmartphoneToCartStepDefinitions.class);

    public AddSmartphoneToCartStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
        this.smartphonesPage = testContextSetup.pageObjectManager.getSmartphonesPage();
        this.devicePage = testContextSetup.pageObjectManager.getDevicePage();
        this.cartPage = testContextSetup.pageObjectManager.getCartPage();
    }

    @Given("The landing page is open")
    public void the_landing_page_is_open() {
        logger.info("Opening T-Mobile landing page");
        landingPage.goToLandingPage("https://www.t-mobile.pl/");
        landingPage.acceptCookies();
    }

    @When("Add a smartphone to the cart")
    public void add_a_smartphone_to_the_cart() {
        logger.info("Going to smartphones");
        landingPage.goToSmartphones();
        logger.info("Opening a device");
        smartphonesPage.goToDevicePage();
        logger.info("Adding a device to the cart");
        devicePage.addToCart();
    }

    @Then("The smartphone is added to the cart and the price and instalment are correct")
    public void the_smartphone_is_added_to_the_cart_and_the_price_and_instalment_are_correct() {
        logger.info("Getting the device price and instalment");
        String priceOnDevicePage = devicePage.getStartPrice();
        String instalmentOnDevicePage = devicePage.getInstalment();
        logger.info("Getting the price and instalment in the cart");
        String priceInCart = cartPage.getStartPriceInCart();
        String instalmentInCart = cartPage.getInstalmentInCart();
        logger.info("Verifying that the cart counter is 1");
        cartPage.goToLandingPage();
        String cartCounter = landingPage.getCartCounterValue();
        Assert.assertEquals(cartCounter, "1");
        logger.info("Verifying that the price and instalment are equal on the device page and in the cart");
        Assert.assertEquals(priceInCart, priceOnDevicePage);
        Assert.assertEquals(instalmentInCart, instalmentOnDevicePage);
    }
}