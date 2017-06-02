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


public class Category {
    protected static FirefoxDriver driver;
    static WebElement element;

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
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        } catch (MalformedURLException e) {

            e.printStackTrace();
        }
    }

    //TCID home_1

        @Test
        public static void categorySelect () {
            pageobjects.edtTxtPhone(driver).sendKeys("8546843038");
            pageobjects.submit(driver).click();
            pageobjects.OTP(driver).sendKeys("otp");
            pageobjects.skip(driver).click();
            driver.findElement(By.id("listOption")).click();
            element = driver.findElement(By.id("outGoingMessage"));
            Assert.assertNotNull(element);


        }

        //TCID home_2
        @Test
                public static void categoryselect() {
            pageobjects.edtTxtPhone((driver)).sendKeys("8546843038");
            pageobjects.submit(driver).click();
            pageobjects.OTP(driver).sendKeys("otp");
            pageobjects.skip(driver).click();
            driver.findElement(By.id("edtTxtInputMessage")).sendKeys("Prepaid Recharge");
            driver.findElement(By.id("btnSend")).click();

            element = driver.findElement(By.id("outGoingMessage"));
            Assert.assertNotNull(element);

        }
//TCID home_7

        @Test
    public static void SessionClose() {
            pageobjects.edtTxtPhone((driver)).sendKeys("8546843038");
            pageobjects.submit(driver).click();
            pageobjects.OTP(driver).sendKeys("otp");
            pageobjects.skip(driver).click();
            driver.findElement(By.id("edtTxtInputMessage")).sendKeys("Get a Burger");
            driver.findElement(By.id("action_cancel")).click();
            driver.findElement(By.id("btnYes")).click();

            element=driver.findElement(By.id("incominMessageLayout"));
            Assert.assertNotNull(element);
            System.out.println("session closed");





        }
@AfterClass
    public static void appquit() {
        driver.close();
}

}


