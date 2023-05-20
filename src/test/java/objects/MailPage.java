package objects;

import driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import settings.ConfigProperty;


public class MailPage {
    WebDriver driver = Driver.getWebDriver();
    public static final Logger LOGGER = Logger.getLogger(MailPage.class.getName());

    public void openPage(String email) {
        driver.get(ConfigProperty.property.getProperty(email));
        LOGGER.trace("Open https://yopmail.com/en/ page");
    }

    public void loginMail(String emailName) {
        driver.findElement(By.id("login")).clear();
        LOGGER.trace("Click on login field");
        driver.findElement(By.xpath("//*[@class='ycptinput']")).sendKeys(emailName);
        LOGGER.trace("Enter email name in login field, locator - '//*[@class='ycptinput']'");
        driver.findElement(By.xpath("//*[@id='refreshbut']")).click();
        LOGGER.trace("Click login button, locator - '//*[@id='refreshbut']'");
    }

    public void refreshMail() {
        driver.findElement(By.xpath("//*[@id='refresh']")).click();
        LOGGER.trace("Refresh page, locator - '//*[@id='refresh']'");
    }

    public void openConfirmLetter() {
        driver.switchTo().frame(driver.findElement(By.id("ifinbox")));
        driver.findElement(By.xpath("//*[@class='bodyinbox yscrollbar']//div[contains(text(), 'One more click to confirm your account')]")).click();
        driver.switchTo().defaultContent();
        LOGGER.trace("Open confirm letter in mailbox, locator - '//*[@class='bodyinbox yscrollbar']//div[contains(text(), 'One more click to confirm your account')]'");
    }

    public void clickConfirmButton() {
        driver.switchTo().frame(driver.findElement(By.id("ifmail")));
        driver.findElement(By.xpath("//a[contains(text(), 'Confirm')]")).click();
        driver.switchTo().defaultContent();
        LOGGER.trace("Click confirm button on mail, locator - '//a[contains(text(), 'Confirm')]'");
    }

    public void openVerifyLetter() {
        driver.switchTo().frame(driver.findElement(By.id("ifinbox")));
        driver.findElement(By.xpath("//*[@class='mctn']//div[contains(text(), 'Your verification link')]")).click();
        driver.switchTo().defaultContent();
        LOGGER.trace("Open verify letter in mailbox, locator - '//*[@class='mctn']//div[contains(text(), 'Your verification link')]'");
    }

    public void clickVerifyButton() {
        driver.switchTo().frame(driver.findElement(By.id("ifmail")));
        LOGGER.trace("Find verify button, locator - 'ifmail'");
        driver.findElement(By.xpath("//a[contains(text(), 'Verify me')]")).click();
        driver.switchTo().defaultContent();
        LOGGER.trace("Click verify button on mail, locator - '//a[contains(text(), 'Verify me')]'");
    }
}