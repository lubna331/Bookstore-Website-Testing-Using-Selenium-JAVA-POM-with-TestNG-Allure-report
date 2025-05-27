package pages;

import org.openqa.selenium.By;

import java.time.Duration;

public class LoginPage extends BasePage{
    // signup using google
    public By googleBtn = By.xpath("//button[@class='btn btn-social-google']");
    public By email_input = By.xpath("//input[@id='identifierId']");
    public By pass_input = By.xpath("//input[@name='Passwd']");
    public By nextBtn = By.xpath("//span[normalize-space()='Next']");

    public By login_btn = By.xpath("//button[normalize-space()='Login']");

    public String user_email = "ENTER YOUR VALID EMAIL";
    public String user_pass = "ENTER YOUR VALID PASSWORD";

    public void loginWithGoogleFlow() throws InterruptedException {
            clickOnElement(googleBtn);
            waitForVisibility(email_input, 10);
            writeOnElement(email_input, user_email);
            clickOnElement(nextBtn);
            waitForVisibility(pass_input, 10);
            writeOnElement(pass_input, user_pass);

//            Thread.sleep(1000);
            // Wait for the next button to be clickable after entering password
            waitForClickAbility(nextBtn, 10);
            int attempts = 0;
            while (attempts < 2) {
                try {
                    waitForClickAbility(nextBtn, 10);
                    clickOnElement(nextBtn);
                    break;
                } catch (Exception e) {
                    attempts++;
                    Thread.sleep(1000);
                }
            }


//        clickOnElement(nextBtn);
    }
}
