package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class RegistrationPage {
	
	private final WebDriver driver;
	
	public RegistrationPage (WebDriver driver){
		
		super();
		this.driver = driver;
		Wait <WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, SECONDS)
				.pollingEvery(2, SECONDS);
		wait.until(ExpectedConditions.titleIs("Registration Form"));
	}
	
	
	public RegistrationPage fillRegistration(String name, String user_name, String password, String password_confirm,  String email, String email_confirm){
		executeFillRegistration(name, user_name, password, password_confirm, email, email_confirm);
		return new RegistrationPage (driver);
		
	}
	
	public void executeFillRegistration (String name, String user_name, String password, String password_confirm,  String email, String email_confirm){
		driver.findElement(By.xpath(".//*[@id='jform_name']")).sendKeys(name);
		driver.findElement(By.xpath(".//*[@id='jform_username']")).sendKeys(user_name);
		driver.findElement(By.xpath(".//*[@id='jform_password2']")).sendKeys(password);
		driver.findElement(By.xpath(".//*[@id='jform_password1']")).sendKeys(password_confirm);
		driver.findElement(By.xpath(".//*[@id='jform_email1']")).sendKeys(email);
		driver.findElement(By.xpath(".//*[@id='jform_email2']")).sendKeys(email_confirm);
		//
		driver.findElement(By.xpath(".//*[@id='member-registration']/div/button")).submit();
		
	}
	
	
	
	
	public String getErrorMessageActivateAccout(){
		
		return driver.findElement(By.xpath(".//*[@id='system-message']/div/div/p")).getText();
	}
	
	public String getRegistrationPageTitle(){
		return driver.findElement(By.tagName("title")).getText();
	}
	
}

