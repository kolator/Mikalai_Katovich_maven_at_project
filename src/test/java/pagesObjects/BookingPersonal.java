package pagesObjects;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class BookingPersonal {
    WebDriver driver = Driver.getWebDriver();

    public void openPersonalPage() {
        driver.get("https://account.booking.com/mysettings/personal");
    }
    public boolean checkVerifyIcon() {
        driver.findElement(By.xpath("//*[contains(text(), 'Verified')]"));
        return false;
    }
    public void closeActiveTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    public void finishTest() {
        driver.close();
        driver.quit();
    }
}
