package homework.objects;

import homework.driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class MyActions {
    WebDriver driver = Driver.getWebDriver();
    Actions make = new Actions(driver);
    public void ctrlC(WebElement webElement) {

        make
                .doubleClick(webElement)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c").clickAndHold()
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
    }
    public void ctrlV(WebElement webElement) {
        make
                .click(webElement)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v").clickAndHold()
                .keyUp(Keys.LEFT_CONTROL)
                .keyDown(Keys.ENTER)
                .build()
                .perform();
    }
    public void moveElem(WebElement webElement) {
        make.moveToElement(webElement);
        make.perform();
    }
    public void openTab() {
        ((JavascriptExecutor) driver).executeScript("window.open();");
    }

}