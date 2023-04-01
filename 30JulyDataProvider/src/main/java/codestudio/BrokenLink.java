package codestudio;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLink {
	// uday logic program
	
	 public int code;
	
	@Test
	public void findBrokenLink() throws IOException, InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		

		// Collect all the links into an element.
		 
		List<WebElement> Link_list = driver.findElements(By.tagName("a"));
		int count =Link_list.size();
	    System.out.println(count);
	    
	    for(int i=0; i<count; i++)
	    {
	    	WebElement link = Link_list.get(i);
	    	String url = link.getAttribute("href");
	    	
	    	URL ur= new URL(url);   // use URL class and create object of class as link
			
			//create connection using url object link
			HttpURLConnection huc=(HttpURLConnection)ur.openConnection();   //
			Thread.sleep(2000);
			huc.connect();
			int ResponseCode = huc.getResponseCode();
			
			if(ResponseCode>=400)
			{
				System.out.println(url +" is broken link");
			}
			else
			{
				System.out.println(url + " is valid link");
			}
	    }
		
	}
  }

