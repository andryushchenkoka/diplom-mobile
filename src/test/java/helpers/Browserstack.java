package helpers;

import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

import static helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {
    public static String getVideoUrl(String sessionId) {
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class);
        return given()
                .log().all()
                .filter(withCustomTemplates())
                .auth().basic(config.getBsUser(), config.getBsKey())
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}