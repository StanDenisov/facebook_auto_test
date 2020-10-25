package pages;

import conf.Conf;
import lombok.var;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"pass\"]")
    private WebElement  passwordField;


    @FindBy(xpath = "//*[@id=\"u_0_b\"]")
    private WebElement  loginButton;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    public void login() {
        loginField.sendKeys("job@warlord.dev");
        passwordField.sendKeys("393483Qwer");
        loginButton.click();
    }
}
