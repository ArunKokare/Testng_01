package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {
	
	String path="C:\\Users\\ARUN\\eclipse-workspace\\30JulyDataProvider\\src\\main\\java\\com\\testData\\MyData.xlsx";
	File file;
	FileInputStream fis ;
	XSSFWorkbook wb;
	
	// constrctor initilize
		public ReadData()
		{  file=new File(path);
		   try {
				fis= new FileInputStream(file);
				wb= new XSSFWorkbook(fis);
		       } 
		   catch (IOException e) 
		     {
				e.printStackTrace();
			 }
		}
//======================================for read data from excel==============================================================
	
		public String getData(String sheet_name,int row_num ,int cell_num)
		{
			 String data =  wb.getSheet(sheet_name).getRow(row_num).getCell(cell_num).getStringCellValue();
			 return data;
	    }
//------------------------------------- total row count--------------------------------------------------------------------- 
		
		public int getRowCount(String sheet_name)
		{
			  int rowcount =  wb.getSheet(sheet_name).getLastRowNum();
			 return rowcount;
		}
	
//------------------------------------- total cell count--------------------------------------------------------------------- 
		
		public int getCellCount(String sheet_name,int row_num)
		{
			 int cellcount =  wb.getSheet(sheet_name).getRow(row_num).getLastCellNum();
			 return cellcount;
	    }
//-------------------------------write data---------------------------------------------------------------------------------
		
		public void writeData(String sheet_name,int row_num,int cell_num,String status ) throws IOException
		{
			wb.getSheet(sheet_name).getRow(row_num).createCell(cell_num).setCellValue(status);
			FileOutputStream fos = new FileOutputStream(file); 
			wb.write(fos);
			wb.close();
		}
}
