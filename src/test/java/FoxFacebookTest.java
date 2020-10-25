import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import conf.Conf;
import entitys.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.var;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.RegistrationPage;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.ErrorCodes.TIMEOUT;

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
        driver.get(Conf.getProperty("page"));
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(1);
    }


    @Test
    public void foxLogin() {
        driver.get(Conf.getProperty("page"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
    }
}
