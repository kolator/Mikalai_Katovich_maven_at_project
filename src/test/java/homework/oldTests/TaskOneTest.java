package homework.oldTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TaskOneTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.get("https://www.booking.com/");
        driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();

        // отелеи в Париже
        WebElement cityField = driver.findElement(By.name("ss"));
        cityField.sendKeys("Париж");

        // календарь
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement dates = driver.findElement(By.xpath("//*[@id=\"indexsearch\"]//button[@data-testid=\"date-display-field-start\"]"));
        dates.click();

        //Выбираем даты
        LocalDate checkinDate = LocalDate.now().plusDays(3);
        LocalDate checkoutDate = checkinDate.plusDays(7);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        driver.findElement(By.xpath(String.format("//span[@data-date='%s']", checkinDate.format(dateFormat)))).click();
        driver.findElement(By.xpath(String.format("//span[@data-date='%s']", checkoutDate.format(dateFormat)))).click();

        //номера + люди
        driver.findElement(By.xpath("//*[@data-testid='occupancy-config']")).click();
        WebElement clickElement = driver.findElement(By.xpath("//*[@id='group_adults']/following-sibling::div/button[2]"));
        clickElement.click();
        clickElement.click();
        driver.findElement(By.xpath("//*[@id='no_rooms']/following-sibling::div/button[2]")).click();

        //сабмит
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        // чекбокс на максимальную стоимость
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> buttons = driver.findElements(By.xpath("//*[@id=':R2hn8cq:']"));
        if (!buttons.isEmpty()) {
            buttons.get(0).click();
        }
        // ползунок на максимальную стоимость
        List<WebElement> rangeInput = driver.findElements(By.xpath("//*[contains(@id,'filter_group_price_')]//input[@type=\"range\"]"));
        if (!rangeInput.isEmpty()) {
            Actions move = new Actions(driver);
            move.dragAndDropBy(rangeInput.get(0), 45, 0).perform();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.attributeToBe(rangeInput.get(0), "value", "1600"));
        }

        // ловер прайс в топ
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();
        driver.findElement(By.xpath("//span[text()='Price (lowest first)']")).click();

        // делаем из текста верхнего прайса число
        List<WebElement> cheapestHotelPriceElement = driver.findElements(By.xpath("//span[@data-testid='price-and-discounted-price']"));
        String cheapestHotelPrice = cheapestHotelPriceElement.get(0).getText().replaceAll("[^\\d.]+", "");
        double cheapestPrice = Double.parseDouble(cheapestHotelPrice);

        // проверяем стоимость с 1600
        double maxPrice = 1600.0;
        if (cheapestPrice >= maxPrice) {
            System.out.println("Success!");
        } else {
            System.out.println("Failure!");
        }

        driver.quit();
    }
}