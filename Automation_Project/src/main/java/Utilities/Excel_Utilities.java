package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;


public class Excel_Utilities {
	public static FileInputStream file;
	public static XSSFWorkbook book;
	public static XSSFSheet sh;
	// to get String Data
	public static String  getStringData(int a , int b, String sheet) throws IOException { 
		String filePath=Constants.TESTDATAFILE;
		file=new FileInputStream(filePath);
		book = new XSSFWorkbook(file);
		sh= book.getSheet(sheet);
		XSSFRow row = sh.getRow(a);
		XSSFCell cell = row.getCell(b);
		return cell.getStringCellValue();
		
	}
	public static String getIntData(int a,int b,String sheet) throws IOException {
		String filePath=Constants.TESTDATAFILE;
		file=new FileInputStream(filePath);
		book = new XSSFWorkbook(file);
		sh= book.getSheet("Sheet1");
		XSSFRow row = sh.getRow(a);
		XSSFCell cell = row.getCell(b);
		int data = (int) cell.getNumericCellValue();
		return String.valueOf(data);
		
		
		
	}
	

}