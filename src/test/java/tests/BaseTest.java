package tests;

import org.junit.Before;
import org.junit.Test;
import utils.AutomationProcess;
import utils.WebDriverType;

public class BaseTest {
    @Before
    public void baseTest() {
        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Start();
    }


    @Test
    public void chromeTest() {
        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Start_Browser(WebDriverType.CHROME.getDriverName());
        sahibindenTestFunc(WebDriverType.CHROME);
    }

    @Test
    public void operaTest() {
        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Start_Browser(WebDriverType.OPERA.getDriverName());
        sahibindenTestFunc(WebDriverType.OPERA);
    }

    @Test
    public void firefoxTest() {
        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Start_Browser(WebDriverType.FIREFOX.getDriverName());
        sahibindenTestFunc(WebDriverType.FIREFOX);
    }


    @Test
    public void internetETest() {
        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Start_Browser(WebDriverType.IE.getDriverName());
        sahibindenTestFunc(WebDriverType.IE);
    }


    private void sahibindenTestFunc(WebDriverType driverType) {
        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Start_SahibindenTest(driverType.getDriverName(), "Sahibinden");

        SahibindenTest sahibindenTest = new SahibindenTest(driverType);

        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Test(1, "HomePage", "Sahibinden");
        sahibindenTest.startHomePageAndGoToAdvancedSearch();

        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Test(2, "AdvancedSearchPage", "Sahibinden");
        sahibindenTest.advancedSearch();

        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Test(3, "SearchResultPage", "Sahibinden");
        sahibindenTest.searchResult();

        sahibindenTest.quit();

        sahibindenTest.testResultReport();
    }


}
