package codestudio;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CodeStudio1 {
	
	@Test
	public void test()
	{
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//find hyperlink
		 List<WebElement> linkList = driver.findElements(By.tagName("a"));
		 System.out.println("Total Broken link on page : "+linkList.size());

		 int resCode=200;//2XX series success
		 int brokenLinkCtn=0;
		 
		 
		 for(WebElement element:linkList)
		 {
			String url= element.getAttribute("href");
			
			try {
				URL urlLink = new URL(url);
				HttpURLConnection huc = (HttpURLConnection)urlLink.openConnection();
				huc.setRequestMethod("HEAD");
				huc.connect();
				
				resCode=huc.getResponseCode();
				
				if(resCode>=400)
					{
						System.out.println(url + "broken link");
						brokenLinkCtn=brokenLinkCtn+1;
					}
				} 
			
			catch(MalformedURLException e)
			  {
				e.printStackTrace();
			  }
		    catch (IOException e) 
			   {
				 e.printStackTrace();
			   }
		  }
		 System.out.println("Total broken link: "+ brokenLinkCtn);

		
		
	}

}
