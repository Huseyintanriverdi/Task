
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import pages.HomePage;
import pages.PatientListingPage;
import pages.RequestPage;

public class Tests extends BaseTest{
    HomePage homePage;
    PatientListingPage patientListingPage;
    RequestPage requestPage;
    @Test
    @Step
    @Order(1)
    public void loginWithCorrectCredentials(){
        homePage=new HomePage(driver);
        patientListingPage=new PatientListingPage(driver);
        homePage.login("hr.doctor@hospitalrun.io","HRt3st12");
        Assertions.assertTrue(patientListingPage.isOnPatientListingPage(),
                "User is not on patient listing page");
    }

    @Test
    @Step
    @Order(2)
    public void cannotLoginWithWrongCredentials(){
     homePage=new pages.HomePage(driver);
     homePage.login("sample@hospitalrun.io","sampLe312");
     Assertions.assertTrue(homePage.isOnHomePage(),
                "User is not on homepage");
     Assertions.assertTrue(homePage.isErrorMessageDisplayed(),
                "Error message is not displayed");
    }

    @Test
    @Step
    @Order(3)
    public void ableToLogOut(){
    homePage=new HomePage(driver);homePage.login("hr.doctor@hospitalrun.io","HRt3st12");
    patientListingPage=new pages.PatientListingPage(driver);
    homePage=new pages.HomePage(driver);
    patientListingPage.logOut();
    Assertions.assertTrue(homePage.isOnHomePage(),
            "user was not logged out");
    }

    @Test
    @Step
    @Order(4)
    public void requestANewMedication() throws InterruptedException {
    requestPage= new pages.RequestPage(driver);
    homePage=new HomePage(driver);
    homePage.login("hr.doctor@hospitalrun.io","HRt3st12");
    requestPage.newMedication();
    requestPage.medicationSectionContains("Requests");
    requestPage.medicationSectionContains("Completed");
    requestPage.medicationSectionContains("New Request");
    requestPage.medicationSectionContains("Return Medication");
    requestPage.fillAllFields();
    Assertions.assertTrue(requestPage.isMedicationRequestSavedPopupDisplayed(),
            "Medication request popup is not displayed");
    Assertions.assertTrue(requestPage.medicationRequestSavedPopupContainsOkButton(),
           "Medication request saved popup does not contain ok button");
    Assertions.assertTrue(requestPage.medicationRequestSavedPopupContainsCrossButton(),
            "Medication request saved popup does not contain cross button");

    Assertions.assertTrue(requestPage.isOnNewMedicationRequestPage(),
            "User is not on request page");

    }



}
