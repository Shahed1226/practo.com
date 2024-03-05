package ExtendReportTNG;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

import io.cucumber.java.Scenario;

public class MyListener implements ITestListener{

	WebDriver driver;
	public void onTestStart(ITestResult result) 
	{
		
	   System.out.println("on test start....");
	}
		
	public void onTestSuccess(ITestResult result, Scenario scenario) 
	{

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		File screenShotName = new File(System.getProperty("user.dir")+"\\Screenshot\\"+result.getName()+".png");
		try {
			FileUtils.copyFile(scrFile, screenShotName);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("on test failure.........");
	}
	
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("on test skipped.........");
	}
	
	public void onFinish(ITestContext context) 
	{
		System.out.println("on test finish.........");
	}
	
	
	
	
	
}
