package examples.selenium.webdriver.decorator.webelement;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.decorators.Decorated;
import org.openqa.selenium.support.decorators.DefaultDecorated;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

public class WebElementDecorator extends WebDriverDecorator<WebDriver> {
    final Logger logger = Logger.getLogger(WebDriverDecorator.class.getName());

    @Override
    public Decorated<WebElement> createDecorated(WebElement original) {
        return new DefaultDecorated<>(original, this) {
            @Override
            public void beforeCall(Method method, Object[] args) {
                String methodName = method.getName();
                if ("click".equals(methodName)){
                    logger.info("Before Call in decorator");
                }
            }
            @Override
            public Object call(Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                if ("click".equals(methodName)) {
                    logger.info("Actual Call in decorator");
                    WebElementWrapper element = new WebElementWrapper(getOriginal());
                    element.click();
                    return null;
                } else {
                    return super.call(method, args);
                }
            }
        };
    }
}
