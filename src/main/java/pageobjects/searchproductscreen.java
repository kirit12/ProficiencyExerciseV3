package pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.Base;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchproductscreen extends Base {

    public searchproductscreen(AndroidDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
    public MobileElement search_txt;

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text")
    public MobileElement item_txt;

    //androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/item_title")
    public MobileElement item_desc_lbl;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"by Sanyo\").instance(0))")
    public MobileElement ScrollAndGetTxt;
    
    
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Sanyo 165 cm (65 inches) Kaizen Series 4K Ultra HD Smart Certified Android IPS LED TV XT-65A082U (Black) (2019 Model)')]")
    public MobileElement item_title_txt;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'by Sanyo')]")
    public MobileElement company_name_txt;
    
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'rupees 54,999')]")
    public MobileElement price_txt;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sanyo']")
    public MobileElement company_name_lbl;
    
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Add to Cart\").instance(0))")
    public MobileElement addTocart_btn;
    
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Cart']")
    public MobileElement cart_img_btn;
    
    @AndroidFindBy(xpath = "//android.view.View[contains(@text, 'Sanyo 165 cm (65 inches) Kaizen Series 4K Ultra HD Smart Certified Android IPS LED TV XT-65A082U (Black) (2019 Model)')]")
    public MobileElement product_title_txt;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, '54,999')]")
    public MobileElement price_txt_cart;
    
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text, 'Delete')]")
    public MobileElement delete_item_cart;
    
    

   






}
