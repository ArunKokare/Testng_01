package com.testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;


public class TestBase {
	
	public static WebDriver driver;
	@Parameters("browser")
	
	@BeforeMethod
	public void setUp(String Br)
	{
		// String Br ="Chrome";
		if(Br.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(Br.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if (Br.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Please Provide Correct Browser");
		}
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
//    @AfterMethod
//		public void tearDown()
//		{
//			driver.quit();
//		}

}
