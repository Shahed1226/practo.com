package stepDefination;

import java.io.IOException;

import java.time.Duration;

import org.apache.hc.client5.http.nio.ManagedAsyncClientConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mongodb.diagnostics.logging.Logger;

import Factory.BaseClass;
import PageObjectModel.Page1;
import PageObjectModel.Page2;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsOfCucumber extends BaseClass {

	
	public org.apache.logging.log4j.Logger logger=BaseClass.getLogger();
	public WebDriver driver=Hooks.driver;
	Page1 p1;
	Page2 p2;
	
	@Given("the user navigates to Practo site homepage")
	public void the_user_navigates_to_practo_site_homepage() throws IOException 
	{
		WebElement practoLogo = driver.findElement(By.xpath("(//i[@class='practo_logo_new'])[1]"));
		 p1=new Page1(driver);
		System.out.println( practoLogo.isDisplayed());
		System.out.println("Practo logo is displayed");
		org.apache.logging.log4j.Logger logger=BaseClass.getLogger();
		logger.info("for try");
	}

	@When("select the city and search speciality")
	public void select_the_city_and_search_speciality() throws InterruptedException, IOException 
	{
		 p1=new Page1(driver);
			p1.SetLocation();
			p1.EnterDoctors();
			logger.info("City and Specialist are selected");
	}

	@When("Apply filters for Patient stories,Experiences,fees,availability and any one sorting")
	public void apply_filters_for_patient_stories_experiences_fees_availability_and_any_one_sorting() throws InterruptedException 
	{
		p1=new Page1(driver);
		p1.SelectGender();
		p1.SelectPatientStories();
		p1.SetExperience();
		p1.AllFilters();
		p1.SortBy(); 
		logger.info("Filters applied which contains Doctor gender, experience, fees etc.");
	}

	@Then("display the five doctor details")
	public void display_the_five_doctor_details() throws IOException 
	{
		
		System.out.println("<--------------Below are the Doctors Name---------------->");
		p1=new Page1(driver);
		p1.get_drNames();
		logger.info("Printed top 5 doctors name with their details in console and excel");
	}

	
	
	
	
	@When("Click on surgeries button and Store all the Surgeries in list and Display it")
	public void click_on_surgeries_button_and_store_all_the_surgeries_in_list_and_display_it() throws IOException 
	{
		System.out.println("<--------------Below are the surgeries---------------->");
		p1=new Page1(driver);
		p1.get_surgeries();
		logger.info("FAll the available surgeries which are displyed on the screen are printed  ");
	}

	
	
	
	
	
	@When("Click on For corporate and select the Health and Wellness plan option")
	public void click_on_for_corporate_and_select_the_health_and_wellness_plan_option() throws InterruptedException 
	{
		p1=new Page1(driver);
		p1.SelectForCorporate();
		Thread.sleep(3000);
		logger.info("Directed to Health and Wellness page ");
	}

	@When("user fills all required fields")
	public void user_fills_all_required_fields() throws InterruptedException, IOException 
	{
	
	Page2 p2 =new Page2(driver);
		p2.EnterDetails();
	
		logger.info("All the details except email is filled ");
	
	}

	@When("entering invalid email")
	public void entering_invalid_email() throws InterruptedException, IOException 
	{
		p2=new Page2(driver);
		p2.invalidmailmethod();
		logger.info("Invalid email is entered");
	}

	@Then("Validate demo button is disabled")
	public void validate_demo_button_is_disabled() 
	{
		System.out.println("<--------------Validating the disabled button---------------->");
		p2=new Page2(driver);
		p2.demoButtonmethod();
		logger.info("Validating the demo button(should be disable)");
	}

	@When("user enters valid email")
	public void user_enters_valid_email() throws InterruptedException, IOException 
	{
		p2=new Page2(driver);
		p2.validmail();
		logger.info("Entering the valid email");
	}

	@Then("Validate demo button is enabled")
	public void validate_demo_button_is_enabled() {
		System.out.println("<--------------Validating the enabled button---------------->");
		p2=new Page2(driver);
		p2.demobuttonenableMethod();
		logger.info("Validating the demo button(should be enable)");
	}

	@When("user click the Demo button")
	public void user_click_the_demo_button() throws InterruptedException {
		p2=new Page2(driver);
		p2.clickDemobutton();
	
	}

	@Then("user is able to see the Thank You message and Validate it")
	public void user_is_able_to_see_the_thank_you_message_and_validate_it() throws InterruptedException 
	{
		Thread.sleep(8000);
		System.out.println("<--------------Validating the Thank you button---------------->");
		p2=new Page2(driver);
		p2.Msg();
		logger.info("Thank you message is displayed and project ended.");
	}

	
}
