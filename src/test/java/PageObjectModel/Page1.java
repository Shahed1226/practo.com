package PageObjectModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import excelutils.writedata;



public class Page1  extends Basepage{

	static Properties p;
	List<String> docs=new ArrayList<String>();
	List<String> surgeries1=new ArrayList<String>();
	Page1 p1;
	
	public Page1(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="(//i[@class='practo_logo_new'])[1]")  WebElement practoLogo;
	@FindBy (xpath="//*[@placeholder='Search location']") WebElement SetLocation;
    @FindBy (xpath="//*[text()='Use my location']") WebElement Location;
    @FindBy (xpath="//*[@data-qa-id='omni-suggestion-main'][text()='Pune']") WebElement Select_pune;
    
	@FindBy (xpath="//*[@placeholder='Search doctors, clinics, hospitals, etc.']") WebElement Search_Doctors;
	@FindBy (xpath="//*[text()='Cardiologist']") WebElement Select_Cardiologist;
	
	@FindBy (xpath="//*[@data-qa-id='doctor_gender_section']") WebElement Gender;
	@FindBy (xpath="//*[@aria-label='Male Doctor']") WebElement Gen_Male;
	
	@FindBy (xpath="//*[@data-qa-id='doctor_review_count_section']") WebElement Patient_Stories;
	@FindBy (xpath="//*[text()='20+ Patient Stories']") WebElement Select_PS;
	
	@FindBy (xpath="//*[@data-qa-id='years_of_experience_section']") WebElement Select_Drp_Exp;
	@FindBy (xpath="//*[text()='10+ Years of experience']") WebElement Select_Exp;
	
	@FindBy (xpath="//*[@data-qa-id='all_filters_icon']") WebElement Click_AllFilter;
	@FindBy (xpath="//*[text()='Above ₹500']") WebElement Fees;
	@FindBy (xpath="//*[text()='Available in next 7 days']") WebElement Availability;
	
	@FindBy (xpath="//*[@data-qa-id='sort_by_selected']") WebElement Sortby;
	@FindBy (xpath="//*[text()='Experience - High to Low']") WebElement Select_sort;
	
	@FindBy (xpath="//*[@class='doctor-name']") List<WebElement> drnames;
	@FindBy (xpath="//div[@data-qa-id='doctor_experience']") List<WebElement> drExperience;
	@FindBy (xpath="//div[@class='uv2-spacer--sm-top']") List<WebElement> OtherDetails;
	@FindBy (xpath="//*[text()='Surgeries']") WebElement surgeries_btn;
	@FindBy (xpath="//*[@class='mt-12px AilmentItem-module_itemText__XvCHL']") List<WebElement> surgeries;
	
	@FindBy (xpath="//*[text()='For Corporates']") WebElement ForCprporate;
	@FindBy (xpath="//*[text()='Health & Wellness Plans']") WebElement SelectHWP;
	
	
	
	public void pageLogo() {
		practoLogo.isDisplayed();
		System.out.println("Practo logo is displayed");
	}
	
	

	public void SetLocation() throws IOException {
		SetLocation.click();
		Actions actions = new Actions(driver);
		actions.doubleClick(SetLocation).perform();	
		p=Factory.BaseClass.getProperties();
		String location =p.getProperty("city");
		
		SetLocation.sendKeys(location);
		Select_pune.click();
	}
	
	public void EnterDoctors() throws InterruptedException, IOException {
		Thread.sleep(2000);
		p=Factory.BaseClass.getProperties();
		String special =p.getProperty("specialist");
		Search_Doctors.sendKeys(special);
		Select_Cardiologist.click();
		System.out.println("Enter the Details Successfully...");
	}
	public void SelectGender() throws InterruptedException {
		Thread.sleep(2000);
		Gender.click();
		Gen_Male.click();
		Thread.sleep(2000);
	}
	
	public void SelectPatientStories() throws InterruptedException 
	{
		Patient_Stories.click();
		Select_PS.click();
		Thread.sleep(2000);
	}
	public void SetExperience() throws InterruptedException 
	{
		Select_Drp_Exp.click();
		Select_Exp.click();
		//Thread.sleep(2000);
	}
	
	public void AllFilters() throws InterruptedException {
		Click_AllFilter.click();
		Fees.click();
		Availability.click();
		Thread.sleep(2000);
	}
		
	public void SortBy() throws InterruptedException 
	{
		Sortby.click();
		Select_sort.click();
		//Thread.sleep(2000);
	}
	
	public void get_drNames() throws IOException 
	{		
		System.out.println("Doctor's Details :");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,300)");
		
		for (int i=0; i<=4; i++) 
		{			
			String doctor =drnames.get(i).getText();
			System.out.println(drnames.get(i).getText()); 
			docs.add(doctor);
			
			String expe =drExperience.get(i).getText();
			System.out.println(drExperience.get(i).getText()); 
			docs.add(expe);		
			
			String othDetails = OtherDetails.get(i).getText();
			System.out.println(OtherDetails.get(i).getText());
			docs.add(othDetails);
			
		}
		writedata.writeExcel(docs);
	}
	
	public void get_surgeries() throws IOException 
	{		
		surgeries_btn.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,600)");
		
		System.out.println("Surgeries:");		
		for(WebElement nam : surgeries) 
		{
			String surr = nam.getText();
			
			System.out.println(nam.getText());
			surgeries1.add(surr);
		}
		writedata.writeSurgerExcel(surgeries1);
	}
	public void SelectForCorporate() {
		ForCprporate.click();
		SelectHWP.click();		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
