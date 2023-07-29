package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(  //path of feature file
           features = "/SpicejetAutomation/src/test/java/SignUp.feature",
           //path of step definition file
           glue = "stepDefination")
public class TestRunner
{
	
}
  