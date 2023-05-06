package homework.project.driver;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Driver {

    private static WebDriver webDriver;

    public static homework.project.driver.Config config;

    public static void setConfig(Config theConfig) {
        config = null == theConfig ? homework.project.driver.Config.valueOf(System.getProperty("CONFIG")) : theConfig;
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = DriverManager.getDriver(config);
            setTimeOuts(10, 10, 10);
        }
        return webDriver;
    }
    public static void closeDriver() {
        webDriver.quit();
        webDriver = null;
    }

    public static void setTimeOuts(int scriptTimeout, int pageLoadTimeout, int implicitlyWait) {
        webDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(scriptTimeout));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
    }

}
