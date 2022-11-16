package us.littleguys.testestimator.AddJob;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import us.littleguys.testestimator.base.TestUtilities;
import us.littleguy.testestimator.pages.AddJobPage;
import us.littleguy.testestimator.pages.EstimatorLoginPage;
import us.littleguy.testestimator.pages.LGMJobsPage;

public class AddJob extends TestUtilities  {
	
	@Test
	@Parameters({ "firstname" ,"lastname", "PhoneNo", "email"})
	public void AddJob(String firstname, String lastname, String PhoneNo, String email) {
		
		LGMJobsPage jobpage = new LGMJobsPage(driver, log);
		AddJobPage addjob = jobpage.createjob();
		sleep(10);
	
		// Verifications
		// New page url is expected
		Assert.assertEquals(addjob.getCurrentUrl(), addjob.getPageUrl());
		
		addjob.Search(firstname, lastname, PhoneNo, email);
		sleep(100);
		Assert.assertTrue(addjob.isNotFoundCustomerMsgDisplayed(), "Customer is available");
		//String actualText = driver.findElement(By.xpath("//p[@class='font-italic']")).getText();
		//String expectedText = "Did not find any Customer!";
		//String actualText = addjob.SearchedMessage();
		//Assert.assert(actualText,expectedText);
		//Assert.assertTrue(actualText.contains("Did not find any Customer!"), "Message doesn't contain expected text.");
		addjob.ClickOnSave();
		String message = addjob.getConfirmationMessage();
		// Verification
		Assert.assertTrue(message.contains("Job Info Added Successfully!"), "Message doesn't contain expected text.");
	
	}
}
