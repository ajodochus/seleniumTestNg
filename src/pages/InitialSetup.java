package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InitialSetup {
    private final WebDriver driver;  
    
    public InitialSetup(WebDriver driver) {  
        super();  
        this.driver = driver;  
 
    }
    
    
    public  AdminHomePage loginAsAdmin(String user, String password){
    	driver.findElement(By.xpath(".//*[@id='mod-login-username']")).sendKeys(user);
    	driver.findElement(By.xpath(".//*[@id='mod-login-password']")).sendKeys(password);
    	driver.findElement(By.xpath(".//*[@id='form-login']/fieldset/div[3]/div/div/button")).click();;
    	return new AdminHomePage(driver);
    }
}
