package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
                features = "src/test/resources",
                glue = "StepDefn",
                monochrome = true,
                plugin =
                        {
                                "html:Reports/All_test_reports/AllTestReport.html",
                                "json:Reports/All_test_reports/AllTestReport.json"
                        }
        )

public class AllTestRunner extends AbstractTestNGCucumberTests {
}
