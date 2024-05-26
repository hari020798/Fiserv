package com.Fiserv;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fizerv {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://www.fiserv.com/");
		driver.findElement(By.xpath("//button[@id='_evidon-banner-acceptbutton']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(("//a[.='Insights']/ancestor::li[@class='primary-nav__dropdown']"))).click();
		/*
		 * WebElement Actual = driver.findElement(By.
		 * xpath("//p[text()='Billing and Payments']/parent::h3/ancestor::div[@class='item col-4 col-total--12']"
		 * )); String text = Actual.getText(); System.out.println(text);
		 * JavascriptExecutor js = (JavascriptExecutor)driver;
		 * js.executeScript("arguments[0].scrollIntoView(true);", Actual);
		 */
		List<WebElement> Allpage = driver.findElements(By.xpath("//div[@class='item col-4 col-total--12']"));
		WebElement Fintech = driver.findElement(By.xpath("(//div[@class='item col-4 col-total--12'])[1]"));
		String text = Fintech.getText();
		for (WebElement all : Allpage) {
			String al = all.getText();
			{
				Assert.assertEquals(al, text);
				all.click();

				System.out.println("True");
			}}
WebElement phone = driver.findElement(By.xpath(("//li[@class='show-on-mobile'])[1]")));
JavascriptExecutor js = (JavascriptExecutor)driver;
 js.executeScript("arguments[0].scrollIntoView(true);", phone);
 List<WebElement> list = driver.findElements(By.xpath("//li[@class='show-on-mobile']"));

for(WebElement lis : list) {
	String li = lis.getText();
	System.out.println(li);
}
		}

	}


