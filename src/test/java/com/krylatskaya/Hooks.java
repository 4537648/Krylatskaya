package com.krylatskaya;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class Hooks {
    public static final String PATH_TO_PROPERTIES = "src/main/resources/config.properties";
    public static String url = "";
    public static String pass = "";
    @Before
    public void prepareData() {
        System.out.println(">>> Hook Before: OK");
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        String webDriver = "";
        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            properties.load(fileInputStream);
            url = properties.getProperty("url");
            pass = properties.getProperty("cred");
            webDriver = properties.getProperty("WebDriver");
        } catch (IOException e) {
            System.err.println("Ошибка! Файл конфигурации или параметр конфигурации не найден!");
        }
        System.setProperty("webdriver.chrome.driver", webDriver);
        System.setProperty("selenide.browser", "Chrome");
        Configuration.driverManagerEnabled = false;
        Configuration.browserSize = "1024x768";
        Configuration.timeout = 600;
        System.out.println(">>> Тестируемый cайт:      " + url);
        System.out.println(">>> Установленный таймаут: " + timeout);
        clearBrowserCache();
        clearBrowserCookies();
        open(url);
    }

    @After
    public void clearData() {
        System.out.println(">>> Hook After: OK");
    }
}