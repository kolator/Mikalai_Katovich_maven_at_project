package pagesObjects;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import settings.ConfigProperty;



public class MailPage {
    WebDriver driver = Driver.getWebDriver();

    public void openPage() {
        driver.get(ConfigProperty.property.getProperty("emailUrl"));
    }

    public void loginMail(String emailName) {
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.xpath("//*[@class='ycptinput']")).sendKeys(emailName);
        driver.findElement(By.xpath("//*[@id='refreshbut']")).click();
    }

    public void refreshMail() {
        driver.findElement(By.xpath("//*[@id='refresh']")).click();
    }

    public void openConfirmLetter() {
        driver.switchTo().frame(driver.findElement(By.id("ifinbox")));
        driver.findElement(By.xpath("//*[@class='bodyinbox yscrollbar']//div[contains(text(), 'One more click to confirm your account')]")).click();
        driver.switchTo().defaultContent();
    }

    public void clickConfirmButton() {
        driver.switchTo().frame(driver.findElement(By.id("ifmail")));
        driver.findElement(By.xpath("//a[contains(text(), 'Confirm')]")).click();
        driver.switchTo().defaultContent();
    }
    public void openVerifyLetter() {
        driver.switchTo().frame(driver.findElement(By.id("ifinbox")));
        driver.findElement(By.xpath("//*[@class='mctn']//div[contains(text(), 'Your verification link')]")).click();
        driver.switchTo().defaultContent();
    }

    public void clickVerifyButton() {
        driver.switchTo().frame(driver.findElement(By.id("ifmail")));
        driver.findElement(By.xpath("//a[contains(text(), 'Verify me')]")).click();
        driver.switchTo().defaultContent();
    }

}
