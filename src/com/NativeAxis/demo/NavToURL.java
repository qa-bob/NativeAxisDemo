package com.NativeAxis.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class NavToURL {
    public static final String USERNAME = "rlsmall5656";
    public static final String ACCESS_KEY = "350cafc9-ab84-45be-8711-3f3c21b9ed2a";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

    public static void main(String[] args) throws Exception {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "Windows 7");
        caps.setCapability("version", "51.0");
        caps.setCapability("screenResolution", "1280x768");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

        driver.get("http://www.nativeaxis.com");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("menu-item-177")).click();
        Thread.sleep(10000);
        WebElement emailBox = driver.findElement(By.id("email"));
        Actions actions = new Actions(driver);
        actions.moveToElement(emailBox);
        emailBox.sendKeys("qabob.small@gmail.com");
        driver.findElement(By.className("submit-button")).click();
        driver.quit();
    }
}
