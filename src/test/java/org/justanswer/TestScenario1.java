package org.justanswer;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CreditCardpage;
import pages.Homepage;
import pages.Questionpage;

public class TestScenario1 extends BaseTest {

   public TestScenario1(){
        super();
    }


    @BeforeClass
    public void commonAction(){
        chatpage = new Homepage(driver);
        creditCardpage = new CreditCardpage(driver);
        questionpage = new Questionpage(driver);

        chatpage.chatConversation("Welcome",properties.getProperty("msg1"));
        chatpage.chatConversation("help",properties.getProperty("msg2"));
        chatpage.chatConversation("model",properties.getProperty("msg3"));
        chatpage.chatConversation("vehicle",properties.getProperty("msg4"));
        chatpage.chatConversation("connect ",properties.getProperty("msg5"));
        chatpage.clickContinue();
        creditCardpage.clickSubmit();
    }


    @Test
    public void verifyEmailError() {
        Assert.assertEquals(creditCardpage.getEmailError(),properties.getProperty("emailError"));
    }

    @Test
    public void verifyCardError() {
        Assert.assertEquals(creditCardpage.getCardError(),properties.getProperty("cardError"));
    }

    @Test
    public void verifyExpiryError() {
        Assert.assertEquals(creditCardpage.getExpiryError(),properties.getProperty("expiryError"));
    }

    @Test
    public void verifyCVVError() {
        Assert.assertEquals(creditCardpage.getCVVError(),properties.getProperty("cvvError"));
    }

    @Test
    public void verifyzipError() {
        Assert.assertEquals(creditCardpage.getzipError(),properties.getProperty("zipError"));
    }

    @Test
    public void verifyExpiryFormatError(){
        creditCardpage.enterExpiry(properties.getProperty("invalidexpiry"));
        Assert.assertEquals(creditCardpage.getExpiryFormatError(),properties.getProperty("expiryFormatError"));
    }

}
