package tests.testng;

import driver.Driver;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import objects.BookingLogIn;
import objects.BookingPersonal;
import objects.BookingRegister;
import objects.MailPage;
import org.junit.Assert;
import settings.ConfigProperty;

public class RegisterLogin {

    private final BookingLogIn bookingLogIn = new BookingLogIn();
    private final BookingRegister bookingRegister = new BookingRegister();
    private final MailPage mailPage = new MailPage();
    private final BookingPersonal bookingPersonal = new BookingPersonal();

    public static final Logger LOGGER = Logger.getLogger(RegisterLogin.class.getName());

    public RegisterLogin() {
    }

    @Test
    public void bookingTestRegister() throws InterruptedException {
        mailPage.openPage("emailUrl");
        mailPage.loginMail(ConfigProperty.property.getProperty("emailName"));
        bookingRegister.openBookingPage("bookingRegisterUrl");
        bookingRegister.enterEmailInSignIn();
        bookingRegister.submitEnterEmail();
        bookingRegister.enterNewPassword();
        bookingRegister.confirmNewPassword();
        bookingRegister.submitEnterPassword();
        mailPage.openPage("emailUrl");
        mailPage.loginMail(ConfigProperty.property.getProperty("emailName"));
        Thread.sleep(5000);
        mailPage.refreshMail();
        mailPage.openConfirmLetter();
        Thread.sleep(4000);
        mailPage.clickConfirmButton();
        bookingPersonal.closeActiveTab();
        bookingLogIn.openSignInPage("bookingSignInUrl");
        bookingRegister.enterEmailInSignIn();
        bookingRegister.submitEnterEmail();
        bookingLogIn.enterVerifiedPassword("password");
        bookingRegister.submitEnterPassword();
        mailPage.openPage("emailUrl");
        mailPage.loginMail(ConfigProperty.property.getProperty("emailName"));
        mailPage.openVerifyLetter();
        mailPage.clickVerifyButton();
        bookingPersonal.openPersonalPage();
        Assert.assertTrue("Иконка верифайд отсутствует", bookingPersonal.checkVerifyIcon());
        LOGGER.debug("Check that verify icon is present");
    }

    @AfterTest
    public void close() {
        Driver.close();
        Driver.quite();
        LOGGER.info("Test finished");
    }
}