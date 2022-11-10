package Saucedemo_test;

import org.testng.annotations.Test;

import Saucedemo_pages.Sortlow;
import io.appium.java_client.android.AndroidDriver;

public class Sort_test extends Login_test{

	AndroidDriver driver;
	Sortlow objsort;
	
	@Test
	public void gosort() throws InterruptedException {
		objsort = new Sortlow();
		objsort.go();
	}
	
}
