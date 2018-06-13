package support.steps;

import support.utils.OperationHelper;

public class StepDefinations {

	public static void main(String[] args) throws Throwable {
		OperationHelper support = new OperationHelper();
		String filePath = "/src/test/resources/DataIn/";
		String fileName = "Elements.xlsx";
		String sheetName = "Login_Page";
		support.openFileExcel(filePath, fileName, sheetName);
		System.out.println(support.getValue_FromExcel(support.getIndex_FromTable(0, 0), support.getIndex_FromTable(0, 1)));
		support.getValueCell();
	}

} 
