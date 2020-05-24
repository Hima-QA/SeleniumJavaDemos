package utils;

import java.io.IOException;

public class ExcelUtilDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String projectPath= System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(projectPath+"\\Excel\\data.xlsx", "Sheet1");
		excel.getRowCount();;
		excel.getCellData(1,0);
		excel.getCellData(1, 1);
		

	}

}
