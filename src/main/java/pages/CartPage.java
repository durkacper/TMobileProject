package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "span[data-qa='BKT_TotalupFront']")
    private WebElement startPrice;

    @FindBy(css = "span[data-qa='BKT_TotalMonthly']")
    private WebElement instalment;

    @FindBy(css = "a[href='https://www.t-mobile.pl/']")
    private WebElement mainPageButton;

    public String getStartPriceInCart(){
        waitUntilElementIsVisible(startPrice);
        return startPrice.getText();
    }

    public String getInstalmentInCart(){
        waitUntilElementIsVisible(instalment);
        return instalment.getText();
    }

    public CartPage goToLandingPage(){
        waitUntilElementIsVisible(mainPageButton);
        mainPageButton.click();
        return this;
    }
}
