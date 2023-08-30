package examples.selenium.webdriver.decorator.webelement;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.decorators.Decorated;
import org.openqa.selenium.support.decorators.DefaultDecorated;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

public class WeebDriverDecorator extends WebDriverDecorator<WebDriver>{

    final Logger logger = Logger.getLogger(WeebDriverDecorator.class.getName());

    @Override
    public Decorated<WebDriver> createDecorated(WebDriver driver) {
        return new DefaultDecorated<>(driver, this) {
            @Override
            public Object call(Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                if ("findElement".equals(methodName)) {
                    logger.info("Actual Call in decorator");
                    WebDriverWrapper driver = new WebDriverWrapper(getOriginal());
                    return driver.findElement( (By) args[0]);
                } else {
                    return super.call(method, args);
                }
            }
        };
    }
}
