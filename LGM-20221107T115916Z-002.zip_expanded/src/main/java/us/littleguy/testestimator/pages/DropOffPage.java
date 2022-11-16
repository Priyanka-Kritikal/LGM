package us.littleguy.testestimator.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropOffPage extends BasePageObject{
	
	private By DropOff1 = By.xpath("//li[text()='2. Dropoff 1']");
	
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
	
	public DropOffPage(WebDriver driver, Logger log)  {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}
	
	public void ClickOnDropOff()
	{
		click(DropOff1);
	}
	public void TypeDropDetails(String DropAddress )
	{
		type(DropAddress , AddressName);
		//type(RoomName , Roomname);
		
	}
	
	public void SelectDropList()
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
		ele1.sendKeys("Alpine");
		pressKeyWithActions(Keys.ARROW_DOWN);
		
	}

}
