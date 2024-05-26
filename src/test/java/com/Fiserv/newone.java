package com.Fiserv;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class newone {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get(
				"https://www.fiserv.com/en/insights/articles-and-blogs/measuring-real-time-insights-into-small-business-performance.html");
		driver.findElement(By.xpath("//button[@id='_evidon-banner-acceptbutton']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		// WebElement phone = driver.findElement(By.xpath(("(//a[text()='Who We
		// Serve'])[2]/parent::li")));

		//
		// js.executeScript("arguments[0].scrollIntoView(true);", phone);
		// Thread.sleep(3000);

		List<WebElement> list = driver.findElements(By.xpath("//li[@class='show-on-mobile']"));

		for (WebElement lis : list) {
			String li = lis.getText();
			System.out.println(li);
		}
		WebElement country = driver.findElement(By.xpath("//a[text()='Country Selector']/parent::li"));
		String actual = country.getText();

		String expected = "Country Selector";
		Assert.assertEquals(expected, actual);
		Actions a = new Actions(driver);
		a.keyDown(Keys.CONTROL).moveToElement(country).click().perform();
		
		Set<String> wH = driver.getWindowHandles();
		for(String childwind : wH) {
			driver.switchTo().window(childwind);
			
			ArrayList<WebElement> FE = (ArrayList<WebElement>) driver.findElements(By.xpath("//div[@class='item col-4 col-total--12']"));
			
			for (WebElement coun : FE) {
				String countries = coun.getText();
				System.out.println(countries);
				String[] split = countries.split("   ");
				System.out.println(split);
			}
		}
		
		
	}

}
