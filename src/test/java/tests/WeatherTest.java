package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class WeatherTest {


    private static final Logger log = LoggerFactory.getLogger(WeatherTest.class);

    @Test
    public void checkWeather() {
        when()
                .get("https://www.onliner.by/sdapi/pogoda/api/now")
        .then()
                .log().all()
                .statusCode(200);
    }
}
