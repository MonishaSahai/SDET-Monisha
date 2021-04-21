package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.BaseClass;

public class ContactINPOMPage {
            
public ContactINPOMPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastnametb;

	public WebElement getLastnametb(){
		return lastnametb;
	}
	
	@FindBy(xpath="//img[@title='Select'][1]")
	private WebElement orgbtn;

	public WebElement getOrgbtn(){
		return orgbtn;
	}
	
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement searchtb;

	public WebElement getSearchtb(){
		return searchtb;
	}
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchbtn;

	public WebElement getSearchbtn(){
		return searchbtn;
	}
	
	@FindBy(xpath="//table[contains(@style,'background-color')]/tbody/tr[2]//a")
	private WebElement orglink;

	public WebElement getOrglink(){
		return orglink;
	}
	
	@FindBy(xpath="//table[@class='dvtContentSpace']//tbody//tbody//tbody/tr[5]/td[4]/input")
	private WebElement mobtb;

	public WebElement getMobtb(){
		return mobtb;
	}
	
	@FindBy(xpath="//table[@class='dvtContentSpace']//tbody//tbody//tbody/tr[4]/td[2]/input")
	private WebElement lastnametb1;

	public WebElement getLastname1(){
		return lastnametb1;
	}
	
	@FindBy(xpath="//input[@type='submit'][1]")
	private WebElement clickbtn;

	public WebElement getClickbtn(){
		return clickbtn;
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement titletxt;

	public WebElement getTitletxt(){
		return titletxt;
	}
	
	/*public void selectorg(String orgname) {
		searchbtb.sendKeys(orgname);
		searchnowchild.click();
	}*/
	
	
}
