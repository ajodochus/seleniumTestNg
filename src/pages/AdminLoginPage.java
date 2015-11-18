package pages;

import static java.util.concurrent.TimeUnit.SECONDS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class AdminLoginPage {
    private final WebDriver driver;  
    
    public AdminLoginPage(WebDriver driver) {  
        super();  
        this.driver = driver;  
  
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver) 
           .withTimeout(30, SECONDS)  
           .pollingEvery(2, SECONDS);  
  
         wait.until(ExpectedConditions.titleIs("selenium_tests - Administration"));  
    }
    
    
    public  AdminHomePage loginAsAdmin(String user, String password){
    	driver.findElement(By.xpath(".//*[@id='mod-login-username']")).sendKeys(user);
    	driver.findElement(By.xpath(".//*[@id='mod-login-password']")).sendKeys(password);
    	driver.findElement(By.xpath(".//*[@id='form-login']/fieldset/div[3]/div/div/button")).click();;
    	return new AdminHomePage(driver);
    }
}
