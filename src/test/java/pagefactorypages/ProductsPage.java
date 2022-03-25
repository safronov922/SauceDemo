package pagefactorypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

}
