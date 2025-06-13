package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    private Driver() {
        // There are several ways to prevent creating an object from this class.
        // In Page Object Model (POM) design, the Singleton Pattern is commonly used.
        // Singleton Pattern means making the constructor visible
        // and setting its access modifier to private to block object creation.
    }

    public static WebDriver driver;

    public static WebDriver getDriver() {

        String browserToUse = ConfigReader.getProperty("browser");
        // Get the browser type from the configuration.properties file

        // Optional safety fallback in case the config file doesn't have a browser value
        if (browserToUse == null) {
            browserToUse = "chrome";
        }

        if (driver == null) {

            switch (browserToUse) {
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                default:
                    driver = new ChromeDriver();
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }
}