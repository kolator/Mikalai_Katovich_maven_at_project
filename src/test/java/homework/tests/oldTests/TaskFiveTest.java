package homework.tests.oldTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TaskFiveTest {
    private WebDriver driver;

    @Before
    public void setup() {
        // Установка пути к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        // Создание экземпляра драйвера Chrome
        driver = new ChromeDriver();
        // Переход на страницу https://booking.com
        driver.get("https://booking.com");
    }

    @Test
    public void testBooking() {
        // Наведение мыши на индикатор валюты
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector("[data-tooltip-text='Choose your currency']"))).perform();

        // Проверка значения подсказки
        String currencyTooltip = driver.findElement(By.cssSelector(".bui-tooltip__content")).getText();
        Assert.assertEquals("Выберите вашу валюту", currencyTooltip);

        // Наведение мыши на индикатор языка
        actions.moveToElement(driver.findElement(By.cssSelector("[data-tooltip-text='Choose your language']"))).perform();

        // Проверка значения подсказки
        String languageTooltip = driver.findElement(By.cssSelector(".bui-tooltip__content")).getText();
        Assert.assertEquals("Выберите язык", languageTooltip);
    }

    @After
    public void teardown() {
        // Закрытие браузера
        driver.quit();
    }
}
