package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskThreeTest {
    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();

        // Переходим на сайт booking.com
        driver.manage().window().maximize();
        driver.get("https://www.booking.com");

        // Находим поле для ввода города и вводим "Москва"
        WebElement cityField = driver.findElement(By.name("ss"));
        cityField.sendKeys("Москва");

        // Находим кнопку поиска и кликаем на нее
        WebElement searchButton = driver.findElement(By.cssSelector("button[type='submit']"));
        searchButton.click();

        // Ждем, пока страница загрузится и отобразятся результаты поиска
        Thread.sleep(5000);

        // Прокручиваем страницу к 10-му отелю
        WebElement hotel = driver.findElement(By.xpath("//div[@id='hotellist_inner']/div[10]"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", hotel);

        // Находим заголовок 10-го отеля
        WebElement hotelTitle = driver.findElement(By.xpath("//div[@id='hotellist_inner']/div[10]//h3[@class='sr-hotel__title']"));

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

        // Закрываем браузер
        driver.quit();
    }
}


