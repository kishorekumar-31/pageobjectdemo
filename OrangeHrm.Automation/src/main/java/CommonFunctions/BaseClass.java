package CommonFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Utils.SeleniumUtils;

public class BaseClass {
	public static Properties pro;
    public static WebDriver driver;  
	public Properties loadproperty() throws FileNotFoundException {
		pro=new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"/config.properties");
	    try {
			pro.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pro;
	    
	}
	@BeforeSuite
	public WebDriver browserinitialization() throws FileNotFoundException {
		loadproperty();
		String browsername=pro.getProperty("browser");
		String url=pro.getProperty("application_url");
		System.out.println(browsername);
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Browserdrivers/chromedriver.exe");
		driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(SeleniumUtils.implicitwait,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(SeleniumUtils.pageloadwait,TimeUnit.SECONDS);
		return driver;
		
	}
	
	@AfterSuite
	public void closebrowser() {
		//driver.close();
	}
}
