package pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.Base;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginscreen extends Base {

    public loginscreen(AndroidDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "com.amazon.mShop.android.shopping:id/sign_in_button")
    public MobileElement sign_in_btn;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    public MobileElement email_txt;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='0']")
    public MobileElement continue_btn;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    public MobileElement password_txt;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='0']")
    public MobileElement signInSubmit_btn;

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/action_bar_burger_icon")
    public MobileElement menu_btn;
    
    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/gno_greeting_text_view")
    public MobileElement glow_subnav_label;
    
    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/drawer_item_title")
    public MobileElement Home_btn;
    






}
