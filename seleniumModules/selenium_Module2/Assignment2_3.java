/*
 Assignment -2(Handling Alerts, Frames, Windows):
➤https://demo.guru99.com/test/delete_customer.php
 ➤ Enter customer Id
➤ Click on Submit
➤ One prompt will open click on ok
➤ Again open one prompt click on ok
Reference site : https://www.guru99.com/alert-popup-handling-selenium.html

Assignment -2.1(Frames):
➤https://demo.guru99.com/test/delete_customer.php
 ➤ Click on the frame shown in the image 

Reference site : https://www.guru99.com/handling-iframes-selenium.html
Assignment -2.2(Windows):
➤url : http://demo.guru99.com/popup.php
 ➤ Click on Click here
➤ It will go to next window. Then enter Email Id
➤ Click on Submit

Assignment -3(Actions, JavaScript Executors):
➤url : https://jqueryui.com/
 ➤ Click on Draggable
➤ Drag the “Drag me around” box another place
➤ Take the Screeshot of that dragged
➤ Suggested method javascript Executor 
 */

package selenium_Module2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testComponents.BaseTest;

public class Assignment2_3 extends BaseTest {

	@Test
	public void alertsHandle() {
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		driver.findElement(By.xpath("//input[@name=\"cusid\"]")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();
		driver.switchTo().alert().accept();
		System.out.println("alert1");
		driver.switchTo().alert().accept();
		System.out.println("alert2");
	}

	@Test
	public void framesHandle() {
		driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name=\"globalSqa\"]")));
		driver.findElement(By.xpath("//a[@href=\"https://www.globalsqa.com/training/selenium-online-training/\"]"))
				.click();
		String actResult = driver.findElement(By.xpath("//h1[text()='Selenium 3.0 Training']")).getText();
		Assert.assertEquals(actResult, "Selenium 3.0 Training");
	}

	@Test
	public void handleWindow() throws InterruptedException, IOException {
		driver.get("http://demo.guru99.com/popup.php");
		takeScreenshot();
		driver.findElement(By.xpath("//a[text() = \"Click Here\"]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> winHandles = new ArrayList<String>(windowHandles);
		Iterator<String> itr = winHandles.iterator();
		String parentWindow = itr.next();
		String childWindow = itr.next();
		driver.switchTo().window(childWindow);
		driver.findElement(By.xpath("//input[@name=\"emailid\"]")).sendKeys("tester@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.className("//input[@name='btnLogin']")).click();

	}

	@Test
	public void jsExecuter() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript(key,args);
		
		// Using execute script method we can do multiple actions like Click, Scroll, Flash, Drag and Drop etc... 
	}

	@Test
	public void takeScreenshot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\Screenshots\\logo.png");
		FileUtils.copyFile(src, trg);
	}

	@Test
	public void mouseActions() {
		// We can do multiple mouse actions using Actions Class. I have used null because the url mentioned in the word doc is not working
		Actions a = new Actions(driver);
		a.moveToElement(null).build().perform();
		a.scrollToElement(null);
		a.doubleClick();
		a.contextClick();
	}

}
