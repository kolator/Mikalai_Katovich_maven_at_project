package tests.testng;

import driver.Driver;
import objects.DateTest;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class DateTestSteps {
    private final DateTest dateTest = new DateTest();

    public static final Logger LOGGER = Logger.getLogger(tests.junit.DateTestSteps.class.getName());
    @Test
    public void DateTestSteps() {
        dateTest.openPage("bookingUrl");
        dateTest.closePopUp();
        dateTest.enterCityName();
        dateTest.selectCity();
        dateTest.selectFirstDate();
        dateTest.selectLastDate();
        dateTest.clickConfirmButtonButton();
        dateTest.clickSearchButton();
        dateTest.checkThatCityToursIsFound();
        LOGGER.debug("Check that tours is found");
    }
    @AfterTest
    public void close() {
        Driver.closeDriver();
        LOGGER.info("Test finished");
    }
}