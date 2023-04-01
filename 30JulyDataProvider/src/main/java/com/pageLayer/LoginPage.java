package com.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.testBase.TestBase;

public class LoginPage extends TestBase {
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//---------obj repository-----------------
	By username_txt = By.xpath("//input[@id='user-name']");
	By password_txt = By.xpath("//input[@id='password']");
	By loogin_btn = By.xpath("//input[@id='login-button']");
	
	//-------actionMethod---------------------
	
	public void enterUsername(String username)
	{
		driver.findElement(username_txt).sendKeys(username);
	}
	public void enterPassword(String password)
	{
		driver.findElement(password_txt).sendKeys(password);
	}
	public void clickOnLoginButton()
	{
		driver.findElement(loogin_btn).click();
	}
	
	public String getCURL()
	{
	  return driver.getCurrentUrl();
	}

	
	

}
