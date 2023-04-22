package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TaskTwoTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // Открываем браузер и переходим на сайт w3schools.com
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/java/");

        // Двойным кликом выделяем слово "Tutorial" в заголовке страницы
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//h1[contains(text(),'Java Tutorial')]")))
                .doubleClick()
                .build()
                .perform();

        // Копируем текст в буфер обмена
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

        // Переходим на страницу google.com
        driver.get("https://www.google.com");

        // Вставляем скопированный текст в поле поиска и запускаем поиск
        driver.findElement(By.name("q")).sendKeys(Keys.CONTROL + "v");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        // Ожидаем загрузки страницы с результатами
        Thread.sleep(3000);

        // Проверяем, что каждый результат содержит слово "Tutorial"
        boolean isWordPresent = true;
        String searchTerm = "Tutorial";
        for (int i = 1; i <= 10; i++) {
            String resultText = driver.findElement(By.xpath("//div[@class='g'][" + i + "]"))
                    .getText()
                    .toLowerCase();
            if (!resultText.contains(searchTerm.toLowerCase())) {
                isWordPresent = false;
                break;
            }
        }
        if (isWordPresent) {
            System.out.println("Каждый из результатов содержит искомое слово: " + searchTerm);
        } else {
            System.out.println("Не каждый из результатов содержит искомое слово: " + searchTerm);
        }

        // Закрываем браузер
        driver.quit();
    }
}