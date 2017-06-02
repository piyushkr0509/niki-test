package niki_assignment;

/**
 * Created by piyush on 01/06/17.
 */


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;


public class pageobjects {


    private static WebElement element = null;

    public static WebElement edtTxtPhone(WebDriver driver) {
        element = driver.findElement(By.id("edtTxtPhone"));
        return element;
    }

    public static WebElement submit(WebDriver driver) {
        element = driver.findElement(By.id("btnSubmit"));
        return element;

    }

    public static WebElement OTP(WebDriver driver) {
        element = driver.findElement(By.id("editTxtCode"));
        return element;
    }

    public static WebElement WrongNumnber(WebDriver driver) {
        element = driver.findElement(By.id("txtWrongNumber"));
        return element;


}
public static WebElement skip(WebDriver driver) {
        element=driver.findElement(By.id("btn_skip"));
        return  element;
}


}
