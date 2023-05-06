package homework.project.pages;
import homework.project.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class BookingMainPage {
    WebDriver driver = Driver.getWebDriver();

    public void getUrl() {
        driver.get("https://booking.com");
    }
}
