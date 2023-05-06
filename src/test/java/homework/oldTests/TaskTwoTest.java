package homework.oldTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TaskTwoTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // Открываем браузер и переходим w3schools.com
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.get("https://www.w3schools.com/java/");
        driver.findElement(By.xpath("//*[@id=\"accept-choices\"]")).click();

        //открываем менюшку
        driver.findElement(By.xpath("//*[@id=\"navbtn_tutorials\"]")).click();

        // выделяем  "Tutorial"
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav_tutorials\"]//h2/b")))
                .doubleClick()
                .build()
                .perform();

        // контрл + Ц
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

        // Переходим google.com
        driver.get("https://www.google.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();

        // контрл В + поиск
        driver.findElement(By.name("q")).sendKeys(Keys.CONTROL + "v");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

        // Проверяем, что каждый результат содержит слово "Tutorial"
        boolean isWordPresent = true;
        String searchTerm = "Tutorials";
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
            System.out.println("Каждый из результатов содержит: " + searchTerm);
        } else {
            System.out.println("Есть результаты без: " + searchTerm);
        }

        // Закрываем
        //        driver.quit();
    }
}