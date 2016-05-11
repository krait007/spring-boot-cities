package com.example.cities;

import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CityTest {
    String SERVICE_URI = "http://localhost";
    int SERVICE_PORT = 8080;

    @BeforeClass
    public static void init() {
        if (System.getenv("CITY_SERVICE_URI") != null) {
            RestAssured.baseURI = System.getenv("CITY_SERVICE_URL");
        }

        if (System.getenv("CITY_SERVICE_PORT") != null) {
            RestAssured.port = Integer.valueOf(System.getenv("CITY_SERVICE_PORT"));
        }
    }

    @Test
    public void testSearchByPostalcodee() {
        get("/cities/search/postalCode?q=00501").
                then().
                log().all().
                body("_embedded.cities[0].name", equalTo("HOLTSVILLE"));
    }
}
