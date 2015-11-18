package pages;



import java.net.InetAddress;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;


public class CapabilitiesPool {
	
	public static DesiredCapabilities getDesiredCapabilities (String environment) {
		
		DesiredCapabilities capability = null;
		
		if (environment.equalsIgnoreCase("FF_LocalHost_W7")){
			capability = DesiredCapabilities.firefox();
			capability.setJavascriptEnabled(true);
			capability.setBrowserName("firefox");
			capability.setVersion("FF_LocalHost_W7");
			capability.setPlatform(Platform.WINDOWS);	
			
		}
		else if (environment.equalsIgnoreCase("CHROME_LocalHost_W7")){
			
			capability = DesiredCapabilities.chrome();
			capability.setJavascriptEnabled(true);
			capability.setBrowserName("chrome");
			capability.setVersion("CHROME_LocalHost_W7");
			capability.setPlatform(Platform.WINDOWS);	
			
		}
		else if (environment.equalsIgnoreCase("IE_LocalHost_W7")){
			
			capability = DesiredCapabilities.internetExplorer();
			capability.setJavascriptEnabled(true);
			capability.setBrowserName("internet explorer");
			capability.setVersion("IE_LocalHost_W7");
			capability.setPlatform(Platform.WINDOWS);	
			
			
		}
		
		
		return capability;
		
	}
	
	
	public static String getUrlLocalhost(){
		 String getOwnIp = null;
		 String baseUrl = null;
		  try{
			  InetAddress ownIP=InetAddress.getLocalHost();
			  getOwnIp = ownIP.getHostAddress();
			  System.out.println("IP of my system is := "+ownIP.getHostAddress());
			  baseUrl = getOwnIp + "/joomla/index.php/";
			  }catch (Exception e){
			  System.out.println("Exception caught ="+e.getMessage());
			 
			  }
		  return baseUrl;
	}
}
