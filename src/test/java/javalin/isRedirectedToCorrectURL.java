package javalin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import setup.Setup;

public class isRedirectedToCorrectURL {

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
    public void isUserRedirectedToFrontPage() {
        driver.get("http://localhost:7000/");
        driver.findElement(By.linkText("Login as User")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("http://localhost:7000/parking-spot"));
    }

    @Test
    public void isAdminRedirectedToAdminPage() {
        driver.get("http://localhost:7000/");
        driver.findElement(By.linkText("Login as Admin")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("http://localhost:7000/admin-page"));
    }

    @AfterAll
    static void shutdown(){
        driver.quit();
        javalinRunner.stopJavalin();
    }
}
