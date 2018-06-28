package support.utils;

import java.io.FileInputStream;
import java.util.Iterator;

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
import org.openqa.selenium.support.ui.Select;

public class OperationHelper {
	private FileInputStream file;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;
	private String sheetNameTest = "";
	private WebDriver driver = null;
	
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
			 * UPDATED DATE: 11/6/2018
			 */
	public String getValue_FromExcel(int x, int y) {
		row = sheet.getRow(x);
		cell = row.getCell(y);
		return cell.getStringCellValue().toString();
	}
	
	public String getUrl_fromTable(String[][] table) {
		int row_table_default = 1;
		int row_excel_index_eName = Integer.parseInt(table[row_table_default][0]);
		int col_excel_index_eName = Integer.parseInt(table[row_table_default][1]);
	  
		String eName = getValue_FromExcel(row_excel_index_eName, col_excel_index_eName);
		return eName;
	}
	//================PhuongTran=================
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
	//================PhuongTran=================
	/**
	 * This function is ....
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
	
	public void openUrl(String[][] table){
		  String url = getUrl_fromTable(table);
		  driver.get(url);
		 }
	
	public void click(String[][] table){
		  WebElement element = getElementTable(table);
		  element.click();
		 }
	
	public void input(String[][] table, String value){
		  WebElement element = getElementTable(table);
		  element.clear();
		  element.sendKeys(value);
		 }
	
	//================PhuongTran=================
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
		String fireFoxPath = "/src/test/references/geckodriver";
		String chromePath = "\\src\\test\\references\\chromedriver";
		String iePath = "\\src\\test\\references\\IEDriverServer_win_x64";
		String driverPropertyChrome = "webdriver.chrome.driver";
		String driverPropertyFireFox = "webdriver.gecko.driver";
		String driverPropertyIe = "webdriver.ie.driver";
		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty(driverPropertyFireFox, rootpath + fireFoxPath);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty(driverPropertyChrome, rootpath + chromePath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty(driverPropertyIe, rootpath + iePath);
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		} else {
			System.out.println("Sorry, this browser is invalid");
		}
	}
	//================PhuongTran=================
	/**
	 * This function is select at dropdown list
	 * AUTHOR: PHUONG TRAN
	 * SU3 - GROUP 2
	 * MODIFIED: 
	 * @param eName ; eLocator ; value ; type
	 * UPDATED DATE: 21/6/2018
	 */
	public void selectDropdownList(String eName, String eLocator, String value, String type) throws Throwable  {
		driver.get("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		Thread.sleep(2000);		//Replace with wait
		Select ddl = new Select(getElements(eName,eLocator ));
		Thread.sleep(2000);
		ddl.selectByValue(value);
		Thread.sleep(2000);
		driver.close();
		
	}

//	 Viết function test cho Flights
	public void getFlights() {
//		 1. Open: https://www.expedia.com/
		driver.get("https://www.expedia.com/");
//		 2. Click on "Flights"
		WebElement element = getElements("search-id","tab-flight-tab-hp");
		element.click();
//		 3. Click on Roundtrip/One way/ Multi-City
		WebElement element1 = getElements("search-id","flight-type-roundtrip-label-hp-flight");
		element1.click();
//		 4. Flight from: nhập Ho Chi Minh City, rồi chọn suggestion Ho Chi Minh bên dưới
		WebElement element2 = getElements("search-id","flight-origin-hp-flight");
		element2.clear();
		element2.sendKeys("Ho Chi Minh City");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement element3 = getElements("search-id","aria-option-0");
		Actions actions = new Actions(driver);

		actions.click(element3).perform();
//		 5. Flight to: nhập Ha Noi, rồi chọn suggestion Ha Noi bên dưới
		WebElement element4 = getElements("search-id","flight-destination-hp-flight");
		element4.clear();
		element4.sendKeys("Ha Noi");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement element5 = getElements("search-id","aria-option-0");
		Actions actions2 = new Actions(driver);

		actions2.click(element5).perform();
//		 6. Check on "Add a hotel" or "Add a car"
		WebElement element6 = getElements("search-id","flight-add-hotel-checkbox-hp-flight");
		element6.click();
//		 7. Click on Search
		WebElement element7 = getElements("search-class","gcw-submit");
		element7.click();
		
		driver.close();
	}
}
