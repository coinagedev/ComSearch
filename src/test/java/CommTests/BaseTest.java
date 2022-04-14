package CommTests;

import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Base class for the tests.
 */
public class BaseTest implements Config {

	protected static WebDriver driver;
	protected static WebDriverWait wait;

	@Rule
	public ExternalResource resource = new ExternalResource() {

		@Override
		public void before() throws Throwable {

			if (host.equals("cloud")) {
				if (chrome.equals("chrome")) {
					WebDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
					driver = new ChromeDriver(options);
					options.addArguments("window-size=4000,3000");
					options.addArguments("--kiosk");
					options.addArguments("--start-maximized");
					options.addArguments("--incognito");
					options.addArguments("--headless");
				}
				if (firefox.equals("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					FirefoxOptions options = new FirefoxOptions();
					options.addPreference("dom.file.createInChild", true);
					driver = new FirefoxDriver(options);
				}
			} else if (host.equals("localhost")) {
				String os = System.getProperty("os.name");
				if (firefox.equals("firefox")) {
					if (os.toLowerCase().contains("windows"))
						System.setProperty("webdriver.gecko.driver",
								System.getProperty("user.dir") + "/vendor/geckodriver.exe");
					else if (os.toLowerCase().contains("linux"))
						System.setProperty("webdriver.gecko.driver",
								System.getProperty("user.dir") + "/vendor/linux/geckodriver.exe");
					else if (os.toLowerCase().contains("mac os") || os.toLowerCase().contains("macos"))
						System.setProperty("webdriver.gecko.driver",
								System.getProperty("user.dir") + "/vendor/Mac/geckodriver.exe");
				} else if (chrome.equals("chrome")) {
					WebDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--kiosk");
					options.addArguments("--no-sandbox"); // Bypass OS security model
					options.addArguments("--headless");
					driver = new ChromeDriver(options);
					options.setExperimentalOption("useAutomationExtension", false);
					options.addArguments("--incognito");
					options.addArguments("--window-size=4000,3000");
					options.addArguments("--disable-infobars"); // disabling infobars
					options.addArguments("--disable-extensions"); // disabling extensions
					options.addArguments("--disable-gpu"); // applicable to Windows os only
					options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems

					if (os.toLowerCase().contains("windows")) {
						System.setProperty("webdriver.chrome.driver",
								System.getProperty("user.dir") + "/vendor/chromedriver.exe");
					} else if (os.toLowerCase().contains("linux")) {
						System.setProperty("webdriver.chrome.driver",
								System.getProperty("user.dir") + "/vendor/linux/chromedriver.exe");
					} else if (os.toLowerCase().contains("mac os") || os.toLowerCase().contains("macos")) {
						System.setProperty("webdriver.chrome.driver",
								System.getProperty("user.dir") + "/vendor/Mac/chromedriver.exe");
					}

				} else if (edge.equals("Edge")) {
					WebDriverManager.edgedriver().setup();
					EdgeOptions options = new EdgeOptions();
					driver = new EdgeDriver(options);
					if (os.toLowerCase().contains("windows"))
						System.setProperty("webdriver.edge.driver",
								System.getProperty("user.dir") + "/vendor/msedgedriver.exe");
					else if (os.toLowerCase().contains("linux"))
						System.setProperty("webdriver.edge.driver",
								System.getProperty("user.dir") + "/vendor/linux/msedgedriver.exe");
				}
			}
		}
	};
}
