package pages;

import static java.util.concurrent.TimeUnit.SECONDS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class AdminHomePage {
    private final WebDriver driver;  
    
    public AdminHomePage(WebDriver driver) {  
        super();  
        this.driver = driver;  
  
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver) 
           .withTimeout(30, SECONDS)  
           .pollingEvery(2, SECONDS);  
  
         wait.until(ExpectedConditions.titleIs("selenium_tests - Administration - Control Panel"));  
    }
    
    public AdminUserManagerPage linkToUserAccounts(){
    	driver.findElement(By.partialLinkText("User Manager")).click();
    	return new AdminUserManagerPage(driver);
    }
}
