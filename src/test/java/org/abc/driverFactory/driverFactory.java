package org.abc.driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class driverFactory {
    private static driverFactory driverFactory;

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static WebDriverWait wait;
    public final static int TIMEOUT = 10;

    private driverFactory() {
        String browser = System.getProperty("browser", "chrome"); // Default to chrome if no browser is provided

        // Initialize WebDriver based on the browser choice
        switch (browser.toLowerCase()) {
            case "firefox":
                driver.set(new FirefoxDriver());
                break;
            case "edge":
                driver.set(new EdgeDriver());
                break;
            case "chrome":
            default:
                ChromeOptions options = new ChromeOptions();
                options.setAcceptInsecureCerts(true);
                driver.set(new ChromeDriver(options));
                break;
        }
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setUpDriver() {

        if (driverFactory==null) {

            driverFactory = new driverFactory();
        }
    }

    public static void tearDown() {

        if(driver!=null) {
            driver.get().close();
            driver.get().quit();
        }
        driverFactory =null;
    }
}
