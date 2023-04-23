package day23042023Cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CucumberSteps {
    @Given("I open site number one")
    public void iOpenSiteNumberOne() {
        System.out.println("Site opened");
    }

    @When("I fill {string} it the form")
    public void iFillItTheForm(String text) {
        System.out.println("Print '%s' string" + text);
    }

    @Then("I need to see something")
    public void iNeedToSeeSomething() {
        Assert.assertTrue(true);
        System.out.println("Complete");
    }

    @When("I fill {string} in the form")
    public void iFillInTheForm(String arg0) {
        System.out.println("Complete" + arg0);
    }
}

