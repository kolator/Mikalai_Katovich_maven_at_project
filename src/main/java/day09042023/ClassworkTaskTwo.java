package day09042023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class ClassworkTaskTwo {
    public static void main(String[] args) throws MalformedURLException {

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:9515"), new ChromeOptions());

        driver.get("https://google.com");
        System.out.println("Title is: " + driver.getTitle());
        System.out.println("URL is: " + driver.getCurrentUrl());
        driver.close();
        driver.quit();
    }
}
