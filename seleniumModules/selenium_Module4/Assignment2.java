/*
Assignment -2(Page Object Model(POM)):
➤ url : https://itechnotion.com/what-will-be-the-cost-of-an-app-like-justdial-its-indias-no-1-local-business-directory/
➤ Retrieve all headers
➤ Click on Products and Select vDoctor 
➤ Click on the FEATURES and retrieve the all features
➤ Click on TECHNOLOGY and retrieve the all technologies
➤ Click on Get Quote 
➤ Enter the data into form by taking all the data from excel sheet
➤ Select any option in what is your interest
➤ Click on submit
 */

package selenium_Module4;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testComponents.BaseTest;

public class Assignment2 extends BaseTest {

	public Assignment2() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//ul[@class='navigation-menu nav-right']")
	List<WebElement> allHeaders;

	@FindBy(xpath = "(//h2[@class='heading']/child::span[text()='Front-End']/parent::h2/parent::div/parent::div/parent::div/parent::div/child::div)[2]")
	List<WebElement> fronendElements;

	@FindBy(xpath = "//ul[@class='list-unstyled footer-list mt-4'] //a[@href=\"/technologies\"]")
	WebElement technologies;

	@FindBy(xpath = "//div[text()='Get Started']")
	WebElement getStarted;

	By nameField = By.xpath("//input[@name='fields[name]']");
	By mailField = By.xpath("//input[@name='fields[email]']");
	By phoneField = By.xpath("//input[@name='fields[phone]']");

	@FindBy(xpath = "//select[@name='fields[country]']")
	WebElement countryDD;

	@FindBy(xpath = "//select[@name='fields[what_is_your_interest]']")
	WebElement interestDD;

	@FindBy(xpath = "//select[@name='fields[budget]']")
	WebElement budgetDD;

	@FindBy(xpath = "//textarea[@name='fields[message]']")
	WebElement messageField;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;

	@FindBy(xpath = "//h1[@class=\"heading mb-1\"]")
	WebElement successMessage;

	@Test
	public void retrieveAllHeaders() {

		driver.get(
				"https://itechnotion.com/what-will-be-the-cost-of-an-app-like-justdial-its-indias-no-1-local-business-directory/");
		List<WebElement> ele = allHeaders;
		System.out.println("All the headers: ");
		for (WebElement ele1 : ele) {
			System.out.println(ele1.getText());
		}

	}

	@Test
	public void technologies() {
		driver.get(
				"https://itechnotion.com/what-will-be-the-cost-of-an-app-like-justdial-its-indias-no-1-local-business-directory/");
		technologies.click();
		// String frontEnd =
		// driver.findElement(By.xpath("//h2[@class='heading']/child::span[text()='Front-End']")).getText();
		// FrontEnd technologies web elements
		List<WebElement> frontEndEles = fronendElements;
		System.out.println("Front-End Technologies: ");
		for (WebElement ele : frontEndEles) {
			System.out.println(ele.getText());
		}
	}

	@Test
	public void getQuote() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(
				"https://itechnotion.com/what-will-be-the-cost-of-an-app-like-justdial-its-indias-no-1-local-business-directory/");
		getStarted.click();
		driver.findElement(nameField).sendKeys("Tester");
		driver.findElement(mailField).sendKeys("tester@gmail.com");
		driver.findElement(phoneField).sendKeys("123456789");
		Select countryDropdown = new Select(countryDD);
		countryDropdown.selectByVisibleText("India");
		Select intDD = new Select(interestDD);
		intDD.selectByVisibleText("Other");
		Select budDD = new Select(budgetDD);
		budDD.selectByVisibleText("$10k+");
		messageField.sendKeys("Testing purpose");

		submit.click();
		String actual = successMessage.getText();

		Assert.assertEquals(actual, "Get In Touch");
	}

}
