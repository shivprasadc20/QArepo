package classes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static classes.Configurations.driver;
import static classes.Configurations.testdata;

public class Login extends Basefunction {
    @FindBy(xpath="//div[text()=\"User ID/Email ID\"]//following-sibling::input")private WebElement loginid;
    @FindBy(xpath="//div[text()=\"Password\"]//following-sibling::input")private WebElement loginpassword;
    @FindBy(xpath="//div[@class=\"css-901oao r-jwli3a r-wbaqdt r-ubezar r-q4m81j r-1vzi8xi\"]") private WebElement loginclick;
//    @FindBy(xpath="//*[@name=\"user\"]") private WebElement userprofileclick;
    @FindBy(xpath="//*[text()=\"Logout\"]") private WebElement logout;

    public Login() {
        PageFactory.initElements(driver, this);
    }
    public void userIsOnLoginPage() {
        driver.navigate().to(testdata.getProperty("applicationurl"));
    }
    public void userEntersLoginidPassword(String userid, String password) throws IOException ,InterruptedException{
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       loginid.sendKeys(userid);
       loginpassword.sendKeys(password);
        Thread.sleep(3000);
        screenshot(driver,"entered userid & password");
    }
    public void clicksLoginButton() throws InterruptedException, IOException {
        loginclick.click();
        Thread.sleep(10000);

    }
    public void userIsNavigatedToTheHomePage() throws IOException, InterruptedException {
        String expectedurl= driver.getCurrentUrl();
        String actualurl="https://money2indiauat.icicibank.com/usa/currency-converter/usd-to-inr";
         if(expectedurl.equals(actualurl))
        {
            System.out.println("Url verification passed:" +expectedurl);
            screenshot(driver,"Sendmoneypage");
        }
        else
        {
            System.out.println("Url verification failed");
            driver.quit();
        }
    }
      public void clickOnMyProfileButton() throws InterruptedException {
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
          WebElement userprofileclick = wait.until(ExpectedConditions.elementToBeClickable
                  (By.xpath("//*[@name=\"user\"]")));
           userprofileclick.click();
           Thread.sleep(2000);
    }
    public void clickOnLogoutButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[text()=\"Logout\"]")));
             logout.click();
        Thread.sleep(4000);
    }
    public void userIsLoggingOut() throws InterruptedException, IOException {
        String expectedurl6="https://money2indiauat.icicibank.com/usa/logout";
        String currenturl6=driver.getCurrentUrl();
        screenshot(driver,"logoutpage");
        if(expectedurl6.equals(currenturl6))
        {
            System.out.println("User is logged out & navigting to log out page, Url verification is passed:" + currenturl6);
        }
        else
        {
            System.out.println("Url verification is failed");
            driver.quit();
        }
        driver.findElement(By.xpath("//*[text()=\"Back To Login\"]")).click();
        Thread.sleep(2000);
        String expectedurl7="https://money2indiauat.icicibank.com/usa/login";
        String currenturl7= driver.getCurrentUrl();
        screenshot(driver,"loginpage");
        if(expectedurl7.equals(currenturl7))
        {
            System.out.println("User is navigating back to login page, Url verification is passed:" + currenturl7);
        }
        else{
            System.out.println("Url verification is failed");
            driver.quit();
        }
    }
}
