package pages;

import static java.util.concurrent.TimeUnit.SECONDS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


public class AdminUserManagerPage {
	   private final WebDriver driver;  
	    
	    public AdminUserManagerPage(WebDriver driver) {  
	        super();  
	        this.driver = driver;  
	        
	        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver) 
	           .withTimeout(30, SECONDS)  
	           .pollingEvery(2, SECONDS);  
	        	
	        	
	         //wait.until(ExpectedConditions.titleIs("selenium_tests - Administration - User Manager: Users"));
	         wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[@name='checkall-toggle']")));
	       
	         
	    }
	    
	    public void checkAll(){
	    	
	    	driver.findElement(By.xpath(".//*[@id='j-main-container']/table/thead/tr/th[1]/input")).click();
	    }
	    
	    public void checkAdmin (){
	    	//exxampe for findElement combinations:
	    	//driver.findElement(By.partialLinkText("Super Admin")).findElement(By.xpath("parent::*")).findElement(By.xpath("parent::*")).findElement(By.xpath("td[1]/input")).click();
	    	//
	    	
	    	driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[*]/td[contains(text(), 'admin')]/../td[1]/input")).click();
	    	 
	    	
	    }
	    
	    public void deleteUser(){
	    	driver.findElement(By.xpath(".//*[@id='toolbar-delete']/button")).click();
	    }
}
