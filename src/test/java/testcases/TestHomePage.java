package testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.DriverSetup;

import java.time.Duration;

public class TestHomePage extends DriverSetup {
    HomePage homePage = new HomePage();

    @BeforeMethod
    public void loadHomePageTest(){
        homePage.loadHomePage();
    }
    @Test
    public void btnPresent(){
//        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        homePage.refreshPage();
        Assert.assertTrue(homePage.isVisible(homePage.signUpBtn));
    }
}
