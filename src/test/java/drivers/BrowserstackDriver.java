package drivers;

import com.codeborne.selenide.WebDriverProvider;

import config.BrowserstackConfig;
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

        BrowserstackConfig bsConfig = ConfigFactory.create(BrowserstackConfig.class);

        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("browserstack.user", bsConfig.getBsUser());
        mutableCapabilities.setCapability("browserstack.key", bsConfig.getBsKey());

        mutableCapabilities.setCapability("app", bsConfig.getAppUrl());

        mutableCapabilities.setCapability("device", bsConfig.getDeviceName());
        mutableCapabilities.setCapability("os_version", bsConfig.getOsVersion());

        mutableCapabilities.setCapability("project", bsConfig.getProjectName());
        mutableCapabilities.setCapability("build", bsConfig.getBuild());
        mutableCapabilities.setCapability("name", bsConfig.getName());

        try {
            return new RemoteWebDriver(new URL("http://hub.browserstack.com/wd/hub"), mutableCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
