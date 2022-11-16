package us.littleguys.testestimator.CustomerPageTest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import us.littleguy.testestimator.pages.CustomerPage;
import us.littleguy.testestimator.pages.LGMJobsPage;
import us.littleguys.testestimator.base.TestUtilities;

public class AddCustomer extends TestUtilities {

	
	@Parameters({ "firstname" ,"lastname","phone","email"})
	@Test(priority = 0)
	public void AddCustomer(String firstname, String lastname, String phoneNo, String email)  {
				
		LGMJobsPage jobpage = new LGMJobsPage(driver, log);
		
		CustomerPage customer = jobpage.ClickOnCustomerOption();
		sleep(20);
		customer.ClickOnAddIcon();
		sleep(10);
		//Assert.assertTrue(jobpage.isPopupTitleVisible(), "title is not visible.");
		customer.addCustomer(firstname, lastname, phoneNo, email);
		sleep(50);
		String message = customer.getPositiveMessage();
		// Verification
		Assert.assertTrue(message.contains("Customer Data is Updated"), "Message doesn't contain expected text.");
		//Assert.assertTrue(jobpage.isPopupTitleVisible(), "title is not visible.");
	}
	
	@Parameters({ "firstname" ,"lastname","phone","email"})
	@Test(priority = 1)
	public void AddCustomerWithSameData(String firstname, String lastname, String phoneNo, String email)  {
		
		LGMJobsPage jobpage = new LGMJobsPage(driver, log);
		
		CustomerPage customer = jobpage.ClickOnCustomerOption();
		sleep(20);
		customer.ClickOnAddIcon();
		sleep(10);
		//Assert.assertTrue(jobpage.isPopupTitleVisible(), "title is not visible.");
		customer.addCustomer(firstname, lastname, phoneNo, email);
		sleep(50);
		String message = customer.getNegativeMessage();
		// Verification
		Assert.assertTrue(message.contains("Customer already exists"), "Message doesn't contain expected text.");
		//Assert.assertTrue(jobpage.isPopupTitleVisible(), "title is not visible.");
	}
		

}
