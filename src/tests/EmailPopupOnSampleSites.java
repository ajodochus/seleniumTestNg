package tests;

import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver; 

import pages.CapabilitiesPool;
import pages.PopUpEmail;
import pages.SampleSites;


public class EmailPopupOnSampleSites {  
    
 
	private static RemoteWebDriver driver;
    private  static String host = "http://" + CapabilitiesPool.getUrlLocalhost() + "/joomla/index.php/sample-sites";  
    
	@Parameters({"browser"})
	@BeforeClass
	public static void setUpBeforeClass(String browser) throws Exception {
		if (browser.equalsIgnoreCase("android")){
			driver = new AndroidDriver();	
		} else {
			DesiredCapabilities capability = CapabilitiesPool.getDesiredCapabilities(browser);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);	
			driver.manage().window().maximize();
		}					
	}
	
    
    @BeforeMethod
	public void before() {  
        driver.get(host);  
    }  
  
     @AfterClass public static void afterAllIsSaidAndDone() {  
        // driver.quit();  
     }  
  
   @AfterMethod
	public void after() {      
        driver.manage().deleteAllCookies();  
    }  
  

  
    @Test  
    public void testLogin() throws Exception {  
    	
    	SampleSites sampleSites = new SampleSites(driver);
        sampleSites.ClickSendEmail(); 
        String mwh=driver.getWindowHandle();
        PopUpEmail windowHandle = new PopUpEmail(driver, mwh);
        windowHandle.fillNameAndCancel(mwh); //switches back from popup to sample_sites window
        //System.out.println("sitename: " + driver.getCurrentUrl());
        sampleSites.ClickSendEmail(); 
  
    }  	
  

}  
