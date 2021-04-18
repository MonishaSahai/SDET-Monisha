package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportiunityPOMPage {

	@FindBy(xpath="//img[@title='Create Opportunity...']")
	private WebElement opportiunitybtn;
	
	public WebElement getOpportiunity()
	{
		return opportiunitybtn;
		
	}
	
	public OpportiunityPOMPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
}
