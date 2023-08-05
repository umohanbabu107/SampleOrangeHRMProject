/*
 Assignment -1(Apache POI (Data Driven)):
➤ url : http://demo.guru99.com/V4/
➤ Get the data from excel sheet using Apache poi
➤ Enter the username 
➤ Enter the password
➤ Click on Login button
➤ One prompt will open click on OK 

 */

package selenium_Module4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import extentReports.TestResultsReport;
import testComponents.BaseTest;

public class Assignment1 extends BaseTest {

	@DataProvider
	public String[][] excelData() throws IOException {
		String path = "C:\\Users\\hp\\SeleniumTestData\\TestDataExcler.xlsx";
		FileInputStream fis = new FileInputStream(path);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = null;

		int numOfSheets = workbook.getNumberOfSheets();
		for (int i = 0; i < numOfSheets; i++) {
			// System.out.println(workbook.getSheetName(i));
			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet2")) {
				sheet = workbook.getSheetAt(i);
			}
		}

		// System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());

		/*
		 * HashMap<String, String> data = new HashMap<String, String>();
		 * data.put("username", cell.getStringCellValue()); data.put("password",
		 * cell.getStringCellValue());
		 */

		Iterator itrRow = sheet.iterator();

		String[][] data = new String[6][2];

		while (itrRow.hasNext()) {
			Row row = (Row) itrRow.next();

			Iterator itrCell = row.cellIterator();

			while (itrCell.hasNext()) {
				Cell cell = (Cell) itrCell.next();
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 2; j++) {
						data[i][j] = cell.getStringCellValue();
					}
				}
			}
		}
		return data;
	}

	@Test(dataProvider = "excelData")
	public void test1(String username, String password) {
		TestResultsReport report = new TestResultsReport();
		ExtentReports extent1 = report.reports();
		extent1.createTest("test1");
		driver.get("http://demo.guru99.com/V4/");
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		driver.switchTo().alert().accept();
		extent1.flush();

	}

}
