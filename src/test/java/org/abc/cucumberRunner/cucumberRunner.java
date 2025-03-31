package org.abc.cucumberRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.abc.utils.RetryExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Execution(ExecutionMode.CONCURRENT)
@CucumberOptions(
        features = "src/test/resources/features", // Path to your feature files
        glue = {"org.abc.stepdefinition"},  // Package with your step definitions
        plugin = {"pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},// Reporting plugins
        monochrome = true,
        tags = "@regression"// Fail the build if there are undefined or pending steps
)
public class cucumberRunner {
}
