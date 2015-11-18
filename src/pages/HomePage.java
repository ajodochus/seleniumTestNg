package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;

import static java.util.concurrent.TimeUnit.SECONDS;


public class HomePage {  
	
    /*private final static Logger logger = LoggerFactory  
    .getLogger(HomePage.class);  */
    
    private final WebDriver driver;  
    public HomePage(WebDriver driver) {  
        super();  
        this.driver = driver;  
  
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)  
           .withTimeout(30, SECONDS)  
           .pollingEvery(2, SECONDS);  
  
         wait.until(ExpectedConditions.titleIs("User Profile"));  
  
    }  
    
    public LoginPage executeLogout() {  
        
        executeLogoutViaLink();
        return new LoginPage(driver);  
    } 
    
    private void executeLogoutViaLink()  {
    	
    	driver.findElement(By.xpath(".//*[@id='login-form']/div[2]/input[1]")).submit();
    }
  
    public String getHomePageWelcomeMessage() throws Exception{  
  
        return driver.findElement(By.xpath(".//*[@id='users-profile-custom']/legend")).getText();  
  
    }  
  
}  