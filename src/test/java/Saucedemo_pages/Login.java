package Saucedemo_pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Saucedemo_core.Appdriver;

public class Login {

	public WebDriver driver;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
	private WebElement usrname;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
	private WebElement psw;
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'LOGIN')]")
	private WebElement clklogin;
	
	public Login() {
		PageFactory.initElements(Appdriver.getDriver(), this);
	}
	
	public String read(String key) throws IOException {
		Properties obj = new Properties();
		FileInputStream fs = new FileInputStream("/Users/onkarprakashbande/eclipse-workspace/SauceDemo/sauce.properties");
		obj.load(fs);
		String msg = obj.getProperty(key);
		return msg;
	}
	
	public void lg() throws InterruptedException, IOException {
		Thread.sleep(4000);
		usrname.sendKeys(read("usrname"));
		psw.sendKeys(read("psw"));
		clklogin.click();
	}
}
