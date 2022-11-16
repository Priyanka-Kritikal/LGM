package us.littleguys.testestimator.CreateTicket;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import us.littleguys.testestimator.base.TestUtilities;
import us.littleguy.testestimator.pages.LGMJobsPage;

public class CreateTicket extends TestUtilities {
	
	@Parameters({ "email" ,"Subject","Name","Description","dropdownvalue"})
	@Test
	public void createticket(String email, String subject, String name, String description, int dropdownvalue) {
				
		LGMJobsPage jobpage = new LGMJobsPage(driver, log);
		
		jobpage.ClickOnTicketButton();
		sleep(20);
		//Assert.assertTrue(jobpage.isPopupTitleVisible(), "title is not visible.");
		jobpage.createTicket(email, subject, name, description, dropdownvalue);
		//CreateTicketPopup ticketpopup = jobpage.ClickOnTicketButton();
		//sleep(10);
		//ticketpopup.createTicket(email, subject, name, description, dropdownvalue);
	}
		
	}


