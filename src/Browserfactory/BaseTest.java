package Browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BaseTest {
    static String browser = "Chrome"; //Setting chrome driver
    public static WebDriver driver; //Declaring webdriver interface

    public void openBrowser(String baseUrl){
        //equalsIgnoreCase method to compare two strings
        if (browser.equalsIgnoreCase("Chrome")){
            //Check if set browser match with another string(chrome), then chrome driver will run
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            //Check if set browser match with another string(Firefox), then Firefox Driver will run
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
            //Check if set browser match with another string(Safari), then Safari Driver will run
            driver = new SafariDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            //Check if set browser match with another string(Edge), then Edge Driver will run
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Internet Explorer")) {
            //Check if set browser match with another string(Internet Explorer), then InternetExplorer Driver will run
            driver = new InternetExplorerDriver();
        } else {
            System.out.println("Wrong browser name");
        }

        //Launching browser
        driver.get(baseUrl);
        //Maximize window
        driver.manage().window().maximize();
        //Setting implicit wait until browser fully loaded
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void closeBrowser(){
        driver.quit();  //Closing browser
    }
}
