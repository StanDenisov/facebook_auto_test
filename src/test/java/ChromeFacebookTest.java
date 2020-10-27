import conf.Conf;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;

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
        step("chrome registration");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        driver.get(Conf.getProperty("page"));
        registrationPage.registration(1);
    }

    @Test
    public void chromeLogin() {
        step("chrome login");
        LoginPage loginPage = new LoginPage(driver);
        driver.get(Conf.getProperty("page"));
        loginPage.login();
    }
}
