package StepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by osifo on 23/07/2017.
 */
enum BrowserTypes {
    Chrome,
    Firefox,
}

public class WebDriverManager {
    public static WebDriver Driver;
    public String exePath = "C:\\Users\\osifo\\IdeaProjects\\TravelCloud\\chromedriver.exe";


    @Before
    public void InitializeTest() {

        BrowserTypes browser = BrowserTypes.Chrome;

        switch (browser) {
            case Chrome:
                System.out.println("Open Chrome Browser");
                String exePathChrome = exePath;
                System.setProperty("webdriver.chrome.Driver", exePathChrome);
                Driver = new ChromeDriver();
                break;

            case Firefox:
                System.out.println("Open FireFox Browser");
                System.setProperty("webdriver.firefox.marionette", exePath);
                Driver = new FirefoxDriver();
                break;

            default:
                System.out.println("Open FireFox Browser");
                System.setProperty("webdriver.firefox.marionette", exePath);
                Driver = new FirefoxDriver();
                break;
        }
        Driver.manage().window().maximize();
    }

    @After
    public void TearDownTest() {
        if (Driver != null) {
            System.out.println("Close Browser");
            Driver.close();
            Driver = null;
        }
    }
}
