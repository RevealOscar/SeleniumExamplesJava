package examples.selenium.webdriver.decorator;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import examples.selenium.webdriver.decorator.webelement.WebElementDecorator;
import examples.selenium.webdriver.decorator.webelement.WeebDriverDecorator;

public class WebDriverTest {
    @Test
    public void decorateWebDriver() {
        final var driver = new ChromeDriver();
        final var decoratedDriver = new WeebDriverDecorator().decorate(driver);
        decoratedDriver.get("https://google.com");
        final var searchBox = decoratedDriver.findElement(By.cssSelector("#APjFqb"));
        searchBox.click();
        /* - WebDriverDecorator will log in decorated driver call ( findElement in this case )

        - Overview of whats happening
        Overriding createDecorated(WebDriver) will apply wrapper to the WebDriver.
        findElement is called from the WebDriver context and will use the webdriverwrapper as the underlying call.

        Sample Log
        Aug 30, 2023 1:39:00 AM examples.selenium.webdriver.decorator.webelement.WeebDriverDecorator$1 call
        INFO: Actual Call in decorator
        Aug 30, 2023 1:39:00 AM examples.selenium.webdriver.decorator.webelement.WebDriverWrapper findElement
        INFO: findElement in driver wrapper: By.cssSelector: #APjFqb

         */
        decoratedDriver.quit();
    }
}
