package com.vtiger;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import generic.ExcelUtility;
import generic.FileUtility;
import generic.Iconstants;
import generic.JavaUtility;
import generic.WebDriverUtility;
import objectRepo.ContactPOMPage;
import objectRepo.HomePOMPage;
import objectRepo.LoginPOMPage;

public class ContactIntegrationPOMPage {
      
		
        JavaUtility jv = new JavaUtility();
		FileUtility fu = new FileUtility();
		WebDriverUtility wdu = new WebDriverUtility();
		ExcelUtility eu = new ExcelUtility();
		
		@Test
		public void createcontact() throws IOException, InterruptedException {
            
			int randomnumber=	jv.createRandomNumber();
			
			String UN=fu.readDatafrompropfile(Iconstants.propfilepath, "username");
			String PWD=fu.readDatafrompropfile(Iconstants.propfilepath, "password");
			String URL=fu.readDatafrompropfile(Iconstants.propfilepath, "url");

			
			String nameLast = eu.readDatafromExcel("Sheet2", 2, 0);
    		String lastname = nameLast+randomnumber;
    		String num = eu.readDatafromExcel("Sheet2", 3, 0);
    		String mobnum = num+randomnumber;
			
			
			WebDriver driver = new ChromeDriver();
			wdu.maximizewindow(driver);
			driver.get(URL);
			wdu.implicitwait(driver);
		   	
			
			//Login the App click on contact module
			LoginPOMPage lp = new  LoginPOMPage(driver);
			lp.loginToApp(UN, PWD);
			
			HomePOMPage hp = new HomePOMPage(driver);
			hp.getContactlnk().click();
			
			ContactPOMPage cp = new ContactPOMPage(driver);
			cp.getCreatecontactbtn().click();
			
			ContactIntegrationPOMPage cip = new ContactIntegrationPOMPage();
			cip.getLastnametb().sendKeys(lastname);
    	   	driver.findElement(By.xpath("//img[@title='Select'][1]")).click();
    	   	
    	   	//Window Handle
    	   	                                                                   
    	   	wdu.switchToChildWindow(driver,"childwin");
    	   	driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys("Test1");
    	   	driver.findElement(By.xpath("//input[@name='search']")).click();
    	    driver.findElement(By.xpath("//table[contains(@style,'background-color')]/tbody/tr[2]//a")).click();
    	   	wdu.switchToChildWindow(driver,"mainwin");
    	   	driver.findElement(By.xpath("//table[@class='dvtContentSpace']//tbody//tbody//tbody/tr[5]/td[4]/input")).sendKeys(mobnum);
    	   	driver.findElement(By.xpath("//table[@class='dvtContentSpace']//tbody//tbody//tbody/tr[4]/td[2]/input")).sendKeys(lastname);
    	   	driver.findElement(By.xpath("//input[@type='submit'][1]")).click();
    	   	WebElement title  = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
    	   		   
    	   	if(driver.getTitle().contains("Contacts")){
    	   	     System.out.println("contact created successfully!!");
    	   			   
    	   		   }
    	   		   
    	   		 //LOGOUT
    	   			
    	                hp.logoutFromApp();
    	                wdu.quit(driver);
    	   		}

		private Object getLastnametb() {
			// TODO Auto-generated method stub
			return null;
		}
    	   		
	
	
	
}
