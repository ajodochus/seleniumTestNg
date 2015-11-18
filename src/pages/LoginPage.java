package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;

import tests.AbstractPage;
import static java.util.concurrent.TimeUnit.SECONDS;



public class LoginPage extends AbstractPage {  
      

	
        private final WebDriver driver;  
      
        public LoginPage(WebDriver driver) {  
            super();  
            this.driver = driver;  
      
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver) 
               .withTimeout(30, SECONDS)  
               .pollingEvery(2, SECONDS);  
      
             wait.until(ExpectedConditions.titleIs("Login"));  
        }  
      
        //
        // REGISTRATIN ACTION
        //
        
        public RegistrationPage gotoRegistrationPage(){
        	executeGotoRegistrationPage();
        	return new RegistrationPage(driver);
        }
        
        private void executeGotoRegistrationPage (){
        	
        	driver.findElement(By.xpath(".//*[@id='content']/div[3]/ul/li[3]/a")).click();
        
        }
        
        //
        // LOGIN ACTION
        //
        public HomePage loginAs(String username, String password) {  
            
            executeLogin(username, password);  
            return new HomePage(driver);  
        } 
      
        public void failLoginAs(String username, String password) {  
            executeLogin(username, password);  
        }  
      
        private void executeLogin(String username, String password) {  
      
            driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(username);  
            driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(password);  
            driver.findElement(By.xpath(".//*[@id='content']/div[2]/form/fieldset/div[3]/div/button")).submit();  
        }  
      
        public String getErrorMessage() {  
      
            return driver.findElement(By.xpath(".//*[@id='system-message']/div/div/p")).getText();  
        }  
        


	public String getLoginPageTitle() {
		// TODO Auto-generated method stub
		return driver.findElement(By.xpath(".//*[@id='username-lbl']")).getText();  
	}
 
      
    }  