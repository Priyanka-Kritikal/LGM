package us.littleguys.testestimator.EmailTemplates;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import us.littleguy.testestimator.pages.CustomerPage;
import us.littleguy.testestimator.pages.EmailTemplatesPage;
import us.littleguy.testestimator.pages.LGMJobsPage;
import us.littleguys.testestimator.base.TestUtilities;

public class CreateEmailTemplate extends TestUtilities{

	@Parameters({ "templateName" ,"templateSubject"})
	@Test(priority = 0)
	public void AddEmailTemplate(String templateName, String templateSubject)  {
				
		LGMJobsPage jobpage = new LGMJobsPage(driver, log);
		
		EmailTemplatesPage emailtemplate = jobpage.ClickOnEmailTemplatesOption();
		sleep(20);
		emailtemplate.ClickOnAddNewTemplate();
		//Verifying page title is visible
		Assert.assertTrue(jobpage.isTitleVisible(), "title is not visible.");
		
		emailtemplate.addEmailTemplate(templateName,templateSubject);
		String message = emailtemplate.getMessage();
		// Verification
		Assert.assertTrue(message.contains("Email Template Updated Successfully"), "Message doesn't contain expected text.");
	}
	

}
