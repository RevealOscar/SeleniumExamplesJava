package examples.selenium.webdriver;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import examples.selenium.webdriver.decorator.webelement.WebElementDecorator;
import examples.selenium.webdriver.listener.Listener;

public class ListenerTest implements WebDriverListener {

    @Test
    public void multipleDecorators() {
        final WebDriver originalDriver = new ChromeDriver();
        final Listener listener = new Listener();
        final WebDriver decoratedDriver = new EventFiringDecorator<>(listener).decorate(new WebElementDecorator().decorate(originalDriver));
        decoratedDriver.get("https://www.google.com");
        final var searchBox = decoratedDriver.findElement(By.cssSelector("#APjFqb"));
        searchBox.click();
        /*
        It is possible to apply multiple decorators to the driver. In this case we are applying the Listener and WebElementDecorator.
        Rules from applied decorators will be applied in the order they are applied. If conflicting rules are applied the last decorator will be applied.

        Sample Log
        INFO: beforeFindElement in Listener
        Aug 30, 2023 1:41:02 AM examples.selenium.webdriver.listener.Listener afterFindElement
        INFO: afterFindElement in Listener
        Aug 30, 2023 1:41:02 AM examples.selenium.webdriver.listener.Listener beforeClick
        INFO: Before click in Listener
        Aug 30, 2023 1:41:02 AM examples.selenium.webdriver.decorator.webelement.WebElementDecorator$1 beforeCall
        INFO: Before Call in decorator
        Aug 30, 2023 1:41:02 AM examples.selenium.webdriver.decorator.webelement.WebElementDecorator$1 call
        INFO: Actual Call in decorator
        Aug 30, 2023 1:41:02 AM examples.selenium.webdriver.decorator.webelement.WebElementWrapper click
        INFO: click
        Aug 30, 2023 1:41:02 AM examples.selenium.webdriver.listener.Listener afterClick
        INFO: After click in Listener
         */
        decoratedDriver.quit();
    }
}
