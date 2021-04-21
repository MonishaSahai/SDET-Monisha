package com.vtiger;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.generic.BaseClass;
import com.generic.ExcelUtility;
import com.generic.FileUtility;
import com.generic.Iconstants;
import com.generic.JavaUtility;
import com.generic.WebDriverUtility;

import objectRepo.ContactPOMPage;
import objectRepo.CreateContactPOMPage;
import objectRepo.HomePOMPage;
import objectRepo.LoginPOMPage;

public class ContactCreationPOM extends BaseClass{
	                                       //JavaUtility jv = new JavaUtility();
	                                      //WebDriverUtility wdu = new WebDriverUtility();
	                                      //FileUtility fu = new FileUtility();
	                                      //ExcelUtility eu = new ExcelUtility();
	
    @Test
	public void createContact() throws IOException{
    	                                   int randomnumber=	jv.createRandomNumber();
    	
    	                                     /*Read data from property file
		                                      String UN=fu.readDatafrompropfile(Iconstants.propfilepath, "username");
		                                      String PWD=fu.readDatafrompropfile(Iconstants.propfilepath, "password");
		                                      String URL=fu.readDatafrompropfile(Iconstants.propfilepath, "url");
		
		                                     //Read Test Script Data from Excel
		                                       String salutation= eu.readDatafromExcel("Sheet2", 0, 0);*/
	String name= eu.fetchDatafromExcel("Sheet2", 1, 0);
    String firstname= name+randomnumber;
    String nameLast= eu.fetchDatafromExcel("Sheet2", 2, 0);
    String lastname= nameLast+randomnumber;
		
		                                       //System.out.println(salutation +  name +  nameLast);*/
		
		

	                                            // WebDriver driver = new ChromeDriver();
		                                        //wdu.maximizewindow(driver);
		                                        //driver.get(URL);
		                                         //wdu.implicitwait(driver);
			
                                                //Login to app & click on contact module
		
		                                        //LoginPOMPage lp = new  LoginPOMPage(driver);
		                                        //lp.loginToApp(UN, PWD);
		
		HomePOMPage hp = new HomePOMPage(driver);
		hp.getContactlnk().click();
		
		ContactPOMPage cp = new ContactPOMPage(driver);
		 cp.getCreatecontactbtn().click();
		
		//Create contact
	    CreateContactPOMPage ccp = new CreateContactPOMPage(driver);
	    ccp.getSalutationList().click();
	    wdu.selectdropdown(ccp.getSalutationList(),"Ms.");
        ccp.getFirstnametb().sendKeys(firstname);
        ccp.getLastnametb().sendKeys(lastname);
		ccp.getSavebtn().click();
        //VALIDATION
     	   
     	System.out.println(ccp.getTitletxt().getText());
  		boolean result = ccp.getTitletxt().getText().contains("Contacts");
  		System.out.println(result);
  		System.out.println("contact created Successfully");
        //LOGOUT
  		
        hp.logoutFromApp(driver);
	    wdu.quit(driver);

	}

}
