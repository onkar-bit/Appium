package Saucedemo_pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Saucedemo_core.Appdriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Buy {

	public WebDriver driver;
	
	@FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]/android.widget.TextView")
	private WebElement cart;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")
	private WebElement carticon;
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'CHECKOUT')]")
	private WebElement chkout;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-First Name\"]")
	private WebElement fname;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Last Name\"]")
	private WebElement lname;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]")
	private WebElement code;
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'CONTINUE')]")
	private WebElement clkcont;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-FINISH\"]/android.widget.TextView")
	private WebElement clkfinish;
	
	public Buy() {
		PageFactory.initElements(Appdriver.getDriver(), this);
	}
	
	public String read(String key) throws IOException {
		Properties obj = new Properties();
		FileInputStream fs = new FileInputStream("/Users/onkarprakashbande/eclipse-workspace/SauceDemo/sauce.properties");
		obj.load(fs);
		String msg = obj.getProperty(key);
		return msg;
	}
	
	public static void scrollDown() {
		Dimension dimension = Appdriver.getDriver().manage().window().getSize();

		int scrollStart = (int) (dimension.getHeight() * 0.8);
		int scrollEnd = (int) (dimension.getHeight() * 0.3);

		int X_scroll = (int) (dimension.getWidth() * 0.2);

		new TouchAction((PerformsTouchActions) Appdriver.getDriver()).press(PointOption.point(X_scroll, scrollStart))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(X_scroll, scrollEnd)).release().perform();

	}
	
	public void getbuy() throws IOException, InterruptedException {
		Thread.sleep(5000);
		cart.click();
		Thread.sleep(3000);
		carticon.click();
		Thread.sleep(3000);
		chkout.click();
		Thread.sleep(3000);
		fname.sendKeys(read("fname"));
		lname.sendKeys(read("lname"));
		code.sendKeys(read("code"));
		clkcont.click();
		Thread.sleep(3000);
		scrollDown();
		clkfinish.click();
	}
}
