package codestudio;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PrintAll_Result {
	// this overall pakage just for practice not part of framework  
	//in that class this code is for print all result 

	@Test
	public void test()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Dell Laptop"+Keys.ENTER);
		
		List<WebElement> listWeb = driver.findElements(By.xpath("//h2[contains(@class, 'a-size-mini a-spacing')]"));
		
		int count = listWeb.size();
		
		for(int i=1;i<=count;i++)   //1 way
		{
			String txt = driver.findElement(By.xpath("(//h2[contains(@class, 'a-size-mini a-spacing')])["+i+"]")).getText();
			System.out.println(txt);
			System.out.println("");
		}
		
		
		for(WebElement xyz : listWeb)//2 way
		{
			String txt = xyz.getText();
			System.out.println(txt);
		}

		
//-----------------------------------------------------------------------------		
		for(int i=0;i<count;i++)//3 way
		{
			String txt = listWeb.get(i).getText();
			System.out.println(txt);
		}
	}
}