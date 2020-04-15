package Pages;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonFunctions.BaseClass;
import Utils.SeleniumUtils;

public class Adminpage extends BaseClass {
	public Adminpage() {
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath = "//a[@id='menu_admin_viewAdminModule']/b")
public static WebElement Admin;
@FindBy(xpath = "//a[@id='menu_admin_UserManagement']")
public static WebElement usermanagement;
@FindBy(xpath = "//*[@id=\"menu_admin_viewSystemUsers\"]")
public static WebElement users;
@FindBy(xpath = "//input[@id='btnAdd']")
public static WebElement Addbutton;
@FindBy(xpath = "//select[@id='systemUser_userType']")
public static WebElement userroledropdown;
@FindBy(xpath = "//input[@id='systemUser_employeeName_empName']")
public static WebElement employeeNametextbox;
@FindBy(xpath = "//input[@id='systemUser_userName']")
public static WebElement usernametextbox;
@FindBy(xpath = "//select[@id='systemUser_status']")
public static WebElement statusdropdown;
@FindBy(xpath = "//input[@id='systemUser_password']")
public static WebElement passwordtextbox;
@FindBy(xpath = "//input[@id='systemUser_confirmPassword']")
public static WebElement confirmpasswordtextbox;
@FindBy(xpath = "//input[@id='btnSave']")
public static WebElement savebutton;
 //systemuser
@FindBy(xpath = "//input[@id='searchSystemUser_userName']")
public static WebElement usernamesearchtextbox;
@FindBy(xpath = "//select[@id='searchSystemUser_userType']")
public static WebElement userrolesearchdropdown;
@FindBy(xpath = "//input[@id='searchBtn']")
public static WebElement searchbutton;

}



