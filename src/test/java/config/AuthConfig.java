package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@org.aeonbits.owner.Config.Sources({
        "system:properties",
        "classpath:auth/auth_bs.properties"
})
public interface AuthConfig extends Config {

    @Key("login")
    String getLogin();

    @Key("password")
    String getPassword();
}
