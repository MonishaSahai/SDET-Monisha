package com.vtiger;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.BaseClass;
import objectRepo.CreateOppPOMPage;
import objectRepo.HomePOMPage;
import objectRepo.OpportiunityPOMPage;

public class OpportiunityValidationTC2 extends BaseClass{
	
	@Test
	public void opportiunityValidation() throws InterruptedException{
		
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
		cop.getSavebtn().click();
		/*WebElement wb = cop.getTitletxt();
		System.out.println(wb.getText());*/
		
		System.out.println(cop.getTitletxt().getText());
		boolean result = cop.getTitletxt().getText().contains("Opportunity Information");
		System.out.println(result);
		System.out.println("opportunity created Successfully");
		
	}

}
