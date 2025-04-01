package org.abc.stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.abc.driverFactory.driverFactory;
import org.abc.utils.ConfigReader;
import org.abc.utils.LogUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class hooks {
    private static ConfigReader configReader;
    @Before
    public void setUp(Scenario scenario) {
        String environement = System.getProperty("environment","dev");
        configReader = new ConfigReader("src/test/resources/config-"+environement+".properties");
        LogUtil.info("Starting scenario: " + scenario.getName());
        driverFactory.setUpDriver();
    }

    public static String getConfigValue(String key) {
        return configReader.getProperty(key);
    }


    // After Hook to quit the WebDriver and capture screenshot for failed tests
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            LogUtil.error("Scenario failed: " + scenario.getName());
            // Capture screenshot if the scenario fails
            try {
                final byte[] screenshot = ((TakesScreenshot) driverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            LogUtil.info("Scenario passed: " + scenario.getName());
        }
        // End the ExtentTest for the current scenario
        driverFactory.tearDown();
    }
}
