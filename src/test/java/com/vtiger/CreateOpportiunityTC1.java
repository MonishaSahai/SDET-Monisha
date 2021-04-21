package com.vtiger;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.generic.BaseClass;

import objectRepo.CreateOppPOMPage;
import objectRepo.HomePOMPage;
import objectRepo.OpportiunityPOMPage;

@Listeners(com.generic.ListenersImplementation1.class)
public class CreateOpportiunityTC1 extends BaseClass {
	
	
	@Test(groups = {"SMOKE-TEST","Regression-test"})
	public void createOpportiunity() throws InterruptedException {
		
		
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
	//Thread.sleep(1000);
	cop.getContacttxtchild().click();
	wdu.switchToChildWindow(driver,"//input[@type='submit'][1]");
	cop.getSavebtn().click();
	WebElement wb = cop.getTitletxt();
	System.out.println(wb.getText());
 }

}
