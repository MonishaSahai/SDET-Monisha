package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPOMPage {
	
	WebDriver driver;

	@FindBy(xpath="//img[@title='Create Organization...']")
    private WebElement createbtn;
    
    public WebElement getCreateBtn()
    {
    	return createbtn;
    		
    }
    
    public OrgPOMPage(WebDriver driver) {
    	
    //this.driver = driver;
      PageFactory.initElements(driver,this);
    }
}
