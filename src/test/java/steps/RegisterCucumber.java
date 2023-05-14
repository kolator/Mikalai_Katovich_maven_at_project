package steps;

import pagesObjects.BookingLogIn;
import pagesObjects.BookingPersonal;
import pagesObjects.BookingRegister;
import pagesObjects.MailPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import settings.ConfigProperty;

public class RegisterCucumber {
    private final BookingLogIn bookingLogIn = new BookingLogIn();
    private final BookingRegister bookingRegister = new BookingRegister();
    private final MailPage mailPage = new MailPage();
    private final BookingPersonal bookingPersonal = new BookingPersonal();
    @Given("I register new email")
    public void registerNewEmail() {
        mailPage.openPage();
        mailPage.loginMail(ConfigProperty.property.getProperty("emailName"));

    }
    @When("I register new user on booking")
    public void registerNewUserOnBooking() {
        bookingRegister.openBookingPage();
        bookingRegister.enterEmailInSignIn();
        bookingRegister.submitEnterEmail();
        bookingRegister.enterNewPassword();
        bookingRegister.confirmNewPassword();
        bookingRegister.submitEnterPassword();

    }
    @When("I confirm email about registration")
    public void comfirmLetterFromBooking() throws InterruptedException {
        mailPage.openPage();
        mailPage.loginMail(ConfigProperty.property.getProperty("emailName"));
        Thread.sleep(5000);
        mailPage.refreshMail();
        mailPage.openConfirmLetter();
        Thread.sleep(4000);
        mailPage.clickConfirmButton();
    }
    @When("I login in to booking account")
    public void loginInToBookingAccount() {
        bookingLogIn.openSignInPage();
        bookingRegister.enterEmailInSignIn();
        bookingRegister.submitEnterEmail();
        bookingLogIn.enterVerifiedPassword();
        bookingRegister.submitEnterPassword();

    }
    @When("I verify booking account")
    public void verifyBookingAccount() {
        mailPage.openPage();
        mailPage.loginMail(ConfigProperty.property.getProperty("emailName"));
        mailPage.openVerifyLetter();
        mailPage.clickVerifyButton();
    }
    @Then("I passed test")
    public void checkVerifyAccount() {
        bookingPersonal.openPersonalPage();
        Assert.assertTrue("На странице отсутствует verified иконка", bookingPersonal.checkVerifyIcon());

    }
}