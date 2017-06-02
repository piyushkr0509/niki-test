package niki_assignment;

/**
 * Created by piyush on 01/06/17.
 */



import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;


public class Login {
    protected static AndroidDriver driver;
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
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {

            e.printStackTrace();
        }
    }
@Test
    public  void validCredentials() {

    driver.findElement(By.id("edtTxtPhone")).sendKeys("8546843038");
    driver.findElement(By.id("btnSubmit")).click();

    //for testing purposes OTP is generally hardcoded , if otp being generated from backend it can be fetched from DB.
    driver.findElement(By.id("editTxtCode")).sendKeys("3716");


// TCID otp_1
    element = driver.findElement(By.id("btn_skip"));
    Assert.assertNotNull(element);
    System.out.println("Login Succesfull");


}


@Test
    public void invalidCredentials () {
        driver.findElement(By.id("edtTxtPhone")).sendKeys("854684303");
    driver.findElement(By.id("btnSubmit")).click();
    //Assert.assertTrue(mePage.getToastMessage().contains("Invalid phone number"));


//TCID login_2
    element=driver.findElement(By.id("edtTxtPhone"));
    Assert.assertNotNull(element);
    System.out.println("Login Unsuccessful");


}
@Test
    public void InvalidOtp() {

        driver.findElement(By.id("edtTxtPhone")).sendKeys("8546843038");
        driver.findElement(By.id("btnSubmit")).click();
        driver.findElement(By.id("editTxtCode")).sendKeys("12345");

        element=driver.findElement(By.id("txtOTPError"));
        Assert.assertNotNull(element);
        System.out.println("Login Unsuccessful");


}
@Test
    public void BannerSkip() {
    driver.findElement(By.id("edtTxtPhone")).sendKeys("8546843038");
    driver.findElement(By.id("btnSubmit")).click();
    driver.findElement(By.id("editTxtCode")).sendKeys("otp");

    driver.findElement(By.id("btn_skip")).click();

    element=driver.findElement(By.id("niki_title_chat"));
    Assert.assertNotNull(element);
    System.out.println("Navigated to Home Page");
}



@AfterClass
    public static void appquit() {
        driver.quit();
}

}
