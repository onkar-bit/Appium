package Saucedemo_test;

import java.io.IOException;

import org.testng.annotations.Test;

import Saucedemo_core.BaseSetup;
import Saucedemo_pages.Login;
import io.appium.java_client.android.AndroidDriver;

public class Login_test extends BaseSetup{

	AndroidDriver driver;
	Login objlogin;
	
	
	@Test(priority = 0)
	public void launch() throws IOException, InterruptedException{
		Login objlogin = new Login();
		objlogin.lg();
	}
}
