package pages.sahibinden;

import models.SearchResultModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.AutomationProcess;
import utils.DriverUtils;
import utils.LogUtil;
import utils.WebDriverType;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends DriverUtils {

    // Detaylı arama sonucunda ilan çıktımı sorgusu
    By resultList = By.cssSelector("div[class='searchResultsRight']");

    // Kaç sonuç çıktığını bulmak için tab menu bakılmalı.
    By toggleMenuList = By.cssSelector("ul[class='faceted-top-buttons new-toggle-menu']");
    By toggleMenuItem = By.cssSelector("a[class='phdef']");

    // Arama sonucu çıkan bilgiler tabloların element adresleri
    By searchResultsTable = By.cssSelector("table[id='searchResultsTable']");
    By searchResultsItem = By.cssSelector("tr[class='searchResultsItem     ']");

    public SearchResultPage(WebDriver driver) {
        super(driver);
        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Create_Page("SearchResultPage", "Sahibinden");
    }

    public boolean isResult() {
        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Page_Func("Is Search Results full or empty", "SearchResultPage", "Sahibinden");
        try {
            waitForElementCssSelector(resultList);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<SearchResultModel> savingSearchResults() {
        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Page_Func("Save listing results", "SearchResultPage", "Sahibinden");
        ArrayList<SearchResultModel> searchResultModelList = new ArrayList<>();
        try {
            int menuListSize = waitForElementCssSelector(toggleMenuList).findElements(By.tagName("li")).size();
            for (int i = 0; i < menuListSize; i++) {
                SearchResultModel searchResultModel = new SearchResultModel();
                List<WebElement> menuList = waitForElementCssSelector(toggleMenuList).findElements(By.tagName("li"));
                searchResultModel.setTabMenuName(menuList.get(i).findElement(toggleMenuItem).getText());
                menuList.get(i).findElement(toggleMenuItem).click();


                WebElement resultsTable = waitForElementCssSelector(searchResultsTable);
                List<WebElement> columns = resultsTable.findElement(By.tagName("thead")).findElements(By.tagName("td"));
                int columnsSize = columns.size();
                searchResultModel.setTableTitle(columns);
                ArrayList<String> emptyContent = new ArrayList<>();
                for (int f = 0; f < columnsSize; f++) {
                    emptyContent.add("İlan Yok");
                }

                List<WebElement> rows = resultsTable.findElement(By.tagName("tbody")).findElements(searchResultsItem);
                int differenceSize = rows.size() - 5;
                if (differenceSize < 0) {
                    for (int k = 0; k < rows.size(); k++) {
                        searchResultModel.setTableContent(k, rows.get(k).findElements(By.tagName("td")));
                    }
                    for (int m = 0; m < 5 - rows.size(); m++) {
                        searchResultModel.setTableContent(rows.size() + m, emptyContent);
                    }
                } else {
                    for (int k = 0; k < 5; k++) {
                        searchResultModel.setTableContent(k, rows.get(k).findElements(By.tagName("td")));
                    }
                }
                searchResultModelList.add(searchResultModel);
            }
        } catch (Exception e) {
            LogUtil.error(e.getMessage());
            e.printStackTrace();
        }
        return searchResultModelList;
    }


}
