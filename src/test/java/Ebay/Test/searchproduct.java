package Ebay.Test;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import pageobjects.searchproductscreen;
import utils.Base;


public class searchproduct extends Base {
	
	static Logger log = Logger.getLogger(searchproduct.class);
    @Test(description = "TC-02 | Search Item Test case",priority = 2)
    public void searchProductTest(Method method) {
        try {
        	
	        	String prodcut_cpn_name = new String();
	        	String item_title_name = new String();
	        	String price_name = new String();
	        	String product_disc = new String();
	        	String price_cart = new String();
	        	String company_name_txt = new String();
	            
	            Thread.sleep(5000);
	            log.info("Start the Search Item Test Case");
	            // Create an object for Search screen to get all elements of search and add to card screen.
	            searchproductscreen searchScreen = new searchproductscreen(driver);
	
	            ATUReports.add("Search test case", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	            
	            // Click on search textbox and enter search text
	            searchScreen.search_txt.click();
	            Thread.sleep(2000);
	            searchScreen.search_txt.sendKeys("65-inch TV");
	            log.info("Enter the 65-inch TV in search textbox");
	            Thread.sleep(2000);
	            waitForElement(driver,searchScreen.item_txt);
	            ATUReports.add("Enter value in Search box","65-inch TV","-","-", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	            searchScreen.item_txt.click();
	            
	            // Scroll the screen until display text.
	            driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	            prodcut_cpn_name = searchScreen.ScrollAndGetTxt.getText();
	            log.info("Scroll the screen scuccessfully"); 
	            
	            // get the item description from search screen.
	            item_title_name = searchScreen.item_title_txt.getText();
	            driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);  
	            
	            // get the company name from search screen.
	            company_name_txt = searchScreen.company_name_txt.getText();
	            
	            // clean on that product for retrieve product detail screen.
	            waitForElement(driver,searchScreen.item_title_txt);
	            searchScreen.item_title_txt.click();
	            
	            // get company name and verify. 
	            waitForElement(driver, searchScreen.company_name_lbl);
	            prodcut_cpn_name = searchScreen.company_name_lbl.getText();
	            Assert.assertEquals("by " +prodcut_cpn_name, company_name_txt);
	            ATUReports.add("Verify Company name ", "-", company_name_txt, "by " +prodcut_cpn_name, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	            log.info("Verify Company name from the detail page.");
	            	            
	            // get the product description and verify.
	            product_disc = searchScreen.product_title_txt.getText();
	            Assert.assertEquals(product_disc, item_title_name);
	            ATUReports.add("Verify product description ", "-", item_title_name, product_disc, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	            log.info("Verify product description from the detail page.");
	            
				// get the item price from search screen.
				Thread.sleep(3000);
	            price_name = searchScreen.price_txt.getText();
	            log.info("Get the Company name, product description and price from the search page.");
	            
	            // get the only number from the price like display in screen is (rupee symbol with price)
	            String price_1 = price_name.split(" ")[1];
				price_1 = price_1.trim();
				
	            // To scroll the screen and click on add to cart button.
	            searchScreen.addTocart_btn.click();
	            
	            // To click on cart button to open the checkout screen.
	            searchScreen.cart_img_btn.click();
	            driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	            	            
	            // get the price and verify.
	            price_cart = searchScreen.price_txt_cart.getText();
	            price_cart =  price_cart.substring(1);
	            price_cart =  price_cart.trim();
	            Assert.assertEquals(price_cart, price_1+".00");
	            ATUReports.add("Verify Price", "-", price_1+".00", price_cart, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	            log.info("Verify Price from the Checkout page.");
	            
	            // Delete the product from the cart using click on delete button.
	            searchScreen.delete_item_cart.click();
	            driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	            ATUReports.add("Delete Item Successfully","-","-","-", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	            ATUReports.add("Search Product and Add to cart test case successfully", "-", "", "", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	            log.info("Search Product and Add to cart test case successfully.");
        
        } catch (Exception e) {
        	ATUReports.add("Search And Add to Cart Screen", " ", " ", e.getMessage(), LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
            log.error("Search And Add to Cart Test Case Error Found: "+e.getMessage());
        }
    }


}
