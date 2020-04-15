package Utils;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import javax.lang.model.util.Elements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import CommonFunctions.BaseClass;

public class SeleniumUtils extends BaseClass {
	public static final long implicitwait=10;
	public static final long pageloadwait=20;
	
	// Utils for sendkeys
	public static void sendkeys(WebDriver driver,WebElement ele,int time,String value) {
		new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(ele));
		ele.sendKeys(value);
	}
	// Utils for click
 public static void clickonelement(WebDriver driver,WebElement ele,int time) {
	 new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(ele));
ele.click();
 }
//Utils to handle dropdown
public static void selectByindex(WebElement element, int i) {
	    Select selectElement = new Select(element);
	    selectElement.selectByIndex(i);
	}
	public static void selectByText(WebElement element, String text) {
	    Select selectElement = new Select(element);
	    selectElement.selectByVisibleText(text);
	}

// Utils to handle alert
public static void handleAlert(WebDriver driver, int timeout, boolean accept) {
	    while (isAlertPresent(driver, timeout)) {
	        resolveAlert(driver, accept);
	    }
	}
private static boolean isAlertPresent(WebDriver driver, int timeout) {
	    try {
	        Alert a = new WebDriverWait(driver, timeout).until(ExpectedConditions.alertIsPresent());
	        if (a != null) {
	            return true;
	        } else {
	            throw new TimeoutException();
	        }
	    } catch (TimeoutException e) {
	        // log the exception;
	        return false;
	    }
	}
private static void resolveAlert(WebDriver driver, boolean accept) {
	    if (accept) {
	        driver.switchTo().alert().accept();
	    } else {
	        driver.switchTo().alert().dismiss();
	    }
	}
// Utils to take screenshot
public static String getScreenshot(WebDriver driver, String imagename) {
	TakesScreenshot ts = (TakesScreenshot)driver;
	File srcFile = ts.getScreenshotAs(OutputType.FILE);
	SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
	Date d = new Date();
	String timestamp = s.format(d);
	String destination = System.getProperty("user.dir")+"/Reports/Screenshots"+"_"+imagename+timestamp+".png";
	File destFile = new File(destination);
	try {
		FileHandler.copy(srcFile, destFile);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return destination;
}
public static void mousemovetoelement(WebDriver driver, WebElement ele,int time) {
	 new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(ele));
	Actions actions=new Actions(driver);
	actions.moveToElement(ele).click().build().perform();
}
//utils to handle multiple window
public static void Windowhandles(WebDriver driver,WebElement ele,int time){
	Set<String> windows =driver.getWindowHandles();
	for (String newwindow : windows) {
		driver.switchTo().window(newwindow);
	}
}

}
