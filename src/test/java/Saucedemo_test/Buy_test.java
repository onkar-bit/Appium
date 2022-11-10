package Saucedemo_test;

import java.io.IOException;

import org.testng.annotations.Test;

import Saucedemo_pages.Buy;
import Saucedemo_pages.Login;
import io.appium.java_client.android.AndroidDriver;

public class Buy_test extends Login_test{

	AndroidDriver driver;
	Buy objbuy;
	Login objlogin;

	
	@Test(priority = 1)
	public void gobuy() throws IOException, InterruptedException {
		objbuy = new Buy();
		objbuy.getbuy();
	}
}
