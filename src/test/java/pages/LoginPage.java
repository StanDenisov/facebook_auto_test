package pages;

import conf.Conf;
import lombok.var;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"pass\"]")
    private WebElement  passwordField;


    @FindBy(xpath = "//*[@id=\"u_0_b\"]")
    private WebElement  loginButton;

    @FindBy(xpath = "//*[@id=\"checkpointBottomBar\"]/div[1]")
    private WebElement downloadInformation;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    public void login(int userID) {
        var user = Conf.getUsersJson().get(userID);
        loginField.sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
        loginButton.click();
        downloadInformation.isDisplayed();
    }
}
