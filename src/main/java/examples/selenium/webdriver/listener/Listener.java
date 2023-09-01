package examples.selenium.webdriver.listener;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class Listener implements WebDriverListener {
    private static final Logger LOGGER = Logger.getLogger(Listener.class.getName());
    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        LOGGER.info("beforeFindElement in Listener");
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        LOGGER.info("afterFindElement in Listener");
    }

    @Override
    public void beforeClick(WebElement element){
        LOGGER.info("Before click in Listener");
    }

    @Override
    public void afterClick(WebElement element){
        LOGGER.info("After click in Listener");
    }
}
