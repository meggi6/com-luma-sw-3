package testsuite;
/**
 * Write down the following test into WomenTestclass
 * 1. verifyTheSortByProductNameFilter
 * * Mouse Hover on Women Menu
 * * Mouse Hover on Tops * Click on Jackets
 * * Select Sort By filter “Product Name”
 * * Verify the products name display in alphabetical order
 * 2. verifyTheSortByPriceFilter * Mouse Hover on Women Menu * Mouse Hover on Tops * Click on Jackets
 * * Select Sort By filter “Price” * Verify the products price display in Low to High
 */

import Utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utility {
    static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() {
        //Mouse Hover on Women Menu
        mouseHover(By.xpath("//span[normalize-space()='Women']"));

        // Mouse Hover on Tops
        mouseHover(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));

        //Click on Jackets
        mouseHoverAndClick(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        //Select Sort By filter “Product Name”
        selectByValueFromDropDown(By.xpath("//div[@class='page-wrapper']//div[2]//div[3]//select[1]"), "name");

        List<WebElement> listOfElements = driver.findElements(By.cssSelector("ol.products.list.items.product-items>li>div>div>strong>a.product-item-link"));

        List<String> array = new ArrayList<>();
        for (WebElement products : listOfElements) {
            array.add(products.getText());
        }

        Assert.assertTrue(array.get(0).equalsIgnoreCase("Adrienne Trek Jacket"));
        System.out.println(array.get(0));
        Assert.assertTrue(array.get(11).equalsIgnoreCase("Stellar Solar Jacket"));
    }

    @Test
    public void verifyTheSortByPriceFilter() {
            //Mouse Hover on Women Menu
            mouseHover(By.xpath("//span[normalize-space()='Women']"));

            // Mouse Hover on Tops
            mouseHover(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));

            //Click on Jackets
            mouseHoverAndClick(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

            //Select Sort By filter “Price”
            selectByIndexFromDropDown(By.xpath("//div[@class='page-wrapper']//div[2]//div[3]//select[1]"), 2);

            List<WebElement> originalList = driver.findElements(By.cssSelector("span[data-price-type='finalPrice']"));
            List<Double> originalProductPriceList = new ArrayList<>();
            for (WebElement product : originalList) {
                originalProductPriceList.add(Double.valueOf(product.getText().replace("$", "")));
            }
            System.out.println("Before Sorting: " + originalProductPriceList);
            List<WebElement> afterSortingList = driver.findElements(By.cssSelector("span[data-price-type='finalPrice']"));
            List<Double> afterSortingProductPrice = new ArrayList<>();
            for (WebElement product : afterSortingList) {
                afterSortingProductPrice.add(Double.valueOf(product.getText().replace("$", "")));
            }
            Collections.sort(originalProductPriceList);
            System.out.println("After Sorting: " + afterSortingProductPrice);
            Assert.assertEquals(originalProductPriceList, afterSortingProductPrice);
        }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
