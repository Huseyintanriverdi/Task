package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class RequestPage extends BasePage{
    public RequestPage(WebDriver driver) {
        super(driver);
    }

    By medicationItem = By.id("ember767");
    By medicationSubItemNewRequest = By.linkText("New Request");
    By medicationSubItems = By.xpath("//div[@class='category-sub-items']");
    By newPatientTextBox = By.xpath("//input[@class='form-control ember-text-field ember-view tt-input']");
    By medicineTextBox = By.id("inventoryItemTypeAhead-ember1419");
    By quantityTextBox = By.id("quantity-ember1493");
    By addNewMedicationButton = By.xpath("//button[text()='Add']");
    By addNewMedicationButtonTwo = By.xpath("(//button[@class='btn btn-primary on-white '])[2]");
    By popUpCrossButton = By.xpath("(//button[@type='button'])[2]");
    By popupOkButton = By.xpath("(//button[@class='btn btn-primary on-white '])[2]");
    By medicationRequestSavedPopupIsDisplayed = By.tagName("h4");
    By medicationRequestText = By.tagName("h1");
    By pleaseSignInText= By.tagName("h2");
    @Step
    public void newMedication() {
        click(medicationItem);

    }
    @Step
    public void medicationSectionContains(String text) {
        Assertions.assertTrue(getText(medicationSubItems).contains(text));
    }

    @Step
    public void fillAllFields() throws InterruptedException {
        Actions actions=new Actions(driver);
        click(medicationSubItemNewRequest);
        waitVisibility(newPatientTextBox);
        type(newPatientTextBox,"Test - Patient - P00201");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("pra").perform();
        actions.sendKeys(Keys.TAB).sendKeys("Test prescription").sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.BACK_SPACE).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ENTER).perform();
        waitFor(5);
        type(medicineTextBox,"mo");
        waitFor(5);
        actions.sendKeys(Keys.TAB).perform();
        actions.click(find(quantityTextBox)).sendKeys("2").perform();
        actions.sendKeys(Keys.TAB).sendKeys("8").perform();
        waitFor(5);
        click(addNewMedicationButton);
        waitFor(5);
        actions.sendKeys(Keys.NUMPAD2).perform();
        click(addNewMedicationButtonTwo);
    }

    @Step
    public boolean isMedicationRequestSavedPopupDisplayed() {
        return isDisplayed(medicationRequestSavedPopupIsDisplayed);
    }

    @Step
    public boolean medicationRequestSavedPopupContainsOkButton() {
        return isDisplayed(popupOkButton);
    }

    @Step
    public boolean medicationRequestSavedPopupContainsCrossButton() {
        return isDisplayed(popUpCrossButton);
    }

    @Step
    public boolean isOnNewMedicationRequestPage() {
    click(popupOkButton);
    return isDisplayed(medicationRequestText);
    }
}
