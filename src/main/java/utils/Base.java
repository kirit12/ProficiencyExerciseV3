package utils;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import io.appium.java_client.android.AndroidDriver;

/**
* Base class is initialize the driver and setup of environment. 
* Initialize the report path.
* After successfully close the driver. 
* @author  Kirit Thakrar
* @version 1.0
* @since   2020-06-07
*/

public class Base {
	
		
	static Logger log = Logger.getLogger(Base.class);
	public Read_ExcelData read_ExcelObj = new Read_ExcelData();
	private static String fileSeperator = System.getProperty("file.separator");
    {
        System.setProperty("atu.reporter.config", "./src/main/java/utils/atu.properties");
        DOMConfigurator.configure(System.getProperty("user.dir")+fileSeperator+"src"+fileSeperator+"main"+fileSeperator+"resources"+fileSeperator+"log4j-config.xml");
        
    }

    public static AndroidDriver driver;

    /**
	   * This is method to used to setup environment for android application testing.
	   * Initialize the Android driver.
	   * 
	   */
    
    @BeforeSuite(alwaysRun = true)
    public AndroidDriver getDriver() {
    	try {
        	
        	List<String> divicelist=new ArrayList<String>();
            divicelist= read_ExcelObj.readFromExcel();
        	
            ATUReports.setWebDriver(driver);
            ATUReports.setAuthorInfo("Kirit Thakrar",Utils.getCurrentTime() , "1");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("app", System.getProperty("user.dir") + "/app/Amazon_shopping.apk");
            desiredCapabilities.setCapability("deviceName", "10.0");
            desiredCapabilities.setCapability("udid", divicelist.get(0));
            desiredCapabilities.setCapability("isHeadless", true);
            desiredCapabilities.setCapability("platformName", "Android");

            URL remoteUrl = new URL("http://localhost:4723/wd/hub");

            driver = new AndroidDriver(remoteUrl, desiredCapabilities);

            ATUReports.add("Successfully Initilize the Android Driver", "-", "-", "-", LogAs.PASSED, null);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return driver;
        }
        return driver;
    }
    
    /**
	   * This is method to used to close the android driver.
	*/

    @AfterSuite(alwaysRun = true)
    public void closeDriver() {
    	
    	ATUReports.add("Close the Androind Driver", "-", "-", "-", LogAs.INFO, null);
        driver.quit();
        ATUReports.add("Successfully Closed the Androind Driver", "-", "-", "-", LogAs.PASSED, null);
    }
    
    
    /**
	   * This is method to used for wait for element.
	   * Dynamic waiting like implicitly wait.
	   * 
	   */
	public void waitForElement(WebDriver driver,WebElement element)
	 {
		try
		 	{
			  	WebDriverWait await = new WebDriverWait(driver, 60,20000);
			 	await.pollingEvery(10, TimeUnit.SECONDS);
			 	await.until(ExpectedConditions.elementToBeClickable(element));
			 	await.until(ExpectedConditions.visibilityOf(element));
		 	}
		 catch(Exception ex)
		 	{
			 	log.error("Wait For Element Error Log:"+ex.getMessage());
		 	}
	 }
}
