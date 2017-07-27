package PageObject;

import StepDefs.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by osifo on 23/07/2017.
 */
public class BasePage {
    private static final int TimeDuration = 50;

    public BasePage()
    {
        PageFactory.initElements(WebDriverManager.Driver, this);
    }

    public void WaitUntilTitleIs(String pageTitle)
    {
        WebDriverWait wait = new WebDriverWait(WebDriverManager.Driver, TimeDuration);
        wait.until(ExpectedConditions.titleContains(pageTitle));
    }

    public void WaitUntilElementIsVisible(By locator)
    {
        WebDriverWait wait = new WebDriverWait(WebDriverManager.Driver, TimeDuration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
