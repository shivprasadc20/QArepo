package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Feature",
        glue={""},
        tags ="@Signup",
        monochrome = true,
        plugin = {"pretty", "html:target/cucumberReports/report.html"})
public class TestRunner {
}
