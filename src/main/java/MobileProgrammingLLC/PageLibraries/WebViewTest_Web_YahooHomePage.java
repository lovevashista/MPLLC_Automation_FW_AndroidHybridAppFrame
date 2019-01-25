package MobileProgrammingLLC.PageLibraries;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WebViewTest_Web_YahooHomePage {
	public WebViewTest_Web_YahooHomePage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}	
	
	@FindBy(xpath="//a[@id='header-logo']") WebElement SiteLogo;
	public WebElement getSiteLogo() {
		return SiteLogo;
	}
	
	@FindBy(xpath="//div[@class='D(tbr)']/div[3]") WebElement profileIcon;
	public WebElement getprofileIcon() {
		return profileIcon;
	}
	
	@FindBy(xpath="//a[@id='profile-user-info']/div") WebElement SignInLnk;
	public WebElement getSignInLnk() {
		return SignInLnk;
	}
	
	@FindBy(xpath="//li[@class='notificationPanel panel']/button/div[2]") WebElement NotificationLnk;
	public WebElement getNotificationLnk() {
		return NotificationLnk;
	}
	
	@FindBy(xpath="//ul[contains(@class,'uh-menu-panel')]/li[4]/a/div[2]") WebElement InboxLnk;
	public WebElement getInboxLnk() {
		return InboxLnk;
	}
	
	@FindBy(xpath="//ul[contains(@class,'uh-menu-panel')]/li[5]/a/div[2]") WebElement ManageAccountsLnk;
	public WebElement getManageAccountsLnk() {
		return ManageAccountsLnk;
	}
	
	@FindBy(xpath="//ul[contains(@class,'uh-menu-panel')]/li[6]/a/div[2]") WebElement SettingsLnk;
	public WebElement getSettingsLnk() {
		return SettingsLnk;
	}
	
	@FindBy(xpath="//ul[contains(@class,'aboutPanel')]/li/button/div[2]") WebElement AboutLnk;
	public WebElement getAboutLnk() {
		return AboutLnk;
	}
}
