package us.littleguy.testestimator.pages;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddJobPage extends BasePageObject {
	
	private String pageUrl = "https://testestimator.littleguys.us/JobAdd";
	private By firstName = By.id("firstName");
	private By lastName = By.id("lastName");
	private By mainPhone = By.id("mainPhone");
	private By Email = By.id("email");
	private By MoveTypedropdown = By.id("moveType");
	private By searchButton = By.xpath("/html//div[@id='root']/div[@class='container-scroller']/div[@class='container-fluid page-body-wrapper']/div/div[@class='content-wrapper p-0']/div[@class='h-100']//button[@title='Search']");
	private By NoDataMessage = By.xpath("//p[@class='font-italic']");
	private By saveButton = By.xpath("/html//div[@id='root']/div[@class='container-scroller']/div[@class='container-fluid page-body-wrapper']//button[.=' Save ']");
	private By AddJobConfiramtionMsg = By.cssSelector(".Toastify__toast.Toastify__toast--success > div[role='alert']");
	private By nextButton = By.xpath("/html//div[@id='root']/div[@class='container-scroller']/div[@class='container-fluid page-body-wrapper']//button[.=' Next ']");
	private By pickup1Header = By.xpath("/html//div[@id='root']/div[@class='container-scroller']/div[@class='container-fluid page-body-wrapper']/div/div[@class='content-wrapper p-0']/div[@class='h-100']//div[@class='address-nav']/ul/li[1]");
	private By addressName = By.xpath("/html//input[@id='address-name']");
	private By address = By.xpath("/html//input[@id='completeAddress']");
	private By street = By.xpath("/html//input[@id='street-add-0']");
	private By roomName = By.xpath("/html//input[@id='room-name']");
	private By PUFloor = By.xpath("/html//select[@id='room-floor']");
	private By DOFloor = By.xpath("/html//div[@id='root']/div[@class='container-scroller']/div[@class='container-fluid page-body-wrapper']/div/div[@class='content-wrapper p-0']/div[@class='h-100']/div[@class='container-fluid job-container-fluid']/div[@class='row']/div[@class='job-address-wrap']/div[@class='job-address-wrap-scroll']/div/div[@class='col-md-12']/div[@class='row']/div[2]/div[3]/div[2]/form[@class='w-100']//select[@name='doFloor']");
	private By AddRoomIcon = By.xpath("/html//div[@id='root']/div[@class='container-scroller']/div[@class='container-fluid page-body-wrapper']/div/div[@class='content-wrapper p-0']/div[@class='h-100']/div[@class='container-fluid job-container-fluid']//i[@title='Add Room']");
	private By Room2Header = By.xpath("/html//div[@id='root']/div[@class='container-scroller']/div[@class='container-fluid page-body-wrapper']/div/div[@class='content-wrapper p-0']/div[@class='h-100']/div[@class='container-fluid job-container-fluid']//div[@class='room-nav']/ul/li[2]");
	private By addItem = By.xpath("/html//div[@id='root']/div[@class='container-scroller']/div[@class='container-fluid page-body-wrapper']/div/div[@class='content-wrapper p-0']/div[@class='h-100']/div[@class='container-fluid job-container-fluid']/div[@class='row']//div[@class='address-column pb-5']/div[@class='col-md-12']/div[@class='row']/div[2]/div[3]/div[3]/div[@class='room-detail-nav']/ul//i[@title='Add item']");
	private By addCustomItem = By.xpath("/html//div[@id='root']/div[@class='container-scroller']/div[@class='container-fluid page-body-wrapper']/div/div[@class='content-wrapper p-0']/div[@class='h-100']/div[@class='container-fluid job-container-fluid']/div[@class='row']//div[@class='address-column pb-5']/div[@class='col-md-12']/div[@class='row']/div[2]/div[3]/div[3]/div[@class='room-detail-nav']/ul//i[@title='Add Custom Item']");
	private By Firstname2 =By.xpath("//th[text()='First Name']");

	public AddJobPage(WebDriver driver, Logger log)  {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}
	
	/** Get URL variable from PageObject */
	public String getPageUrl() {
		return pageUrl;
	}
	
	public boolean isPickupTitleVisible() {
		waitForVisibilityOf(pickup1Header,Duration.ofSeconds(10));
		return find(pickup1Header).isDisplayed();
	}

	public boolean isNotFoundCustomerMsgDisplayed() {
		waitForPresenceOf(NoDataMessage,Duration.ofSeconds(10));
		return find(NoDataMessage).isDisplayed();
	}

	public boolean IsEnteredDataFound()
	{
		
		return find(Firstname2).isDisplayed() ;
		
		//System.out.println("Customer exists");
			
		
	}
	
	

	/** This method selects given option from dropdown */
	public void selectOption(int i) {
		log.info("Selecting option " + i + " from dropdown");
		WebElement dropdownElement = find(MoveTypedropdown);
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
		WebElement dropdownElement = find(MoveTypedropdown);
		Select dropdown = new Select(dropdownElement);
		String selectedOption = dropdown.getFirstSelectedOption().getText();
		log.info(selectedOption + " is selected in dropdown");
		return selectedOption;
	}
	
	public  void selectFirstOption() {
		WebElement dropdownElement = find(MoveTypedropdown);
		Select dropdown = new Select(dropdownElement);
		String selectedOption = dropdown.getFirstSelectedOption().getText();
		log.info(selectedOption + " is selected in dropdown");
	}

	public void Search(String firstname, String lastname, String PhoneNo, String email ) {
		log.info("Adding details and clicking on search button");
		type(firstname, firstName);
		type(lastname, lastName);
		type(PhoneNo, mainPhone);
		type(email, Email);
		scrollToBottom();
		//selectFirstOption();
		click(searchButton);
		
	}
	
	
	public String SearchedMessage() {
		scrollToBottom();
		WebElement message = find(NoDataMessage);
		String SearchedMessage = message.getText();
		log.info(SearchedMessage + " is selected in dropdown");
		return SearchedMessage;
	}
	
	public void ClickOnSave() {
		click(saveButton);
	}
	public boolean IsSaveBtnVisible()
	{
		boolean b =find(saveButton).isDisplayed();
		return b;
	}
	
	public void ClickOnNext() {
		log.info("Clicking on next button");
		click(nextButton);
	}
	
	public String getConfirmationMessage() {
		waitForVisibilityOf(AddJobConfiramtionMsg,Duration.ofSeconds(10));
		return driver.findElement(AddJobConfiramtionMsg).getText();
	}
}
