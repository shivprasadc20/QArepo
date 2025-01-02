package classes;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Basefunction {
    public static void screenshot(WebDriver driver, String filename) throws IOException {  // take  a screen shot for every pages where this method is used
        TakesScreenshot s = (TakesScreenshot) driver;
        File srcFile = s.getScreenshotAs(OutputType.FILE);
        File des = new File("/home/shivprasad/Softwares & tools/ICICI_M2I/screenshots/" + filename + ".jpg");
        FileUtils.copyFile(srcFile, des);

    }
}