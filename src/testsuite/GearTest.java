package testsuite;

import Utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * .Write down the following test into ‘GearTest’ class 1. userShouldAddProductSuccessFullyTo ShoppinCart()
 * * Mouse Hover on Gear Menu * Click on Bags * Click on Product Name ‘Overnight Duffle’ * Verify the text ‘Overnight Duffle’
 * * Change Qty 3 * Click on ‘Add to Cart’ Button. * Verify the text
 * ‘You added Overnight Duffle to your shopping cart.’
 * * Click on ‘shopping cart’ Link into message
 * * Verify the product name ‘CronusYogaPant’
 * * Verify the Qty is ‘3’
 * * Verify the product price ‘$135.00’
 * * Change Qty to ‘5’
 * * Click on ‘Update Shopping Cart’ button * Verify the product price ‘$225.00’
 */
public class GearTest extends Utility {
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
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        //Mouse Hover on Gear Menu
        mouseHover(By.xpath("//a[@id='ui-id-6']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));
        //Click on Bags
        Thread.sleep(2000);
        mouseHoverAndClick(By.cssSelector("a[id='ui-id-25'] span"));
        //Click on Product Name ‘Overnight Duffle’
        mouseHoverAndClick(By.xpath("(//a[normalize-space()='Overnight Duffle'])[1]"));
        //Verify the text ‘Overnight Duffle’
        String actualName = getTextFromElement(By.xpath("//span[@class='base']"));
        Assert.assertEquals("Invalid name", "Overnight Duffle", actualName);
        //Change Qty 3
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        sendTextToElement(By.xpath("//input[@id='qty']"), "3");
        // Click on ‘Add to Cart’ Button.
        clickOnElement(By.id("product-addtocart-button"));
        //Verify the text ‘You added Overnight Duffle to your shopping cart.’
        verifyElements("Invalid text", "You added Overnight Duffle to your shopping cart.", By.xpath("//div[@class='message-success success message']"));
        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //Verify the product name ‘Overnight duffle’
        Thread.sleep(2000);
        verifyElements("Invalid product added", "Overnight Duffle", By.xpath("//td[@class='col item']/descendant::a[2]"));
        //Verify the Qty is ‘3’
        String qty = driver.findElement(By.xpath("//td[@class='col qty']/child::div[1]/descendant::input")).getAttribute("value");
        Assert.assertEquals("Invalid quantity", "3", qty);
        //Verify the product price ‘$135.00’
        String price = driver.findElement(By.xpath("//td[@class='col subtotal']//descendant::span[contains(text(),'$135.00')]")).getText();
        Thread.sleep(5);
        Assert.assertEquals("Invalid price", "$135.00", price);
        //Change Qty to ‘5’
        driver.findElement(By.xpath("//td[@class='col qty']/child::div[1]/descendant::input")).clear();
        sendTextToElement(By.xpath("//td[@class='col qty']/child::div[1]/descendant::input"), "5");
        //Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//div[@class='cart main actions']/descendant::button[2]"));
        //Verify the product price ‘$225.00’
        Thread.sleep(2000);
        String qty1 = driver.findElement(By.xpath("//td[@data-th='Subtotal']//span[@class='price']")).getText();
        Thread.sleep(5);
        Assert.assertEquals("Invalid text", "$225.00", qty1);

    }
}
