package pagesObjects;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import settings.ConfigProperty;



public class BookingLogIn {
    WebDriver driver = Driver.getWebDriver();


    public void openSignInPage() {
        driver.get(ConfigProperty.property.getProperty("bookingSignInUrl"));

    }

    public void enterVerifiedPassword() {
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys(ConfigProperty.property.getProperty("password"));
    }
    public void closeWelcomePopUp() {
        driver.findElement(By.xpath("//*[@class='modal-mask-closeBtn']")).click();
    }
    public void backToMainPage() {
        driver.navigate().back();
    }


}
