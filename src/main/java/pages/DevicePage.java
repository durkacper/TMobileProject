package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DevicePage extends BasePage {

    public DevicePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='dt_price_change'])[3]")
    private WebElement startPrice;

    @FindBy(xpath = "(//div[@class='dt_price_change'])[4]")
    private WebElement instalment;

    @FindBy(xpath = "(//button[@data-qa='PRD_AddToBasket'])[2]")
    private WebElement addToCartButton;

    public String getStartPrice(){
        waitUntilElementIsVisible(startPrice);
        return startPrice.getText().substring(0, startPrice.getText().length()-3);
    }

    public String getInstalment(){
        waitUntilElementIsVisible(instalment);
        return instalment.getText().substring(0, instalment.getText().length()-3);
    }

    public DevicePage addToCart(){
        waitUntilElementIsVisible(addToCartButton);
        addToCartButton.click();
        return this;
    }
}
