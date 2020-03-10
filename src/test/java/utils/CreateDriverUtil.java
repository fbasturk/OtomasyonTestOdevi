package utils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateDriverUtil {

   public static WebDriver CreateDriver (WebDriverType webDriverType) {
       System.setProperty(webDriverType.getSystemKey(), webDriverType.getSystemValue());

       WebDriver driver;
       switch (webDriverType.getDriverName()) {
           case "CHROME":
             driver = new ChromeDriver();
               break;
           case "OPERA":
               driver = new OperaDriver();
               break;
           case "IE":
               InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
               internetExplorerOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
               driver = new InternetExplorerDriver(internetExplorerOptions);
               break;
           case "FIREFOX":
               driver = new FirefoxDriver();
               break;
           default:
               throw new IllegalStateException("Unexpected value: " + webDriverType.getDriverName());
       }

       return  driver;
   }
}
