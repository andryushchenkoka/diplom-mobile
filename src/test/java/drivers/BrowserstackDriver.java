package drivers;

import com.codeborne.selenide.WebDriverProvider;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    @SneakyThrows
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("browserstack.user", "");
        mutableCapabilities.setCapability("browserstack.key", "");

        mutableCapabilities.setCapability("app", "");

        mutableCapabilities.setCapability("device", "");
        mutableCapabilities.setCapability("os_version", "");

        mutableCapabilities.setCapability("project", "");
        mutableCapabilities.setCapability("build", "");
        mutableCapabilities.setCapability("name", "");

        return new RemoteWebDriver(new URL("http://hub.browserstack.com/wd/hub"), mutableCapabilities);
    }
}
