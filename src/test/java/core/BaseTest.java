package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeEach
    public void setUp() {
        System.setProperty(
                "webdriver.chrome.driver",
                "src/test/resources/drivers/chromedriver.exe"
        );
        Configuration.browser = "chrome";
        Configuration.browserSize ="1920x1080";
        Configuration.headless = false;
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
