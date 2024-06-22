package factory;

import java.io.FileReader;
import java.security.SecureRandom;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseClass {

    static WebDriver driver;
    static Properties p;
    static Logger logger;

    public static WebDriver initilizeBrowser() throws IOException {
        if (getProperties().getProperty("execution_env").equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            // OS
            if (getProperties().getProperty("os").equalsIgnoreCase("windows")) {
                capabilities.setPlatform(Platform.WIN11);
            } else if (getProperties().getProperty("os").equalsIgnoreCase("mac")) {
                capabilities.setPlatform(Platform.MAC);
            } else {
                System.out.println("No matching OS..");
            }
            // Browser
            switch (getProperties().getProperty("browser").toLowerCase()) {
                case "chrome":
                    capabilities.setBrowserName("chrome");
                    break;
                case "safari":
                    capabilities.setBrowserName("safari");
                    break;
                case "edge":
                    capabilities.setBrowserName("MicrosoftEdge");
                    break;
                default:
                    System.out.println("No matching browser");
            }

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

        } else if (getProperties().getProperty("execution_env").equalsIgnoreCase("local")) {
            switch (getProperties().getProperty("browser").toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    System.out.println("No matching browser");
                    driver = null;
            }
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static Properties getProperties() throws IOException {
        FileReader file = new FileReader(System.getProperty("user.dir") + "/src/test/resources/config.properties");

        p = new Properties();
        p.load(file);
        return p;
    }

    public static Logger getLogger() {
        logger = LogManager.getLogger(); // Log4j
        return logger;
    }

    public static String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public static String randomNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public static String randomAlphaNumeric() {
        String str = RandomStringUtils.randomAlphabetic(4);
        String num = RandomStringUtils.randomNumeric(3);
        return str + num;
    }

    public static String generateSecurePassword() {
        SecureRandom random = new SecureRandom();
        String upperCaseLetters = RandomStringUtils.random(1, 65, 90, true, true, null, random);
        String lowerCaseLetters = RandomStringUtils.random(1, 97, 122, true, true, null, random);
        String numbers = RandomStringUtils.randomNumeric(1);
        String specialChars = RandomStringUtils.random(1, 33, 45, false, false, null, random);

        String totalChars = RandomStringUtils.random(4, 33, 122, true, true, null, random);
        String combinedChars = upperCaseLetters + lowerCaseLetters + numbers + specialChars + totalChars;
        List<Character> pwdChars = combinedChars.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        Collections.shuffle(pwdChars, random);

        String password = pwdChars.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        return password;
    }
}
