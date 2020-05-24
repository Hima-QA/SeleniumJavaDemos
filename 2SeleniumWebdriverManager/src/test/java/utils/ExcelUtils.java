package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static String projectPath;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath, String sheetName) throws IOException{ //Creating constructor
		//projectPath= System.getProperty("user.dir");	
		//wb = new XSSFWorkbook(projectPath+"\\Excel\\data.xlsx");//General adding excel path
		wb = new XSSFWorkbook(excelPath);
		
		sheet = wb.getSheet(sheetName);
	}
	
	public static int getRowCount() throws IOException {
		
		int rowCount=0;
		rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("No. of rows are: "+rowCount);
		return rowCount;
	}
	public static int getColCount() throws IOException {
		
		int colCount=0;
		colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("No. of cells are: "+colCount);
		return colCount;
	}
	
	public static String getCellData(int rowNum, int colNum) throws IOException {
		/*projectPath= System.getProperty("user.dir");	
		wb = new XSSFWorkbook(projectPath+"\\Excel\\data.xlsx");
		sheet = wb.getSheet("Sheet1");*/
		
		//Above things not required as mentioned in Constructor
		
		String cellData=null;
		cellData =sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		//System.out.println(cellData);
		return cellData;
	}
	
	public static void main(String[] args) throws IOException {
		getRowCount();
		getCellData(1,0);
		getCellData(1,1);
		
	}
	
}