package examples.selenium.webdriver.decorator.webdriver;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.decorators.Decorated;
import org.openqa.selenium.support.decorators.DefaultDecorated;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

public class WeebDriverDecorator extends WebDriverDecorator<WebDriver>{

    private static final Logger LOGGER = Logger.getLogger(WeebDriverDecorator.class.getName());

    @Override
    public Decorated<WebDriver> createDecorated(WebDriver driver) {
        return new DefaultDecorated<>(driver, this) {
            @Override
            public Object call(Method method, Object[] args) throws Throwable {
                final String methodName = method.getName();
                if ("findElement".equals(methodName)) {
                    getLogger().info("Actual Call in decorator");
                    final SearchContext webDriverWrapper = new WebDriverWrapper(getOriginal());
                    return webDriverWrapper.findElement( (By) args[0]);
                } else {
                    return super.call(method, args);
                }
            }
        };
    }
    public Logger getLogger() {
        return LOGGER;
    }
}
