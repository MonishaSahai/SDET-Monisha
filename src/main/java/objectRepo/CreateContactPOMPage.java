package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPOMPage {
	
	public CreateContactPOMPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@name='salutationtype']")
	private WebElement salutationlist;

	public WebElement getSalutationList() {
		return salutationlist;
	}

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstnametb;

	public WebElement getFirstnametb() {
		return firstnametb;
	}
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastnametb;

	public WebElement getLastnametb() {
		return lastnametb;
	}
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement titletxt;

	public WebElement getTitletxt() {
		return titletxt;
	}

}
