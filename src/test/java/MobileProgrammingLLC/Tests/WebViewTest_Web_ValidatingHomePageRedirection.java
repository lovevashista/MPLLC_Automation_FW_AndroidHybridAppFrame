package MobileProgrammingLLC.Tests;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import MobileProgrammingLLC.PageLibraries.WebViewTest_App_HomePage;
import MobileProgrammingLLC.PageLibraries.WebViewTest_Web_YahooHomePage;
import MobileProgrammingLLC.Resources.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class WebViewTest_Web_ValidatingHomePageRedirection {
	AndroidDriver<AndroidElement> driver;
	Logger log = LogManager.getLogger(WebViewTest_Web_ValidatingHomePageRedirection.class.getName());
	Properties locators = new Properties();
	Properties config = new Properties();
	Properties data = new Properties();
	WebViewTest_App_HomePage whp;
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
		log.info("Configurations Successfully Initialized.");
	}
	
	@Test
	public void app_validateIntroTitle() {
		b.compareContent(whp.getAppTitle(), data.getProperty("ExpectedAppTitleOnHomePage"));
	}
	
	@Test(dependsOnMethods= {"app_validateIntroTitle"})
	public void app_handlingConfirmPopUps() {
		b.tapOn(whp.getWorldIcon(), driver);
		for(int i=0; i<3; i++) {
			b.tapOn(whp.getallowBtn(), driver);
		}
	}
	
	@Test(dependsOnMethods= {"app_handlingConfirmPopUps"})
	public void app_navigatingToWebSite() {
		b.enterContentInto(whp.getURLTF(), data.getProperty("YahooURL"));
		b.tapOn(whp.getMoveBtn(), driver);
		b.switchContext(driver, "web");
		b.waitForPresence(By.xpath(locators.getProperty("SiteLogo")));
		b.flash(wyhp.getSiteLogo());
		b.isDisplayedOnPage(wyhp.getSiteLogo());
	}
	
	@Test(dependsOnMethods= {"app_navigatingToWebSite"})
	public void app_tapOnNavigationMenuBtn() {
		b.switchContext(driver, "native");
		b.tapOn(whp.getAppNavigationBtn(), driver);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		b.stopAppiumServer();
	}
}
