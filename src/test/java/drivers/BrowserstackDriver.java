package drivers;

import com.codeborne.selenide.WebDriverProvider;

import config.DeviceBsConfig;
import config.UserBsConfig;
import lombok.SneakyThrows;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    @SneakyThrows
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        UserBsConfig userBsConfig = ConfigFactory.create(UserBsConfig.class);
        DeviceBsConfig bsConfig = ConfigFactory.create(DeviceBsConfig.class);

        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("browserstack.user", userBsConfig.getBsUser());
        mutableCapabilities.setCapability("browserstack.key", userBsConfig.getBsKey());

        mutableCapabilities.setCapability("app", bsConfig.getAppUrl());

        mutableCapabilities.setCapability("device", bsConfig.getDeviceName());
        mutableCapabilities.setCapability("os_version", bsConfig.getOsVersion());

        mutableCapabilities.setCapability("project", bsConfig.getProjectName());
        mutableCapabilities.setCapability("build", bsConfig.getBuild());
        mutableCapabilities.setCapability("name", bsConfig.getName());

        try {
            return new RemoteWebDriver(new URL(bsConfig.getBaseUrl()), mutableCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
