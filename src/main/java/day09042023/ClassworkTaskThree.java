package day09042023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class ClassworkTaskThree {
    public static void main(String[] args) throws MalformedURLException {

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:9515"), new ChromeOptions());

        driver.get("https://google.com");
        System.out.println("Opened: " + driver.getTitle());
        System.out.println("Opened: " + driver.getCurrentUrl());

        driver.navigate().to("https://yandex.ru");
        System.out.println("Navigated to: " + driver.getTitle());
        System.out.println("Navigated to: " + driver.getCurrentUrl());

        driver.navigate().back();
        System.out.println("Back to: " + driver.getTitle());
        System.out.println("Back to: " + driver.getCurrentUrl());

        driver.navigate().refresh();

        driver.close();
        driver.quit();
    }
}
