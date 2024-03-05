package stepDefination;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks  {
	
	 public static WebDriver driver;
	 static Properties p;
	
	
	@BeforeAll
	 public static void driverSetup() throws IOException 
	{
		
	    	driver=new ChromeDriver();
	    	driver.manage().deleteAllCookies(); 
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    	    	
	    	p=Factory.BaseClass.getProperties();
	    	driver.get(p.getProperty("appURL"));
	    	driver.manage().window().maximize();
	    		
		}	

	@AfterStep
    public void addScreenshot(Scenario scenario) {
    	// this is for cucumber junit report
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
    }
	
	
	    
    @AfterAll
    public static void tearDown() {
        		
       driver.quit();
       
    }
	
	
	
	
}
	
	
	
	
	
	
	

