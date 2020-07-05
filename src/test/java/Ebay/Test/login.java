package Ebay.Test;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import pageobjects.loginscreen;
import utils.Base;


public class login extends Base {
	
	static Logger log = Logger.getLogger(login.class);
    @Test(description = "TC-01 | Login Test case", priority = 1)
    public void clickLoginButton(Method method) {
        try {
	           List<String> loginlist=new ArrayList<String>();
	           loginlist = read_ExcelObj.readFromExcel();
	           log.info("Start the Login Test Case");
	           String loginValid = "";
	           // Create an object of login screen for locators access
	           loginscreen loginScreen = new loginscreen(driver);

	            loginScreen.sign_in_btn.click();
	            driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	            
	            // Enter User name and Password 
	            loginScreen.email_txt.sendKeys(loginlist.get(1));
	            loginScreen.continue_btn.click();
	            log.info("Enter Username");
	            ATUReports.add("Enter Username", loginlist.get(1), "-", "-", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	            loginScreen.password_txt.clear();
	            loginScreen.password_txt.sendKeys(loginlist.get(2));
	            log.info("Enter Password");
	            ATUReports.add("Enter Password", loginlist.get(2), "-", "-", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	            
	            // Click on login button
	            loginScreen.signInSubmit_btn.click();
	            ATUReports.add("Click on Login Button", "", "-", "-", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	            waitForElement(driver,loginScreen.menu_btn);
	            
	            // Click on menu for verify the login successfully
	            loginScreen.menu_btn.click();
	            loginValid = loginScreen.glow_subnav_label.getText();
	            String[] parts = loginValid.split(" ");
	            
	            Assert.assertEquals(parts[0], "Hello,");
	            ATUReports.add("Login successfully", "-", "Hello,", parts[0], LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	            waitForElement(driver,loginScreen.Home_btn);
	            
	            // Click on Home 
	            loginScreen.Home_btn.click();
	            log.info("Login Test Case run successfully");
            
        } catch (Exception e) {
        	ATUReports.add("Login", " ", " ", e.getMessage(), LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
            log.error("Login Test Case Error Found: "+e.getMessage());
        }
    }


}
