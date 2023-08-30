package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
				dryRun=false,// used to skip if the name is failed to match
				features= {"src/test/java/feature/login.feature"},// to identify feature file which start ftom src
				glue= {"stepdef"},//identify the step definition java file
				monochrome= true //for report
		)
public class RunWindowsRunner extends AbstractTestNGCucumberTests{
	

}
