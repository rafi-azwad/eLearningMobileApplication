package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(tags ="@login or @exam",
        features = {
                "src/test/resources/Features/"
        },

        glue = {"ELearningStepDefinition"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty", "html:build/reports/eLearningFeature.html"
        })

@Test
public class AllTestRunner extends AbstractTestNGCucumberTests {


}


