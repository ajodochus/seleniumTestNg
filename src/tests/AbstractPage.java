package tests;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.CapabilitiesPool;

public class AbstractPage {

	// static RemoteWebDriver driver;
	public static RemoteWebDriver driver;
	public static String baseUrl = "";

	public static String getUrl(String pageEntryPoint) {
		String baseUrl = "http://" + CapabilitiesPool.getUrlLocalhost() + pageEntryPoint;
		return baseUrl;
	}

	public static RemoteWebDriver getDriver(String systemAndBrowser) {

		DesiredCapabilities capability = CapabilitiesPool
				.getDesiredCapabilities(systemAndBrowser);
		try {
			driver = new RemoteWebDriver(
					new URL("http://localhost:4444/wd/hub"), capability);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;

	}

}
