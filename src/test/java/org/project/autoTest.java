package org.project;

import org.junit.Test;

import static org.junit.Assert.fail;

public class autoTest extends AbstractAndroid{

    @Test
    public void OpenCathayBankAndScreenshot() {

        String testName="OpenCathayBankAndScreenshot";
        getDriver().get("https://www.cathaybk.com.tw/cathaybk/");

        try{
            showElementByXpath("(//*[@class='cubre-m-searchBox__box'])[2]");
            showElementByXpath("//*[@class='cubre-o-quickLink']");
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
            xpathAssertEquals("(//*[@class='cubre-o-menu__btn'])[2]", "產品介紹");
            waitToClickByXpath("(//*[@class='cubre-o-menu__btn'])[2]");
            xpathAssertEquals("(//*[@class='cubre-o-menuLinkList__btn'])[1]", "信用卡");
            waitToClickByXpath("(//*[@class='cubre-o-menuLinkList__btn'])[1]");
            int element = 1;
            while (showElementByXpath("(//*[@class='cubre-o-menuLinkList__content'])[2]/a["+ element +"]")){
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
            xpathAssertEquals("(//*[@class='cubre-o-menu__btn'])[2]", "產品介紹");
            waitToClickByXpath("(//*[@class='cubre-o-menu__btn'])[2]");
            xpathAssertEquals("(//*[@class='cubre-o-menuLinkList__btn'])[1]", "信用卡");
            waitToClickByXpath("(//*[@class='cubre-o-menuLinkList__btn'])[1]");
            xpathAssertEquals("(//*[@class='cubre-o-menuLinkList__content'])[2]/a[1]", "卡片介紹");
            waitToClickByXpath("(//*[@class='cubre-o-menuLinkList__content'])[2]/a[1]");
            xpathAssertEquals("(//*[@class='cubre-m-anchor__btn swiper-slide'])[1]/p", "百貨購物");
            waitToClickByXpath("(//*[@class='cubre-m-anchor__btn swiper-slide'])[1]");
            xpathAssertEquals("(//*[@class='cubre-m-anchor__btn swiper-slide'])[2]/p", "整併卡");
            waitToClickByXpath("(//*[@class='cubre-m-anchor__btn swiper-slide'])[2]");
            xpathAssertEquals("(//*[@class='cubre-m-anchor__btn swiper-slide'])[2]/p", "停發卡");
            waitToClickByXpath("(//*[@class='cubre-m-anchor__btn swiper-slide'])[2]");
            int element = 1;
            while (showElementByXpath("(//*[@class='cubre-o-slide__page swiper-pagination-clickable swiper-pagination-bullets'])[5]/span["+ element +"]")){
                waitToClickByXpath("(//*[@class='cubre-o-slide__page swiper-pagination-clickable swiper-pagination-bullets'])[5]/span["+ element +"]");
                Thread.sleep(1000);
                getScreenshotAs(this.getFilePath() + this.formatterUtil.getCurrentTime() + testName + "_" + element + ".jpg");
                element ++;
            }
            int count = element - 1;
            System.out.println("Count = " + count);
        } catch (Exception e) {
            System.out.println("Test Failure: "+testName);
            getScreenshotAs(this.getFilePath() + this.formatterUtil.getCurrentTime() + testName + "_error.jpg");
            fail(e.getMessage());
        }
    }
}