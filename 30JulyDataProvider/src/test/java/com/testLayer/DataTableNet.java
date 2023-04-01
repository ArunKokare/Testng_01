package com.testLayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataTableNet {
	
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://datatables.net/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("software");
		int count = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
		
		for(int i=1;i<=count;i++)
		{
			for(int j=1;j<=1;j++)
			{
				String fsg = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print(fsg +"      ");
			}
			System.out.println("");
		}
		Thread.sleep(2000);
		driver.quit();
		
	}
	

}
