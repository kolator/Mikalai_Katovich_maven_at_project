package classwork.day22042023;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    public static WebDriver getDriver(Config config){
        switch (config){
            case CHROME:
                return getChromeDriver();
            case FF:
                return getFirefoxDriver();
            case EDGE:
                return getEdgeDriver();
            default:
                throw null;
        }
    }
    private static WebDriver getChromeDriver() {
        return null;
    }
    private static WebDriver getFirefoxDriver() {
        return null;
    }
    private static WebDriver getEdgeDriver() {
        return null;
    }
}

