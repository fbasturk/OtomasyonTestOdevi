package tests;

import models.SearchModel;
import models.SearchResultModel;
import org.openqa.selenium.WebDriver;
import pages.sahibinden.AdvancedSearchPage;
import pages.sahibinden.HomePage;
import pages.sahibinden.SearchResultPage;
import utils.AutomationProcess;
import utils.CreateDriverUtil;
import utils.JsonGenerator;
import utils.WebDriverType;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class SahibindenTest {
    private long startTime;
    private WebDriver driver;
    private SearchModel searchModel;
    private String webDriverTypeName, testResultFile;

    SahibindenTest(WebDriverType webDriverType) {
        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Create_WebDriver("Sahibinden");
        this.webDriverTypeName = webDriverType.getDriverName();
        this.driver = CreateDriverUtil.CreateDriver(webDriverType);
        this.driver.manage().window().maximize();
        // IE maximize metodunda hata veriryorsa IE nin ayarlarından zoom ayarını varsayılan 100% ayarlanmalıdır.
        this.searchModel = createSearchModel();
        this.startTime = System.currentTimeMillis();
    }

    public void startHomePageAndGoToAdvancedSearch() {
        HomePage homePage = new HomePage(driver);
        homePage.goToPage();
        if (!webDriverTypeName.equals("IE"))
            homePage.goToPage();


        // homePage.closeAds();

        homePage.clickAdvancedSearch();

        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Finish_Page("HomePage", "Sahibinden");
    }

    public void advancedSearch() {
        AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage(driver, searchModel);
        advancedSearchPage.setCategory();
        advancedSearchPage.setProvince();
        advancedSearchPage.setDistrict();
        advancedSearchPage.setCheckDetail();
        advancedSearchPage.clickSearchButton();

        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Finish_Page("AdvancedSearchPage", "Sahibinden");
    }

    public void searchResult() {
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        boolean searchResult = searchResultPage.isResult();
        ArrayList<SearchResultModel> searchResultModelList = new ArrayList<>();
        if (searchResult) {
            searchResultModelList = searchResultPage.savingSearchResults();

        } else {
            System.out.println("Sonuc Yok ");
        }

        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Create_Result_Json("SearchResultPage", "Sahibinden");
        long testTime = System.currentTimeMillis() - startTime;
        testResultFile = JsonGenerator.createConfigs(webDriverTypeName, testTime, searchModel, searchResultModelList);


        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Finish_Page("SearchResultPage", "Sahibinden");
    }

    public void quit() {
        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Finish_Browser(webDriverTypeName);
        driver.quit();
    }

    public void testResultReport() {
        String testResult = JsonGenerator.readJSONReportFile(testResultFile);
        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Test_Result_Report(testResult);
    }

    public SearchModel createSearchModel() {
        ArrayList<String> categories = new ArrayList<>();
        categories.add("Emlak");
        categories.add("Konut");
        categories.add("Kiralık");
        categories.add("Daire");

        ArrayList<String> addressProvince = new ArrayList<>();
        addressProvince.add("İstanbul");

        ArrayList<String> addressDistrict = new ArrayList<>();
        addressDistrict.add("Başakşehir");
        addressDistrict.add("Fatih");


        return new SearchModel(categories, addressProvince, addressDistrict, true, true, false);
    }
}
