package testsuite;

import Utilities.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 *  Write down the following test into ‘MenTest’ class 1. userShouldAddProductSuccessFullyTo ShoppinCart()
 *  *  Mouse Hover on Men Menu * Mouse Hover on Bottoms * Click on Pants
 *  *  Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
 *  *  Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
 *  *  Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
 *  *  Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’ * Click on ‘shopping cart’ Link into message
 *  *  Verify the text ‘ShoppingCart.’ * Verify the product name ‘CronusYogaPant’ * Verify the product size ‘32’
 *  *  Verify the product colour ‘Black’
 */
public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    //Before annotation run in the beginning of all tests
    @Before
    //Browser set-up method
    public void setUp() {
        openBrowser(baseUrl);
    }

    //After annotation method run at the end of all tests
    @After
    //Browser closing method
    public void tearDown() {
        closeBrowser();
    }

    //Test annotation for executing the method
    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart () throws InterruptedException {
            //Mouse Hover on Men Menu
            mouseHover(By.xpath("//a[@id='ui-id-5']"));
            //Mouse Hover on Bottoms
            Thread.sleep(2000);
            mouseHover(By.xpath("//a[@id='ui-id-18']"));
            //Click on Pants
            Thread.sleep(1000);
            mouseHoverAndClick(By.id("ui-id-23"));
            //Mouse Hover on product name‘Cronus Yoga Pant’ and click on size 32.
            mouseHoverAndClick(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));
            //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
            mouseHoverAndClick(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));
            //Mouse Hover on product name‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
            mouseHoverAndClick(By.xpath("//main[@id='maincontent']/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[3]/div/div[1]/form/button/span"));
            //Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
            verifyElements("Invalid text", "You added Cronus Yoga Pant to your shopping cart.", By.xpath("//div[@class='message-success success message']"));
            //Click on ‘shopping cart’ Link into message
            clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
            //Verify the text ‘Shopping Cart.’
            verifyElements("Invalid text", "Shopping Cart", By.xpath("//span[@class='base']"));
            //Verify the product name ‘Cronus Yoga Pant’
            verifyElements("error", "Cronus Yoga Pant", By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
            //Verify the product size ‘32’
            verifyElements("error", "32", By.xpath("//dd[contains(text(),'32')]"));
            //Verify the product colour ‘Black’
            verifyElements("error", "Black", By.xpath("//dd[contains(text(),'Black')]"));
        }
    }
