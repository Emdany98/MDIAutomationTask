package Tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class TestBase {
    WebDriver driver;

    @BeforeTest
    @Parameters({"browser"})
    public void OpenURL(@Optional("chrome") String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", (String) System.getProperty(("user.dir")) + "/Drivers/Chromedriver.exe");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty(("user.dir")) + "/Drivers/geckodriver.exe");
        }
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.eg");
    }

    @AfterTest
    public void CloseWebsite() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.close();
    }
}
