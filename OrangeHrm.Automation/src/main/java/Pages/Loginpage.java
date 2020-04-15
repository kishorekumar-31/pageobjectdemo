package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonFunctions.BaseClass;
import Utils.SeleniumUtils;

public class Loginpage extends BaseClass {
	
	@FindBy(xpath="//input[@id='txtUsername']")
	WebElement usernametextbox;
	@FindBy(xpath = "//input[@id='txtPassword']")
	WebElement passwordtextbox;
	@FindBy(xpath = "//input[@id='btnLogin']")
	WebElement submitbutton;
	
	public void dologin(String username, String password) {
	SeleniumUtils.sendkeys(driver, usernametextbox, 5, username);
	SeleniumUtils.sendkeys(driver, passwordtextbox, 5,password);
	SeleniumUtils.clickonelement(driver, submitbutton, 5);
	}
	
	public Loginpage(){
		PageFactory.initElements(driver, this);
		}
}
