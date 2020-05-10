package dk.cphbusiness.banking.restTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstTest {

    private static WebDriver driver;

//    @Before
//    public void setup(){
//        String pathToChromeDriver = "lib/chromedriver.exe";
//
//        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
//
//        driver = new ChromeDriver();
//
//    }
//
//    @AfterClass
//    public static void teardown(){
//        driver.close();
//    }

        @org.junit.Test
        public void site_header_is_on_home_page() throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");

            WebDriver driver = new ChromeDriver();
            driver.get("http://localhost:3000/");
            Thread.sleep(2000);  // Let the user actually see something!

            //WebElement element = driver.findElement(By.tagName("div"));

            driver.findElement(By.id("submitAcc")).click();
            Thread.sleep(2000);  // Let the user actually see something!

            WebElement e = driver.findElement(By.id("accDisplayed"));

            Assert.assertTrue(e.isDisplayed());

            driver.quit();

        }
}
