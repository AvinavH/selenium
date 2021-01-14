package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "src/test/java/features",
		glue="stepDefinitions", 
		//tags="@RegressionTest or @SmokeTest or @MobileTest"
		tags="@PortalTest",monochrome=true,strict=true,
		plugin={"pretty","html:target/cucumber.html","json:target/cucumber.json","junit:target/cucumber.xml"}
		)
public class testRunner1 {

}
