import conf.Conf;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.RegistrationPage;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.ErrorCodes.TIMEOUT;

public class ChromeFacebookTest {

    private WebDriver driver;

    @BeforeTest
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethodInit() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void after() {
        driver.close();
    }


    @Test
    public void chromeRegistration() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        driver.get(Conf.getProperty("page"));
        registrationPage.registration(1);
    }

    @Test
    public void chromeLogin() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get(Conf.getProperty("page"));
        loginPage.login();
    }
}
