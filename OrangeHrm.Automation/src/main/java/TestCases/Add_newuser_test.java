package TestCases;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonFunctions.BaseClass;
import Pages.Adminpage;
import Pages.Loginpage;
import Utils.ExcelReader;
import Utils.SeleniumUtils;

public class Add_newuser_test extends BaseClass {
	@BeforeTest
	public void testdata() {
		ExcelReader.setExcelFileSheet("sheet1");
	}
	
	public  void Adminpagetestdata(XSSFRow row) {
		SeleniumUtils.sendkeys(driver, Adminpage.employeeNametextbox, 5, row.getCell(0).toString());
		SeleniumUtils.sendkeys(driver, Adminpage.usernametextbox, 5, row.getCell(1).toString());
		SeleniumUtils.sendkeys(driver, Adminpage.passwordtextbox, 5, row.getCell(2).toString());
		SeleniumUtils.sendkeys(driver, Adminpage.confirmpasswordtextbox, 5, row.getCell(2).toString());
	}
	@Test
public void addnewuser() {
	PageFactory.initElements(driver, Adminpage.class);
	new Loginpage().dologin(pro.getProperty("username"),pro.getProperty("password"));
	SeleniumUtils.mousemovetoelement(driver, Adminpage.Admin, 5);
	SeleniumUtils.mousemovetoelement(driver, Adminpage.usermanagement, 5);
	SeleniumUtils.mousemovetoelement(driver, Adminpage.users, 3);
	SeleniumUtils.clickonelement(driver, Adminpage.Addbutton, 3);
    Adminpagetestdata(ExcelReader.getRowData(1));
    SeleniumUtils.selectByindex(Adminpage.statusdropdown, 0);
    SeleniumUtils.clickonelement(driver, Adminpage.savebutton, 5);
   
	}

}
