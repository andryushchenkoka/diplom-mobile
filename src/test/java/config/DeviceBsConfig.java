package config;

import org.aeonbits.owner.Config;

@org.aeonbits.owner.Config.Sources({
        "classpath:config/device_bs.properties"
})
public interface DeviceBsConfig extends Config {


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
