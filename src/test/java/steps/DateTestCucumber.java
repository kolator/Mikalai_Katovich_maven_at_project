package steps;

import io.cucumber.java.en.And;
import objects.BookingLogIn;
import objects.DateTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;


public class DateTestCucumber {
    private final DateTest dateTest = new DateTest();
    public static final Logger LOGGER = Logger.getLogger(DateTestCucumber.class.getName());

    @Given("I open booking page")
    public void iOpenPage() {
        dateTest.openPage("bookingUrl");
        LOGGER.debug("Open booking page");
    }

    @When("I close pop-up")
    public void iClosePopUp() {
        dateTest.closePopUp();
        LOGGER.debug("Close pop up on main page");
    }

    @And("I enter city")
    public void iEnterCityName() {
        dateTest.enterCityName();
        LOGGER.debug("Enter city name");
    }

    @And("I click city")
    public void iSelectCity() {
        dateTest.selectCity();
        LOGGER.debug("Select city in dropdown");
    }

    @And("I select first date")
    public void iSelectFirstDate() {
        dateTest.selectFirstDate();
        LOGGER.debug("Select first date");
    }

    @And("I select last date")
    public void iSelectLastDate() {
        dateTest.selectLastDate();
        LOGGER.debug("Select last date");
    }

    @And("I click confirm button")
    public void iClickConfirmButtonButton() {
        dateTest.clickConfirmButtonButton();
        LOGGER.debug("Click confirm button");
    }

    @And("I click search button")
    public void iClickSearchButton() {
        dateTest.clickSearchButton();
        LOGGER.debug("Click search button");
    }

    @Then("I check tour availability")
    public void iCheckThatCityToursIsFound() {
        dateTest.checkThatCityToursIsFound();
        LOGGER.debug("Check that city tours is found");
    }
}