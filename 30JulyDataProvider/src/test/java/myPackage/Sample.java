package myPackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Sample {//Data provider concept
	
	
	@Test(dataProvider="companyNames")
	public void data (String xyz)
	{
		System.out.println(xyz);
	}
	
	//-----------------------------------------------------------
	@DataProvider(name="companyNames")
	public String[] data1()
	{
		String obj[]= {"WIPRO","AXIS","Tech Mahindra","TCS"};
		return obj;
	}
	
	
	
	

}
