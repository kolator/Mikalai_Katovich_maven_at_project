package homework.oldTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TaskFourTest {
    private WebDriver driver;

    @Before
    public void setup() {
        // Установка пути к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        // Создание экземпляра драйвера Chrome
        driver = new ChromeDriver();
        // Переход на страницу https://demoqa.com/select-menu
        driver.get("https://demoqa.com/select-menu");
    }

    @Test
    public void testSelectMenu() {
        // Выбор значения в первом выпадающем списке
        Select select1 = new Select(driver.findElement(By.id("oldSelectMenu")));
        select1.selectByVisibleText("Purple");

        // Выбор значения во втором выпадающем списке
        Select select2 = new Select(driver.findElement(By.id("cars")));
        select2.selectByIndex(2);

        // Выбор значения в третьем выпадающем списке
        Select select3 = new Select(driver.findElement(By.id("fruit-selects")));
        select3.selectByValue("orange");
    }

    @After
    public void teardown() {
        // Закрытие браузера
        driver.quit();
    }
}