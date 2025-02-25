package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SmartphonesPage extends BasePage {

    public SmartphonesPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@data-qa,'LST_ProductCard')]")
    private List<WebElement> listOfDevices;

    public SmartphonesPage goToDevicePage(){
        waitUntilListOfElementsIsVisible(listOfDevices);
        for (int i = 0; i < listOfDevices.size(); i++) {
            waitUntilElementIsClickable(listOfDevices.get(0));
            listOfDevices.get(0).click();
        }
        return this;
    }
}
