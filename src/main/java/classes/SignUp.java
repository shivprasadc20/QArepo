package classes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static classes.Configurations.driver;
import static classes.Configurations.testdata;

public class SignUp extends Basefunction{

    @FindBy(xpath = "//div[text()=\"Sign Up\"]") private WebElement tabsignup;
    @FindBy(xpath = "//input[@class=\"input css-1cwyjr8 r-wbaqdt\"]")private WebElement country;
    @FindBy(xpath = "//div[text()=\"Individual\"]") private WebElement individual;
    @FindBy(xpath = "//div[text()=\"Business\"]") private WebElement business;
    @FindBy(xpath = "//div[text()=\"First Name\"]/following-sibling::input") private WebElement firstname;
    @FindBy(xpath = "//div[text()=\"Last Name\"]/following-sibling::input") private WebElement lastname;
    @FindBy(xpath = "//div[text()=\"Mobile Number\"]/following-sibling::input") private WebElement mobile;
    @FindBy(xpath = "//div[text()=\"Email Address\"]/following-sibling::input") private WebElement email;
    @FindBy(xpath = "//img[@alt=\"checkbox\"]") private WebElement checkbox;
    @FindBy(xpath = "//div[text()=\"Yes\"]") private WebElement yes;
    @FindBy(xpath = "//div[text()=\"Yes\"]") private WebElement no;
    @FindBy(xpath = "//div[text()=\"Verify With OTP\"]") private WebElement otpbtn;
    @FindBy(xpath="//div[text()=\"Submit\"]") private WebElement submit;
//    @FindBy(xpath = "//div[@class='css-1dbjc4n r-19fu0aa r-13ui10z r-1544tr9 r-1ui5ee8 r-1ph75f1 r-zso239" +
//            " r-1mnahxq r-bnwqim r-q4m81j r-cfp7ip']//input[@aria-label='See an informative alert']")private WebElement otp;
    @FindBy(xpath = "//div[text()=\"Resend OTP\"]")private WebElement resendotp ;
    @FindBy(xpath = "//div[@class='css-1dbjc4n r-18u37iz r-mvpalk']")private WebElement timer;
    @FindBy(xpath = "//div[text()=\"Enter Password\"]/following-sibling::input")private WebElement newpassword;
    @FindBy(xpath = "//div[text()=\"Confirm Password\"]/following-sibling::input")private WebElement confpassword;
    @FindBy(xpath = "//div[text()=\"Sign Up\"]") private WebElement signup;

    public SignUp() {
        PageFactory.initElements(driver,this);
    }
    public void user_click_on_sign_up_button() throws InterruptedException {
        driver.navigate().to(testdata.getProperty("applicationurl"));
        Thread.sleep(5000);
        tabsignup.click();
        Thread.sleep(4000);
    }
    public void user_is_navigating_to_sign_up_page() {
        String Actualurl="https://money2indiauat.icicibank.com/usa/registration/individual";
        String expectedurl=driver.getCurrentUrl();
        if(Actualurl.equals(expectedurl))
        {
            System.out.println("url verification passed:"+ Actualurl);
        }
        else
        {
            System.out.println("url verification failed");
            driver.quit();
        }
    }
    public void verify_sending_money_from_country_drop_down_as_united_states_by_default() {
       String selectedcountry=country.getText();
       System.out.println(selectedcountry);
    }
    public void user_is_able_to_select_business_for_sign_up() throws InterruptedException {
       business.click();
       Thread.sleep(2000);
    }
    public void user_is_able_to_select_individual_for_sign_up() throws InterruptedException {
        individual.click();
        Thread.sleep(2000);
    }
    public void userEntersInFirstTextField(String arg0) {
        firstname.sendKeys(arg0);
    }
    public void userEntersInSecondTextField(String arg1) {
        lastname.sendKeys(arg1);
    }
    public void userEntersInTextField(String arg2) {
        mobile.sendKeys(arg2);
    }
    public void userEntersInEmailTextField(String arg3) {
        email.sendKeys(arg3);
    }
    public void user_selects_terms_conditions_checkbox() {
        checkbox.click();
    }
    public void userSelectsYesForMarketingCommunication() throws InterruptedException {
      yes.click();
      Thread.sleep(2000);
    }
    public void userSelectsNOForMarketingCommunication() throws InterruptedException {
        no.click();
        Thread.sleep(1000);
    }
    public void verify_with_otp_button_is_visible() throws IOException {
        System.out.println(otpbtn.getText());
        screenshot(driver,"signupfirstpage");
    }
    public void click_on_verify_with_otp_button_is_clickable() throws InterruptedException {
       otpbtn.click();
       Thread.sleep(25000);
    }
    public void userIsNavigatingToOTPPageSubmitOtpToVerify() throws InterruptedException, IOException {
        screenshot(driver,"otp page");
    }
    public void userIsNavigateToPasswordPageToSetPassword() {
      WebElement text=driver.findElement(By.xpath("//div[text()=\"Set a password\"]"));
        System.out.println(text.getText());}
    public void userEnetersPasswordOnPasswordPage(String arg5) {
     newpassword.sendKeys(arg5);
    }
    public void userEnetersConfirmPasswordOnPasswordPage(String arg6) {
        confpassword.sendKeys(arg6);
    }
    public void signupButtonIsVisible() throws IOException {
        System.out.println(signup.getText());
        screenshot(driver,"password page");
    }
    public void userClickOnSignupButton() throws InterruptedException {
        signup.click();
        Thread.sleep(3000);
    }
    public void userIsNavigatingToSignUpSendMoneyPage() throws InterruptedException, IOException {

        String currenturl1="https://money2indiauat.icicibank.com/usa/send-money-for-new-user";
        String Expectedurl1=driver.getCurrentUrl();
        screenshot(driver,"signupsendmoneypage");
        if(currenturl1.equals(Expectedurl1))
        {
            System.out.println("URL Verification passed:"+ currenturl1);

        }
        else {
            System.out.println("URL Verification failed");
            driver.quit();
        }
    }
}
