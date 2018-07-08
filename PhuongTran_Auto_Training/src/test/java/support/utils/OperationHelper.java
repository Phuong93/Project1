package support.utils;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OperationHelper {
	private FileInputStream file;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;
	private String sheetNameTest = "";
	private WebDriver driver = null;
	private final String referencePath = "/src/test/references/";
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
		/**
		 * This function is read excel xlsx file
		 * AUTHOR: PHUONG TRAN
		 * SU3 - GROUP 2
		 * MODIFIED: 
		 * UPDATED DATE: 11/6/2018
		 */
	public String getValue_FromExcel(int x, int y) {
		row = sheet.getRow(x);
		cell = row.getCell(y);
		return cell.getStringCellValue().toString();
	}
		/**
		 * This function is getUrl from excel with dataTable
		 * AUTHOR: PHUONG TRAN
		 * SU3 - GROUP 2
		 * MODIFIED: 
		 * UPDATED DATE: 11/6/2018
		 */
	public String getUrl_fromTable(String[][] table) {
		int row_table_default = 1;
		int row_excel_index_eName = Integer.parseInt(table[row_table_default][0]);
		int col_excel_index_eName = Integer.parseInt(table[row_table_default][1]);
		String eName = getValue_FromExcel(row_excel_index_eName, col_excel_index_eName);
		return eName;
	}
		/**
		 * This function is get elements
		 * AUTHOR: PHUONG TRAN
		 * SU3 - GROUP 2
		 * MODIFIED: 
		 * @param eName ; eLocator
		 * UPDATED DATE: 21/6/2018
		 */
	public WebElement getElements(String eName, String eLocator) {
		WebElement e = null;
		if (eName.toLowerCase().endsWith("-id")) {
			e = driver.findElement(By.id(eLocator));
		} else if (eName.toLowerCase().endsWith("-name")) {
			e = driver.findElement(By.name(eLocator));
		} else if (eName.toLowerCase().endsWith("-xpath")) {
			e = driver.findElement(By.xpath(eLocator));
		} else if (eName.toLowerCase().endsWith("-class")) {
			e = driver.findElement(By.className(eLocator));
		} else if (eName.toLowerCase().endsWith("-css")) {
			e = driver.findElement(By.cssSelector(eLocator));
		} else {
			System.out.println("eName is invalid, please check");
		}
		return e;
	}
		/**
		 * This function is launch a  browser
		 * AUTHOR: PHUONG TRAN
		 * SU3 - GROUP 2
		 * MODIFIED: 
		 * @param browser name
		 * UPDATED DATE: 21/6/2018
		 */
	public void launch(String browserName) {
		String rootpath = System.getProperty("user.dir");
		switch (browserName.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", rootpath + referencePath + "chromedriver");
			driver = new ChromeDriver();
			break;
		case "firefox" :
			System.setProperty("webdriver.gecko.driver", rootpath + referencePath + "geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "ie" :
			System.setProperty("webdriver.ie.driver", rootpath + referencePath + "IEDriverServer_win_x64.exe");
			driver = new InternetExplorerDriver();
		default:
			System.out.println("Sorry, this browser is invalid");
			break;
		}
	}
		/**
		 * This function is getElement with table from excel
		 * AUTHOR: PHUONG TRAN
		 * SU3 - GROUP 2
		 * MODIFIED: 
		 * UPDATED DATE: 11/6/2018
		 */
	public WebElement getElementTable(String[][] table){
		  int row_table_default = 1;
		  int row_excel_index_eName = Integer.parseInt(table[row_table_default][0]);
		  int col_excel_index_eName = Integer.parseInt(table[row_table_default][1]);
		  String eName = getValue_FromExcel(row_excel_index_eName, col_excel_index_eName);
		  String eLocator = getValue_FromExcel(row_excel_index_eName + 1, col_excel_index_eName);
		  System.out.println(eName + eLocator);
		  return getElements(eName, eLocator);
		 }
		/**
		 * This function is get infos from the flights site
		 * AUTHOR: PHUONG TRAN
		 * SU3 - GROUP 2
		 * MODIFIED: 
		 * @param eName ; eLocator ; value ; type
		 * UPDATED DATE: 21/6/2018
		 */
	public void openUrl(String[][] table){
		  String url = getUrl_fromTable(table);
		  driver.get(url);
		 }
	public void click(String[][] table) throws Throwable{
		  WebElement element = getElementTable(table);
		  element.click();
		 }
	public void input(String[][] table, String value){
		  WebElement element = getElementTable(table);
		  element.clear();
		  element.sendKeys(value);
		 }
	public void selectAutoComplete(String[][] table, String value, String[][] table_auto) {
		WebElement element = getElementTable(table);
		element.clear();
		element.sendKeys(value);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement element1 = getElementTable(table_auto);
		element1.click();
	}
}
