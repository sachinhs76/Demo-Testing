package testCases;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.Fibonacci;

public class Demo1 {
	
	public WebDriver driver;
	public Demo1 demo1;

	@Test
	public void config() throws InterruptedException, MalformedURLException {
		WebDriverManager.chromedriver().setup();
		//ChromeOptions options=new ChromeOptions();
		//options.addArguments("--incognito");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
	}
}
