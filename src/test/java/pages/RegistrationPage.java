package pages;

import conf.Conf;
import lombok.Data;
import lombok.var;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.ErrorCodes.TIMEOUT;


public class RegistrationPage {
    @FindBy(xpath = "//*[@id=\"u_1_g\"]")
    private WebElement  emailField;

    @FindBy(xpath = "//*[@id=\"u_1_b\"]")
    private WebElement  nameField;

    @FindBy(xpath = "//*[@id=\"u_1_d\"]")
    private WebElement  lastNameField;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[2]")
    private WebElement  genderMaleRadio;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[1]")
    private WebElement  genderFemaleRadio;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[3]")
    private WebElement  genderAnotherRadio;

    @FindBy(xpath = "//*[@id=\"u_1_j\"]")
    private WebElement againEmailField;

    @FindBy(xpath = "//*[@id=\"password_step_input\"]")
    private WebElement  passwordField;

    @FindBy(xpath = "//*[@id=\"day\"]")
    private WebElement  birthdayDateDayField;

    @FindBy(xpath = "//*[@id=\"u_q_p\"]/select")
    private WebElement  genderPreferredPronounSelect;

    @FindBy(xpath = "//*[@id=\"u_q_q\"]")
    private WebElement  customGenderField;

    @FindBy(xpath = "//*[@id=\"month\"]")
    private WebElement birthdayDateMonthField;

    @FindBy(xpath = "//*[@id=\"year\"]")
    private WebElement  birthdayDateYearField;

    @FindBy(xpath = "//*[@id=\"u_1_s\"]")
    private WebElement registrationCompleteButton;

    @FindBy(xpath = "//*[@id=\"u_0_2\"]")
    private WebElement registrationButton;

    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void registration(int userID) throws InterruptedException {
        var user = Conf.getUsersJson().get(userID);
        System.out.println(user.toString());
        registrationButton.click();
        System.out.println("Sleep begin");
        Thread.sleep(2000);
        System.out.println("Sleep end");
        emailField.sendKeys(user.getEmail());
        nameField.sendKeys(user.getName());
        lastNameField.sendKeys(user.getLastName());
        passwordField.sendKeys(user.getPassword());
        Thread.sleep(2000);
        againEmailField.sendKeys(user.getEmail());
        switch (user.getGender()) {
            case "m":
                genderMaleRadio.click();
                break;
            case "f":
                genderFemaleRadio.click();
                break;
            case "x":
                genderAnotherRadio.click();
                Select select = new Select(genderPreferredPronounSelect);
                select.selectByIndex(1);
                customGenderField.sendKeys(user.getGenderType());
                break;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(user.getBirthdayDate());
        Select birthdayYearSelect = new Select(birthdayDateYearField);
        birthdayYearSelect.selectByValue(String.valueOf(cal.get(Calendar.YEAR)));
        Select birthdayMonthSelect = new Select(birthdayDateMonthField);
        birthdayMonthSelect.selectByValue(String.valueOf(cal.get(Calendar.MONTH)));
        Select birthdayDaySelect = new Select(birthdayDateDayField);
        birthdayDaySelect.selectByValue(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
        registrationCompleteButton.click();
    }
}
