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
		String [][] table2 = {
				{"Row_Index","Column_Index"}
				,{"1","2"}
		};
		support.click(table2);
		String [][] table3 = {
				{"Row_Index","Column_Index"}
				,{"1","3"}
		};
		String [][] table3_1 = {
				{"Row_Index","Column_Index"}
				,{"1","11"}
		};
		support.selectAutoComplete(table3, "Ha noi", table3_1);
		String [][] table4 = {
				{"Row_Index","Column_Index"}
				,{"1","4"}
		};
		support.selectAutoComplete(table4, "Ho chi minh", table3_1);
		String [][] table5 = {
				{"Row_Index","Column_Index"}
				,{"1","5"}
		};
		support.input(table5, "07/12/2018");
		String [][] table6 = {
				{"Row_Index","Column_Index"}
				,{"1","6"}
		};
		support.input(table6, "07/14/2018");
		String [][] table7 = {
				{"Row_Index","Column_Index"}
				,{"1","7"}
		};
		support.click(table7);
		String [][] table8 = {
				{"Row_Index","Column_Index"}
				,{"1","8"}
		};
		support.input(table8, "07/12/2018");
		String [][] table9 = {
				{"Row_Index","Column_Index"}
				,{"1","9"}
		};
		support.input(table9, "07/14/2018");
		String [][] table10 = {
				{"Row_Index","Column_Index"}
				,{"1","10"}
		};
		support.click(table10);
	}

} 
