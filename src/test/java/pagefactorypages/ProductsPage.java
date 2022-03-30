package pagefactorypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class ProductsPage extends BasePage {
    @FindBy(css = "[data-test='add-to-cart-sauce-labs-bike-light']")
    private WebElement addBikeLightButton;
    @FindBy(className = "shopping_cart_container")
    private WebElement shoppingContainer;
    @FindBy(className = "inventory_item_name")
    private WebElement itemName;
    @FindBy(className = "inventory_item_price")
    private WebElement price;
    @FindBy(id = "remove-sauce-labs-bike-light")
    private WebElement removeButton;
    @FindBy(xpath = "//a[contains(text(),'LinkedIn')]")
    private WebElement linkedInButton;
    @FindBy(xpath = "//icon[@data-test-id='nav-logo']")
    private WebElement linkedInLogo;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddBikeLightButton() {
        addBikeLightButton.click();
    }

    public void clickShoppingContainer() {
        shoppingContainer.click();
    }

    public String getItemName() {
        return itemName.getText();
    }

    public String getPrice() {
        return price.getText();
    }
    public void clickOnLinkedInButton(){
        linkedInButton.click();
    }
    public void switchToNewTab(){
        Set<String> tab_handles = driver.getWindowHandles();
        int number_of_tabs = tab_handles.size();
        int new_tab_index = number_of_tabs-1;
        driver.switchTo().window(String.valueOf(new_tab_index));
    }

}
