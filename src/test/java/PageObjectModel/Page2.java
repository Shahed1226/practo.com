package PageObjectModel;


import java.io.IOException;
import java.util.Properties;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import stepDefination.*;

public class Page2 extends Basepage {

Properties p;
	
	public JavascriptExecutor jsExecutor=(JavascriptExecutor)Hooks.driver;
			
	Page2 p2;
	
	
	public Page2(WebDriver driver) 
	{
		super(driver);
	}


	@FindBy (xpath="(//input[@id='name'])[1]")
	WebElement Name;
	@FindBy (xpath="//input[@id='organizationName']")
	WebElement OrganizationName;
	@FindBy (xpath="//input[@id='contactNumber']") 
	WebElement ContactNumber;
	@FindBy (xpath="//input[@id='officialEmailId']") WebElement invalidEmailid;
	@FindBy (xpath="//select[@id='organizationSize']") WebElement Organizationsize;
	@FindBy(xpath = "//*[@id=\'organizationSize\']") WebElement org;
	@FindBy (xpath="//select[@id='interestedIn']") WebElement Interestedin;
	@FindBy (xpath="//*[@id=\"app\"]/div/div/header[2]/div[2]/div/form/button") WebElement demobtn;
	@FindBy (xpath="//*[@class='u-text--bold u-border-radius--8 text-white text-center u-m-t--5 u-p-v--12 width-per--100 u-cur--ptr bg-blue']") WebElement Button;
	
	@FindBy (xpath="//*[@class='u-text--bold text-alpha']") WebElement TYmsg;
	
	public void EnterDetails() throws InterruptedException, IOException {
		Thread.sleep(2000);
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//	    js.executeScript("window.scrollBy(0,200)");
		
		Name.click();
		p=Factory.BaseClass.getProperties();
		String n1 =p.getProperty("name");
		
		Name.sendKeys(n1);
		
		//Name.sendKeys("Green");
		
		OrganizationName.click();
		p=Factory.BaseClass.getProperties();
		String orgN2 =p.getProperty("organization");
		OrganizationName.sendKeys(orgN2);
		
		
		ContactNumber.click();
		p=Factory.BaseClass.getProperties();
		String mob =p.getProperty("phone");
		ContactNumber.sendKeys(mob);
		
		org.click();
		//Thread.sleep(3000);
		Select sl=new Select(Organizationsize);
		sl.selectByValue("501-1000");
		Interestedin.click();
		Select sl1=new Select(Interestedin);
		sl1.selectByIndex(1);
	}
		

	public void invalidmailmethod() throws InterruptedException, IOException {
		
		
		invalidEmailid.click();
		
		p=Factory.BaseClass.getProperties();
		String eemm =p.getProperty("invalidemail");
		invalidEmailid.sendKeys(eemm);
		
		//invalidEmailid.sendKeys("shahed@gmailcom");
		//Thread.sleep(3000);
		
	}  

	
	public void demoButtonmethod() 
	    {
		System.out.println("<-------After Entering Invalid Email------->");
		boolean ss=demobtn.isEnabled();
		System.out.println("Demo Button is Disabled: "+ss);
		}
	
	
	
	
	public void validmail() throws InterruptedException, IOException	{
		invalidEmailid.clear();
		
		p=Factory.BaseClass.getProperties();
		String eemai =p.getProperty("phone");
		invalidEmailid.sendKeys(eemai);
		
		
		invalidEmailid.sendKeys("shaikh@gmail.com");
		//Thread.sleep(10);
		

	}
	 public void demobuttonenableMethod() 
	    {
		 System.out.println("<-------After Entering Valid Email------->");
		 boolean ss=demobtn.isEnabled();
		System.out.println("Demo Button is Disabled: "+ss);
		
		}
	 public void clickDemobutton() throws InterruptedException 
	    {
		
		 Button.click();
		 Thread.sleep(5000);
		}
	
	public void Msg() {
		boolean msg= TYmsg.isDisplayed();
		System.out.println(" THANK YOU Message is Displayed: "+msg);
						
	}
	
	
}
