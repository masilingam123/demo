package runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/feature",
		glue={"stepDefinition"}, plugin= {"pretty","json:target/cucumber.json"
				//,"html:target/cucumber.html"
				}, dryRun=false,
		
		//tags ="@rr",
		monochrome = false
		)

public class Testrunner {

}
