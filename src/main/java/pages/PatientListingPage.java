package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientListingPage extends BasePage{
    public PatientListingPage(WebDriver driver) {
        super(driver);
    }
    By patientListingText = By.xpath("//h1[text()='Patient Listing']");
    By cogWheelIcon = By.xpath("//a[@class='settings-trigger ']");
    By logOutButton = By.xpath("//a[@class='logout']");

    @Step
    public boolean isOnPatientListingPage() {
    return isDisplayed(patientListingText);
    }

    @Step
    public void logOut() {
        click(cogWheelIcon);
        click(logOutButton);

    }
}
