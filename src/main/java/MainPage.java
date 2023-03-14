import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginInput = By.id("login-button");
    private By error = By.cssSelector("div.error-message-container.error");

    public MainPage typeName(String name) {
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }
    public MainPage typePassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    public Products register (String name, String password){
        this.typeName(name);
        this.typePassword(password);
        driver.findElement(loginInput).click();
        return new Products(driver);
    }

    public MainPage invalidRegister (String name, String password){
        this.typeName(name);
        this.typePassword(password);
        driver.findElement(loginInput).click();
        return new MainPage(driver);
    }

    public String errorText (){
        return driver.findElement(error).getText();
    }




}






