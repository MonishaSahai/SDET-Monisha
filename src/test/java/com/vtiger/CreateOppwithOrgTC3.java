package com.vtiger;

import org.testng.annotations.Test;

import com.generic.BaseClass;

import objectRepo.CreateOppPOMPage;
import objectRepo.HomePOMPage;
import objectRepo.OpportiunityPOMPage;

public class CreateOppwithOrgTC3 extends BaseClass{
	@Test
	public void createOppwithOrg() throws InterruptedException {
		
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
		cop.getSavebtn().click();
		
		System.out.println(cop.getTitletxt().getText());
		boolean result = cop.getTitletxt().getText().contains("Opportunity Information");
		System.out.println(result);
		System.out.println("opportunity created Successfully");
		
		
		
		
	}
	

}
