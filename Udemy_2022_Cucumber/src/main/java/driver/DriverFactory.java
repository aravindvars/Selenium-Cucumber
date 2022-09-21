package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    public static WebDriver getDriver(){
        if (webDriver.get()==null)
        {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    private static WebDriver createDriver(){

        WebDriver driver = null;

        switch(getBrowserTpe())
        {
            case "chrome" ->
            {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/driver/drivers/chromedriver");
                ChromeOptions chromeoptions = new ChromeOptions();
                chromeoptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeoptions);

                break;
            }
            case "firefox"->
            {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/java/driver/drivers/geckodriver");
                FirefoxOptions firefoxoptions = new FirefoxOptions();
                firefoxoptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(firefoxoptions);
                driver.manage().window().maximize();
                break;
            }
        }
        driver.manage().window().maximize();
        return driver;
    }
    private static  String getBrowserTpe() {
        String browserType = null;
        try
        {
            Properties properties = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/properties/config.properties");
            properties.load(file);
            browserType = properties.getProperty("browser").toLowerCase().trim();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        return browserType;
    }
    public static void cleanupDriver()
    {
        webDriver.get().quit();
        webDriver.remove();
    }
}
