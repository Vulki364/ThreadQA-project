package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    @BeforeEach
    public void setUp() {
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            System.setProperty(
                    "webdriver.chrome.driver",
                    "src/test/resources/drivers/chromedriver.exe");
        }
        Configuration.browser = "chrome";
        Configuration.browserSize ="1920x1080";
        Configuration.headless = true;

        Configuration.browserCapabilities = new ChromeOptions()
                .addArguments("--headless=new")
                .addArguments("--no-sandbox")
                .addArguments("--disable-dev-shm-usage")
                .addArguments("--disable-gpu");

    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
