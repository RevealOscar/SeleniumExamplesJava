package examples.selenium.webdriver.decorator.webelement;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class WebElementWrapper implements WebElement {
    final Logger logger = Logger.getLogger(WebElementWrapper.class.getName());
    private WebElement element;
    public WebElementWrapper(final WebElement element) {
        this.element = element;
    }
    @Override
    public void click() {
        logger.info("click");
        element.click();
    }
    @Override
    public void submit() {
        element.submit();
    }
    @Override
    public void sendKeys(final CharSequence... keysToSend) {
        logger.info("keysToSend: " + keysToSend);
        element.sendKeys(keysToSend);
    }
    @Override
    public void clear() {
        element.clear();
    }
    @Override
    public String getTagName() {
        return element.getTagName();
    }
    @Override
    public String getAttribute(final String name) {
        return element.getAttribute(name);
    }
    @Override
    public boolean isSelected() {
        return element.isSelected();
    }
    @Override
    public boolean isEnabled() {
        return element.isEnabled();
    }
    @Override
    public String getText() {
        return element.getText();
    }
    @Override
    public List<WebElement> findElements(final By by) {
        return findElements(by);
    }
    @Override
    public WebElement findElement(final By by) {
        logger.info("Find element in WebElementWrapper");
        return findElement(by);
    }
    @Override
    public boolean isDisplayed() {
        return false;
    }
    @Override
    public Point getLocation() {
        return null;
    }
    @Override
    public Dimension getSize() {
        return null;
    }
    @Override
    public Rectangle getRect() {
        return null;
    }
    @Override
    public String getCssValue(final String propertyName) {
        return null;
    }
    @Override
    public <X> X getScreenshotAs(final OutputType<X> target) throws WebDriverException {
        return null;
    }
}
