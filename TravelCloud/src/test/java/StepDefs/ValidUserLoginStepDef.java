package StepDefs;

import PageObject.LandingPage;
import PageObject.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by osifo on 23/07/2017.
 */
public class ValidUserLoginStepDef {

    public LoginPage loginPage = new LoginPage();
    public LandingPage landingPage = new LandingPage();

    @Given("^i choose to navigate to travel cloud$")
    public void iChooseToNavigateToTravelCloud() throws Throwable {
        WebDriverManager.Driver.navigate().to("https://apps-preview.uat.travel.cloud");
    }

    @When("^i choose to log in with user with valid ([^\"]*) username and ([^\"]*) password$")
    public void iChooseToLogInWithUserWithValidUsernameUsernameAndPasswordPassword(String email, String password) throws Throwable {
        landingPage  = loginPage.ChooseToLogin(email, password);
    }

    @Then("^authentication is successful$")
    public void authenticationIsSuccessful() throws Throwable {
        String title = WebDriverManager.Driver.getTitle();
        Assert.assertEquals("Travel", title);
    }

    @And("^the user can view his dashboard$")
    public void theUserCanViewHisDashboard() throws Throwable {
        List<String> actualDashboardText = new ArrayList();
        actualDashboardText.add("Book a flight");
        actualDashboardText.add("Book a hotel");
        actualDashboardText.add("Book a train ticket");
        actualDashboardText.add("Book car hire");
        actualDashboardText.add("Book a London Travelcard");

        List<WebElement> dashboardContent = WebDriverManager.Driver.findElements(By.cssSelector(".caption>h2"));
        List<String> expectedDashboardText = new ArrayList();

        for (WebElement dc : dashboardContent) {
            expectedDashboardText.add(dc.getText());
        }

        Assert.assertEquals(expectedDashboardText, actualDashboardText);
    }
}
