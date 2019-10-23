package OrangeFeature;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\java\\Resources\\Features",tags="~@LoginFailed ,@login")
public class RunTest {
}
