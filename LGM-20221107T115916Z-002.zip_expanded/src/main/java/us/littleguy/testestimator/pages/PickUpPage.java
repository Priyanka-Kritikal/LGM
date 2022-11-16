package us.littleguy.testestimator.pages;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PickUpPage extends BasePageObject{
	
	private By Pickup1 = By.xpath("//li[text()='1. Pickup 1']");
	private By AddressName = By.id("address-name");
	private By PropertyName = By.name("propertyType");
	private By DefaultFloor = By.id("default-floor");
	private By Haselevator = By.className("input-helper");
	private By WalkDistance = By.id("walkDistance");
	private By State = By.name("state");
	private By City = By.name("city");
	private By Miles = By.name("miles");
	private By Roomname= By.id("room-name");
	private By Roomfloor= By.id("room-floor");
	private By Additem = By.xpath("//*[@id=\"root\"]/div/div/div/div/div[3]/div[2]/div/div[2]/div/div/div/div/div[2]/div[3]/div[3]/div/ul/li[1]/i");
	private By SelectItem= By.xpath("/html/body/div[1]/div/div/div/div/div[3]/div[2]/div/div[2]/div/div/div/div/div[2]/div[3]/div[3]/div/div/div/table/tbody/tr[1]/td[2]/div/div/div/div/input");
	private By NextBtn = By.xpath("//button[text()='Next']");
	private By ChooseItem = By.xpath("//h4[text()='Choose Item']");
	private By AddCustomeItem = By.xpath("//html/body/div[1]/div/div/div/div/div[3]/div[2]/div/div[2]/div/div/div/div/div[2]/div[3]/div[3]/div/ul/li[2]/i");
	private By ItemName = By.id("itemName-0-0");
	private By AddSpecialOrder = By.xpath("//*[@id=\"root\"]/div/div/div/div/div[3]/div[2]/div/div[2]/div/div/div/div/div[2]/div[3]/div[4]/div/ul/li[3]/i");
	private By SelectItem2 = By.xpath("/html/body/div[1]/div/div/div/div/div[3]/div[2]/div/div[2]/div/div/div/div/div[2]/div[3]/div[3]/div/div/div/table/tbody/tr[3]/td[2]/div/div/div/div/input");
	private By AddCustome = By.xpath("/html/body/div[1]/div/div/div/div/div[3]/div[2]/div/div[2]/div/div/div/div/div[2]/div[3]/div[4]/div/ul/li[4]/i");
	private By ItemName1 = By.id("itemName-0-1");
	private By Numcrew = By.name("numCrew");
	private By gmail = By.xpath("/html/body/div[1]/div/div/div/div/div[3]/div[2]/div/div[2]/div/div/div[1]/div[2]/div[1]/div/div/div/div/div/div");
	private By SubjectName = By.name("subject");
	private By Perpoint1 = By.xpath("/html/body/div[1]/div/div/div/div/div[3]/div[2]/div/div[2]/div/div/div/div/div[2]/div[3]/div[3]/div/div/div/table/tbody/tr[1]/td[6]/div/input");
	private By Perpoint2 = By.xpath("/html/body/div[1]/div/div/div/div/div[3]/div[2]/div/div[2]/div/div/div/div/div[2]/div[3]/div[3]/div/div/div/table/tbody/tr[2]/td[6]/div/input");
	private By BasicConfig = By.xpath("//span[text()=\"Basic configuration \"]");
	private By JobStatus = By.xpath("//span[text()='Job Status:']");
	private By EmailHistory = By.xpath("//h4[text()='Email History']");
	private By inputhelper = By.xpath("/html/body/div[5]/div/div/div[1]/div/div[1]/div/label/input");
	private By closeBtn = By.xpath("/html/body/div[5]/div/div/div[2]/button");
	private By SaveBtn = By.xpath("//button[text()='Save']");
	private By Newwindow = By.xpath("//h3[text()='Related Items Armoire']");
	private By JobConfiramtionMsg = By.cssSelector(".Toastify__toast.Toastify__toast--success > div[role='alert']");
	private By relatedItem = By.xpath("//button[text()='Related Item']");
	private By Mail = By.xpath("/html/body/div[1]/div/div/div/div/div[3]/div[2]/div/div[2]/div/div/div[1]/div[4]/div/div/div/div[2]/div[1]");
	public PickUpPage(WebDriver driver, Logger log)  {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}
	
	public void ClickOnPickUp()
	{
		click(Pickup1);
	}
	public void TypeDetails(String Address ,String RoomName)
	{
		type(Address , AddressName);
		type(RoomName , Roomname);
		
	}
	
	public void SelectFromList()
	{
		WebElement dropdownElement1 = find(PropertyName);
		Select sel = new Select(dropdownElement1);
		sel.selectByIndex(1);
		WebElement dropdownElement2 = find(DefaultFloor);
		sel = new Select(dropdownElement2);
		sel.selectByIndex(1);
		WebElement dropdownElement3 = find(WalkDistance);
		sel = new Select(dropdownElement3);
		sel.selectByIndex(1);
		WebElement dropdownElement4 = find(State);
		sel = new Select(dropdownElement4);
		sel.selectByIndex(1);
		WebElement ele1 = find(City);
		ele1.sendKeys("Denton");
		pressKeyWithActions(Keys.ARROW_DOWN);
		WebElement dropdownElement6 = find(Roomfloor);
		sel = new Select(dropdownElement6);
		sel.selectByIndex(1);
		
		
		
	}
	public void ClickAddItem()
	{
		//click(Additem);
		click(AddCustomeItem);
		//click(AddSpecialOrder);
		click(AddCustome);
	}
	
	public boolean IsItemAdded()
	{
		waitForVisibilityOf(ChooseItem,Duration.ofSeconds(10));
		return find(ChooseItem).isDisplayed();
	}
	
	public void Selectitem()
	{
		WebElement ele1 = find(SelectItem);
		ele1.sendKeys("Armoire");
		pressKeyWithActions(Keys.ARROW_DOWN);
		pressKeyWithActions(Keys.ENTER);
		click(relatedItem);
		switchToWindowWithTitle("Related Items Armoire");
		switchToAlert();
		/*WebElement Ele2 = find(SelectItem2);
	    Ele2.sendKeys("Hot");
	    pressKeyWithActions(Keys.ARROW_DOWN);
	    pressKeyWithActions(Keys.ENTER);
	    switchToAlert();*/
	   click(inputhelper);
	   click(closeBtn);
		
	}
	public void WriteItemname(String s1 , String s2)
	{
		type(s1 ,ItemName);
		type(s2 , ItemName1);
	}
	public void Typeitem()
	{
		type("2" , Perpoint1);
		type("2" , Perpoint2);
	}
	
	public boolean IsBasicConfigVisible()
	{
		waitForVisibilityOf(BasicConfig,Duration.ofSeconds(10));
		return find(BasicConfig).isDisplayed();
	}
	public boolean IsJobStatusVisible()
	{
		waitForVisibilityOf(JobStatus,Duration.ofSeconds(10));
		return find(JobStatus).isDisplayed();
	}
	public boolean IsEmailHistory()
	{
		waitForVisibilityOf(EmailHistory,Duration.ofSeconds(10));
		return find(EmailHistory).isDisplayed();
	}
	public void writeEmail(String Gmail ,String mailSubject)
	{click(gmail);
		type(Gmail , gmail);
		pressKeyWithActions(Keys.ARROW_DOWN);
		pressKeyWithActions(Keys.ENTER);
		click(Mail);
		type (mailSubject ,SubjectName);
	}
	public void clickSaveBtn()
	{
		click(SaveBtn);
	}
	public String IsJobAddedSuccefullAlert()
	{
		waitForVisibilityOf(JobConfiramtionMsg,Duration.ofSeconds(10));
		return driver.findElement(JobConfiramtionMsg).getText();
	}
	public void clickNextBtn()
	{
		click(NextBtn);
	}
	
}
