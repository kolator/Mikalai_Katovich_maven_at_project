package day09042023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ClassworkTaskFour {
    public static void main(String[] args) throws MalformedURLException {

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:9515"), new ChromeOptions());

        driver.get("https://google.com");

        WebElement acceptButton = driver.findElement(By.cssSelector("#L2AGLb"));
        acceptButton.click();

        WebElement searchBox = driver.findElement(By.name("q"));

        searchBox.sendKeys("погода минск");
        searchBox.sendKeys(Keys.ENTER);



//        System.out.println("Title is: " + driver.getTitle());
//        System.out.println("URL is: " + driver.getCurrentUrl());
//        driver.close();
//        driver.quit();
    }
}
