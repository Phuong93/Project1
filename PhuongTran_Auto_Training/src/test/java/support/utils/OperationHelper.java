package support.utils;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
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
	// print all cells
	public void getValueCell() {
		Iterator<Row> iterator = sheet.iterator();
		while(iterator.hasNext()) {
    	  Row row = iterator.next();
    	  for (int i = 0; i < row.getLastCellNum(); i++) {
			System.out.print(row.getCell(i).getStringCellValue());
		}
    	  System.out.println("");
      }
	}
	//================PhuongTran=================
			/**
			 * This function is read excel xlsx file
			 * AUTHOR: PHUONG TRAN
			 * SU3 - GROUP 2
			 * MODIFIED: 
			 * + ADD getValue_FromExcel() function
			 * UPDATED DATE: 11/6/2018
			 */
	// print a cell
	public String getValue_FromExcel(int x, int y) {
		row = sheet.getRow(x);
		cell = row.getCell(y);
		return cell.getStringCellValue();
	}
	//================PhuongTran=================
	/**
	 * This function is read excel xlsx file
	 * AUTHOR: PHUONG TRAN
	 * SU3 - GROUP 2
	 * MODIFIED: 
	 * + ADD getIndex_FromTable() function
	 * UPDATED DATE: 11/6/2018
	 */
	// datatable
	public int getIndex_FromTable(int x, int y) {
		int[][] dataTable = new int[3][3];
		dataTable[0][0] = 0;
		dataTable[0][1] = 1;
		dataTable[0][2] = 2;
		dataTable[1][0] = 0;
		dataTable[1][1] = 1;
		dataTable[1][2] = 2;
		dataTable[2][0] = 0;
		dataTable[2][1] = 1;
		dataTable[2][2] = 2;
		return dataTable[x][y];
	}	
}
