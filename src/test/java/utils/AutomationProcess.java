package utils;

public class AutomationProcess {

    //// 1. Adım
    public static void AnadoluSigorta_Web_Test_Odev_Start() {
        LogUtil.info("1- Anadolu Sigorta's web test automation begins.");
    }

    ///// 2. Adım
    public static void AnadoluSigorta_Web_Test_Odev_Start_Browser(String driverName) {
        LogUtil.info("2- Browser Name: " + driverName + " The Browser  is getting ready to run.");
    }

    //// 3. Adım
    public static void AnadoluSigorta_Web_Test_Odev_Start_SahibindenTest(String driverName, String webSite) {
        LogUtil.info("3- Browser Name: " + driverName + ": " + webSite + " web test started.");
    }

    //// 4. Adım
    public static void AnadoluSigorta_Web_Test_Odev_Create_WebDriver(String webSite) {
        LogUtil.info("4- WebDriver created for " + webSite);
    }

    //// 5. Adım
    public static void AnadoluSigorta_Web_Test_Odev_Test(int index, String testPage, String webSite) {
        LogUtil.info("5." + index + "- " + testPage + " Test in " + webSite);
    }

    //// Sayfaları oluşturma adımları
    public static void AnadoluSigorta_Web_Test_Odev_Create_Page(String testPage, String webSite) {
        LogUtil.info(" \t" + testPage + " created for " + webSite);
    }

    public static void AnadoluSigorta_Web_Test_Odev_Finish_Page(String testPage, String webSite) {
        LogUtil.info(" \tTest " + testPage + " completed for " + webSite);
    }

    //// Sayfalarda yapılan işlemlerin adımları
    public static void AnadoluSigorta_Web_Test_Odev_Page_Func(String funcMessage, String testPage, String webSite) {
        LogUtil.info(" \t\t " + funcMessage + " in " + testPage + " for " + webSite);
    }

    //// 6. Adım
    public static void AnadoluSigorta_Web_Test_Odev_Create_Result_Json(String testPage, String webSite) {
        LogUtil.info("6- Save listing results by criteria in " + testPage + " for " + webSite);
    }

    //// 7. Adım
    public static void AnadoluSigorta_Web_Test_Odev_Finish_Browser(String driverName) {
        LogUtil.info("7- Browser Name: " + driverName + " The Browser is finish");
    }

    /// 8. Adım
    public static void AnadoluSigorta_Web_Test_Odev_Test_Result_Report(String result) {
        LogUtil.info("8- Result:\n"+result);
    }

}
