package homework;

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


        // Фильтруем по максимальной стоимости и сортируем по возрастанию цены
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        WebElement priceButton = driver.findElement(By.xpath("//*[@id=':R2hn8cq:']"));
//        priceButton.click();

        // если ползунок
        WebElement rangeInput = driver.findElement(By.xpath("//*[contains(@id,'filter_group_price_')]//input[@type=\"range\"]"));
        Actions move = new Actions(driver);
        move.dragAndDropBy(rangeInput, 100, 0).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(rangeInput, "value", "25"));


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();
        driver.findElement(By.xpath("//span[text()='Price (lowest first)']")).click();



        WebElement cheapestHotelPriceElement = driver.findElement(By.xpath("(//*[@class='bui-price-display__value prco-text-nowrap-helper prco-inline-block-maker-helper'])[1]"));
        String cheapestHotelPrice = cheapestHotelPriceElement.getText().replaceAll("[^\\d.]+", "");
        double cheapestPrice = Double.parseDouble(cheapestHotelPrice);

// проверяем, что стоимость ночи самого дешевого отеля на странице больше или равна 1600 злотых
        double maxPrice = 1600.0;
        if (cheapestPrice >= maxPrice) {
            System.out.println("Success!");
        } else {
            System.out.println("Failure!");
        }

        driver.quit();

    }
}