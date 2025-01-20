package testCases;

import pageObject.Fibonacci;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FibonacciTest {

	public WebDriver driver;
	public Fibonacci fibonacci;

	@BeforeClass
	public void config() throws InterruptedException, MalformedURLException {
		WebDriverManager.chromedriver().setup();
		//ChromeOptions options=new ChromeOptions();
		//options.addArguments("--incognito");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qa.hiring.evenhealthcare.com/");
		System.out.println(driver.getTitle());
		fibonacci = new Fibonacci(driver);
			}

	@Test(description="test Fibonacci Number",priority=1)
	public void testFibonacciNumber() throws InterruptedException {  
		fibonacci.enterEmailId();		
		fibonacci.enterNumber("22");
		fibonacci.clickCalculateButton();
		Assert.assertEquals(fibonacci.getValueFromResult(),"75025");
        
	}

}
