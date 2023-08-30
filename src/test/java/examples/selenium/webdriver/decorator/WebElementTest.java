package examples.selenium.webdriver.decorator;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import examples.selenium.webdriver.decorator.webelement.WebElementDecorator;

public class WebElementTest {
    @Test
    public void decorateWebElement() {
        final var driver = new ChromeDriver();
        final var decoratedDriver = new WebElementDecorator().decorate(driver);
        decoratedDriver.get("https://google.com");
        final var searchBox = decoratedDriver.findElement(By.cssSelector("#APjFqb"));
        searchBox.click();
        /* - WebElementDecorator will log beforeCall and afterCall in decorated web element.

        - Overview of whats happening
        Overriding createDecorated(WebElement) will apply wrapper to the WebElement.
        In this case findElement is not applicable since it is called from the WebDriver context.
        It is possible to override findElement and findElements in the WebDriverDecorator
        to apply the wrappers to the WebElement since SearchContext is available for both driver and elements.
        for the use case of finding child elements ( ex. searchBox.findElement() )
        See WebDriverTest for an example of overriding findElement and findElements in the driver

        Sample Log
        INFO: Before Call in decorator
        Aug 29, 2023 7:34:20 PM examples.selenium.webdriver.decorator.webelement.WebElementDecorator$1 call
        INFO: Actual Call in decorator
        Aug 29, 2023 7:34:20 PM examples.selenium.webdriver.decorator.webelement.WebElementWrapper click
        INFO: click
         */
        decoratedDriver.quit();
    }
}
