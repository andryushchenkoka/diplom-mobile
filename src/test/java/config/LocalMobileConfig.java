package config;

import org.aeonbits.owner.Config;

@org.aeonbits.owner.Config.Sources({
        "classpath:config/local_mobile.properties"
})
public interface LocalMobileConfig extends Config {

    @Config.Key("localVersion")
    String getOSVersion();

    @Config.Key("localPlatformName")
    String getPlatformName();

    @Config.Key("localDeviceName")
    String getDeviceName();

    @Config.Key("localAppPath")
    String getLocalAppPath();

    @Config.Key("localApppackage")
    String getLocalApppackage();

    @Config.Key("localAppactivity")
    String getLocalAppactivity();

    @Config.Key("localUrl")
    String getLocalUrl();
}
