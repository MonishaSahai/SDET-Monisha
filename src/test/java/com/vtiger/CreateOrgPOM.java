package com.vtiger;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.generic.BaseClass;
import com.generic.ExcelUtility;
import com.generic.FileUtility;
import com.generic.Iconstants;
import com.generic.JavaUtility;
import com.generic.WebDriverUtility;

import objectRepo.CreateOrganizationPOMPage;
import objectRepo.HomePOMPage;
import objectRepo.LoginPOMPage;
import objectRepo.OrgPOMPage;

public class CreateOrgPOM extends BaseClass {
	
	JavaUtility jv = new JavaUtility();
	FileUtility fu=  new FileUtility();
	ExcelUtility eu= new ExcelUtility();
	WebDriverUtility wdu= new WebDriverUtility();
	@Test
	public void createOrg() throws IOException, InterruptedException {
		int randomnumber=	jv.createRandomNumber();


		                                                       //Read data from property file
		                                                       /*String UN=fu.readDatafrompropfile(Iconstants.propfilepath, "username");
		                                                         String PWD=fu.readDatafrompropfile(Iconstants.propfilepath, "password");
		                                                         String URL=fu.readDatafrompropfile(Iconstants.propfilepath, "url");*/

		//Read Test Script Data from Excel
		String name=eu.fetchDatafromExcel("Sheet1", 0, 0);
		String orgname=name+randomnumber;
		String phonenumber=eu.fetchDatafromExcel("Sheet1", 1, 0);
		String indDD=eu.fetchDatafromExcel("Sheet1", 2, 0);
		String ratingDD=eu.fetchDatafromExcel("Sheet1", 3, 0);
		String typeDD=eu.fetchDatafromExcel("Sheet1", 4, 0);

		                                                           //Name of org
		                                                  //System.out.println(name+" "+orgname+" "+phonenumber+" "+indDD+" "+ratingDD+" "+typeDD);

		                                                    /*WebDriver driver = new ChromeDriver();
		                                                        wdu.maximizewindow(driver);
		                                                        driver.get(URL);
		                                                       wdu.implicitwait(driver);*/
		
		//Login using LOGINPOMPAGE
		
		//LoginPOMPage lp = new  LoginPOMPage(driver);
		//lp.loginToApp(UN, PWD);
		
		HomePOMPage hp = new HomePOMPage(driver);
		hp.getOrgBtn().click();
		
		OrgPOMPage op = new OrgPOMPage(driver);
		op.getCreateBtn().click();
		
		CreateOrganizationPOMPage cop = new CreateOrganizationPOMPage(driver);
		cop.getOrgnametb().sendKeys(orgname);
		cop.getPhonetb().sendKeys(phonenumber);
		
		cop.getIndustrylist().click();
		wdu.selectdropdown(cop.getIndustrylist(),indDD);
		
		cop.getRatinglist().click();
		wdu.selectdropdown(cop.getRatinglist(),ratingDD);
		
		cop.getIndustrylist().click();
		wdu.selectdropdown(cop.getTypelist(),typeDD);
		
		cop.getSaveBtn().click();
		wdu.refresh(driver);
		
		cop.getOrglist().click();
		cop.getSearchbox().sendKeys(orgname);
		cop.getSearchlist().click();
		wdu.selectdropdown(cop.getSearchlist(),"Organization Name");
		cop.getSavebtn1().click();
		
		//VALIDATION
		
		wdu.waitforElement(cop.getActualorg());
		System.out.println(cop.getActualorg().getText());
		boolean result = cop.getActualorg().getText().contains(orgname);
		System.out.println(result);
		System.out.println("Organization created Successfully");
		
		//LOGOUT
		
		hp.logoutFromApp(driver);
		wdu.quit(driver);

	}

}
