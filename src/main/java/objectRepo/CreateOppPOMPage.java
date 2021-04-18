package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOppPOMPage {

	@FindBy(xpath="//input[@name='potentialname']")
	private WebElement opptb;
	
	public WebElement getOpptb()
	{
		return opptb;
	}
	
	@FindBy(xpath="//select[@id='related_to_type']")
	private WebElement listbox;
	
	public WebElement getListbox()
	{
		return listbox;
		
	}
	
	@FindBy(xpath="//input[@id='related_to_display']/following-sibling::img[@title='Select']")
	private WebElement contactbtn;
	
	public WebElement getContactbtn()
	{
		return contactbtn;
		
	}
	
	@FindBy(xpath="//input[@id='related_to_display']/following-sibling::input[@title='Clear']")
	private WebElement eraserbtn;
	
	public WebElement getEraserbtn()
	{
		return eraserbtn;
		
	}
	
	@FindBy(xpath="//input[@id='related_to_display']")
	private WebElement contacttb1;
	
	public WebElement getContacttb1()
	{
		return contacttb1;
		
	}
	
	
	@FindBy(xpath="(//table[@class='small'])[3]/tbody/tr[*]/td[1]/a[text()='Monisha939 Sahai939']")
	private WebElement contacttxtchild;
	
	public WebElement getContacttxtchild()
	{
		return contacttxtchild;
		
	}
	
	@FindBy(xpath="//a[text()='Test1']")
	private WebElement orgtxtchild;
	
	public WebElement getOrgtxtchild()
	{
		return orgtxtchild;
		
	}
	
	
	@FindBy(xpath="//input[@type='submit'][1]")
	private WebElement savebtn;
	
	public WebElement getSavebtn()
	{
		return savebtn;
		
	}
	
	@FindBy(xpath="//div[@class='small']/table[1]/tbody[1]/tr[1]/td[*]")
	private WebElement titletxt;
	
	public WebElement getTitletxt()
	{
		return titletxt;
		
	}
	
	public CreateOppPOMPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	
	
	
}
