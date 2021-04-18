package com.vtiger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import generic.BaseClass;
import objectRepo.CreateOppPOMPage;
import objectRepo.HomePOMPage;
import objectRepo.OpportiunityPOMPage;

@Test
public class CreateOpportunityusingContErasebuttonTC4 extends BaseClass {
	       
	       public void createContactusingErasebutton() throws InterruptedException {
	    	   
	    	HomePOMPage hp = new HomePOMPage(driver);
	   		hp.getOppBtn().click();
	   		
	   		OpportiunityPOMPage op = new OpportiunityPOMPage(driver);
	   		op.getOpportiunity().click();	
	   			
	   		CreateOppPOMPage cop = new CreateOppPOMPage(driver);
	   		cop.getOpptb().sendKeys("abc");
	   		cop.getListbox().click();
	   		wdu.selectdropdownbyvalue(cop.getListbox(),"Contacts");
	   		cop.getContactbtn().click();
	   		wdu.switchToChildWindow(driver,"//td[text()='Contact']");
	   		Thread.sleep(1000);
	   		cop.getContacttxtchild().click();
	   		wdu.switchToChildWindow(driver,"//input[@type='submit'][1]");
	   		cop.getEraserbtn().click();
	   		cop.getSavebtn().click();
	   		//Verification of erase button by alert handling
	   		String msg = wdu.alertHandling(driver);
	   		System.out.println(msg);
	   		wdu.alertHandling1(driver);
	   		//Again entering the details
	   		cop.getContactbtn().click();
	   		wdu.switchToChildWindow(driver,"//td[text()='Contact']");
	   		Thread.sleep(1000);
	   		cop.getContacttxtchild().click();
	   		wdu.switchToChildWindow(driver,"//input[@type='submit'][1]");
	   		cop.getSavebtn().click();
	   		
	       }

}
