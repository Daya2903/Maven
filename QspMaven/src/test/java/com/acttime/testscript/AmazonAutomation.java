package com.acttime.testscript;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AmazonAutomation {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		WebElement allDropDownButton = driver.findElement(By.xpath("//div[@class='nav-search-scope nav-sprite']"));
		allDropDownButton.click();
		WebElement electronicsOption = driver.findElement(By.xpath("//option[contains(.,'Electronics')]"));
		electronicsOption.click();
		WebElement searchBarTextField = driver.findElement(By.id("twotabsearchtextbox"));
		searchBarTextField.sendKeys("mouse");
		searchBarTextField.sendKeys(Keys.ENTER);
		WebElement mouse = driver.findElement(By.xpath(
				"//div[@class='sg-col-inner']//span[text()='Amazon Basics Wired USB Mouse, 3-Button, 1000 DPI Optical Sensor, Plug & Play, for Windows/Mac']"));
		mouse.click();
		Set<String> allWid = driver.getWindowHandles();
		for (String wid : allWid) {
			driver.switchTo().window(wid);
		}
		WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
		addToCartButton.click();	
	}
}
