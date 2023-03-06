package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@org.aeonbits.owner.Config.Sources({
        "classpath:config/browserstack.properties"
})
public interface BrowserstackConfig extends Config {

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
