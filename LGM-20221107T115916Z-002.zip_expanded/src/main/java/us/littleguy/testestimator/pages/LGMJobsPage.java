package us.littleguy.testestimator.pages;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LGMJobsPage extends BasePageObject {
	
	private String pageUrl = "https://testestimator.littleguys.us/Jobs";
	private By title = By.cssSelector(".roleNav-link");
	private By addJobIcon = By.cssSelector(".mdi.mdi-plus");
	private By createTicket = By.xpath("//div[@id='root']/div/nav//ul[@class='navbar-nav navbar-nav-right']//button[.=' Create Ticket ']");
	private By Customer = By.xpath("//nav[@id='sidebar']/ul[@class='nav']//a[@href='/Contacts']");
	private By emailTemplates = By.xpath("//nav[@id='sidebar']/ul[@class='nav']//a[@href='/Template']/span[@class='menu-title']");
	private By Popuptitle = By.cssSelector("/html//div[@id='root']/div[@class='container-scroller']/div[@class='container-fluid page-body-wrapper']//span[.='JOB LIST']");
	//private By Popuptitle = By.cssSelector("h3[title='Help & Support']");
	///html//div[@id='root']/div[@class='container-scroller']/div[@class='container-fluid page-body-wrapper']//span[.='JOB LIST']
	private By requester = By.xpath("/html//input[@id='helpdesk_ticket_email']");
	private By subject = By.id("helpdesk_ticket_subject");
	private By name = By.cssSelector("div#name_field > input[name='helpdesk_ticket[name]']");
	private By description = By.cssSelector(".redactor_editor > p");
	private By dropdown = By.id("helpdesk_ticket_custom_field_app_351995");
	private By submit = By.id("helpdesk_ticket_submit");
			
	public LGMJobsPage(WebDriver driver, Logger log)  {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}
	
	/** Get URL variable from PageObject */
	public String getPageUrl() {
		return pageUrl;
	}

	public boolean isPopupTitleVisible() {
		waitForVisibilityOf(Popuptitle,Duration.ofSeconds(10));
		return find(Popuptitle).isDisplayed();
	}
	
	public boolean isTitleVisible() {
		waitForVisibilityOf(title,Duration.ofSeconds(10));
		return find(title).isDisplayed();
	}
	
	public AddJobPage createjob() {
		log.info("Clicking on Add job(+) icon");
		click(addJobIcon);
		return new AddJobPage(driver, log);
	}

	public CreateTicketPopup ClickOnTicketButton() {
		//log.info("Clicking on create ticket button");
		click(createTicket);
		return new CreateTicketPopup(driver, log);
	}
	
	public CustomerPage ClickOnCustomerOption() {
		//log.info("Clicking on create ticket button");
		click(Customer);
		return new CustomerPage(driver, log);
	}
	
	
	public EmailTemplatesPage ClickOnEmailTemplatesOption() {
		//log.info("Clicking on create ticket button");
		click(emailTemplates);
		return new EmailTemplatesPage(driver, log);
	}
	
	
	public void selectOption(int i) {
		log.info("Selecting option " + i + " from dropdown");
		WebElement dropdownElement = find(dropdown);
		Select dropdown = new Select(dropdownElement);

		// There are three ways to use Select class
		// #1
		// dropdown.selectByIndex(i);

		// #2
		dropdown.selectByValue("" + i);

		// #3
		// dropdown.selectByVisibleText("Option " + i);
	}

	/** This method returns selected option in dropdown as a string */
	public String getSelectedOption() {
		WebElement dropdownElement = find(dropdown);
		Select dropdown = new Select(dropdownElement);
		String selectedOption = dropdown.getFirstSelectedOption().getText();
		log.info(selectedOption + " is selected in dropdown");
		return selectedOption;
	}
	
	public  void selectFirstOption() {
		WebElement dropdownElement = find(dropdown);
		Select dropdown = new Select(dropdownElement);
		String selectedOption = dropdown.getFirstSelectedOption().getText();
		log.info(selectedOption + " is selected in dropdown");
	}
	
	public void createTicket(String email,String Subject,String Name,String Description,int dropdownvalue) {
		
		log.info("Adding details and clicking on submit button");
		driver.switchTo().frame("freshwidget-embedded-form");
		click(requester);
		type(email, requester);
		type(Subject, subject);
		type(Name, name);
		type(Description, description);
		selectFirstOption(); 
		click(submit);
	}

	
	
}
