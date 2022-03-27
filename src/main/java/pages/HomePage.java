package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) { super(driver);}

    By userNameBox = By.id("identification");

    By passwordBox = By.id("password");

    By loginButton = By.xpath("//button[@type='submit']");

    By errorFailedLogInXpath = By.xpath("//div[@class='alert alert-danger form-signin-alert']");

    @Step
    public void login(String username, String password) {
        type(userNameBox,username);
        type(passwordBox,password);
        click(loginButton);
    }

    @Step
    public boolean isOnHomePage() {
    return driver.getTitle().equals("HospitalRun");
    }

    @Step
    public boolean isErrorMessageDisplayed() {
        return isDisplayed(errorFailedLogInXpath);
    }
    }
