package com.acttime.testscript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintOperators {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/java/java_operators.asp");
		Thread.sleep(4000);
		List<WebElement> allOperators=driver.findElements(By.xpath("//th[text()='Description']/preceding-sibling::th[text()='Operator']/../../tr/td[1]"));
		List<WebElement> allDescription=driver.findElements(By.xpath("//th[text()='Description']/../../tr/td[3]"));
		int operatorCount = allOperators.size();
		int descriptionCount = allDescription.size();
		System.out.println(operatorCount);
		System.out.println(descriptionCount);
		for(int i=0;i<operatorCount;i++) {
			String name = allOperators.get(i).getText();
			String description = allDescription.get(i).getText();
			System.out.println("Operator name:- "+ name+ "    --> Operator desciption:- "+description);
		}
}}
