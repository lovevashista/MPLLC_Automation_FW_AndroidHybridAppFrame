package MobileProgrammingLLC.PageLibraries;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WebViewTest_App_AboutPage {
	public WebViewTest_App_AboutPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(className = "android.widget.ImageView") AndroidElement AppImageIcon;
	public AndroidElement getAppImageIcon() {
		return AppImageIcon;
	}
	
	@AndroidFindBy(uiAutomator="text(\"Developer\")") AndroidElement DeveloperText;
	public AndroidElement getDeveloperText() {
		return DeveloperText;
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Development']") AndroidElement DevelopmentText;
	public AndroidElement getDevelopmentText() {
		return DevelopmentText;
	}
	
	@AndroidFindBy(id="com.snc.test.webview2:id/license") AndroidElement LicenseBtn;
	public AndroidElement getLicenseBtn() {
		return LicenseBtn;
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Copyright ©')]") AndroidElement CopyrightText;
	public AndroidElement getCopyrightText() {
		return CopyrightText;
	}
}
