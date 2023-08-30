package examples.selenium.webdriver.decorator;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoggingDecoratorTest {
    @Test
    public void decorateFindElement(){
        final var driver = new ChromeDriver();
        final var decoratedDriver = new LoggingDecorator().decorate(driver);
        decoratedDriver.get("https://google.com");
        final var searchBox = decoratedDriver.findElement(By.cssSelector("#APjFqb"));

        /*
        LoggingDecorator will log beforeFindElement and afterFindElement in decorated driver
        Overriding beforeCall and afterCall

        Sample Log
        INFO: Thread: main | Method Name: get | Method Args: [https://google.com]
        Aug 29, 2023 7:31:39 PM examples.selenium.webdriver.decorator.LoggingDecorator afterCall
        INFO: Thread: main | Method Name: get | Method Args: [https://google.com] | Method Result: null
        Aug 29, 2023 7:31:39 PM examples.selenium.webdriver.decorator.LoggingDecorator beforeCall
        INFO: Thread: main | Method Name: findElement | Method Args: [By.cssSelector: #APjFqb]
        Aug 29, 2023 7:31:39 PM examples.selenium.webdriver.decorator.LoggingDecorator afterCall
        INFO: Thread: main | Method Name: findElement | Method Args: [By.cssSelector: #APjFqb] | Method Result: Decorated {[[ChromeDriver: chrome on mac (f2a9e8cd6ebbce9eccd886d39adbd049)] -> css selector: #APjFqb]}
         */
        driver.quit();
    }
}
