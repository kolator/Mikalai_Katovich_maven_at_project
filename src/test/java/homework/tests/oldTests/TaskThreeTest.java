package homework.tests.oldTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class TaskThreeTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.get("https://www.booking.com/");
        driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();

        // вводим Zakopane
        WebElement cityField = driver.findElement(By.name("ss"));
        cityField.sendKeys("Zakopane");

        // сабмит
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Прокручиваем страницу к 10-му отелю
        WebElement hotelTen = driver.findElement(By.xpath("(//*[@data-testid=\"property-card\"])[10]"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", hotelTen);

        // Находим заголовок 10-го отеля
        WebElement hotelTitle = driver.findElement(By.xpath("(//*[@data-testid=\"title\"])[10]"));

        // Меняем цвет фона на зеленый
        jse.executeScript("arguments[0].style.backgroundColor = 'green'", hotelTitle);

        // Меняем цвет текста на красный
        jse.executeScript("arguments[0].style.color = 'red'", hotelTitle);

        // Получаем цвет текста заголовка и проверяем, что он красный
        String color = hotelTitle.getCssValue("color");
        if (color.equals("rgba(255, 0, 0, 1)")) {
            System.out.println("Заголовок отеля красного цвета");
        } else {
            System.out.println("Заголовок отеля не красного цвета");
        }

        //Закрываем
        driver.quit();
    }
}


