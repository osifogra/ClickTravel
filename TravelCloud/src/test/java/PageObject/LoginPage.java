package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by osifo on 23/07/2017.
 */

public class LoginPage extends BasePage
{
    @FindBy(how = How.ID, using = "emailAddress")
    public WebElement UsernameField;

    @FindBy(how = How.ID, using ="password")
    public WebElement PasswordField;

    @FindBy(how = How.CSS, using = ".btn.btn-success.btn-block.btn-lg")
    public WebElement SubmitButton;

    public LandingPage ChooseToLogin(String userName, String password)
    {
        UsernameField.sendKeys(userName);
        PasswordField.sendKeys(password);
        SubmitButton.click();

        WaitUntilElementIsVisible(By.cssSelector(".caption>h2"));

        return new LandingPage();
    }
}
