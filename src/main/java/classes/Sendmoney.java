package classes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static classes.Configurations.driver;

public class Sendmoney extends Basefunction {

@FindBy(xpath = "//div[text()=\"Bank Transfer\"]") private WebElement banktransfer;
//@FindBy(xpath = "//div[text()=\"You send\"]/following-sibling::input")private WebElement enteramount;
@FindBy(xpath = "//div[text()=\"Receiver gets\"]/following-sibling::input")private WebElement recieveramout;
@FindBy(xpath = "//div[text()=\"View Breakup\"]") private WebElement viewbrakup;
@FindBy(xpath = "//div[text()=\"Receiver Gets:\"]/following-sibling::div")private WebElement breakuprecieveramount;
@FindBy(xpath = "//*[@name=\"cancel\"]")private WebElement cancelbrakuppage;
@FindBy(xpath = "//div[@id=\"erv_send_money\"]//parent::div[@role=\"button\"]")private WebElement sendmoneyclick;

    public Sendmoney(){PageFactory.initElements(driver,this);}

    public void bankTransferOptionIsVisibleWithTheCreditTimelinesMessage() {
     WebElement timelinemessage=driver.findElement(By.xpath
             ("//div[contains(text(),\"Credited to Recipient in 4-5 business\")]"));
     String message1=timelinemessage.getText();
     System.out.print("timeline message showing for bank trnafer:" +  message1);
    }
    public void selectBankTransferOptionIsClickable() {
        banktransfer.click();

    }
    public void userEntersAmount(int amount) throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement enteramount = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//div[text()=\"You send\"]/following-sibling::input")));

        enteramount.sendKeys(Keys.CONTROL + "a"); // Select all text
//        enteramount.sendKeys(Keys.BACK_SPACE);
//        enteramount.clear();
        enteramount.sendKeys("" + amount +"");
        enteramount.sendKeys(Keys.ENTER);
//        sendmoneyclick.click();
//        Thread.sleep(2000);
    }
    public void userIsGettingCorrectReciverAmountToRecieverGetsField() {
//       String s2= recieveramout.getText();
       System.out.println(recieveramout.getText());
//       int a=41210;
//        if(s2.equals(a))
//        {
//            System.out.println("Amount displayed is correct:" + s2);
//        }
//        else{
//            System.out.println("Amount displayed is incorrect");
////            driver.quit();
//        }

    }
    public void userIsAbleToSeeCorrectAmountInBreakupDetailsWithCompareToRecieverAmount() {
        String s3= breakuprecieveramount.getText();
       String s2=recieveramout.getText() ;
        if(s2.equals(s3))
        {
            System.out.println("view breakup Reciever Amount is matching:" + s3);
        }
        else{
            System.out.println("Amount displayed is incorrect");
            driver.quit();
        }

    }
    public void sendmoneyButtonIsVisible() {
        System.out.println(sendmoneyclick.getText());

    }
    public void sendmoneyButtonIsClickableUserIsNavigatingToSelectAccountDetailsPage() {
        sendmoneyclick.click();
        String Expectedurl= "https://money2indiauat.icicibank.com/usa/select_account_details";
        String currenturl=driver.getCurrentUrl();
        if(currenturl.equals(Expectedurl))
        {
            System.out.println("URL Verification passed:" + currenturl);
        }
        else {
            System.out.println("URL Verification failed:" + currenturl);
            driver.quit();
        }
    }
}
