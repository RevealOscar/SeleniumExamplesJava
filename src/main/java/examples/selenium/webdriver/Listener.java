package examples.selenium.webdriver;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class Listener implements WebDriverListener {
    Logger logger = Logger.getLogger(Listener.class.getName());
    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        logger.info("beforeFindElement in Listener");
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        logger.info("afterFindElement in Listener");
    }

    @Override
    public void beforeClick(WebElement element){
        logger.info("Before click in Listener");
    }

    @Override
    public void afterClick(WebElement element){
        logger.info("After click in Listener");
    }
}
