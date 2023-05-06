package homework.tests.oldTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TaskSixTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup() {
        // Установка пути к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        // Создание экземпляра драйвера Chrome
        driver = new ChromeDriver();
        // Создание объекта WebDriverWait с таймаутом 10 секунд
        Duration timeout = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver, timeout);
        // Переход на страницу https://booking.com
        driver.get("https://booking.com");
    }

    @Test
    public void testBooking() {
        // Ввести в поиск "Москва"
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.sendKeys("Москва");

        // Выбрать для проживания 2 гостей и 1 номер
        WebElement guestsButton = driver.findElement(By.cssSelector("[data-modal-header-async-url-param*='group_adults=2']"));
        guestsButton.click();

        WebElement roomsButton = driver.findElement(By.cssSelector("[data-modal-header-async-url-param*='no_rooms=1']"));
        roomsButton.click();

        // Нажать на кнопку поиска
        WebElement searchButton = driver.findElement(By.cssSelector("button[type='submit']"));
        searchButton.click();

        // Проверить, что в Москве есть отели на введенные даты
        WebElement searchResults = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_results_table")));
        Assert.assertTrue(searchResults.isDisplayed());
    }

    @After
    public void teardown() {
        // Закрытие браузера
        driver.quit();
    }
}