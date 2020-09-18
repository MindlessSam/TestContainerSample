package com.wipro.witaas.Goibibo;

import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;

import static org.junit.Assert.assertEquals;

public class TestContainerSelenium {
    @ClassRule
    public static BrowserWebDriverContainer chrome = new BrowserWebDriverContainer()
            .withCapabilities(new ChromeOptions());
    public static BrowserWebDriverContainer firefox = new BrowserWebDriverContainer().withCapabilities(new FirefoxOptions());
    public static BrowserWebDriverContainer internetExplorer = new BrowserWebDriverContainer().withCapabilities(new InternetExplorerOptions());
    public static BrowserWebDriverContainer opera = new BrowserWebDriverContainer().withCapabilities(new OperaOptions());

    @Test
    public void whenNavigatedToPage_thenHeadingIsInThePage() {
        RemoteWebDriver driver = internetExplorer.getWebDriver();
        driver.get("https://google.com");
        String heading = driver.findElement(By.name("btnI")).getAttribute("value");


        assertEquals("I'm Feeling Lucky", heading);
    }
}
