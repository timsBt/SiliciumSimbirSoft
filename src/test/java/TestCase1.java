import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase1 {

    private WebDriver driver;
    private MainPage mainPage;
    private Products products;
    private YourCart yourCart;
    private CheckYourInfo checkYourInfo;
    private Overview overview;

   @Before
    public void preStep()  {
        System.setProperty("webserver.chrome.driver", "C:\\Tools\\ChromDraivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        mainPage = new MainPage(driver);

        mainPage.register("standard_user","secret_sauce");
        products = new Products(driver);
        products.addToCart();
        products.cartClick();

        yourCart = new YourCart(driver);
        yourCart.chekout();

        checkYourInfo = new CheckYourInfo(driver);
        checkYourInfo.yourOver("test", "test" , "test");

        overview = new Overview(driver);
        overview.finish();

    }

    @Test
    public void redirect(){
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/checkout-complete.html", url);
    }

    @Test
    public void expectedResult(){
       Complete newComplete = new Complete(driver);
       String message = newComplete.textCheck();
       Assert.assertEquals("THANK YOU FOR YOUR ORDER", message);
    }

    @After
    public void tearDown(){
       driver.quit();
    }



}
