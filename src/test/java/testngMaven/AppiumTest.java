package testngMaven;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.util.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import pages.RecycleViewPage;

public class AppiumTest {
	
	public static URL url;
	public static DesiredCapabilities capabilities;
	public static AndroidDriver<MobileElement> driver;
	
	@BeforeSuite
	public void setupAppium() throws MalformedURLException{
		
		final String URL_String = "http://127.0.0.1:4723/wd/hub";
		url = new URL(URL_String);
		
		capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capabilities.setCapability(MobileCapabilityType.APP,"C:\\mobileautomation\\app-debug.apk");
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		
		driver = new AndroidDriver<MobileElement>(url, capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
    public void exampleOfTestNgMaven() throws InterruptedException {
        
		RecycleViewPage recycle = new RecycleViewPage(driver);
	
		String animalText = recycle.getRecycleElement();
		Assert.isTrue(true, animalText);
		
		System.out.println(animalText);
		
    }
	
	@AfterSuite
	public void uninstallApp() throws MalformedURLException{
		driver.quit();
	}

}
