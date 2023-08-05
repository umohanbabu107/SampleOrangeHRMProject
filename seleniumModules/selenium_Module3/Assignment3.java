/*
 Assignment -3(TestNG):
➤ url : https://demoqa.com/
➤ Click on  Forms
➤ Click on Practise Form
➤ Make above two actions in group as smoke test
➤ Then fill the entire form group name will be regression 
➤ Enter Submit

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
import org.testng.annotations.Test;

import testComponents.BaseTest;

public class Assignment3 extends BaseTest {

	@Test(groups = "smoketest")
	public void clickForms() {
		driver.get("https://demoqa.com/");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]/div/div[2]")).click();
	}

	@Test(groups = "somke test")
	public void clickPracticeForm() {
		driver.get("https://demoqa.com/");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]/div/div[2]")).click();
		driver.findElement(By.xpath("//span[text() = \"Practice Form\"]")).click();
	}

	@Test(groups= "regression")
	public void fillForm() {
		driver.get("https://demoqa.com/");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]/div/div[2]")).click();
		driver.findElement(By.xpath("//span[text() = \"Practice Form\"]")).click();

		driver.findElement(By.xpath("//input[@id=\"firstName\"]")).sendKeys("Mohanbabu");

		driver.findElement(By.xpath("//input[@id=\"lastName\"]")).sendKeys("Ungati");

		driver.findElement(By.xpath("//input[@id=\"userEmail\"]")).sendKeys("abcd@gmail.com");

		driver.findElement(By.xpath("//label[@for=\"gender-radio-1\"]")).click();
	}

}
