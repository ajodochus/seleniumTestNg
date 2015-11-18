package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import pages.HomePage;
import pages.LoginPage;

public class UserLoginTests extends AbstractPage {

	@Parameters({ "browser", "pageEntryPoint" })
	@BeforeClass
	public static void setUpBeforeClass(String browser, String pageEntryPoint)
			throws Exception {
		driver = getDriver(browser);
		baseUrl = getUrl(pageEntryPoint);
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void before() {

		driver.get(baseUrl);
	}

	@AfterClass
	public static void afterAllIsSaidAndDone() {
		driver.quit();
	}

	@AfterMethod
	public void after() {
		driver.manage().deleteAllCookies();
	}

	@Test
	public void testLogin() throws Exception {

		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.loginAs("admin", "admin");
		AssertJUnit.assertEquals("Basic Settings",
				homePage.getHomePageWelcomeMessage());

	}

	@Test
	public void testFailedLogin() throws Exception {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.failLoginAs("nobody", "WRONG");
		AssertJUnit
				.assertTrue(loginPage
						.getErrorMessage()
						.contains(
								"Username and password do not match or you do not have an account yet."));
	}

	@Test
	public void testLogoutViaLink() throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.loginAs("admin", "admin");
		AssertJUnit.assertEquals("Basic Settings",
				homePage.getHomePageWelcomeMessage());
		LoginPage loginPageLoggedOut = homePage.executeLogout();
		AssertJUnit.assertEquals("User Name *",
				loginPageLoggedOut.getLoginPageTitle());

	}

}
