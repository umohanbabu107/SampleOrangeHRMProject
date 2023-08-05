/*
 Assignment -2(TestNG):
➤ url : https://demo.guru99.com/test/login.html
➤ Using TestNG Annotaions to complete this assignment
➤ In Before test annotation must have the initialize the drivers
➤ In Test annotation we have to enter the username and password
➤ You need to take the data(username and password) from datadriven method
➤ In After annotation must have the close() to close the application

 */

package selenium_Module3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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

import testComponents.BaseTest;

public class Assignment2 extends BaseTest {

	@Test(dataProvider = "data")
	public void login(String username, String password) {
		driver.get("https://demo.guru99.com/test/login.html");
		driver.findElement(By.cssSelector("input#email")).sendKeys(username);
		driver.findElement(By.cssSelector("input#passwd")).sendKeys(password);
	}

	@DataProvider
	public Object[][] data() {
		Object[][] data = new Object[][] { { "mohanbabu", "Mohan123" } };

		return data;
	}

	
}
