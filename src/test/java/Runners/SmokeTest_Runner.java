package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (features = "src/test/resources", glue = "StepDefn",
                monochrome = true,
                tags = "@SmokeTest",
                //"@RegressionTest"
                //"@SmokeTest and @RegressionTest"
                //"@SmokeTest or @RegressionTest"
                //"not @RegressionTest"
                plugin = { // makes the reports look pretty with colour coding
                        "html:Reports/Sample_test_reports/SmoketestHtml.html", //generates HTML report
                        "json:Reports/Sample_test_reports/Smoketestjson.json"} // generates json report
        )
public class SmokeTest_Runner extends AbstractTestNGCucumberTests {
}
