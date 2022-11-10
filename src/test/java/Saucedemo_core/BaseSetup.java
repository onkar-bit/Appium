package Saucedemo_core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;

public class BaseSetup {

	public static AndroidDriver driver;
	DesiredCapabilities DC;
	private String appiumPort = "0.0.0.0";
	private String serverIp = "4723";
	private String platformName = "ANDROID";
	private String platformVersion = "11";
	private String deviceName = "emulator-5554";
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		DC = new DesiredCapabilities();
		DC.setCapability("platformName", platformName);
		DC.setCapability("platformVersion", platformVersion);
		DC.setCapability("deviceName", deviceName);
		DC.setCapability("newCommandTimeout", "1200");
		DC.setCapability("automationName", "UiAutomator2");
		DC.setCapability("UDID", "dqpz458pro6tswjb");
		DC.setCapability("appPackage", "com.swaglabsmobileapp");
		DC.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
		DC.setCapability("app", "/Users/onkarprakashbande/Downloads/SauceLabs.apk");
		DC.setCapability("autoGrantPermissions", true);
	    DC.setCapability("appium:ignoreHiddenApiPolicyError", true);

		//DC.setCapability("unicodeKeyboard", true);
		//DC.setCapability("resetKeyboard", true);
		driver = new AndroidDriver(new URL("http://" + appiumPort + ":" + serverIp + "/wd/hub"), DC);
        Appdriver.setDriver(driver);
		System.out.println("Driver Setup");
	}
}
