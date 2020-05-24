package utils;

import java.io.IOException;

public class ExcelUtilDataProvider {
	
	public static Object[][] testData(String excelPath, String sheetName) throws IOException {
		
		
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();	
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for(int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				String cellData = excel.getCellData(i,j);
				System.out.println(cellData);
				data[i-1][j] =cellData; //inside loop keep on adding Data
				
			}
		}
		return data;
	}
	
	public static void  main(String[] args) throws IOException {
		String projectPath= System.getProperty("user.dir");
		testData(projectPath+"\\Excel\\data.xlsx","Sheet1"); // passing parameter to the fn testData(excelPath,sheetName)
	}
}
