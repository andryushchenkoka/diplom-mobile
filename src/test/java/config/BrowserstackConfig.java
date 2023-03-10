package config;

import org.aeonbits.owner.Config;

@org.aeonbits.owner.Config.Sources({
        "classpath:config/browserstack.properties"
})
public interface BrowserstackConfig extends Config {

    @Key("bs_user")
    String getBsUser();

    @Key("bs_key")
    String getBsKey();

    @Key("appURL")
    String getAppUrl();

    @Key("baseURL")
    String getBaseUrl();

    @Key("device_name")
    String getDeviceName();

    @Key("os_version")
    String getOsVersion();

    @Key("project_name")
    String getProjectName();

    @Key("build")
    String getBuild();

    @Key("name")
    String getName();
}
