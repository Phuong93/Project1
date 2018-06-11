package support.utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OperationHelper {
	private FileInputStream file;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;
	private String sheetNameTest = "";
	
	//================PhuongTran=================
		/**
		 * This function is read excel xlsx file
		 * AUTHOR: PHUONG TRAN
		 * SU3 - GROUP 2
		 * MODIFIED: 
		 * + ADD openFileExcel() function
		 * UPDATED DATE: 11/6/2018
		 */
	public void openFileExcel(String filePath, String fileName, String sheetName) throws Throwable {
		String fileDir = System.getProperty("user.dir") + filePath + fileName;
		file = new FileInputStream(fileDir);
		workbook = new XSSFWorkbook(file);
		sheetNameTest = sheetName;
		sheet = workbook.getSheet(sheetNameTest);
	}
	//================PhuongTran=================
			/**
			 * This function is read excel xlsx file
			 * AUTHOR: PHUONG TRAN
			 * SU3 - GROUP 2
			 * MODIFIED: 
			 * + ADD getValueCell() function
			 * UPDATED DATE: 11/6/2018
			 */
	public String getValueCell(int rowIndex, int columnIndex) {
		int index = 1;
		int rowData = 3;
		for (int i = 0; i < rowData; i++) {
			for (int j = 0; j < index; j++) {
				row = sheet.getRow(i);
				cell = row.getCell(j);
				System.out.print(cell);
			}
			row = sheet.getRow(i);
			cell = row.getCell(index);
			System.out.println(cell);
		}
		return cell.getStringCellValue();

	}
}
