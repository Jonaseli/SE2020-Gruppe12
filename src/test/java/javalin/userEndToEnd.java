package javalin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import setup.Setup;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class userEndToEnd {

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
    @Order(1)
    public void userCreatesParkingSpot() {
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

    @Test
    @Order(2)
    public void userCreatesReservation() {
        driver.get("http://localhost:7000/");
        driver.findElement(By.linkText("Login as User")).click();
        driver.findElement(By.linkText("My Parking spots")).click();
        driver.findElement(By.partialLinkText("Address: " + streetAddress + " " + streetNumber)).click();
        driver.findElement(By.linkText("Rent parking spot")).click();
        driver.findElement(By.linkText("Successful payment")).click();

        Assertions.assertTrue(driver.getPageSource().contains("Rented Address: " + streetAddress + " " + streetNumber));

    }

    @Test
    @Order(3)
    public void userDeletesReservation() {
        driver.get("http://localhost:7000/");
        driver.findElement(By.linkText("Login as User")).click();
        driver.findElement(By.linkText("My Parking spots")).click();

        Assertions.assertTrue(driver.getPageSource().contains("Rented Address: " + streetAddress + " " + streetNumber));
        //Navigate to delete button, and press enter
        driver.findElement(By.partialLinkText("Rented Address: " + streetAddress + " " + streetNumber)).sendKeys(Keys.TAB, Keys.TAB, Keys.ENTER);
        //Sleep to make sure enough time is given to delete before exiting
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertFalse(driver.getPageSource().contains("Rented Address: " + streetAddress + " " + streetNumber));
    }

    @Test
    @Order(4)
    public void userDeletesParkingSpot() {
        driver.get("http://localhost:7000/");
        driver.findElement(By.linkText("Login as User")).click();
        driver.findElement(By.linkText("My Parking spots")).click();
        Assertions.assertTrue(driver.getPageSource().contains("Owned Address: " + streetAddress + " " + streetNumber));
        //Navigate to delete button, and press enter
        driver.findElement(By.partialLinkText("Owned Address: " + streetAddress + " " + streetNumber)).sendKeys(Keys.TAB, Keys.TAB, Keys.ENTER);
        //Sleep to make sure enough time is given to delete before exiting
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertFalse(driver.getPageSource().contains("Address: " + streetAddress + " " + streetNumber));
    }

    @AfterAll
    static void shutdown(){
        driver.quit();
        javalinRunner.stopJavalin();
    }
}
