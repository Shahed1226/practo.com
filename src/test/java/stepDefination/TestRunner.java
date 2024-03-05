package stepDefination;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith (Cucumber.class)
@CucumberOptions (
		
		features = {"src\\test\\java\\FeatureFile.feature"},
		glue="stepDefination",
		plugin = {"pretty","html:CucumberReport/CucumberReportNormal.html"},
		
		dryRun=false,    // checks mapping between scenario steps and step definition methods
    monochrome=true,    // to avoid junk characters in output
	publish=true   // to publish report in cucumber server
			
	
	         //tags="@regression"
			//tags="@sanity and @regression,@positive" //Scenarios tagged with both @sanity and @regression
			//tags = "@sanity and @regression"
			
		 
		
		
		)


public class TestRunner
{	

}
