package support.steps;

import support.utils.OperationHelper;

public class StepDefinations {

	public static void main(String[] args) throws Throwable {
		OperationHelper support = new OperationHelper();
		String filePath = "/src/test/resources/DataIn/";
		String fileName = "Elements.xlsx";
		String sheetName = "Login_Page";
		support.openFileExcel(filePath, fileName, sheetName);
		support.launch("chrome");
		String [][] table = {
				{"Row_Index","Column_Index"}
				,{"0","1"}
			};
		support.openUrl(table);
		String [][] table1 = {
							{"Row_Index","Column_Index"}
							,{"1","1"}
		};
		support.click(table1);
		//support.input(table1, "phuong tran");
		String [][] table2 = {
				{"Row_Index","Column_Index"}
				,{"1","2"}
		};
		support.click(table2);
		String [][] table3 = {
				{"Row_Index","Column_Index"}
				,{"1","3"}
		};
		support.input(table3, "Ha noi");
		support.click(table3);
		String [][] table4 = {
				{"Row_Index","Column_Index"}
				,{"1","4"}
		};
		support.input(table4, "Ho Chi Minh");
		support.click(table4);
		String [][] table5 = {
				{"Row_Index","Column_Index"}
				,{"1","5"}
		};
		support.click(table5);
		String [][] table6 = {
				{"Row_Index","Column_Index"}
				,{"1","7"}
		};
		support.click(table6);
		//support.getFlights();
	}

} 
