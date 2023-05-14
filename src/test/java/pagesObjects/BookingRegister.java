package pagesObjects;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import settings.ConfigProperty;


public class BookingRegister {
    WebDriver driver = Driver.getWebDriver();

    public void openBookingPage() {
        driver.get(ConfigProperty.property.getProperty("bookingRegisterUrl"));
    }

    public void registrationPage() {
        driver.findElement(By.xpath("//*[@data-testid='header-sign-up-button']")).click();
    }

    public void enterEmailInSignIn() {
        driver.findElement(By.xpath("//*[@type='email']")).sendKeys(ConfigProperty.property.getProperty("emailName")
                + ConfigProperty.property.getProperty("emailDomain"));
    }

    public void submitEnterEmail() {
        driver.findElement(By.xpath("//*[@type='submit']")).click();
    }

    public void enterNewPassword() {
        driver.findElement(By.xpath("//*[@name='new_password']")).sendKeys(ConfigProperty.property.getProperty("password"));
    }

    public void confirmNewPassword() {
        driver.findElement(By.xpath("//*[@name='confirmed_password']")).sendKeys(ConfigProperty.property.getProperty("password"));
    }

    public void submitEnterPassword() {
        driver.findElement(By.xpath("//*[@type='submit']")).click();
    }

    public void closeWelcomePopup() {
        driver.findElement(By.xpath("//*[@class='modal-mask-closeBtn']")).click();
    }

    public void clickSignInButtonAfterConfirm() {
        driver.findElement(By.xpath("//*[@class='transition']//span")).click();
    }

    public void openConfirmedPage() {
        driver.get(ConfigProperty.property.getProperty("bookingComfirmUrl"));
    }
}
