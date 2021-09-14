package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	
	public static Object[][] getTestData(String filePath, String sheetName) {
		FileInputStream file = null;
		Workbook book = null;
		try {
			file = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		return data;
	}
	public String getExceldata(String filepath,String sheetname,int rownum,int colnum) throws EncryptedDocumentException, InvalidFormatException, IOException{
		System.out.println(filepath+" "+sheetname+"    "+rownum+"   "+colnum);
		FileInputStream fis=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		Row rw=sh.getRow(rownum);
		
	    String data=rw.getCell(colnum).getStringCellValue();
		System.out.println("come1");
	    return data;
		}
	public int countofdata(String filepath,String sheetname) throws EncryptedDocumentException, InvalidFormatException, IOException{
			FileInputStream fis=new FileInputStream(filepath);
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet(sheetname);
		int rowcount=	sh.getLastRowNum();
		return rowcount;
	}
	public void ReadExceldata(String filepath,String sheetname,int rownum,int colnum,String data) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		Row rw=sh.getRow(rownum);
		Cell cel=rw.createCell(colnum);
		cel.setCellType(Cell.CELL_TYPE_STRING);
		FileOutputStream fos=new FileOutputStream(filepath);
		cel.setCellValue(data);
		wb.write(fos);
	
	}
	
	public double getExceldatanum(String filepath,String sheetname,int rownum,int colnum) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		Row rw=sh.getRow(rownum);
	    double data=rw.getCell(colnum).getNumericCellValue();
	    return data;
		}
	public void ReadExceldatanum(String filepath,String sheetname,int rownum,int colnum,double data) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		Row rw=sh.getRow(rownum);
		Cell cel=rw.createCell(colnum);
		cel.setCellType(Cell.CELL_TYPE_NUMERIC);
		FileOutputStream fos=new FileOutputStream(filepath);
		int e=(int)data;
	    cel.setCellValue(e);
		wb.write(fos);
	
	}
}
