package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import generic.WebDriverUtility;
public class HomePOMPage {
	
	WebDriver driver;
	WebDriverUtility wdu;
	
	@FindBy(xpath="//a[text()='Organizations']")
    private WebElement orgbtn;
    
    public WebElement getOrgBtn()
    {
    	return orgbtn;
    		
    }
    
    @FindBy(xpath="//a[text()='Contacts']")
    private WebElement contactbtn;
    
    public WebElement getContactlnk() 
    {
    	return contactbtn;
    	
    }	
   
    @FindBy(xpath="//a[text()='Products']")
    private WebElement probtn;
    
    public WebElement getProBtn()
    {
    	return probtn;
    		
    }
    @FindBy(xpath="//a[text()='Opportunities']")
    private WebElement oppbtn;
    
    public WebElement getOppBtn()
    {
    	return oppbtn;
    		
    }
    
    public HomePOMPage(WebDriver driver) {
    	
    	                                                           //this.driver = driver;
    	                                                          //PageFactory.initElements(driver, HomePOMPage.class);
    	PageFactory.initElements(driver,this);
    }
    
    @FindBy(xpath="//td[contains(@onmouseout,'fnHideDrop')][1]")
    private WebElement logoutbtn;
      
    @FindBy(xpath="//a[text()='Sign Out']")
    private WebElement signoutbtn;
    
    public WebElement getSignout()
    {
 	   return signoutbtn;
    }
    
    public void logoutFromApp()
    {
    	wdu.movetoelement(driver, logoutbtn);
    	getSignout().click();
    }
    
    
}







