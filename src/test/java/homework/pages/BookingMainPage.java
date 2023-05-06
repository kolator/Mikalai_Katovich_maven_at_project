package homework.pages;
import homework.driver.Driver;
import org.openqa.selenium.WebDriver;

public class BookingMainPage {
    WebDriver driver = Driver.getWebDriver();

    public void getUrl() {
        driver.get("https://booking.com");
    }
}
