package objects;

import driver.Driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import settings.ConfigProperty;

public class DateTest {
    WebDriver driver = Driver.getWebDriver();
    public static final Logger LOGGER = Logger.getLogger(DateTest.class.getName());

    public void openPage(String bookingUrl) {
        driver.get(ConfigProperty.property.getProperty(bookingUrl));
        LOGGER.trace("Open booking page https://www.booking.com/");
    }

    public void closePopUp() {
        driver.findElement(By.xpath("//*[@aria-label='Скрыть меню входа в аккаунт.']")).click();
        LOGGER.trace("Close pop up on main page, locator - '//*[@aria-label='Скрыть меню входа в аккаунт.']'");
    }

    public void enterCityName() {
        driver.findElement(By.xpath("//*[@name='ss']")).sendKeys(ConfigProperty.property.getProperty("cityName"));
        LOGGER.trace("Enter city name, locator - '//*[@name='ss']'");
    }

    public void selectCity() {
        driver.findElement(By.xpath("//*[@data-testid='autocomplete-result']/div/div[text()='Paris']")).click();
        LOGGER.trace("Select sity in dropdown, locator - '//*[@data-testid='autocomplete-result']/div/div[text()='Paris']'");
    }

    public void selectFirstDate() {
        driver.findElement(By.xpath("//*[@data-date='2023-05-15']")).click();
        LOGGER.trace("Select first date, locator - '//*[@data-date='2023-05-15']'");
    }

    public void selectLastDate() {
        driver.findElement(By.xpath("//*[@data-date='2023-05-30']")).click();
        LOGGER.trace("Select last date, locator - '//*[@data-date='2023-05-30']'");
    }

    public void clickConfirmButtonButton() {
        driver.findElement(By.xpath("//*[@data-testid='occupancy-config']")).click();
        LOGGER.trace("Click confirm button, locator - '//*[@data-testid='occupancy-config']'");
    }

    public void clickSearchButton() {
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        LOGGER.trace("Click search button, locator - '//*[@type='submit']'");
    }

    public void checkThatCityToursIsFound() {
        WebElement element = driver.findElement(By.xpath("//*[@data-capla-component='b-search-web-searchresults/HeaderDesktop']//h1[contains(text(), 'Париж')]"));
        String textElement = element.getText();
        assert textElement.contains("Париж:") : "There is no any dates a list";
        LOGGER.trace("Check that city tours is found, locator - '//*[@data-capla-component='b-search-web-searchresults/HeaderDesktop']//h1[contains(text(), 'Париж')]'");
    }
}