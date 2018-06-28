package support.steps;

import support.utils.OperationHelper;

public class StepDefinations {

	public static void main(String[] args) throws Throwable {
		OperationHelper support = new OperationHelper();
		String filePath = "/src/test/resources/DataIn/";
		String fileName = "Elements.xlsx";
		String sheetName = "Login_Page";
		support.openFileExcel(filePath, fileName, sheetName);
		support.launch("firefox");
	//	support.getElements("search-id", "lst-ib");
//		String [][] table = {
//				{"Row_Index","Column_Index"}
//				,{"0","1"}
//			};
//		support.openUrl(table);
//		String [][] table1 = {
//							{"Row_Index","Column_Index"}
//							,{"1","1"}
//		};
		//support.click(table1);


//		support.input(table1, "phuong tran");
//		
//		String [][] table2 = {
//				{"Row_Index","Column_Index"}
//				,{"1","2"}
//		};
//		support.click(table2);
		//support.selectDropdownList("select-id", "select-demo", "Tuesday", "text");
		
//		 Viết function test cho Flights
		support.getFlights();
	}

} 
