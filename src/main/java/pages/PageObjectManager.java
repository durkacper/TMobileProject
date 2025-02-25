package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public LandingPage landingPage;
    public DevicePage devicePage;
    public CartPage cartPage;
    public SmartphonesPage smartphonesPage;
    public WebDriver driver;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public LandingPage getLandingPage(){
       landingPage = new LandingPage(driver);
       return landingPage;
    }

    public DevicePage getDevicePage(){
        devicePage = new DevicePage(driver);
        return devicePage;
    }

    public CartPage getCartPage(){
        cartPage = new CartPage(driver);
        return cartPage;
    }

    public SmartphonesPage getSmartphonesPage(){
        smartphonesPage = new SmartphonesPage(driver);
        return smartphonesPage;
    }
}
