package Saucedemo_pages;

import java.time.Duration;

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

public class Sortlow {

	public WebDriver driver;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
	private WebElement sorticon;
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Price (low to high)')]")
	private WebElement clklow;
	
	@FindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Price\"])[1]")
	private WebElement lowprice;
	
	@FindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Price\"])[2]")
	private WebElement highprice;
	
	public Sortlow() {
		PageFactory.initElements(Appdriver.getDriver(), this);
	}
	
	public static void scrollDown() {
		Dimension dimension = Appdriver.getDriver().manage().window().getSize();

		int scrollStart = (int) (dimension.getHeight() * 0.8);
		int scrollEnd = (int) (dimension.getHeight() * -0.1);

		int X_scroll = (int) (dimension.getWidth() * 0.2);

		new TouchAction((PerformsTouchActions) Appdriver.getDriver()).press(PointOption.point(X_scroll, scrollStart))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(X_scroll, scrollEnd)).release().perform();
	}
	
	public void go() throws InterruptedException {
		Thread.sleep(5000);
		sorticon.click();
		Thread.sleep(3000);
		clklow.click();
		Thread.sleep(4000);
		System.out.println("Lowest price: "+lowprice.getText());
		scrollDown();
		Thread.sleep(5000);
		System.out.println("highest price: "+highprice.getText());
	}
}
