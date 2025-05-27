package pages;

import org.openqa.selenium.By;

import java.security.PublicKey;

public class CartPage extends BasePage{
    public By selectBook = By.xpath("(//div[@class='books-wrapper__item'])[1]");
    public By addToCart = By.xpath("//span[text()='Add to Cart']/parent::button");
    public By goToCart = By.xpath("//a[@class='navigation_cartContainer__9oZWv']");
    public By proceedToCheckout = By.xpath("//span[normalize-space()='Proceed to Checkout']");

    // shipping
    public By userName = By.xpath("//div[@class='shipping-form-container']//input[@id='name']");
    public By userPhone = By.xpath("//fieldset[@class='group']//input[@id='phone']");
    public By userCity = By.xpath("//select[@id='js--city']");
    public By userArea = By.xpath("//select[@id='js--area']");
    public By userAddress = By.xpath("//fieldset[@class='mb-0']//textarea[@id='address']");

    public String name = "Harry Potter";
    public String phone = "01771009653";
    public String address = "Dhaka-1000,Banani,Road-11,House-05";
    // navigate to home page
    public By goToHomePage = By.xpath("//img[@alt='Rokomari.com']");
}
