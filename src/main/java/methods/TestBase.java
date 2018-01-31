package methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestBase {

	public static Properties CONFIG = new Properties();
	public static WebDriver driver = null;
	String path = System.getProperty("user.dir")+"//src//main//java//config//config.properties";
	public static String url ;
	public static String browser;
			
	public static WebDriver launch() throws IOException
	{
		
						File file = new File(System.getProperty("user.dir")+"/src/main/java/config/config.properties");
							FileInputStream fileInput = null;
							try {
								fileInput = new FileInputStream(file);
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							}
							Properties prop = new Properties();
							try {
								prop.load(fileInput);
							} catch (IOException e) {
								e.printStackTrace();
							}

						prop.load(fileInput);
						url = prop.getProperty("baseURL");
						browser = prop.getProperty("browser");
						
						System.out.println("Browser: " + browser);
						System.out.println("URL: " + url);

						switch (browser.toLowerCase()) {
						case "ff":
						case "firefox":
							System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/java/drivers/geckodriver.exe");
							driver = new FirefoxDriver();
							break;

						case "ch":
						case "chrome":
							System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/drivers/chromedriver.exe");
							driver = new ChromeDriver();
							break;

						case "ie" :
						case "internetexplorer":
							driver = new InternetExplorerDriver();
							break;

						case "safari":
							driver = new SafariDriver();
							break;
						 default:
							 System.out.println("Invalid browser name "+browser);
							 System.exit(0);
								break;	
						}//switch
							
						driver.manage().deleteAllCookies();
						driver.manage().window().maximize();
						driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
						driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

						return driver;
		
		
	}
	
	public void navigatePage()
	{
		
	driver.get(url);

	}
}

