package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOMPage {
	        WebDriver driver;
	        
	        public LoginPOMPage(WebDriver driver) {
	        	                                             //Rule -4
	        	PageFactory.initElements(driver, this);
	        }
	
			@FindBy (xpath = "//input[@name='user_name']")
			WebElement usernametb1;
			
			@FindBy(name="user_name")                         //Rule -2 
			private WebElement usernametb;
			
			
			@FindBy(name="user_password")
			private WebElement passwordtb;
			
			@FindBy(id="submitButton")
			private WebElement loginbtn;
			
			
			public WebElement getUsernametb()        
			{
				return usernametb;
			}
			
			public WebElement getPasswordtb()
			{
				return passwordtb;
			}
			
			public WebElement getLoginBtn()
			{
				return loginbtn;
			}
			public void loginToApp(String username , String password) {  //generic method           //Rule -5
				usernametb.sendKeys(username);
				passwordtb.sendKeys(password);
				loginbtn.click();
			}
			
			public void loginToApp() {             //Rule -5 //app based harcoded
				usernametb.sendKeys("admin");
				passwordtb.sendKeys("12345");
				loginbtn.click();
			}
		    
			

}







