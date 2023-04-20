package generic_utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_utility 
{
	/**
	 * this method is used to fetch the data from excel sheets
	 * @param sheetname
	 * @param rows
	 * @param col
	 * @return
	 * @throws Throwable
	 * @author murali
	 */
  public String getexceldata(String sheetname,int rows,int col) throws Throwable
  {
	  FileInputStream fes=new FileInputStream("./src/test/resources/Excelsheetdata.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rows);
		Cell cell = row.getCell(col);
		String data = cell.getStringCellValue();
		return data;
  }
  public void writeexceldata(String sheetname,int rows,int col,String data) throws Throwable
  {
	  FileInputStream fes=new FileInputStream("./src/test/resources/Excelsheetdata.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetname);
		sheet.createRow(rows).createCell(col).setCellValue(data);
	//	sheet.getRow(rows).createCell(col).setCellValue(data);
		//sheet.getRow(rows).getCell(col).setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./src/test/resources/Excelsheetdata.xlsx");
		book.write(fos);
		book.close();
		fos.close();
  }
	
  public String getexceldataformatter(String sheetname1,int rows1,int col1) throws Throwable
  {
	  FileInputStream fes=new FileInputStream("./src/test/resources/Excelsheetdata.xlsx");
	  Workbook book = WorkbookFactory.create(fes);
	  DataFormatter format=new DataFormatter();
	  String data1 = format.formatCellValue(book.getSheet(sheetname1).getRow(rows1).getCell(col1));
	  return data1; 
  }
 /* public String getexceldataformatter1(String sheetname1,int rows1,int col1) throws Throwable
  {
	  FileInputStream fes=new FileInputStream("./src/test/resources/Dataprovider.xlsx");
	  Workbook book = WorkbookFactory.create(fes);
	  DataFormatter format=new DataFormatter();
	  String data1 = format.formatCellValue(book.getSheet(sheetname1).getRow(rows1).getCell(col1));
	  return data1; 
  }*/
  
  public Object[][] dataproviderfetcher(String sheetname ) throws Throwable
	{
	
	    FileInputStream fes=new FileInputStream("./src/test/resources/Dataprovider.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetname);
		int lastrow = sheet.getLastRowNum()+1;
		int lastcell = sheet.getRow(0).getLastCellNum();
		Object[][] obj=new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++) 
		{
		for(int j=0;j<lastcell;j++)
		{
			obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
		}
		}
		return obj;
	}
  
  
}
