/*
 Assignment -2(Locators working with WebElements)
➤ URL (https://demo.guru99.com/test/radio.html
➤ Find Option 1 and select
➤ Find Checkbox2 and Checkbox3 and select
➤ Suggested site(https://demo.guru99.com/test/newtours/register.php)
➤ Find Country Dropdown
➤ Select “KUWAIT”

 */





package selenium_Module1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testComponents.BaseTest;

//Assignment -2(Locators working with WebElements)

public class Assignment2 extends BaseTest {

	@Test
	public void findOption() {

		driver.get("https://demo.guru99.com/test/radio.html");
		WebElement ele = driver.findElement(By.cssSelector("input#vfb-7-1"));
		ele.click();
		boolean option1 = ele.isEnabled();
		Assert.assertTrue(option1);

	}

	@Test
	public void findCheckboxes() {
		driver.get("https://demo.guru99.com/test/radio.html");
		WebElement ele1 = driver.findElement(By.cssSelector("input#vfb-6-1"));
		ele1.click();
		boolean checkbox2 = ele1.isEnabled();
		Assert.assertTrue(checkbox2);

		WebElement ele2 = driver.findElement(By.cssSelector("input#vfb-6-2"));
		ele2.click();
		boolean checkbox3 = ele2.isEnabled();
		Assert.assertTrue(checkbox3);
	}

	@Test
	public void countryDropDown() {
		driver.get("https://demo.guru99.com/test/newtours/register.php");

		WebElement ele = driver.findElement(By.xpath("//select[@name = 'country']"));

		Select countryDropdown = new Select(ele);
		countryDropdown.selectByVisibleText("KUWAIT");
	}

}
