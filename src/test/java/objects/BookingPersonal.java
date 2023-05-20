package objects;

import driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class BookingPersonal {
    WebDriver driver = Driver.getWebDriver();
    public static final Logger LOGGER = Logger.getLogger(BookingPersonal.class.getName());

    public void openPersonalPage() {
        driver.get("https://account.booking.com/mysettings/personal");
        LOGGER.trace("Open personal page");
    }

    public boolean checkVerifyIcon() {
        driver.findElement(By.xpath("//*[contains(text(), 'Verified')]"));
        LOGGER.trace("Check verify icon, locator - '//*[contains(text(), 'Verified')]'");
        return false;
    }

    public void closeActiveTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        LOGGER.trace("Close active tab");
    }

    public void finishTest() {
        driver.close();
        driver.quit();
        LOGGER.trace("Finished test");
    }
}