package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    public String url = "https://www.rokomari.com/";

    public void  loadHomePage(){
        loadPage(url);
    }

    public By signUpBtn = By.xpath("/html/body/div[1]/div[2]/div/div[2]");
    public By logoutBtn = By.xpath("//button[@class='navigation_menuItem__yDz2d js--logout-button']");
    public By navBtn = By.xpath("//button[@class='navigation_userContainer__FW8TZ']");
}
