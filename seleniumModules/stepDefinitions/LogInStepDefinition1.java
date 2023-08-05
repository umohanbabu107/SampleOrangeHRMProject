package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class LogInStepDefinition1 {

	public WebDriver driver;

	@Before
	public WebDriver initialize_the_driver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files\\chromeDriver\\chromedriver_win32 (112)\\chromedriver.exe");

		driver = new ChromeDriver();

		return driver;
	}

	@Given("^I want to launch fb page$")
	public void i_want_to_launch_fb_page() {
		driver.get("https://www.facebook.com/");
	}

	@When("^I enter wrong username (.+) and password (.+)$")
	public void i_enter_wrong_username_and_password(String username, String password) {
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.name("login")).click();
	}

	@Then("^I verify error message$")
	public void i_verify_error_message() {
		String errorMessage = driver
				.findElement(By.xpath("//div[contains(text(), \"The password that you've entered is incorrect.\")]"))
				.getText();
		Assert.assertEquals(errorMessage, "The password that you've entered is incorrect. Forgotten password?");
	}

	@After
	public void tearDown() {
		driver.close();
	}

}
