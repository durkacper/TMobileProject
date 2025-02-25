package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='didomi-notice-agree-button']")
    private WebElement acceptCookies;

    @FindBy(xpath = "//li/button[contains(text(),'Urządzenia')]")
    private WebElement devices;

    @FindBy(css = "a[data-ga-ea='nav-links - Urządzenia/Bez abonamentu/Smartfony']")
    private WebElement smartphonesWithoutSubscription;

    @FindBy(xpath = "(//a[@href='https://www.t-mobile.pl/sklep/basket'])[1]//div")
    private WebElement cartCounter;

    public String getCartCounterValue(){
        waitUntilElementIsVisible(cartCounter);
        return cartCounter.getText();
    }

    public LandingPage goToSmartphones(){
        Actions actions = new Actions(driver);
        actions.moveToElement(devices).build().perform();
        smartphonesWithoutSubscription.click();
        return this;
    }

    public LandingPage acceptCookies(){
        waitUntilElementIsVisible(acceptCookies);
        acceptCookies.click();
        return this;
    }

    public LandingPage goToLandingPage(String url){
        driver.get(url);
        return this;
    }
}
