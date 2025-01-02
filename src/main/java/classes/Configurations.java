package classes;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Configurations {
    public Configurations() {
        PageFactory.initElements(driver, this);
    }

    public static WebDriver driver;
    public static Properties testdata;
    public static Properties configuration;

    @Before
    public void setUp() throws IOException, InterruptedException {
        initialiseProperties();
        if (configuration.getProperty("browser").equals("Chrome")) {
//
            ChromeOptions options = new ChromeOptions();
//             options.addArguments("--headless"); // uncomment this line to run browser in headless mode
            options.addArguments("--window-size=1280,800");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        } else if (configuration.getProperty("browser").equals("Firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            // options.addArguments("--headless"); // uncomment this line to run browser in headless mode
            options.addArguments("--window-size=1920,1080");
//            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            driver = new FirefoxDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) { //takes screenshots and attaches to report when a scenario fails
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            System.out.println(driver.getCurrentUrl()); // prints the URL of the page where the testcase failed
        }
//        driver.quit(); // quits the web driver after every scenario run
    }
    public void initialiseProperties() throws IOException {
        testdata = new Properties();
        FileInputStream ip1 = new FileInputStream("src/test/resources/testdata.properties");
        testdata.load(ip1);

        configuration = new Properties();
        FileInputStream ip2 = new FileInputStream("src/test/resources/configuration.properties");
        configuration.load(ip2);

    }
}
