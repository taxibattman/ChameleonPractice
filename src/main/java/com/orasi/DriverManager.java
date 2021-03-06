package com.orasi;

import java.net.URL;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;

import com.orasi.utils.Constants;
import com.orasi.utils.io.FileLoader;
import com.orasi.web.OrasiDriver;

public abstract class DriverManager {

    protected WebDriver driver = null;
    private static ThreadLocal<OrasiDriver> orasiDriver = new ThreadLocal<>();

    protected abstract void startService();

    protected abstract void stopService();

    protected abstract void createDriver();

    protected abstract void createDriver(URL url);

    protected abstract DriverType getDriverType();

    public static void quitDriver() {
        if (null != orasiDriver && null != orasiDriver.get()) {
            orasiDriver.get().quit();
        }
    }

    public static void setDriver(OrasiDriver driver) {
        orasiDriver.set(driver);
    }

    public void initalizeDriver() {
        startService();
        createDriver();
        createOrasiDriver();
    }

    public void initalizeDriver(URL url) {
        createDriver(url);
        createOrasiDriver();
    }

    public static OrasiDriver getDriver() {
        if (null == orasiDriver || null == orasiDriver.get()) {
            throw new AutomationException("Driver is null");
        }
        return orasiDriver.get();
    }

    protected String getDriverLocation(String filename) {
        String fileType = "";
        String osFolder = "";

        if (SystemUtils.IS_OS_WINDOWS) {
            osFolder = "windows/";
            fileType = ".exe";
        } else if (SystemUtils.IS_OS_LINUX) {
            osFolder = "linux/";
        } else if (SystemUtils.IS_OS_MAC) {
            osFolder = "mac/";
        }

        String filePath = Constants.CURRENT_DIR + Constants.DRIVERS_PATH_LOCAL + osFolder + filename + fileType;

        return FileLoader.getAbsolutePathForResource(filePath);
    }

    private void createOrasiDriver() {
        OrasiDriver driver = new OrasiDriver();
        driver.setDriver(this.driver);
        driver.setElementTimeout(Constants.ELEMENT_TIMEOUT);
        driver.setPageTimeout(Constants.PAGE_TIMEOUT);
        driver.setScriptTimeout(Constants.DEFAULT_GLOBAL_DRIVER_TIMEOUT);
        driver.setDriverType(getDriverType());
        orasiDriver.set(driver);
    }

}