package PageObjectModel;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Factory.BaseClass;
import io.cucumber.java.Scenario;


public class TestNgExecution extends BaseClass {

	BaseClass bs =new BaseClass();
	public static WebDriver driver;
	
	Page1 p1;
	Page2 page2;
	static Properties p;
	@BeforeSuite
	 public void driverSetup() throws IOException 
	{
		 //driver = new ChromeDriver();
         driver =BaseClass.initilizeBrowser();
		 p=Factory.BaseClass.getProperties();
		 driver.get(p.getProperty("appURL"));
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
	    		
		}	

	@Test (priority = 2)
public void Page1() throws InterruptedException, IOException {
		BaseClass bs =new BaseClass();
	Page1 p1 =new Page1(driver);
	Thread.sleep(5000);
    p1.pageLogo();
	p1.SetLocation();
	bs.takeSnapshot(driver, "Location");
	p1.EnterDoctors();
	p1.SelectGender();
	p1.SelectPatientStories();
	p1.SetExperience();
	p1.AllFilters();
	p1.SortBy();
	p1.get_drNames();
	bs.takeSnapshot(driver, "Doctor Names");
	p1.get_surgeries();
	bs.takeSnapshot(driver, "Surgeries");
	p1.SelectForCorporate();
	
}	
	@Test (priority = 3)
	public void Page2() throws InterruptedException, IOException {
		BaseClass bs =new BaseClass();
		Page2 p2 =new Page2(driver);
		p2.EnterDetails();
		p2.invalidmailmethod();
		bs.takeSnapshot(driver, "invalidEmail ss");
		p2.demoButtonmethod();
		p2.validmail();
		bs.takeSnapshot(driver, "ValidMail");
		//Thread.sleep(9000);
		p2.demobuttonenableMethod();
		p2.clickDemobutton();
		p2.Msg();
		bs.takeSnapshot(driver, "Thankyou msg ss");
		
	}
	  @AfterSuite
	   public void tearDown() {
	       		
	      driver.quit();
	      
	   }
	
	
	
}
