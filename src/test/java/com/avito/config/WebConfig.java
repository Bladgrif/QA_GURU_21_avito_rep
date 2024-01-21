package com.avito.config;


import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${environment}.properties"
})

public interface WebConfig extends Config {
    @Key("browser")
    @DefaultValue("CHROME")
    Browser getBrowser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("baseURL")
    @DefaultValue("https://avito.ru")
    String getBaseURL();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();

    @Key("remoteURL")
    String getRemoteURL();
}