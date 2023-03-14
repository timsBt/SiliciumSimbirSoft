import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Products {

    private WebDriver driver;

    public Products(WebDriver driver) {
        this.driver = driver;
    }

    private By addCarts = By.cssSelector(".btn.btn_primary.btn_small.btn_inventory");
    private By cart =  By.cssSelector(".shopping_cart_link");

    public Products addToCart () {
        List<WebElement> add = driver.findElements(addCarts);
        add.get(0).click();
        return this;
    }

    public YourCart cartClick(){
        driver.findElement(cart).click();
        return new YourCart(driver);
    }


}
