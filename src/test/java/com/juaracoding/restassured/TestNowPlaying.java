package com.juaracoding.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNowPlaying {
    String API_KEY = "61b509a6ad8ae770271dc5c1d8199ac9";
    String BASE_URI = "https://api.themoviedb.org/3/movie";

    @Test
    public void testGetNowPlaying() {
        // Set up the request parameters
        String region = "US";

        // Make the API request
        Response response = RestAssured.given()
                .baseUri(BASE_URI)
                .queryParam("api_key", API_KEY)
                .queryParam("region", region)
                .get("/now_playing");

        // Validate the response
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}

