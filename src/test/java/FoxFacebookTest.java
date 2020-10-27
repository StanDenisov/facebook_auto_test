import conf.Conf;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;

public class FoxFacebookTest {

    private WebDriver driver;

    @BeforeTest
    public void setupTest() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    public void beforeMethodInit() {
        driver = new FirefoxDriver();
    }

    @AfterMethod
    public void after() {
        driver.close();
    }


    @Test
    public void foxRegistration() throws InterruptedException {
        step("fox registration");
        driver.get(Conf.getProperty("page"));
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(1);
    }


    @Test
    public void foxLogin() {
        step("fox login");
        driver.get(Conf.getProperty("page"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
    }
}
