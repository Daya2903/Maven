package com.acttime.testscript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

public class RedBusAutomation {
	// public static void main(String[] args) throws IOException, Exception {
	// CSVReader reader = new CSVReader(new
	// FileReader("./src/test/resources/Data.csv"));
	// String[] data;
	// while ((data = reader.readNext()) != null) {
	// String from = data[0];
	// String to = data[1];
	// System.out.println("Name: " + from + ", Email: " + to);
	// }
	// reader.close();
	// }
	// @Test
	// public void testReadCsvData() throws IOException, CsvException {
	// Reader readerObj = new FileReader("./src/test/resources/Data.csv");
	// CSVReader reader = new CSVReader(readerObj);
	// //List<String[]> allHeading = reader.readAll();
	// String[] s =new String[4];
	// for(int i=0;i<4;i++) {
	// s=reader.readNext();
	// for (String string : s) {
	// System.out.println(string);
	// }
	// }
	// //reader.

	public static void main(String[] args) throws CsvValidationException, IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		FileReader file = new FileReader("./src/test/resources/Data.csv");
		CSVReader reader = new CSVReader(file);
		String[] data;
		while ((data = reader.readNext()) != null) {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.redbus.in/");
			String from = data[0];
			String dest = data[1];
			Thread.sleep(2000);
			driver.findElement(By.id("src")).sendKeys(from + Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.id("dest")).sendKeys(dest + Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.id("onwardCal")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[contains(@class,'CalendarDays')and text()='1'])[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("search_button")).click();
			String busCount = driver.findElement(By.xpath("//span[contains(@class,'busFound')]")).getText();
			System.out.println(busCount);
			driver.navigate().to("https://www.redbus.in/");
		}
	}
}
