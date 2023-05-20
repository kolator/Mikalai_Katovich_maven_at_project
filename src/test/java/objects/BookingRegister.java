package objects;

import driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import settings.ConfigProperty;


public class BookingRegister {
    WebDriver driver = Driver.getWebDriver();
    public static final Logger LOGGER = Logger.getLogger(BookingRegister.class.getName());

    public void openBookingPage(String bookingRegisterUrl) {
        driver.get(ConfigProperty.property.getProperty(bookingRegisterUrl));
        LOGGER.trace("Open booking page https://www.booking.com/");
    }

    public void registrationPage() {
        driver.findElement(By.xpath("//*[@data-testid='header-sign-up-button']")).click();
        LOGGER.trace("Click on sign in button, locator - '//*[@data-testid='header-sign-up-button']'");
    }

    public void enterEmailInSignIn() {
        driver.findElement(By.xpath("//*[@type='email']")).sendKeys(ConfigProperty.property.getProperty("emailName")
                + ConfigProperty.property.getProperty("emailDomain"));
        LOGGER.trace("Enter email in sign in form, locator - '//*[@type='email']' + email domain '@nomail.xl.cx'");
    }

    public void submitEnterEmail() {
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        LOGGER.trace("Submit enter email, locator - '//*[@type='submit']'");
    }

    public void enterNewPassword() {
        driver.findElement(By.xpath("//*[@name='new_password']")).sendKeys(ConfigProperty.property.getProperty("password"));
        LOGGER.trace("Enter new password, locator - '//*[@name='new_password']'");
    }

    public void confirmNewPassword() {
        driver.findElement(By.xpath("//*[@name='confirmed_password']")).sendKeys(ConfigProperty.property.getProperty("password"));
        LOGGER.trace("Confirm new password, locator - '//*[@name='confirmed_password']'");
    }

    public void submitEnterPassword() {
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        LOGGER.trace("Submit enter password, locator - '//*[@type='submit']'");
    }

    public void closeWelcomePopup() {
        driver.findElement(By.xpath("//*[@class='modal-mask-closeBtn']")).click();
        LOGGER.trace("Close welcome popup, locator - '//*[@class='modal-mask-closeBtn']'");
    }

    public void clickSignInButtonAfterConfirm() {
        driver.findElement(By.xpath("//*[@class='transition']//span")).click();
        LOGGER.trace("Clock sign in button after confirm form, locator - '//*[@class='transition']//span'");
    }

    public void openConfirmedPage() {
        driver.get(ConfigProperty.property.getProperty("bookingComfirmUrl"));
        LOGGER.trace("Open confirmation page");
    }
}