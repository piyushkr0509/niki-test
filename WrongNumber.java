package niki_assignment;

/**
 * Created by piyush on 02/06/17.
 */

import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import  org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;




public class WrongNumber extends Login{
    protected static FirefoxDriver driver;
    WebElement element;

    @BeforeClass
    public static void openApp() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android 5.1");
        capabilities.setCapability("platformVersion", "5.1.1");
        capabilities.setCapability("app", "/Users/piyush/Desktop/app-test-apk.apk");
        capabilities.setCapability("browserName", "");
        capabilities.setCapability("newCommandTimeout", "180");
        try {
           driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {

            e.printStackTrace();
        }
    }


//TCID wrong_1

    @Test
    public void WrongNumber() {
        pageobjects.edtTxtPhone(driver).sendKeys("8546843038");
        pageobjects.submit(driver).click();
        driver.findElement(By.id("txtWrongNumber")).click();

element=driver.findElement(By.id("edtTxtPhone"));
Assert.assertNotNull(element);
System.out.println("Navigated back to main page");




    }
    @AfterClass
    public static void appquit(){
        driver.close();
    }



}
