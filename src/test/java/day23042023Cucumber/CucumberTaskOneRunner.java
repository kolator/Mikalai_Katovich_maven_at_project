package day23042023Cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "summary"},
        glue = {"day23042023Cucumber"},
        features = {"src/test/resources/features/one.feature", "src/test/resources/features/two.feature"}
//        tags = "@QA"
)
public class CucumberTaskOneRunner {

}
