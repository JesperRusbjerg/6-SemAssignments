package dk.cphbusiness.banking.testFrontend;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFrontEnd {

    private static WebDriver driver;

        @Test
        public void Test_Account_Found_After_search() throws InterruptedException {
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

    @Test
    public void Test_Transfer_Money_successfully() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3000/");
        Thread.sleep(2000);  // Let the user actually see something!

        //WebElement element = driver.findElement(By.tagName("div"));
        driver.findElement(By.id("submitAcc")).click();
        Thread.sleep(2000);  // Let the user actually see something!


        driver.findElement(By.id("moneys")).sendKeys("80");
        Thread.sleep(2000);

        driver.findElement(By.id("tranferMoney")).click();
        Thread.sleep(2000);

        WebElement e = driver.findElement(By.id("moneyTransfered"));
        Assert.assertTrue(e.isDisplayed());
        driver.quit();
    }

    @Test
    public void Test_Account_Not_Found() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3000/");
        Thread.sleep(2000);  // Let the user actually see something!

        driver.findElement(By.id("accFind")).sendKeys("80");

        WebElement element = driver.findElement(By.tagName("div"));
        driver.findElement(By.id("submitAcc")).click();
        Thread.sleep(2000);  // Let the user actually see something!

        WebElement e = driver.findElement(By.id("ERROR"));

        Assert.assertTrue(e.isDisplayed());
        driver.quit();
    }

    @Test
    public void Test_Insufficient_Funds_Money_transfer() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3000/");
        Thread.sleep(2000);  // Let the user actually see something!

        //WebElement element = driver.findElement(By.tagName("div"));
        driver.findElement(By.id("submitAcc")).click();
        Thread.sleep(2000);  // Let the user actually see something!


        driver.findElement(By.id("moneys")).sendKeys("8000000");
        Thread.sleep(2000);

        driver.findElement(By.id("tranferMoney")).click();
        Thread.sleep(2000);

        WebElement e = driver.findElement(By.id("ERROR"));
        Assert.assertTrue(e.isDisplayed());
        driver.quit();
    }

}
