package com.flipkart.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.flipkart.qa.base.Basepage;
import com.flipkart.qa.resources.ExcelDataConfig;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;

public class HomePage extends Basepage {

	public HomePage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")
	private MobileElement searchbox;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Apply')]")
	private MobileElement filter_apply;
	
	@AndroidFindBy(xpath="//*[contains(@text,'ADD TO CART')]")
	private MobileElement addtocart;
	
	@AndroidFindBy(xpath="//*[contains(@id,'com.flipkart.android:id/cart_bg_icon')]")
	private MobileElement click_on_cart;
	
	@AndroidFindBy(xpath="//*[contains(@id,'PLACE ORDER')]")
	private MobileElement proceed_to_buy;
	
    @AndroidFindBy(xpath="//*[contains(@id,'add new adress')]")
    private MobileElement add_new_adress;
    
	@AndroidFindBy(xpath="//*[@id=\"container\"]/div/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div[2]/label/div[2]/div/form/div/div[2]/div[1]/input")
	private MobileElement fullname;
	
	@AndroidFindBy(xpath="//*[@id=\"enterAddressPhoneNumber\"]")
	private MobileElement mobilenumber;
	
	@AndroidFindBy(xpath="//*[@id=\"enterAddressCity\"]")
	private MobileElement enter_city;
	
	@AndroidFindBy(xpath="//*[@id=\"enterAddressPostalCode\"]")
	private MobileElement enter_postalcode;
	
	@AndroidFindBy(xpath="//*[@id=\"address-select\"]/form/div/div/a/div")
	private MobileElement enter_adressline1;
	
	@AndroidFindBy(xpath="//*[@id=\"enterAddressLandmark\"]")
	private MobileElement enter_landmark;
	
	@AndroidFindBy(xpath="//*[@id=\"address-new\"]/div[1]/span/form/span/span/input")
	private MobileElement use_this_adress;
	
	@AndroidFindBy(xpath="//*[@id=\"address-select\"]/form/div/div/a/div")
	private MobileElement select_adress;
	
	@AndroidFindBy(xpath="//*[@id=\"changeQuantityFormId\"]/span/span/input")
	private MobileElement continue_tobuy;
	
	@AndroidFindBy(xpath="@AndroidFindBy(xpath=\"//*[@id=\\\"changeQuantityFormId\\\"]/span/span/input\")\r\n" + 
			"	private MobileElement continue_tobuy;")
	private MobileElement price_of_item;
	
	
	
	
	public void clickOnAutocomplete() throws InterruptedException{
		
		ExcelDataConfig excel=new ExcelDataConfig("./src/main/resources/Book2.xlsx");
		
		searchbox.sendKeys(excel.getData("Sheet2",1,0));              //"samsung 65 inch tv"
		searchbox.sendKeys(Keys.ENTER);
		
		// apply filter on price
		
		TouchAction action=new TouchAction(driver);
		action.moveTo(PointOption.point(320, 200)).click().release().perform();
		
		TouchAction action1=new TouchAction(driver);
		action1.moveTo(PointOption.point(300,1150)).click().release().perform();
		
		filter_apply.click();
		
		//apply sort low----high
		
		TouchAction action2=new TouchAction(driver);
		action2.moveTo(PointOption.point(330, 200)).click().release().perform();
		
		TouchAction action3=new TouchAction(driver);
		action3.moveTo(PointOption.point(665,969)).click().release().perform();
		
		AndroidElement element=(AndroidElement) driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"WebView\").instance(4))");
		element.click();
		
		Assert.assertEquals(element.getText(),("samsung 65 inch led tv"));
		
		 addtocart.click();
		 
		 click_on_cart.click();
		 
		 proceed_to_buy.click();
		 
		 select_adress.click();
		 add_new_adress.click();
		 fullname.sendKeys(excel.getData("Sheet3",1,0));               //"santhosh"
		 mobilenumber.sendKeys(excel.getData("Sheet3",1,1));          //"8888855556"
		 enter_city.sendKeys(excel.getData("Sheet3",1,2));             //"bengalore"  
		 enter_postalcode.sendKeys(excel.getData("Sheet3",1,3));       //"123456"
		 enter_adressline1.sendKeys(excel.getData("Sheet3",1,4));      //"h.no:45,ram nagar ,tekkali street"
		 enter_landmark.sendKeys(excel.getData("Sheet3",1,5));           //"pragathi book store"
		 use_this_adress.click();
		 
		 
		 continue_tobuy.click();
		 
		System.out.println(price_of_item.getText());
		 
	}
}
