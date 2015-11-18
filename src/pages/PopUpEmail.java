package pages;


import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


public class PopUpEmail {
	
    private final WebDriver driver;  
    
    public PopUpEmail(WebDriver driver, String mwh) {  
    	super(); 
    	Set<String> s=driver.getWindowHandles();

		Iterator<String> ite=s.iterator();

		while(ite.hasNext())
		{
		    String popupHandle=ite.next().toString();
		    System.out.println("window_x: " + popupHandle);
		    if(!popupHandle.contains(mwh))
		    {
		               driver.switchTo().window(popupHandle);	 
		               break;
		    } 
		}
    
        this.driver = driver;         
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)  
                .withTimeout(30, SECONDS)  
                .pollingEvery(2, SECONDS);  
        	
              wait.until(ExpectedConditions.titleIs("selenium_tests"));  
 
    } 
	
	
	
	public void fillNameAndCancel(String mwh){
		driver.findElement(By.xpath(".//*[@id='mailto_field']")).sendKeys("hallo");	
		driver.findElement(By.xpath(".//*[@id='mailtoForm']/p/button[2]")).click();
		driver.switchTo().window(mwh);
	}

}
