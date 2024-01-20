package com.avito.config;


import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${environment}.properties"
})

public interface WebConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://www.tinkoff.ru")
    String baseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    Browser browser();

    @Key("browserSize")
    @DefaultValue("2560x1440")
    String browserSize();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String browserVersion();

    @Key("remoteUrl")
    String remoteUrl();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();
}