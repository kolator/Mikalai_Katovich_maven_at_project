package steps;

import io.cucumber.java.en.And;
import objects.BookingLogIn;
import objects.BookingPersonal;
import objects.BookingRegister;
import objects.MailPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import settings.ConfigProperty;

public class RegisterCucumber {
    private final BookingLogIn bookingLogIn = new BookingLogIn();
    private final BookingRegister bookingRegister = new BookingRegister();
    private final MailPage mailPage = new MailPage();
    private final BookingPersonal bookingPersonal = new BookingPersonal();
    public static final Logger LOGGER = Logger.getLogger(DateTestCucumber.class.getName());
    @Given("I register new email")
    public void registerNewEmail() {
        mailPage.openPage("emailUrl");
        mailPage.loginMail(ConfigProperty.property.getProperty("emailName"));
        LOGGER.debug("Open email page");
    }

    @When("I register new user on booking")
    public void registerNewUserOnBooking() {
        bookingRegister.openBookingPage("bookingRegisterUrl");
        bookingRegister.enterEmailInSignIn();
        bookingRegister.submitEnterEmail();
        bookingRegister.enterNewPassword();
        bookingRegister.confirmNewPassword();
        bookingRegister.submitEnterPassword();
        LOGGER.debug("Register new user on booking");
    }

    @And("I confirm email about registration")
    public void comfirmLetterFromBooking() throws InterruptedException {
        mailPage.openPage("emailUrl");
        mailPage.loginMail(ConfigProperty.property.getProperty("emailName"));
        Thread.sleep(5000);
        mailPage.refreshMail();
        mailPage.openConfirmLetter();
        Thread.sleep(4000);
        mailPage.clickConfirmButton();
        LOGGER.debug("Confirm letter from booking");
    }

    @And("I login in to booking account")
    public void loginInToBookingAccount() {
        bookingLogIn.openSignInPage("bookingSignInUrl");
        bookingRegister.enterEmailInSignIn();
        bookingRegister.submitEnterEmail();
        bookingLogIn.enterVerifiedPassword("password");
        bookingRegister.submitEnterPassword();
        LOGGER.debug("Login to booking account");
    }

    @And("I verify booking account")
    public void verifyBookingAccount() {
        mailPage.openPage("emailUrl");
        mailPage.loginMail(ConfigProperty.property.getProperty("emailName"));
        mailPage.openVerifyLetter();
        mailPage.clickVerifyButton();
        LOGGER.debug("Verify booking account");
    }

    @Then("I passed test")
    public void checkVerifyAccount() {
        bookingPersonal.openPersonalPage();
        Assert.assertTrue("На странице отсутствует verified иконка", bookingPersonal.checkVerifyIcon());
        LOGGER.debug("Check that account is verified");
    }
}