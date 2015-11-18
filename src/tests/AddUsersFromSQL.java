package tests;

import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import pages.LoginPage;
import pages.RegistrationPage;
import pages.CapabilitiesPool;

public class AddUsersFromSQL {

	private static RemoteWebDriver driver;
	private static String host = "http://" + CapabilitiesPool.getUrlLocalhost() + "/joomla/index.php/login";

	@Parameters({ "browser" })
	@BeforeClass
	public static void setUpBeforeClass(String browser) throws Exception {
		if (browser.equalsIgnoreCase("android")) {
			driver = new AndroidDriver();
		} else {
			DesiredCapabilities capability = CapabilitiesPool
					.getDesiredCapabilities(browser);
			driver = new RemoteWebDriver(
					new URL("http://localhost:4444/wd/hub"), capability);
			driver.manage().window().maximize();
		}
	}

	@BeforeMethod
	public void before() {
		driver.get(host);
	}

	@AfterClass
	public static void afterAllIsSaidAndDone() {
		driver.quit();
	}

	@AfterMethod
	public void after() {
		driver.manage().deleteAllCookies();
	}

	@Test(dataProvider = "MySQL-provider", dataProviderClass = database.MySqlQueries.class)
	public void testAddUsersFromSQL(String count, String userName, String name,
			String password, String passwordConfirm, String email,
			String emailConfirm) throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		RegistrationPage registrationPage = loginPage.gotoRegistrationPage();
		RegistrationPage registrationPageAgain = registrationPage
				.fillRegistration(userName, name, password, passwordConfirm,
						email, emailConfirm);
		//
		AssertJUnit
				.assertEquals(
						"Your account has been created and an activation link has been sent to the email address you entered. Note that you must activate the account by clicking on the activation link when you get the email before you can login.",
						registrationPageAgain.getErrorMessageActivateAccout());
	}

}
