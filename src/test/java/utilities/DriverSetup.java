package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverSetup {
    //make it private
    private static String browser_name = System.getProperty("browser","Chrome");
    //set ThreadLocal
    private static final ThreadLocal<WebDriver> LOCAL_DRIVER = new ThreadLocal<>();

    // getter
    public static WebDriver getDriver(){
        return LOCAL_DRIVER.get();
    }

    // setter
    public static void setDriver(WebDriver driver){
        DriverSetup.LOCAL_DRIVER.set(driver);
    }

    @BeforeMethod
    public void openBrowser(){
        WebDriver driver = getBrowser(browser_name);
        setDriver(driver);
    }
    @AfterMethod
    public void closeBrowser(){
        getDriver().quit();
    }

    public WebDriver getBrowser(String name){
        if (name.equalsIgnoreCase("firefox"))
            return new FirefoxDriver();
        else if (name.equalsIgnoreCase("chrome"))
            return new ChromeDriver();
        else if (name.equalsIgnoreCase("edge"))
            return new EdgeDriver();
        else{
            throw new RuntimeException("Browser is not currently available with the given name: "+name);
        }
    }
}
