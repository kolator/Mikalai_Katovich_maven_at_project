package tests.junit;

import pagesObjects.DateTest;
import org.junit.Test;


public class DateTestSteps {
    private final DateTest dateTest = new DateTest();
    @Test
    public void DateTestSteps() {
        dateTest.openPage();
        dateTest.closePopUp();
        dateTest.enterCityName();
        dateTest.selectCity();
        dateTest.selectFirstDate();
        dateTest.selectLastDate();
        dateTest.clickConfirmButtonButton();
        dateTest.clickSearchButton();
        dateTest.checkThatCityToursIsFound();
    }
}
