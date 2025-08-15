package aguilar.natalia.rover.acceptanceTest.resources;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= "src/test/resources/features",
        glue={"aguilar.natalia.rover.acceptanceTest"},
        plugin={"pretty", "html:target/cucumber-report.html"}
)
public class RunCucumberTest {
}
