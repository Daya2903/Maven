package com.acttime.testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CreateCustomer {
	@Test
	public void testCreateCustomer() {
		WebDriver d=new FirefoxDriver();
		d.get("https://www.facebook.com");
		System.out.println(d.getTitle());
		d.quit();
		Reporter.log("testCreateCustomer", true);
	}
}
