package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src_utils/cucumber", glue = "stepDefinitions.LogInStepDefinitions1", monochrome = true, plugin = "html:target/fblogin.html")
public class TestRunner extends AbstractTestNGCucumberTests {

}
