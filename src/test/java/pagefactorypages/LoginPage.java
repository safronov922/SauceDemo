package pagefactorypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import staticdata.WebUrls;

public class LoginPage extends BasePage {


    @FindBy(id = "user-name")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement logInButton;

    @FindBy(className = "title")
    private WebElement pageName;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLogInPage() {
        driver.get(WebUrls.BASE_URL);
    }

    public void inputLogin(String login) {
        loginInput.sendKeys(login);
    }

    public void inputPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLogInButton() {
        logInButton.click();
    }

    public String getPageName() {
        return pageName.getText();
    }

}
