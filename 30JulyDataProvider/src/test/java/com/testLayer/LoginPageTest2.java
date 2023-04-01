package com.testLayer;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageLayer.LoginPage;
import com.testBase.TestBase;
import com.utilities.ReadData;

public class LoginPageTest2 extends TestBase{
	
	// use dataprovider in util package in that we use dataproviderClass for calling time
	
		@Test(dataProvider="LoginData",dataProviderClass=UtilDataProvider.class)
		public void verifyLogin(String username ,String password)
		{	String Expected_url="https://www.saucedemo.com/inventory.html";
			ReadData rd =new ReadData();
			LoginPage log = new LoginPage();
			log.enterUsername(username);
			log.enterPassword(password);
			log.clickOnLoginButton();
			
			Assert.assertEquals(log.getCURL(), Expected_url);
		//	rd.writeData(password, 0, 0, Expected_url);
			
		}
	
		
		

}
