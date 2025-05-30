package com.internship.idlocater;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class FindElementId {
	public static WebDriver driver;
	ExtentReports  Extent;
	ExtentTest test;
	@BeforeTest
	public void startReport() {
		ExtentSparkReporter  spark=new ExtentSparkReporter("LoginReport.html");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setReportName("Login Test Report");
		spark.config().setDocumentTitle("Automation Report");
		Extent=new ExtentReports();
		Extent.attachReporter(spark);
	}
	@BeforeMethod
	public void setupTest() {
		test=Extent.createTest("Login Test");
	}
	
@Test
	public void setup() throws InterruptedException {
		 driver=new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		test.info("Navigate  to LoginPage URL");
		driver.manage().window().maximize();
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("student");
		test.info("Entered UserName");
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("Password123");
		test.info("Entered Password");
		WebElement button=driver.findElement(By.id("submit"));
		button.click();
		test.info("Clicked submit button");
	test.pass("Logged In Successfully");
		Thread.sleep(2000);
		
	}
@AfterTest
public void tearDown() {
	driver.close();
	Extent.flush();
}



	}


