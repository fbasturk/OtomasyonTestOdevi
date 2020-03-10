package pages.sahibinden;

import models.SearchModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.AutomationProcess;
import utils.DriverUtils;
import utils.LogUtil;
import utils.WebDriverType;

import java.util.ArrayList;
import java.util.List;

public class AdvancedSearchPage extends DriverUtils {
    private String pageLink = "https://www.sahibinden.com/arama/detayli";

    // Kategori seçimi yapılabilmesi için element adresleri
    By categoryList = By.cssSelector("div[class*='category-list']");
    By categoryItemList = By.cssSelector("span[href*='/arama/detayli']");

    //Ortak adres alanları için belirlenen element adresleri
    By waitVisibleAddress = By.cssSelector("div[class='address-pane active']");
    By closePane = By.cssSelector("a[class='collapse-pane']");

    // İl seçimi yapılması için element adresleri
    By addressProvinceButton = By.cssSelector("li[data-address='city']");
    By addressProvinceList = By.cssSelector("li[data-level='city']");

    // İlçe seçimi yapılması için element adresleri
    By addressDistrictButton = By.cssSelector("li[data-address='town']");
    By addressDistrictList = By.cssSelector("li[data-level='town']");

    // Checkbox ların bulunduğu seçeneklerin element adresleri
    By checkBoxTable = By.cssSelector("table[class='categorySubTable bool-element-group']");
    By checkVideo = By.cssSelector("label[for='hasVideo']");
    By checkPhoto = By.cssSelector("label[for='hasPhoto']");
    By checkMegaPhoto = By.cssSelector("label[for='hasMegaPhoto']");

    // Arama yap butonu için element adresi
    By searchButton = By.cssSelector("button[value='Arama Yap']");


    ArrayList<String> categories;
    ArrayList<String> addressProvince;
    ArrayList<String> addressDistrict;

    SearchModel searchModel;

    public AdvancedSearchPage(WebDriver driver, SearchModel searchModel) {
        super(driver);
        this.searchModel = searchModel;

        this.categories = searchModel.getCategories();
        this.addressProvince = searchModel.getAddressProvince();
        this.addressDistrict = searchModel.getAddressDistrict();
        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Create_Page("AdvancedSearchPage", "Sahibinden");
    }

    public void setCategory() {
        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Page_Func("The given categories are selected.", "AdvancedSearchPage", "Sahibinden");
        try {
            int titleCount = 0;
            for (String category : categories) {
                List<WebElement> anaBasliklar = waitForElementsCssSelector(categoryList);
                WebElement itemList = anaBasliklar.get(titleCount);

                List<WebElement> selectItems = itemList.findElements(categoryItemList);
                for (WebElement item : selectItems) {
                    if (item.getText().trim().equals(category)) {
                        item.click();
                        break;
                    }
                }
                titleCount += 2;
            }
        } catch (Exception e) {
            LogUtil.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public void setProvince() {
        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Page_Func("The given Province are selected.", "AdvancedSearchPage", "Sahibinden");
        try {
            waitForElementCssSelector(addressProvinceButton).click();
            waitForElementCssSelector(waitVisibleAddress);
            for (String province : addressProvince) {
                List<WebElement> provinceList = elementsCssSelector(addressProvinceList);
                for (WebElement element : provinceList) {
                    if (element.getText().toLowerCase().contains(province.toLowerCase())) {
                        element.click();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            LogUtil.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public void setDistrict() {
        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Page_Func("The given District are selected.", "AdvancedSearchPage", "Sahibinden");
        try {
            waitForElementCssSelector(addressDistrictButton).click();
            waitForElementCssSelector(waitVisibleAddress);
            for (String province : addressDistrict) {
                List<WebElement> provinceList = elementsCssSelector(addressDistrictList);
                for (WebElement element : provinceList) {
                    if (element.getText().toLowerCase().contains(province.toLowerCase())) {
                        moveToClickElement(element);
                        // element.click();
                        break;
                    }
                }
            }

            waitForElementCssSelector(closePane).click();
        } catch (Exception e) {
            LogUtil.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public void setCheckDetail() {
        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Page_Func("The given Detail are selected.", "AdvancedSearchPage", "Sahibinden");
        try {
            ScrollJSElement(elementCssSelector(checkBoxTable));
            if (searchModel.getVideo())
                waitForElementCssSelector(checkVideo).click();
            if (searchModel.getPhoto())
                waitForElementCssSelector(checkPhoto).click();
            if (searchModel.getMegaPhoto())
                waitForElementCssSelector(checkMegaPhoto).click();

        } catch (Exception e) {
            LogUtil.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public void clickSearchButton() {
        AutomationProcess.AnadoluSigorta_Web_Test_Odev_Page_Func("Click the Search button", "AdvancedSearchPage", "Sahibinden");
        try {
            waitForElementCssSelector(searchButton).click();
        } catch (Exception e) {
            LogUtil.error(e.getMessage());
            e.printStackTrace();
        }
    }

}
