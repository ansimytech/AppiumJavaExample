package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

public class RecycleViewPage {
	
    private AndroidDriver<MobileElement> driver;
    
    public RecycleViewPage() {
    }
    
    public RecycleViewPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    @AndroidFindBy(id = "au.com.recyclerview:id/tv_animal_type")
    private List<AndroidElement> recycleElement;
    
    
    public String getRecycleElement() {
    	
    	return recycleElement.get(0).getText().toString();
    	
    }
    
    

}
