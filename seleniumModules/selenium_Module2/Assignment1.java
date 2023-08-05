/*
 Assignment -1(WebTable):
➤ url : https://demo.guru99.com/test/web-table-element.php
 ➤ Retrieve the all company names from the table
➤ And display in console
➤ url : https://demo.guru99.com/test/login.html
➤ Enter email
➤ Enter password
➤ Click on Login button

 */

package selenium_Module2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testComponents.BaseTest;

public class Assignment1 extends BaseTest{
	
	@Test
	public void webTables() {
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		List<WebElement> elements = driver.findElements(By.xpath("//table[@class=\"dataTable\"]//tbody//tr//td[1]"));
		for(WebElement ele : elements) {
			System.out.println(ele.getText());
		}
	}
	
	
	@Test
	public void guru99Login() {
		driver.get("https://demo.guru99.com/test/login.html");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("tester@gmail.com");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("tester123");
		driver.findElement(By.xpath("//button[@id=\"SubmitLogin\"]")).click();
		String actResult = driver.findElement(By.xpath("//div[@class=\"error-copy\"]//h3")).getText();
		Assert.assertEquals(actResult, "Successfully Logged in...");
	}
	
	

}
