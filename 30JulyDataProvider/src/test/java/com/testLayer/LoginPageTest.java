package com.testLayer;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageLayer.LoginPage;
import com.testBase.TestBase;
import com.utilities.ReadData;

public class LoginPageTest extends TestBase{
	//--DataProvider Annotation method------
		
	  @DataProvider(name="LoginData")
		public String[][] getLoginData()
		{
			ReadData rd =new ReadData();
			int r =rd.getRowCount("Login Data");
			int c =rd.getCellCount("Login Data", 1);
			
			String logindata[][]= new String [r][c]; 
			for(int i=1;i<=r;i++)
			{
				for(int j=0;j<c;j++)
				{
					logindata[i-1][j]= rd.getData("Login Data", i, j);
				}
			}
			return logindata;
		 }
//-------------------------------------------------------------------------------------
		//--use dataprovider with in same class----
		
		
		@Test(dataProvider="LoginData")
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
	
		
//-----------for check last rownum and cellnum of excel sheet------	

		
//		@Test
//		public void sample()
//		{
//			ReadData rd =new ReadData();
//			System.out.println("row count = "+rd.getRowCount("Login Data"));
//			System.out.println("cell count = "+rd.getCellCount("Login Data",1));
//	
//		}
		
}
