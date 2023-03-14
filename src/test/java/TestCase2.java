import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase2 {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void preStep(){
        System.setProperty("webserver.chrome.driver", "C:\\Tools\\ChromDraivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        mainPage = new MainPage(driver);
        mainPage.invalidRegister("test","test");
    }

    @Test
    public void errorMessage(){
        String error = mainPage.errorText();
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service" , error);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
