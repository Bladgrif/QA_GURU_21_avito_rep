package com.avito.config;


import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class WebProvider {
    private final WebConfig config;

    public WebProvider(WebConfig config) {
        this.config = config;
    }

    public void webConfiguration() {
        Configuration.baseUrl = config.baseUrl();
        Configuration.browser = config.browser().toString();
        Configuration.browserSize = config.browserSize();
        Configuration.browserVersion = config.browserVersion();
        Configuration.pageLoadStrategy = "eager";

        if (config.isRemote()) {
            Configuration.remote = config.remoteUrl();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            Map<String, Object> value = new HashMap<>();
            value.put("enableVNC", true);
            value.put("enableVideo", true);
            capabilities.setCapability("selenoid:options", value);

            Configuration.browserCapabilities = capabilities;
        }
    }
}