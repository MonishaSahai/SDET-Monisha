package com.vtiger;

import org.testng.annotations.Test;

import com.generic.BaseClass;

import objectRepo.CreateOppPOMPage;
import objectRepo.HomePOMPage;
import objectRepo.OpportiunityPOMPage;


public class CreateOpportunityUsingOrgErasebuttonTC5 extends BaseClass {
	@Test
	public void createOppusingOrgErasebutton() throws InterruptedException {
		HomePOMPage hp = new HomePOMPage(driver);
		hp.getOppBtn().click();
		
		OpportiunityPOMPage op = new OpportiunityPOMPage(driver);
		op.getOpportiunity().click();	
			
		CreateOppPOMPage cop = new CreateOppPOMPage(driver);
		cop.getOpptb().sendKeys("abc");
		cop.getListbox().click();
		wdu.selectdropdownbyvalue(cop.getListbox(),"Accounts");
		cop.getContactbtn().click();
		wdu.switchToChildWindow(driver,"//td[text()='Organizations']");
		Thread.sleep(1000);
		cop.getOrgtxtchild().click();
		wdu.switchToChildWindow(driver,"//input[@type='submit'][1]");
	    cop.getEraserbtn().click();
		cop.getSavebtn().click();
		//Verification of erase button by alert handling
   		String msg = wdu.alertHandling(driver);
   		System.out.println(msg);
   		wdu.alertHandling1(driver);
   		//Again entering the details
   		cop.getContactbtn().click();
		wdu.switchToChildWindow(driver,"//td[text()='Organizations']");
		Thread.sleep(1000);
		cop.getOrgtxtchild().click();
		wdu.switchToChildWindow(driver,"//input[@type='submit'][1]");
		cop.getSavebtn().click();
	}
}
