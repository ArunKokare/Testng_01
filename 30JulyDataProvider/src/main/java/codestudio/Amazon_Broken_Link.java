package codestudio;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Amazon_Broken_Link {
	// this overall pakage just for practice not part of framework  
	//in this class write  code is for find broken link  


	@Test
	public void test()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Dell Laptop"+Keys.ENTER);
		
//-----------------------------------------------------------------------------------------------
		String url = "";
		
		List<WebElement> list_links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> li = list_links.iterator();
		
//--------------------li.next()--------------------------------------------------------------------
		while(li.hasNext())
		{
			url = li.next().getAttribute("href");
			System.out.println(url);
			
			if(url==null || url.isEmpty())
			{
//				System.out.println("The url is not configured "+url);
//				System.out.println("--------------------------------------------");
			}
			else
			{
//				System.out.println("The url is configured " +url);
//				System.out.println("--------------------------------------------");
			}
		}
		
		
		HttpURLConnection huc = null;
		
		try 
		{
			huc = (HttpURLConnection)(new URL(url).openConnection());
			huc.setRequestMethod("HEAD");
			huc.connect();
			
			int respCode = huc.getResponseCode();
			
			if(respCode>=400)
			{
				System.out.println("This link is broken -- "+url);
			}
			else
			{
				System.out.println("This link is valid -- "+url);
			}
		} 
		catch (MalformedURLException e) 
		{
			
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		

	}
}