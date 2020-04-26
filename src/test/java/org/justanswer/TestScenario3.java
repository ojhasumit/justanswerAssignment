package org.justanswer;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CreditCardpage;
import pages.Homepage;
import pages.Questionpage;

public class TestScenario3 extends BaseTest {

    public TestScenario3(){
        super();
    }

    @BeforeTest
    public void createDriver(){
        chatpage = new Homepage(driver);
        creditCardpage = new CreditCardpage(driver);
        questionpage = new Questionpage(driver);
    }



    public void commonAction(){

        chatpage.chatConversation("Welcome",properties.getProperty("msg1"));
        chatpage.chatConversation("help",properties.getProperty("msg2"));
        chatpage.chatConversation("model",properties.getProperty("msg3"));
        chatpage.chatConversation("vehicle",properties.getProperty("msg4"));
        chatpage.chatConversation("connect ",properties.getProperty("msg5"));
        chatpage.clickContinue();
        creditCardpage.enterEmail(properties.getProperty("email"));
        creditCardpage.enterCardDetails(properties.getProperty("invalidCardNumber"));
        creditCardpage.selectExpiryDateandYear(properties.getProperty("expiryMonth"),properties.getProperty("expiryYear"));
        creditCardpage.enterZip(properties.getProperty("zip"));
        creditCardpage.enterCVV(properties.getProperty("cvv"));
        creditCardpage.clickSubmit();
    }

    @Test
    public void questionScenario(){
        chatpage.clickFirstQuestion();
        questionpage.clickOnAskYourQuestion();
        commonAction();
        Assert.assertEquals(creditCardpage.getCardError(),properties.getProperty("invalidCardError"));
    }

}

