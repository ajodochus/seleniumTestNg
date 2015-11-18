package pages;

import static java.util.concurrent.TimeUnit.SECONDS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class SampleSites {
    private final WebDriver driver;  
    public SampleSites(WebDriver driver) {  
        super();  
        this.driver = driver;  
  
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)  
           .withTimeout(30, SECONDS)  
           .pollingEvery(2, SECONDS);  
  
         wait.until(ExpectedConditions.titleIs("Sample Sites"));  
  
    } 
    
    public void ClickSendEmail(){
    	driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[2]/a")).click();
    	driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[2]/ul/li[2]/a")).click();
    }
    
    
}
