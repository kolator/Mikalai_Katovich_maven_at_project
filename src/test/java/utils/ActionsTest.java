package utils;

import driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsTest {
    WebDriver driver = Driver.getWebDriver();
    Actions actions = new Actions(driver);

    public void findCurrencyIcon() {
        WebElement element = driver.findElement(By.xpath("//*[@data-testid='header-currency-picker-trigger']"));
        actions.moveToElement(element);
        actions.perform();
    }
    public void checkHoverCurrencyText() {
        String hover =  driver.findElement(By.xpath("//*[@id=':R2cl:']")).getText();
        Assert.assertEquals("There is no tooltip","Выберите валюту", hover);
    }
    public void findLangIcon() {
        WebElement element1 = driver.findElement(By.xpath("//*[@data-testid='header-language-picker-trigger']"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(element1);
        actions1.perform();
    }
    public void checkHoverLangText() {
        String hover1 = driver.findElement(By.xpath("//*[@id=':R2kl:']")).getText();
        Assert.assertEquals("There is no tooltip","Выберите язык", hover1);

    }
}