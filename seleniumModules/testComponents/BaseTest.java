  package testComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	public WebDriver driver;
	
	@BeforeMethod(alwaysRun = true)
	public void driverInitialization() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src_utils\\resourses\\Browser.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		
		if(browserName.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromeDriver\\chromedriver_win32 (112)\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			
			driver = new ChromeDriver(options);
			
		} 
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.driver", "C:\\Program Files\\Drivers for selinium\\FirefoxDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) 
		{
			System.setProperty("webdriver.edge.driver", "C:\\Program Files\\Drivers for selinium\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	

}
