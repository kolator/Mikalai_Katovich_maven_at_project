package homework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    private static WebDriver getChromeDriver() {
        ChromeOptions caps = new ChromeOptions();
        caps.addArguments("start-maximized");
        return new ChromeDriver(caps);
    }

    private static WebDriver getFirefoxDriver() {
        return null;
    }

    private static WebDriver getEdgeDriver() {
        return null;
    }

    public static WebDriver getDriver(Config config) {
        return switch (config != null ? config : Config.CHROME) {
            case CHROME -> getChromeDriver();
            case FF -> getFirefoxDriver();
            case EDGE -> getEdgeDriver();
        };
    }

}
