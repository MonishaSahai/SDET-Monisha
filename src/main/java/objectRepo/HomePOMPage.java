package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import generic.WebDriverUtility;
public class HomePOMPage {
	
	//WebDriver driver;
	WebDriverUtility wdu = new WebDriverUtility();
	
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
    
    
    
    @FindBy(xpath = "//img[contains(@src,'user.PNG')]")
	private WebElement adminstrationImg;
      
    @FindBy(linkText = "Sign Out")
	private WebElement signOutbtn;
    
    public WebElement getSignout()
    {
 	   return signOutbtn;
    }
    
    public HomePOMPage(WebDriver driver)
    {
    	
    	//this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    
    public void logoutFromApp(WebDriver driver)
    {
    	wdu.movetoelement(driver,adminstrationImg);
    	getSignout().click();
    }
    
    
}







