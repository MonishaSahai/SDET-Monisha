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
import objectRepo.ContactINPOMPage;


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
			//contact creation
		    ContactINPOMPage cip = new ContactINPOMPage(driver);
		    cip.getLastnametb().sendKeys(lastname);
    	   	cip.getOrgbtn().click();
    	   	
    	   	//Window Handle
    	   	wdu.switchToChildWindow(driver,"childwin");
    	   	//childwindow
    	   	
    	   	cip.getSearchtb().sendKeys("Test1");
    	   	cip.getSearchbtn().click();
    	   	//wdu.waitandclick(driver,"//table[@class='dvtContentSpace']//tbody//tbody//tbody/tr[5]/td[4]/input");
    	    cip.getOrglink().click();
    	    //mainwindow
    	    
    	   	wdu.switchToChildWindow(driver,"mainwin");    	   	
    	   	cip.getMobtb().sendKeys(mobnum);
    	   	cip.getLastname1().sendKeys(lastname);
    	   	//wdu.waitandclick(driver,"//input[@type='submit'][1]");
    	   	cip.getClickbtn().click();
    	   
    	   		   
    	   	if(driver.getTitle().contains("Contacts")){
    	   	     System.out.println("contact created successfully!!");
    	   			   
    	   		   }
    	   		   
    	   		 //LOGOUT
    	   			
    	                hp.logoutFromApp(driver);
    	                wdu.quit(driver);
    	   		}

}

