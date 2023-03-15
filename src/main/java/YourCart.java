import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourCart {

    private WebDriver driver;

    public YourCart (WebDriver driver) {
        this.driver = driver;
    }

    private By check = By.id("checkout");

    public CheckYourInfo checkout (){
        driver.findElement(check).click();
        return new CheckYourInfo(driver);
    }

}