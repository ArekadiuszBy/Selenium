package com.example.Selenium;


import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class Test_Google_Covid19 {

    //Tutaj musi Pan ustawić swojá siezkę do swojego "chromedriver.exe"
    String value = "C:\\Users\\NaszDom\\source\\repos\\Sel02\\packages\\Selenium.WebDriver.ChromeDriver.88.0.4324.9600\\driver\\win32\\chromedriver.exe";


//    String key = "webdriver.chrome.driver";
//    WebDriver driver = new ChromeDriver();

// // // WebDriver driver = new RemoteWebDriver(new java.net.URL("http://localhost:8080"), DesiredCapabilities.chrome());



    public Test_Google_Covid19() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver",value);
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.google.com");

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Coronavirus COVID-19 Global Cases by Johns Hopkins CSSE");

        element.submit();

        driver.findElement(By.id("res"));
        assertThat(driver.findElement(By.tagName("body")).getText(), containsString("CSSE"));

        //oczekiwanie, by zamknęło przeglądarke po 10 sekundach
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);


        driver.quit();
    }


    @Test
    public void T_Covid_Not_Working() throws MalformedURLException  {

//
//            System.setProperty(key, value);
//        driver.get("https://www.google.com");

//        WebDriver driver = new RemoteWebDriver("http://localhost:9515", DesiredCapabilities.chrome());
//        driver.get("http://www.google.com");

    }

    @After
    public void quitBrowser() {

    }
}
