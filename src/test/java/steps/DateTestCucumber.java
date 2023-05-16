package steps;

import pagesObjects.DateTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class DateTestCucumber {
    private final DateTest dateTest = new DateTest();

    @Given("I open booking page")
    public void iOpenPage() {
        dateTest.openPage();

    }

    @When("I close pop-up")
    public void iClosePopUp() {
        dateTest.closePopUp();

    }

    @When("I enter city")
    public void iEnterCityName() {
        dateTest.enterCityName();

    }

    @When("I click city")
    public void iSelectCity() {
        dateTest.selectCity();

    }

    @When("I select first date")
    public void iSelectFirstDate() {
        dateTest.selectFirstDate();

    }

    @When("I select last date")
    public void iSelectLastDate() {
        dateTest.selectLastDate();

    }

    @When("I click confirm button")
    public void iClickConfirmButtonButton() {
        dateTest.clickConfirmButtonButton();

    }

    @When("I click search button")
    public void iClickSearchButton() {
        dateTest.clickSearchButton();

    }

    @Then("I check tour availability")
    public void iCheckThatCityToursIsFound() {
        dateTest.checkThatCityToursIsFound();
    }
}