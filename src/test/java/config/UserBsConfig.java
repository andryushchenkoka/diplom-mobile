package config;

import org.aeonbits.owner.Config;

@org.aeonbits.owner.Config.Sources({
        "classpath:auth/user_bs.properties"
})
public interface UserBsConfig extends Config {

    @Key("bs_user")
    String getBsUser();

    @Key("bs_key")
    String getBsKey();
}
