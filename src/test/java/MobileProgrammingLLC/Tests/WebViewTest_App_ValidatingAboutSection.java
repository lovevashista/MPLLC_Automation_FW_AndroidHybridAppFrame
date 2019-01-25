package MobileProgrammingLLC.Tests;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import MobileProgrammingLLC.PageLibraries.WebViewTest_App_AboutPage;
import MobileProgrammingLLC.PageLibraries.WebViewTest_App_HomePage;
import MobileProgrammingLLC.PageLibraries.WebViewTest_Web_YahooHomePage;
import MobileProgrammingLLC.Resources.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class WebViewTest_App_ValidatingAboutSection {
	AndroidDriver<AndroidElement> driver;
	Logger log = LogManager.getLogger(WebViewTest_App_ValidatingAboutSection.class.getName());
	Properties locators = new Properties();
	Properties config = new Properties();
	Properties data = new Properties();
	WebViewTest_App_HomePage whp;
	WebViewTest_App_AboutPage wap;
	WebViewTest_Web_YahooHomePage wyhp;
	Base b = new Base();
	
	@BeforeClass
	public  void initConfigs() {
		log.info("Initializing Configurations...");
		locators = b.loadLocators();
		config = b.loadConfig();
		data = b.loadData();
		driver = b.createAppiumServerConnection(config.getProperty("ip"),config.getProperty("port"), config.getProperty("DeviceType"));
		whp = new WebViewTest_App_HomePage(driver);
		wyhp = new WebViewTest_Web_YahooHomePage(driver);
		wap = new WebViewTest_App_AboutPage(driver);
		log.info("Configurations Successfully Initialized.");
	}
	
	@Test
	public void app_validateIntroTitle() {
		b.compareContent(whp.getAppTitle(), data.getProperty("ExpectedAppTitleOnHomePage"));
	}
	
	@Test(dependsOnMethods= {"app_validateIntroTitle"})
	public void app_tapOnNavigationMenuBtn() {
		b.switchContext(driver, "native");
		b.tapOn(whp.getAppNavigationBtn(), driver);
	}
	
	@Test(dependsOnMethods= {"app_tapOnNavigationMenuBtn"})
	public void app_tapOnAboutOption() {
		b.tapOn(whp.getAboutOptionLnk(), driver);
	}
	
	@Test(dependsOnMethods= {"app_tapOnAboutOption"})
	public void app_verifyAboutPage() {
		b.isDisplayedOnPage(wap.getAppImageIcon());
		b.isDisplayedOnPage(wap.getDeveloperText());
		b.isDisplayedOnPage(wap.getDevelopmentText());
		b.isDisplayedOnPage(wap.getLicenseBtn());
		b.isDisplayedOnPage(wap.getCopyrightText());
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		b.stopAppiumServer();
	}
}
