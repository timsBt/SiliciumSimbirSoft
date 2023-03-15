import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Products {

    private WebDriver driver;

    public Products(WebDriver driver) {
        this.driver = driver;
    }

    private By addCarts = By.id("add-to-cart-sauce-labs-backpack");
    private By cart =  By.cssSelector(".shopping_cart_link");

    public Products addToCart () {
        driver.findElement(addCarts).click();
        return this;
    }

    public YourCart cartClick(){
        driver.findElement(cart).click();
        return new YourCart(driver);
    }


}