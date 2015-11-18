package android;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



// -------------------------- setup android emulator
//
// cmd to adb platform tools in: C:\Users\Admin\AppData\Local\Android\android-sdk
//
// install webdriver apk
// adb -s emulator-5554 -e install -r "C:\Users\Admin\Downloads\android-server-2.32.0.apk"
//
// port forward for tests:
// adb -s emulator-5554 forward tcp:8080 tcp:8080

public class ConnectAndroid {
	
	private static AndroidDriver driver;
	@Parameters({"browser"})
	@BeforeClass
	public static void setUpBeforeClass(String browser) throws Exception {
	
			
		if (browser.equalsIgnoreCase("android")){
			System.out.println("browservar: " + browser);
		}
		 driver = new AndroidDriver();
	
	}
	
    //private  static String host = "http://192.168.179.58/joomla";  
  
    @AfterMethod
    public void quitDriver(){
    	  driver.quit();
    }
 
    @Test
    public void callBrowser(){
    	driver.get("http://www.google.com");
    }
    @Test  
    public void testLogin() throws Exception {  

         
        
        
        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));
        
        // Enter something to search for
        element.sendKeys("Cheese!");
        
        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
        
        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
      

  
    }
}
