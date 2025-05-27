package pages;

import org.openqa.selenium.By;

public class AuthorPage extends BasePage{
    public By hoverAuthor = By.xpath("//span[contains(text(),'লেখক')]");
    public By clickAuthor = By.xpath("//a[contains(text(),'হুমায়ূন আহমেদ')]");
    public By filterOne = By.xpath("//label[contains(text(),'সমকালীন উপন্যাস')]");
    public By filterTwo = By.xpath("//label[@for='rok-filter-categoryIds-1321']");
    public By navNextPage = By.xpath("//div[@class='browse-page']//a[4]");
}
