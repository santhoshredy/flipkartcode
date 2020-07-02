package com.flipkart.qa.pages;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;

import com.flipkart.qa.base.Basepage;
import com.flipkart.qa.resources.ExcelDataConfig;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage  extends Basepage{
	public LoginPage(AndroidDriver<MobileElement> driver) {  //(IOSDriver driver)    (WebDriver driver)
		super(driver);
	}
	
	@AndroidFindBy(xpath="//*[contains(@class,'android.widget.ImageButton' and @content-desc,'Open Drawer')]")
	private MobileElement menu_link_tologin;
	
	@AndroidFindBy(xpath="//*[contains(@resource-id,'com.flipkart.android:id/phone_input')]")  //@iOSBy(xpath="")     @FindBy 
	private MobileElement enter_phone_no;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Send OTP')]")
	private MobileElement send_otp;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Password')]")
	private MobileElement enter_password;
	
	@AndroidFindBy(xpath="//*[contains(@text,'continue')]")
	private MobileElement continue_to_login;
	
	
	
	@AndroidFindBy(xpath="//*[contains(@class,'android.widget.ImageButton' and @content-desc,'Back Button')]")
	private MobileElement back_to_homepage;
	

	
	public HomePage clickOnViews() throws Exception{
		
		ExcelDataConfig excel=new ExcelDataConfig("./src/main/resources/Book2.xlsx");
		
		Set<String> con = driver.getContextHandles();
		for(String c : con)
		{
			System.out.println("Available Context : "+c);
			if(c.contains("webview"))
			{
				driver.context(c);
				break;
			}
		}
		
		menu_link_tologin.click();
		
		AndroidElement myaccount=(AndroidElement) driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"My Account\").instance(2))");
		myaccount.click();
		
		
		enter_phone_no.sendKeys(excel.getData("Sheet1", 1, 0));          //"8888856655"
		send_otp.click();
		
		enter_password.sendKeys(excel.getData("Sheet1", 1, 1));        //"santhu"
		continue_to_login.click();
		
		
		rotateScreen();
		
		back_to_homepage.click();
		return new HomePage(driver);
	}
	
	
	public void rotateScreen() throws Exception{
	//screen rotation method
	
	ScreenOrientation curr=driver.getOrientation();
	driver.rotate(curr.LANDSCAPE);
	Thread.sleep(2000);
	screenshotMethod();
	driver.rotate(curr.PORTRAIT);
	
	}
	public void screenshotMethod() throws IOException {
		//for screen shot
		File f1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f1,new File("screenshot.jpg"));
	}
	
	
}
