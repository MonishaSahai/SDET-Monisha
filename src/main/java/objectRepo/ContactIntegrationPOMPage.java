package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactIntegrationPOMPage {
	
	public ContactIntegrationPOMPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastnametb;

	public WebElement getLastnametb() {
		return lastnametb;
	}
	
	@FindBy(xpath="//input[@name='account_name']//following-sibling::img")
	private WebElement orgbtn;
	
	public WebElement getOrgbtn() {
		return orgbtn;
	}

	@FindBy(id="search_txt")//IN CHILD WINDOW(NOT CREATED POM  EXPLICITLY)
	private WebElement searchboxchild;
	
	public WebElement searchboxchild() {
		return searchboxchild;
	}
	
	@FindBy(xpath="//input[@name='search']")//IN CHILD WINDOW
	private WebElement searchnowchild;
	
	public WebElement searchnowchild() {
		return searchnowchild;
	}
	
	@FindBy(xpath="//a[@id='1']")//IN CHILD WINDOW
	private WebElement searchsuggestion;
	
	public WebElement searchsuggestion() {
		return searchsuggestion;
	}
	
	@FindBy(xpath="//input[@class='crmButton small save']")//IN CHILD WINDOW
	private WebElement savebtn;
	
	public WebElement savebtn() {
		return savebtn;
	}
	
	public void selectorg(String orgname) {
		searchboxchild.sendKeys(orgname);
		searchnowchild.click();
	}
	

}
