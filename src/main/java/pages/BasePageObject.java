package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class BasePageObject{
    WebDriver driver;


    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void handlePopup(By locator) throws InterruptedException {
        List<WebElement> popup = driver.findElements(locator);
        if (!popup.isEmpty()) {
            popup.get(0).click();
            waitFor(1);
        }
    }
}
