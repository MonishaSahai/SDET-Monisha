package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPOMPage {
	
	WebDriver driver;
        
	@FindBy(xpath="//img[@title='Create Organization...']")
    private WebElement orgbtn;
    
    public WebElement getOrgBtn()
    {
    	return orgbtn;
    		
    }
    
    @FindBy(xpath="//input[@name='accountname']")
    private WebElement orgnametb;
    
    public WebElement getOrgnametb()
    {
    	return orgnametb;
    		
    }
    
    @FindBy(xpath="//input[@id='phone']")
    private WebElement phonetb;
    
    public WebElement getPhonetb()
    {
    	return phonetb;
    		
    }
    
    @FindBy(xpath="//select[@name='industry']")
    private WebElement industrylist;
    
    public WebElement getIndustrylist()
    {
    	return industrylist;
    		
    }
    
    @FindBy(xpath="//select[@name='rating']")
    private WebElement ratinglist;
    
    public WebElement getRatinglist()
    {
    	return ratinglist;
    		
    }
    
    @FindBy(xpath="//select[@name='accounttype']")
    private WebElement typelist;
    
    public WebElement getTypelist()
    {
    	return typelist;
    		
    }
    
    @FindBy(xpath="//input[@title='Save [Alt+S]']")
    private WebElement savebtn;
    
    public WebElement getSaveBtn()
    {
    	return savebtn;
    		
    }
    
    @FindBy(xpath="//a[@class='hdrLink']")
    private WebElement orglist;
    
    public WebElement getOrglist()
    {
    	return orglist;
    		
    }
    
    @FindBy(xpath="//input[@name='search_text']")
    private WebElement searchbox;
    
    public WebElement getSearchbox()
    {
    	return searchbox;
    		
    }
    
    @FindBy(xpath="//div[@id='basicsearchcolumns_real']/select[@id='bas_searchfield']")
    private WebElement searchlist;
    
    public WebElement getSearchlist()
    {
    	return searchlist;
    		
    }
    
    @FindBy(xpath="//input[@name='submit']")
    private WebElement savebtn1;
    
    public WebElement getSavebtn1()
    {
    	return savebtn1;
    		
    }
    
    @FindBy(xpath="//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']")
    private WebElement actualorg;
    
    public WebElement getActualorg()
    {
    	return actualorg;
    		
    }
    
    
    public CreateOrganizationPOMPage(WebDriver driver) {
    	
    	//this.driver = driver;
    	PageFactory.initElements(driver,this);
    }
    
}
