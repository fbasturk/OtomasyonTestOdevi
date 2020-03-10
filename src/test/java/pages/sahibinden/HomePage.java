package pages.sahibinden;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.SahibindenTest;
import utils.AutomationProcess;
import utils.DriverUtils;
import utils.LogUtil;
import utils.WebDriverType;

public class HomePage extends DriverUtils {
    private String homePageLink = "https://www.sahibinden.com/";

    By adsContainer = By.cssSelector("li[class='splash-360-home']");
    By advancedSearchButton = By.cssSelector("a[title='Detaylı Arama']");

    public HomePage(WebDriver driver) {
        super(driver);
        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Create_Page("HomePage", "Sahibinden");
    }

    public void goToPage() {
        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Page_Func("Go to Link", "HomePage", "Sahibinden");
        try {
            GoPage(homePageLink);
        } catch (Exception e) {
            LogUtil.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public void closeAds() {
        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Page_Func("Click the close button of Splash", "HomePage", "Sahibinden");
        try {
            waitForElementCssSelector(adsContainer).click();
        } catch (Exception e) {
            LogUtil.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public void clickAdvancedSearch() {
        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Page_Func("Click the DetailSearch button", "HomePage", "Sahibinden");
        try {
            waitForElementCssSelector(advancedSearchButton).click();
        } catch (Exception e) {
            LogUtil.error(e.getMessage());
            e.printStackTrace();
        }
    }


}
