package testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthorPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;

import java.time.Duration;

public class TestAuthorPage extends DriverSetup {
    AuthorPage authorPage = new AuthorPage();

    @BeforeMethod
    public void loginFirst() throws InterruptedException {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        TestLoginPage testLoginPage = new TestLoginPage();

        // Load home page
        homePage.loadHomePage();
        getDriver().manage().window().maximize();
        authorPage.refreshPage();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        authorPage.refreshPage();
        // Click sign up to open login options
        homePage.clickOnElement(homePage.signUpBtn);

        // Perform login using the reusable method in LoginPage
        loginPage.loginWithGoogleFlow();
//        testLoginPage.signupWithGoogle();
    }

    @Test
    public void testHover() throws InterruptedException {
        authorPage.hoverOnElement(authorPage.hoverAuthor);
        authorPage.clickOnElement(authorPage.clickAuthor);

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        authorPage.refreshPage();
        authorPage.scrollToElement(authorPage.filterOne);
        authorPage.waitForClickAbility(authorPage.filterOne, 10);
        authorPage.clickOnElement(authorPage.filterOne);
        authorPage.scrollToElement(authorPage.filterTwo);
        authorPage.waitForClickAbility(authorPage.filterOne, 10);
        authorPage.clickOnElement(authorPage.filterTwo);

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        authorPage.scrollToElement(authorPage.navNextPage);
        authorPage.waitForClickAbility(authorPage.navNextPage, 10);
        authorPage.clickOnElement(authorPage.navNextPage);
//        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        Thread.sleep(3000);
    }
}
