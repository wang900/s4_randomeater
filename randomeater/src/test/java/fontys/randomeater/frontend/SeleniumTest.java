package fontys.randomeater.frontend;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class SeleniumTest {

    private static WebDriver driver;
    @BeforeAll
    static void setupTests() {
        System.setProperty("webdriver.chrome.driver", "D:\\Jenkins\\workspace\\Chrome_driver\\chromedriver.exe");
        driver = new ChromeDriver();

        String baseUri = "http://localhost:8100/";
        driver.get(baseUri);
    }

    @Test
    public void test() {
        assertEquals("Ionic App", driver.getTitle());
    }

    @AfterAll
    static void quitBrowser() {
        driver.close();
    }
}
