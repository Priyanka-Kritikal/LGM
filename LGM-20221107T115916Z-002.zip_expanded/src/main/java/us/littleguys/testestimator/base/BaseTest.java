package us.littleguys.testestimator.base;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import us.littleguy.testestimator.pages.EstimatorLoginPage;
import us.littleguy.testestimator.pages.LGMJobsPage;

@Listeners({ us.littleguys.testestimator.base.TestListener.class })
public class BaseTest {
	

	protected WebDriver driver;
	protected Logger log;
	
	
	protected String testSuiteName;
	protected String testName;
	protected String testMethodName;
	
	

	@Parameters({ "browser" })
	@BeforeMethod
	public void setUp(@Optional("chrome") String browser,ITestContext ctx) {
		String testName = ctx.getCurrentXmlTest().getName();
		//log = LogManager.getLogger(BaseTest.class);
		//String testName = ctx.getClass().getName();
		log = LogManager.getLogger(testName);

		BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
		driver = factory.createDriver();

		driver.manage().window().maximize();
		
		this.testSuiteName = ctx.getSuite().getName();
		this.testName = testName;
		//this.testMethodName = method.getName();
		
		
		
		EstimatorLoginPage loginpage = new EstimatorLoginPage(driver, log);
		loginpage.openPage();
		//sleep(10);
		//takeScreenshot("LoginPage opened");
		log.info("LoginPage opened");

		// execute log in
		LGMJobsPage jobpage = loginpage.logIn("sudhir.ssh@gmail.com","Shammu7193$");
		
		//takeScreenshot("Jobs opened");
		
		// log out button is visible
		Assert.assertTrue(jobpage.isTitleVisible(), "title is not visible.");

		
		// Verifications
		// New page url is expected
		Assert.assertEquals(jobpage.getCurrentUrl(), jobpage.getPageUrl());
		//call dataprovider
		

	}
	
	@AfterMethod
	public void tearDown() {
		log.info("Close driver");
		// Close browser
		driver.quit();
	}
	
	
	
}
