package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.DriverSetup.getDriver;

public class BasePage {
    public WebElement getElement(By locator) {
        return getDriver().findElement(locator);
    }

    public void loadPage(String url) {
        getDriver().get(url);
    }

    public void clickOnElement(By locator) {
        getElement(locator).click();
    }

    public void writeOnElement(By locator, String text) {
        getElement(locator).sendKeys(text);
    }

    public String getAttributeValue(By locator, String attributeName) {
        return getElement(locator).getAttribute(attributeName);
    }

    public Boolean isVisible(By locator) {
        try {
            return getElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getElementText(By locator) {
        return getElement(locator).getText();
    }

    public void hoverOnElement(By locator) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getElement(locator)).build().perform();
    }

    public void waitForVisibility(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForClickAbility(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    public void scrollToElement(By locator) {
        WebElement element = getElement(locator);
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });",
                element
        );
    }

    public void selectByIndex(By locator, int index) {
        WebElement dropdownElement = getElement(locator);
        Select select = new Select(dropdownElement);
        select.selectByIndex(index);
    }

    public void selectByValue(By locator, String value) {
        WebElement dropdownElement = getElement(locator);
        Select select = new Select(dropdownElement);
        select.selectByValue(value);
    }

    public void selectDropdownByVisibleText(By dropdownLocator, String visibleText) {
        WebElement dropdown = getElement(dropdownLocator);
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }

}

