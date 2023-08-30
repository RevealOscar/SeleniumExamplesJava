package examples.selenium.webdriver.decorator;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.decorators.Decorated;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

public class LoggingDecorator extends WebDriverDecorator<WebDriver> {
    final Logger logger = Logger.getLogger(LoggingDecorator.class.getName());

    @Override
    public void beforeCall(Decorated<?> target, Method method, Object[] args) {
        final String methodName = method.getName();
        switch (methodName) {
            default -> {
                logger.info("Thread: " + Thread.currentThread().getName() +
                            " | Method Name: " + methodName +
                            " | Method Args: " + Arrays.toString(args));
            }
        }
    }

    @Override
    public void afterCall(Decorated<?> target, Method method, Object[] args, Object res) {
        final String methodName = method.getName();
        switch (methodName) {
            default -> {
                logger.info("Thread: " + Thread.currentThread().getName() +
                            " | Method Name: " + methodName +
                            " | Method Args: " + Arrays.toString(args) +
                            " | Method Result: " + res);
            }
        }
    }
}