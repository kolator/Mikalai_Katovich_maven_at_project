package day15042023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;


public class BookingSearchTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.get("https://www.booking.com/");
        driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();

        WebElement cityField = driver.findElement(By.name("ss"));
        cityField.sendKeys("Париж");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement checkInAndOutdDates = driver.findElement(By.xpath("//button[@data-testid='date-display-field-start']"));
        checkInAndOutdDates.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement checkIn = driver.findElement(By.xpath("//*[@id=\"calendar-searchboxdatepicker\"]//descendant::tr[4]/td[2]/span/span"));
        checkIn.click();
        WebElement checkOut = driver.findElement(By.xpath("//td[@data-date='2023-04-25']"));
        checkOut.click();





    }
}