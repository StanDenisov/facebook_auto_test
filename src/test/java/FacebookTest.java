import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import conf.Conf;
import entitys.User;
import lombok.var;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
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

public class FacebookTest {

    @Test
    public void foxRegistration() throws InterruptedException {
        System.setProperty("webdriver.firefox.driver", Conf.getProperty("geckodriver"));
        WebDriver driver = new FirefoxDriver();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        driver.manage().window().fullscreen();
        driver.get(Conf.getProperty("page"));
        registrationPage.registration(1);
        driver.close();
    }


    @Test
    public void foxLogin() {
        System.setProperty("webdriver.gecko.driver", Conf.getProperty("geckodriver"));
        WebDriver driver = new FirefoxDriver();
        LoginPage loginPage = new LoginPage(driver);
        driver.manage().window().fullscreen();
        driver.get(Conf.getProperty("page"));
        loginPage.login();
        driver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.MINUTES);
        driver.close();
    }







}
