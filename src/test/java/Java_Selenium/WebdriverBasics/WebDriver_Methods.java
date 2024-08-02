package Java_Selenium.WebdriverBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;


public class WebDriver_Methods {


    @Test
    public void Run() throws InterruptedException {

        FirefoxOptions options = new FirefoxOptions();
        String firefoxBinaryPath = "/usr/bin/firefox";
        options.setBinary(firefoxBinaryPath);
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments();
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://www.google.com");
        System.out.print(driver.getCurrentUrl());
        driver.manage().window().maximize();
        WebElement searchbox = driver.findElement(By.xpath("//textarea[@title='Search']"));

        searchbox.sendKeys("Hello World");
        Thread.sleep(3000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value=''",searchbox);
        Thread.sleep(3000);


        driver.quit();
    }

}
