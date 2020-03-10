package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DriverUtils {

    private WebDriver driver;
    private WebDriverWait driverWait;

    public DriverUtils(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, 30);
    }

    public void GoPage(String link) {
        driver.get(link);
    }

    public WebElement waitForElementCssSelector(By cssSelector) {
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(cssSelector));

    }

    public List<WebElement> waitForElementsCssSelector(By cssSelector) {
        return driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cssSelector));
    }

    public WebElement elementCssSelector(By cssSelector) {
        return driver.findElement(cssSelector);
    }

    public List<WebElement> elementsCssSelector(By cssSelector) {
        return driver.findElements(cssSelector);
    }

    public void ScrollJSElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void moveToClickElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }


    public void Quit() {
        driver.quit();
    }


}
