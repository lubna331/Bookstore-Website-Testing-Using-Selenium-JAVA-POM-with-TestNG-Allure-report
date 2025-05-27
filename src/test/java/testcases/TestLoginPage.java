package testcases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;

import java.time.Duration;

public class TestLoginPage extends DriverSetup {
    private static final Logger log = LoggerFactory.getLogger(TestLoginPage.class);
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void setup_class(){
        homePage.loadHomePage();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        homePage.clickOnElement(homePage.popUpBtn);
        loginPage.refreshPage();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.refreshPage();
        homePage.clickOnElement(homePage.signUpBtn);
    }
    @Test
    public void signupWithGoogle() throws InterruptedException {
        Assert.assertTrue(loginPage.isVisible(loginPage.googleBtn));
        loginPage.clickOnElement(loginPage.googleBtn);
        loginPage.writeOnElement(loginPage.email_input, loginPage.user_email);
        loginPage.clickOnElement(loginPage.nextBtn);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.writeOnElement(loginPage.pass_input, loginPage.user_pass);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

        loginPage.waitForClickAbility(loginPage.nextBtn, 10);
        int attempts = 0;
        while (attempts < 2) {
            try {
                loginPage.waitForClickAbility(loginPage.nextBtn, 10);
                loginPage.clickOnElement(loginPage.nextBtn);
                break;
            } catch (Exception e) {
                attempts++;
//                Thread.sleep(1000);
            }
        }
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        loginPage.refreshPage();
//        Assert.assertTrue(homePage.isVisible(homePage.navBtn));

        homePage.hoverOnElement(homePage.navBtn);
        Thread.sleep(8000);
    }
}
