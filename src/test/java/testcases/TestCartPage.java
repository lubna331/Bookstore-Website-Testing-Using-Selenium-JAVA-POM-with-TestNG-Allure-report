package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;

import java.time.Duration;

public class TestCartPage extends DriverSetup {
    CartPage cartPage = new CartPage();
    HomePage homePage = new HomePage();
    @BeforeMethod
    public void loginFirst() throws InterruptedException {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        TestAuthorPage testAuthorPage = new TestAuthorPage();

        // Load home page
        homePage.loadHomePage();
        getDriver().manage().window().maximize();
        cartPage.refreshPage();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        cartPage.refreshPage();
        // Click sign up to open login options
        homePage.clickOnElement(homePage.signUpBtn);

        // Perform login using the reusable method in LoginPage
        loginPage.loginWithGoogleFlow();

        // select author and book using authorPage
        testAuthorPage.testHover();
    }

    @Test
    public void setCartPage() throws InterruptedException {
        cartPage.scrollToElement(cartPage.selectBook);

        cartPage.clickOnElement(cartPage.selectBook);

        // Switch to new tab
        String originalWindow = getDriver().getWindowHandle();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(driver -> driver.getWindowHandles().size() > 1);

        for (String windowHandle : getDriver().getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        By addToCart = By.xpath("//span[text()='Add to Cart']/parent::button");
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(addToCart));
        cartPage.clickOnElement(cartPage.addToCart);

        By goToCart = By.xpath("//a[@class='navigation_cartContainer__9oZWv']");
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(goToCart));
        cartPage.clickOnElement(cartPage.goToCart);

        By proceedToCheckout = By.xpath("//span[normalize-space()='Proceed to Checkout']");
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(proceedToCheckout));
        cartPage.clickOnElement(cartPage.proceedToCheckout);
        Thread.sleep(3000);

        // shipping
//        cartPage.writeOnElement(cartPage.userName, cartPage.name);
        cartPage.writeOnElement(cartPage.userPhone, cartPage.phone);
        cartPage.clickOnElement(cartPage.userCity);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        cartPage.selectDropdownByVisibleText(cartPage.userCity,"ঢাকা");

        cartPage.selectByValue(cartPage.userArea, "13");
        cartPage.writeOnElement(cartPage.userAddress, cartPage.address);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        cartPage.clickOnElement(cartPage.goToHomePage);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //logout
        cartPage.refreshPage();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        cartPage.refreshPage();
        homePage.hoverOnElement(homePage.navBtn);
        Thread.sleep(2000);
        homePage.clickOnElement(homePage.logoutBtn);
        Thread.sleep(2000);
    }
}
