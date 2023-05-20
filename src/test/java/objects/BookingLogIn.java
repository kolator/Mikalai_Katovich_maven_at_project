package objects;

import driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import settings.ConfigProperty;


public class BookingLogIn {
    WebDriver driver = Driver.getWebDriver();
    public static final Logger LOGGER = Logger.getLogger(BookingLogIn.class.getName());

    public void openSignInPage(String signInUrl) {
        driver.get(ConfigProperty.property.getProperty(signInUrl));
        LOGGER.trace("Open sign in page https://account.booking.com/sign-in");

    }

    public void enterVerifiedPassword(String password) {
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys(ConfigProperty.property.getProperty(password));
        LOGGER.trace("Enter verified password, locator - '//*[@type='password']'");
    }

    public void closeWelcomePopUp() {
        driver.findElement(By.xpath("//*[@class='modal-mask-closeBtn']")).click();
        LOGGER.trace("Close welcome pop-up, locator - '//*[@class='modal-mask-closeBtn']'");
    }

    public void backToMainPage() {
        driver.navigate().back();
        LOGGER.trace("Back to navigate menu");
    }
}