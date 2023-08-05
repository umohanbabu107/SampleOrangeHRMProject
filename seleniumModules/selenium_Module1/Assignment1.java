/*
***** Assignment -1(Webdriver  architecture, All Types of Drivers) *****
➤ First Selenium Test: Verify amazon HomaPage
➤ verify the FaceBook HomePage 
➤ Verify the Page Tittle. 
➤ Invoke : Firefox, Safari, Opera, IE
➤ Using Navigator commands to move home page to other page and comeback to homepage
 */

package selenium_Module1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testComponents.BaseTest;

//Assignment -1(Webdriver  architecture, All Types of Drivers)

public class Assignment1 extends BaseTest {

	@Test
	public void verifyAmazonHomePage() {
		driver.get("https://www.amazon.com/");
		String amazonTitleAct = driver.getTitle();
		String amazonTitleExp = "Amazon.com. Spend less. Smile more.";

		Assert.assertEquals(amazonTitleAct, amazonTitleExp);
	}

	@Test
	public void verifyFbHomePage() {
		driver.get("https://www.facebook.com/");
		String fbTitleAct = driver.getTitle();
		String fbTitleExp = "Facebook – log in or sign up";
		Assert.assertEquals(fbTitleAct, fbTitleExp);
	}

	@Test(priority=0)
	public void pageNavigation() {
		// This test will open Today's deals in Amazon page and come back to home page
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		driver.get("https://www.amazon.com/");
		String homepageTitle = driver.getTitle();
		System.out.println(homepageTitle);
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//input[@data-action-type=\"DISMISS\"]"))));
		driver.findElement(By.xpath("//input[@data-action-type=\"DISMISS\"]")).click();
		driver.findElement(By.xpath("//a[text() = \"Today's Deals\"]")).click();
		String todayDealsPageName = driver.findElement(By.xpath("//h1[@class='a-size-extra-large a-spacing-micro']"))
				.getText();
		System.out.println(todayDealsPageName);
		driver.navigate().back();
		System.out.println(driver.getTitle());
		driver.navigate().forward();
		String todayDealsPageName1 = driver.findElement(By.xpath("//h1[@class='a-size-extra-large a-spacing-micro']"))
				.getText();
		System.out.println(todayDealsPageName1);

	}

}
