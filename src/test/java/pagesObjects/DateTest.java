package pagesObjects;

import driver.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import settings.ConfigProperty;

public class DateTest {
    WebDriver driver = Driver.getWebDriver();

    public void openPage() {
        driver.get(ConfigProperty.property.getProperty("bookingUrl"));
    }

    public void closePopUp() {
        driver.findElement(By.xpath("//*[@aria-label='Скрыть меню входа в аккаунт.']")).click();
    }

    public void enterCityName() {
        driver.findElement(By.xpath("//*[@name='ss']")).sendKeys(ConfigProperty.property.getProperty("cityName"));
    }

    public void selectCity() {
        driver.findElement(By.xpath("//*[@data-testid='autocomplete-results']/li[1]")).click();
    }

    public void selectFirstDate() {
        driver.findElement(By.xpath("//*[@data-date='2023-05-15']")).click();
    }

    public void selectLastDate() {
        driver.findElement(By.xpath("//*[@data-date='2023-05-30']")).click();
    }

    public void clickConfirmButtonButton() {
        driver.findElement(By.xpath("//*[@data-testid='occupancy-config']")).click();
    }

    public void clickSearchButton() {

        driver.findElement(By.xpath("//*[@type='submit']")).click();
    }

    public void checkThatCityToursIsFound() {
        WebElement element = driver.findElement(By.xpath("//*[@data-capla-component='b-search-web-searchresults/HeaderDesktop']//h1[contains(text(), 'Париж')]"));
        String textElement = element.getText();
        assert textElement.contains("Париж:") : "There is no any dates a list";


    }

}
