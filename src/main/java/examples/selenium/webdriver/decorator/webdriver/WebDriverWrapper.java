package examples.selenium.webdriver.decorator.webdriver;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverWrapper implements WebDriver {
    private static final Logger LOGGER = Logger.getLogger(WebDriverWrapper.class.getName());

    private final WebDriver driver;
    public WebDriverWrapper(final WebDriver driver) {
        this.driver = driver;
    }
    @Override
    public void get(final String url) {
        LOGGER.info("get: " + url);
        driver.get(url);
    }
    @Override
    public String getCurrentUrl() {
        LOGGER.info("getCurrentUrl");
        return driver.getCurrentUrl();
    }
    @Override
    public String getTitle() {
        LOGGER.info("getTitle");
        return driver.getTitle();
    }
    @Override
    public List<WebElement> findElements(final By by) {
        LOGGER.info("findElements in driver wrapper: " + by);
        return driver.findElements(by);
    }
    @Override
    public WebElement findElement(final By by) {
        LOGGER.info("findElement in driver wrapper: " + by);
        return driver.findElement(by);
    }
    @Override
    public String getPageSource() {
        LOGGER.info("getPageSource");
        return driver.getPageSource();
    }
    @Override
    public void close() {
        LOGGER.info("close");
        driver.close();
    }
    @Override
    public void quit() {
        LOGGER.info("quit");
        driver.quit();
    }
    @Override
    public Set<String> getWindowHandles() {
        LOGGER.info("getWindowHandles");
        return driver.getWindowHandles();
    }
    @Override
    public String getWindowHandle() {
        LOGGER.info("getWindowHandle");
        return driver.getWindowHandle();
    }
    @Override
    public TargetLocator switchTo() {
        LOGGER.info("switchTo");
        return driver.switchTo();
    }
    @Override
    public Navigation navigate() {
        LOGGER.info("navigate");
        return driver.navigate();
    }
    @Override
    public Options manage() {
        LOGGER.info("manage");
        return driver.manage();
    }
}
