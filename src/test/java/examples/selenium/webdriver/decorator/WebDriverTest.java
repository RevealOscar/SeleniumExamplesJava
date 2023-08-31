package examples.selenium.webdriver.decorator;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import examples.selenium.webdriver.decorator.webdriver.WeebDriverDecorator;

public class WebDriverTest {
    @Test
    public void decorateWebDriver() {
        final WebDriver driver = new ChromeDriver();
        final var decoratedDriver = new WeebDriverDecorator().decorate(driver);
        decoratedDriver.get("https://google.com");
        final var searchBox = decoratedDriver.findElement(By.cssSelector("#APjFqb"));
        searchBox.click();
        /* - WebDriverDecorator will log in decorated driver call ( findElement in this case )

        - Overview of what's happening
        Overriding createDecorated(WebDriver) will apply wrapper to the WebDriver.
        findElement is called from the WebDriver context and will use the webdriverwrapper as the underlying call.
        note that in this case any findElement calls from the web element will not be decorated. This can be added
        by overriding the WebElement context call.
        Sample Log
        Aug 30, 2023 1:39:00 AM examples.selenium.webdriver.decorator.webdriver.WeebDriverDecorator$1 call
        INFO: Actual Call in decorator
        Aug 30, 2023 1:39:00 AM examples.selenium.webdriver.decorator.webdriver.WebDriverWrapper findElement
        INFO: findElement in driver wrapper: By.cssSelector: #APjFqb
         */

        decoratedDriver.quit();
    }
}
