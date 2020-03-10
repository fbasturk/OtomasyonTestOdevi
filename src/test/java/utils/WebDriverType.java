package utils;

public enum WebDriverType {

    CHROME("CHROME", "webdriver.chrome.driver", "src/test/resources/chromedriver.exe"),
    OPERA("OPERA", "webdriver.opera.driver", "src/test/resources/operadriver.exe"),
    IE("IE", "webdriver.ie.driver", "src/test/resources/IEDriverServer.exe"),
    FIREFOX("FIREFOX", "webdriver.gecko.driver", "src/test/resources/geckodriver.exe");

    private String driverName, systemKey, systemValue;

    private WebDriverType(String driverName, String systemKey, String systemValue) {
        this.driverName = driverName;
        this.systemKey = systemKey;
        this.systemValue = systemValue;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getSystemKey() {
        return systemKey;
    }

    public String getSystemValue() {
        return systemValue;
    }
}
