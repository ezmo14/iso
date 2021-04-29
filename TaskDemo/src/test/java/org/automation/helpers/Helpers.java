package org.automation.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Helpers {

	/**
	 * create a random string of alphabitcal characters sized with size
	 *
	 * @param size
	 * @return random alphabitcal string  
	 */
	public static String randomAlpha(int size) {
		StringBuilder builder = new StringBuilder();

		String source = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		while (size-- != 0) {
			int character = (int) (Math.random() * source.length());
			builder.append(source.charAt(character));
		}
		return builder.toString();
	}
	
	/**
	 * Read data from excel files
	 *
	 * @param filePath
	 * @param sheetName
	 * @return data from sheet
	 */
	public static Object[][] readExcel(String filePath,String sheetName) throws IOException{

		File file =    new File(filePath);


	    FileInputStream inputStream = new FileInputStream(file);
	    Workbook workbook  = new HSSFWorkbook(inputStream);

	    DataFormatter formatter = new DataFormatter();

	    Sheet sheet = workbook.getSheet(sheetName);

	   

	    int rows = sheet.getLastRowNum()-sheet.getFirstRowNum()+1;

	    Object[][] testcases = new Object[rows][sheet.getRow(0).getLastCellNum()];
	   
		for(int i=0;i < rows;i++) {
			
	        Row row = sheet.getRow(i);
	   
	      for(int j=0;j < row.getLastCellNum();j++) {
	    	  
	    	
	    		 testcases[i][j]=formatter.formatCellValue(row.getCell(j));
	    	  
	        	
	        }
	      
	    } 
	    workbook.close();
	    
	    return testcases;
		}

}
