package codestudio;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CountRadioButton {
	
	@Test
	public void radioButton()
	{
		
		//login and maximize apply wait
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://udyamregistration.gov.in/Udyam_Login.aspx");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// find out all radio btn and print
		
		List<WebElement> radio_BtnList = driver.findElements(By.xpath("//input[@type='radio']"));
		System.out.println(radio_BtnList.size());
		
	}

}
