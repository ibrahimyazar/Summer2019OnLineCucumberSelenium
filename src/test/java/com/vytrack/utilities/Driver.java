package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.net.URL;

public class Driver {

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();  // jan 3 20220

    private Driver() {

    }

    public static WebDriver get() {
        //if this thread doesn't have a web driver yet - create it and add to pool
        if (driverPool.get() == null) {
            System.out.println("TRYING TO CREATE DRIVER");
            // this line will tell which browser should open based on the value from properties file
            String browserParamFromEnv = System.getProperty("browser");
            String browser = browserParamFromEnv == null ? ConfigurationReader.getProperty("browser") : browserParamFromEnv;
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    break;
                case "chrome_headless":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                case "firefox_headless":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    }
                    WebDriverManager.iedriver().setup();
                    driverPool.set(new InternetExplorerDriver());
                    break;
                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS doesn't support Edge");
                    }
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your OS doesn't support Safari");
                    }
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driverPool.set(new SafariDriver());
                    break;
                case "remote_chrome":
                    try {
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.setCapability("platform", Platform.ANY);
                        driverPool.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "remote_firefox":
                    try {
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.setCapability("platform", Platform.ANY);
                        driverPool.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }

        }
        //return corresponded to thread id webdriver object
        return driverPool.get();
    }

    public static void close() {
        driverPool.get().quit();
        driverPool.remove();
    }
}
//    private static RemoteWebDriver driver;
//
//    // you can not do like this if constructor is private Driver obj = new Driver()
//    private Driver(){   // drtiver constructor
//
//    }
//    //if switch statement complains on string parameter
//    //change java version to 7+, better at least 8
//    //File--> Project Structure--> Set Project language level to at least 8 or above
//        public static WebDriver get(){
//        // if webdriver object was not crated yet
//        if(driver == null){
//            //create webdriver object based on browser value from properties file
//            String browser = ConfigurationReader.getProperty("browser");
//            switch (browser){
//                case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    //to configure chrome browser for tests
//                   // ChromeOptions chromeOptions = new ChromeOptions();  // day 12/12/2019 eklendi video 16:50
//                    //to run tests without interface, set to true
////                    chromeOptions.setHeadless(true);
//                //   driver = new ChromeDriver(chromeOptions);
//                    driver = new ChromeDriver();
//                    break;
//
//                case "chrome_headless":  // to run the
//                    WebDriverManager.chromedriver().setup();
//                    //to configure chrome browser for tests
//                    ChromeOptions options = new ChromeOptions();
//                    //to run tests without interface, set to true
//                    options.setHeadless(true);
//                    driver = new ChromeDriver(options);
//                    break;
//
//                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
//                    driver = new FirefoxDriver();
//                    break;
//                default:
//                    // if browsr is wrong stop tst and throw exception
//                    throw new RuntimeException("Wrong browser type");
//            }
//        }
//        // if webdriver object was created you can use it
//        return driver;
//    }
//
//    public static void close(){
//        // if driver still exist
//        if(driver != null){
//            //close all browser
//            driver.quit();
//            //destroy driver object ready for go
//            driver = null;
//
//        }
//    }
//}
