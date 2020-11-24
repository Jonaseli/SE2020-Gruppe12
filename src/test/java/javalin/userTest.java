package javalin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import setup.Setup;

import java.io.File;
import java.io.IOException;


public class userTest {

    static Setup javalinRunner;
    static WebDriver driver;

    @BeforeAll
    static void startup(){
        javalinRunner = new Setup();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
    }

    @Test
    public void userCreatesParkingSpot() throws IOException {
        driver.get("http://localhost:7000/");

        driver.findElement(By.id("userLoginButton")).click();
        driver.findElement(By.linkText("My Parking spots")).click();
        driver.findElement(By.linkText("Create new parking spot")).click();
        driver.findElement(By.id("streetAddress")).sendKeys("123");
        driver.findElement(By.id("streetNumber")).sendKeys("456");
        driver.findElement(By.id("postalCode")).sendKeys("789");
        driver.findElement(By.id("city")).sendKeys("012");
        driver.findElement(By.id("width")).sendKeys("333");
        driver.findElement(By.id("length")).sendKeys("222");
        driver.findElement(By.id("height")).sendKeys("111");
        driver.findElement(By.id("height")).submit();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./image.png"));
        //Assertions.assertTrue(driver.getPageSource().contains("<h1>EZpark</h1>"));


    }

    @AfterAll
    static void shutdown(){
        driver.quit();
        javalinRunner.stopJavalin();
    }
}
