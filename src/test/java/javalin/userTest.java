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

    //Data for creation of parking spot, and assertions
    String streetAddress = "ks0eq";
    String streetNumber = "88q0r";
    String postalCode = "qrrjz";
    String city = "guw05";
    String width = "2099";
    String length = "8864";
    String height = "7155";

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
        driver.findElement(By.linkText("Login as User")).click();
        driver.findElement(By.linkText("My Parking spots")).click();
        driver.findElement(By.linkText("Create new parking spot")).click();
        driver.findElement(By.id("streetAddress")).sendKeys(streetAddress);
        driver.findElement(By.id("streetNumber")).sendKeys(streetNumber);
        driver.findElement(By.id("postalCode")).sendKeys(postalCode);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("width")).sendKeys(width);
        driver.findElement(By.id("length")).sendKeys(length);
        driver.findElement(By.id("height")).sendKeys(height);
        driver.findElement(By.id("height")).submit();
        driver.findElement(By.partialLinkText("Address: " + streetAddress + " " + streetNumber)).click();

        Assertions.assertTrue(driver.findElement(By.id("street")).getText().contains(streetAddress + " " + streetNumber));
        Assertions.assertTrue(driver.findElement(By.id("city")).getText().contains(postalCode + " " + city));
        Assertions.assertTrue(driver.findElement(By.id("width")).getText().contains("Width: " + width));
        Assertions.assertTrue(driver.findElement(By.id("length")).getText().contains("Length: " + length));
        Assertions.assertTrue(driver.findElement(By.id("height")).getText().contains("Height: " + height));
    }

    @AfterAll
    static void shutdown(){
        driver.quit();
        javalinRunner.stopJavalin();
    }
}
