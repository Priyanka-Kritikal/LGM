package us.littleguys.testestimator.Loginpagetests;


import java.time.Duration;


import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import us.littleguys.testestimator.base.TestUtilities;
import us.littleguy.testestimator.pages.EstimatorLoginPage;
import us.littleguy.testestimator.pages.LGMJobsPage;


public class PositiveLoginTest extends TestUtilities {


	@Parameters({ "username" ,"password"})
	@Test(priority = 1)
	public void logInTest(String username, String password) {
		// open main page
				EstimatorLoginPage loginpage = new EstimatorLoginPage(driver, log);
				loginpage.openPage();
				//sleep(10);
				takeScreenshot("LoginPage opened");

				// execute log in
				LGMJobsPage jobpage = loginpage.logIn(username,password);
				
				takeScreenshot("Jobs opened");
				
				// log out button is visible
				Assert.assertTrue(jobpage.isTitleVisible(), "title is not visible.");

				
				
				// Verifications
				// New page url is expected
				Assert.assertEquals(jobpage.getCurrentUrl(), jobpage.getPageUrl());
				
				Assert.assertTrue(jobpage.isPopupTitleVisible(), "title is not visible.");

}
	
	
//	@Parameters({ "email" ,"Subject","Name","Description","dropdownvalue"})
//	@Test
//	public void createticket(String email, String subject, String name, String description, int dropdownvalue) {
//				
//		LGMJobsPage jobpage = new LGMJobsPage(driver, log);
//		jobpage.createTicket(email, subject, name, description, dropdownvalue);
//	}
	
	
}