package uk.co.test.cucumber.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/",glue = { "uk.co.test.cucumber.steps" }, tags = {"@version=customTestTag"})
public class CustomTestRunner {
}
