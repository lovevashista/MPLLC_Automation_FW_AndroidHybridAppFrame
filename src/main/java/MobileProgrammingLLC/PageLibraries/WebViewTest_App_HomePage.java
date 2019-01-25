package MobileProgrammingLLC.PageLibraries;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WebViewTest_App_HomePage {
	public WebViewTest_App_HomePage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Testing WebView Android App']") AndroidElement AppTitle;
	public AndroidElement getAppTitle() {
		return AppTitle; 
	}
	
	@AndroidFindBy(id="com.snc.test.webview2:id/action_go_website") AndroidElement worldIcon;
	public AndroidElement getWorldIcon() {
		return worldIcon;
	}
	
	@AndroidFindBy(uiAutomator="text(\"ALLOW\")") AndroidElement allowBtn;
	public AndroidElement getallowBtn() {
		return allowBtn;
	}
	
	@AndroidFindBy(id="com.snc.test.webview2:id/input_url") AndroidElement URLTF;
	public AndroidElement getURLTF() {
		return URLTF;
	}
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='MOVE']") AndroidElement MoveBtn;
	public AndroidElement getMoveBtn() {
		return MoveBtn;
	}
	
	@AndroidFindBy(xpath="//android.widget.ImageButton") AndroidElement AppNavigationBtn;
	public AndroidElement getAppNavigationBtn() {
		return AppNavigationBtn;
	}
	
	@AndroidFindBy(uiAutomator="text(\"About\")") AndroidElement AboutOptionLnk;
	public AndroidElement getAboutOptionLnk() {
		return AboutOptionLnk;
	}
	
}
