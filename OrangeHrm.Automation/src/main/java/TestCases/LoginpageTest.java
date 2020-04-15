package TestCases;

import org.testng.annotations.Test;

import CommonFunctions.BaseClass;
import Pages.Loginpage;
import Utils.SeleniumUtils;

public class LoginpageTest extends BaseClass{
  @Test
 public void logincheck() {
new Loginpage().dologin(pro.getProperty("username"),pro.getProperty("password"));
SeleniumUtils.getScreenshot(driver, "logincheck_");
  }
	
}
