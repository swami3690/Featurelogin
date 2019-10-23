package OrangeFeature;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserSelector extends Utils {


    //create object for loadprop

    public static LoadProp loadProp = new LoadProp();
    public static final String USERNAME = loadProp.getProperty("SAUCE_USERNAME");
    public static final String ACCESS_KEY = loadProp.getProperty("SAUCE_ACCESS_KEY");
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com/wd/hub";

    public static final boolean SAUCE_LAB = Boolean.parseBoolean(System.getProperty("Sauce"));
    public static final String browser = System.getProperty("browser");

    public void setUpBrowser (){
        System.out.println(USERNAME);
        System.out.println(ACCESS_KEY);
        //If sauce lab is true.................

        if (SAUCE_LAB)
        {
            System.out.println("Running in SauceLab......with browser "+browser);

            if (browser.equalsIgnoreCase("chrome"))

            {
                MutableCapabilities sauceOptions = new MutableCapabilities();

                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setExperimentalOption("w3c", true);
                browserOptions.setCapability("platformName", "Windows 7");
                browserOptions.setCapability("browserVersion", "77.0");
                browserOptions.setCapability("sauce:options", sauceOptions);
                DesiredCapabilities caps = DesiredCapabilities.chrome();

                try {
                    driver = new RemoteWebDriver(new URL(URL),caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }

            else if (browser.equalsIgnoreCase("IE"))
            {
                MutableCapabilities sauceOptions = new MutableCapabilities();

                InternetExplorerOptions browserOptions = new InternetExplorerOptions();
                browserOptions.setCapability("platformName", "Windows 7");
                browserOptions.setCapability("browserVersion", "11.0");
                browserOptions.setCapability("sauce:options", sauceOptions);
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();

                try {
                    driver = new RemoteWebDriver(new URL(URL),caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }

            else if (browser.equalsIgnoreCase("Firefox"))

            {
                MutableCapabilities sauceOptions = new MutableCapabilities();

                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setCapability("platformName", "Windows 7");
                browserOptions.setCapability("browserVersion", "69.0");
                browserOptions.setCapability("sauce:options", sauceOptions);
                DesiredCapabilities caps = DesiredCapabilities.firefox();

                try {
                    driver = new RemoteWebDriver(new URL(URL),caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }

            else if (browser.equalsIgnoreCase("Safari"))

            {
                MutableCapabilities sauceOptions = new MutableCapabilities();

                SafariOptions browserOptions = new SafariOptions();
                browserOptions.setCapability("platformName", "OS X 10.10");
                browserOptions.setCapability("browserVersion", "8.0");
                browserOptions.setCapability("sauce:options", sauceOptions);
                DesiredCapabilities caps = DesiredCapabilities.safari();

                try {
                    driver = new RemoteWebDriver(new URL(URL),caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            else if (browser.equalsIgnoreCase("edge"))
            {
                MutableCapabilities sauceOptions = new MutableCapabilities();

                EdgeOptions browserOptions = new EdgeOptions();
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "16.16299");
                browserOptions.setCapability("sauce:options", sauceOptions);
                DesiredCapabilities caps = DesiredCapabilities.edge();

                try {
                    driver = new RemoteWebDriver(new URL(URL),caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }

            else
            {System.out.println("Browser name is empty or typed wrong: " + browser);

            }

        }
        else {

            //storing browser as a string variable
            //String browser = loadProp.getProperty("browser");
            //String browser = System.getProperty("browser");

            if (browser.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver","src\\test\\java\\Resources\\BrowserDriver1\\chromedriver.exe");
                driver = new ChromeDriver();

            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "src\\test\\java\\Resources\\BrowserDriver1\\geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("ie")){
                System.setProperty("webdriver.ie.driver","src\\test\\java\\Resources\\BrowserDriver1\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            } else {
                System.out.println("Browser name is empty or typed wrong: " + browser);
            }
        }


    }


}

