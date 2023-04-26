import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class TestCase1 {


    private WebDriver driver;
    private LoginPage loginPage;
    private Products products;
    private YourCart yourCart;
    private CheckYourInfo checkYourInfo;
    private CheckOverview checkOverview;
    private Complete complete;

    @BeforeEach
    public void SetUp()  {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");

        products = new Products(driver);
        products.addToCart()
                .cartClick();

        yourCart = new YourCart(driver);
        yourCart.checkout();

        checkYourInfo = new CheckYourInfo(driver);
        checkYourInfo.yourOver("test", "test" , "test");

        checkOverview = new CheckOverview(driver);
        checkOverview.finish();


    }

    @Test
    public void redirect(){
        String url = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.saucedemo.com/checkout-complete.html", url);
    }

    @Test
    public void thankYouMessage(){

        complete = new Complete(driver);
        String message = complete.textCheck();
        Assertions.assertEquals("THANK YOU FOR YOUR ORDER", message);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }


}



