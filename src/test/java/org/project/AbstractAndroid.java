package org.project;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class AbstractAndroid extends SetUpAndroid{

    FormatterUtil formatterUtil = new FormatterUtil();
    protected void getScreenshotAs(String path) {
        TakesScreenshot ts = (TakesScreenshot) getDriver();
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void waitToClickByXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        getDriver().findElementByXPath(xpath).click();
    }

    protected boolean showElementByXpath(String xpath) {
        try{
            getDriver().findElementByXPath(xpath);
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

    protected void xpathAssertEquals(String xpath, String prop) {
        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        String text = getDriver().findElementByXPath(xpath).getText();
        assertEquals(prop, text);
    }

    protected String getFilePath() {
        return this.inprop.getProperty("filePath") + this.formatterUtil.getCurrentDate() + "/";
    }

    public AppiumDriver<WebElement> getDriver() {
        return driver;
    }

}