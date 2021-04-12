package com.vtiger;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import generic.ExcelUtility;
import generic.FileUtility;
import generic.Iconstants;
import generic.JavaUtility;
import generic.WebDriverUtility;

	public class Create_ContactNew {
		
		JavaUtility jv = new JavaUtility();
		WebDriverUtility wdu = new WebDriverUtility();
		FileUtility fu = new FileUtility();
		ExcelUtility eu = new ExcelUtility();
		
        @Test
		public void createContact() throws IOException{
        	int randomnumber=	jv.createRandomNumber();
        	
        	//Read data from property file
    		String UN=fu.readDatafrompropfile(Iconstants.propfilepath, "username");
    		String PWD=fu.readDatafrompropfile(Iconstants.propfilepath, "password");
    		String URL=fu.readDatafrompropfile(Iconstants.propfilepath, "url");
    		
    		//Read Test Script Data from Excel
    		String salutation= eu.readDatafromExcel("Sheet2", 0, 0);
    		String name= eu.readDatafromExcel("Sheet2", 1, 0);
    		String firstname= name+randomnumber;
    		String nameLast= eu.readDatafromExcel("Sheet2", 2, 0);
    		String lastname= nameLast+randomnumber;
    		
    		System.out.println(salutation +  name +  nameLast);

		    WebDriver driver = new ChromeDriver();
    		wdu.maximizewindow(driver);
    		driver.get(URL);
    		wdu.implicitwait(driver);
				
            //Login to app & click on contact module
    		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWD);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		    //Create contact
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

			WebElement Salutation = driver.findElement(By.xpath("//select[@name='salutationtype']"));
			wdu.selectdropdown(Salutation, salutation);	
			driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname);
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
            driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
            WebElement title  = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
            if(driver.getTitle().contains("Contacts")){
         	   System.out.println("contact created successfully!!");
         	   
            }
            //LOGOUT
            WebElement crmout =driver.findElement(By.xpath("//td[contains(@onmouseout,'fnHideDrop')][1]"));
    		wdu.movetoelement(driver, crmout);
            driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
         	
         	driver.close();

		}

	
}
