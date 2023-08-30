package examples.selenium.webdriver.decorator.webelement;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverWrapper implements WebDriver {
    final Logger logger = Logger.getLogger(WebDriverWrapper.class.getName());

    private WebDriver driver;
    public WebDriverWrapper(final WebDriver driver) {
        this.driver = driver;
    }
    @Override
    public void get(final String url) {
        logger.info("get: " + url);
        driver.get(url);
    }
    @Override
    public String getCurrentUrl() {
        logger.info("getCurrentUrl");
        return driver.getCurrentUrl();
    }
    @Override
    public String getTitle() {
        logger.info("getTitle");
        return driver.getTitle();
    }
    @Override
    public List<WebElement> findElements(final By by) {
        logger.info("findElements in driver wrapper: " + by);
        return driver.findElements(by);
    }
    @Override
    public WebElement findElement(final By by) {
        logger.info("findElement in driver wrapper: " + by);
        return driver.findElement(by);
    }
    @Override
    public String getPageSource() {
        logger.info("getPageSource");
        return driver.getPageSource();
    }
    @Override
    public void close() {
        logger.info("close");
        driver.close();
    }
    @Override
    public void quit() {
        logger.info("quit");
        driver.quit();
    }
    @Override
    public Set<String> getWindowHandles() {
        logger.info("getWindowHandles");
        return driver.getWindowHandles();
    }
    @Override
    public String getWindowHandle() {
        logger.info("getWindowHandle");
        return driver.getWindowHandle();
    }
    @Override
    public TargetLocator switchTo() {
        logger.info("switchTo");
        return driver.switchTo();
    }
    @Override
    public Navigation navigate() {
        logger.info("navigate");
        return driver.navigate();
    }
    @Override
    public Options manage() {
        logger.info("manage");
        return driver.manage();
    }
}
