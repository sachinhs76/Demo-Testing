package pageObject;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Fibonacci {
	
	public WebDriver driver;
	 
	@FindBy(xpath="//input[@class='ant-input ant-input-lg']")
	WebElement numberField;
	
	@FindBy(xpath="//span[text()='Calculate!']")
	WebElement calculateButton;
	
	@FindBy(xpath="//div[@class='ant-alert-message']")
	WebElement result;
	
	@FindBy(xpath="//input[@id='identifierId']")
	WebElement email;
	
	//
 
	public Fibonacci(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailId() throws InterruptedException
	{   
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		Actions action=new Actions(driver);
		email.sendKeys("enterEmail",Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Try another way']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Enter your password']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='Passwd']")).sendKeys("EnterPassword",Keys.ENTER);
		
		
		
		}
 
	public void enterNumber(String s) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(numberField));		
		numberField.sendKeys(s);
	}
	
	public void clickCalculateButton() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		calculateButton.click();
		wait.until(ExpectedConditions.visibilityOf(result));		
	}
	
	public String getValueFromResult() {
		String s = result.getText().split("is")[1].trim().substring(0);
		return s;
	}

}
