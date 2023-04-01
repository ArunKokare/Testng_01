package com.testLayer;

import org.testng.annotations.DataProvider;

import com.utilities.ReadData;

public class UtilDataProvider {
	
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

}
