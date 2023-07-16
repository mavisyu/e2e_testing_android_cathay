package org.project;

import org.junit.Test;

import static org.junit.Assert.fail;

public class autoTest extends AbstractAndroid{

    @Test
    public void OpenCathayBankAndScreenshot() {

        String testName="OpenCathayBankAndScreenshot";
        getDriver().get("https://www.cathaybk.com.tw/cathaybk/");

        try{
            waitToClickByXpath("(//*[@class='cubre-m-searchBox__box'])[2]");
            getScreenshotAs(this.getFilePath() + this.formatterUtil.getCurrentTime() + testName + ".jpg");
        } catch (Exception e) {
            System.out.println("Test Failure: "+testName);
            getScreenshotAs(this.getFilePath() + this.formatterUtil.getCurrentTime() + testName + "_error.jpg");
            fail(e.getMessage());
        }
    }

    @Test
    public void TestShowCreditCardListAndScreenshot() {

        String testName="TestShowCreditCardListAndScreenshot";
        getDriver().get("https://www.cathaybk.com.tw/cathaybk/");

        try{
            waitToClickByXpath("//*[@class='cubre-a-burger']");
            waitToClickByXpath("(//*[@class='cubre-o-menu__btn'])[2]");
//            xpathAssertEquals("(//*[@class='cubre-o-menuLinkList__btn'])[1]", "credit.card");
            waitToClickByXpath("(//*[@class='cubre-o-menuLinkList__btn'])[1]");
            int element = 1;
            while (showElementByXpath("(//*[@class='cubre-o-menuLinkList__content'])[2]/a["+ element +"]")){
                element += 1;
                element ++;
            }
            int count = element - 1;
            System.out.println("Count = " + count);
            getScreenshotAs(this.getFilePath() + this.formatterUtil.getCurrentTime() + testName + ".jpg");
        } catch (Exception e) {
            System.out.println("Test Failure: "+testName);
            getScreenshotAs(this.getFilePath() + this.formatterUtil.getCurrentTime() + testName + "_error.jpg");
            fail(e.getMessage());
        }
    }

    @Test
    public void TestShowCreditCardIntroduction() {

        String testName="TestShowCreditCardIntroduction";
        getDriver().get("https://www.cathaybk.com.tw/cathaybk/");

        try{
            waitToClickByXpath("//*[@class='cubre-a-burger']");
            waitToClickByXpath("(//*[@class='cubre-o-menu__btn'])[2]");
            waitToClickByXpath("(//*[@class='cubre-o-menuLinkList__btn'])[1]");
            waitToClickByXpath("(//*[@class='cubre-o-menuLinkList__content'])[2]/a[1]");
//            xpathAssertEquals("(//*[@class='cubre-m-anchor__btn'])[6]", "card");
            waitToClickByXpath("(//*[@class='cubre-m-button'])[2]");
        } catch (Exception e) {
            System.out.println("Test Failure: "+testName);
            getScreenshotAs(this.getFilePath() + this.formatterUtil.getCurrentTime() + testName + "_error.jpg");
            fail(e.getMessage());
        }
    }
}