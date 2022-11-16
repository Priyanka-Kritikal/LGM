package us.littleguy.testestimator.pages;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerPage extends BasePageObject {

	private String pageUrl = "https://testestimator.littleguys.us/Contacts";
	private By AddIcon = By.xpath("/html//div[@id='root']/div[@class='container-scroller']/div[@class='container-fluid page-body-wrapper']//div[@class='contectList-inner']/div/div/ul/li[@title='Add New Customer']/a[@href='/addContact']/i[@class='mdi mdi-plus']");
	private By firstname = By.xpath("/html//input[@id='firstName']");
	private By lastname = By.xpath("/html//input[@id='lastName']");
	private By email = By.xpath("/html//input[@id='email']");
	private By phone = By.xpath("/html//input[@id='mainPhone']");
	private By save = By.xpath("/html//div[@id='root']/div[@class='container-scroller']/div[@class='container-fluid page-body-wrapper']/div/div[@class='content-wrapper p-0']//button[@title='Save']");
	private By negativeMessage = By.xpath("/html//div[@id='root']/div[@class='container-scroller']//div[@class='Toastify__toast Toastify__toast--error']/div[@role='alert']");
	private By positiveMessage = By.xpath("/html//div[@id='root']/div[@class='container-scroller']//div[@class='Toastify__toast Toastify__toast--success']/div[@role='alert']");
	
	public CustomerPage(WebDriver driver, Logger log)  {
		super(driver, log);
	}
	
	public void ClickOnAddIcon() {
		log.info("Clicking on add icon");
		click(AddIcon);
	}
	
	public String getPositiveMessage() {
		waitForVisibilityOf(positiveMessage,Duration.ofSeconds(10));
		return driver.findElement(positiveMessage).getText();
	}
	public String getNegativeMessage() {
		waitForVisibilityOf(negativeMessage,Duration.ofSeconds(10));
		return driver.findElement(negativeMessage).getText();
	}
	public void addCustomer(String Firstname, String Lastname,String PhoneNo,String Email)  {
		log.info("Adding details and clicking on save button");
		type(Firstname, firstname);
		type(Lastname, lastname);
		type(PhoneNo, phone);
		type(Email, email);
		click(save);
	}
}
