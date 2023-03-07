package com.juaracoding.restassured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPopularMovie {
    String API_KEY = "61b509a6ad8ae770271dc5c1d8199ac9";
    String BASE_URI = "https://api.themoviedb.org/3/movie";

    @Test
    public void testGetPopularMovies() {
        // Set up the request parameters
        String language = "en-US";
        int page = 1;

        // Make the API request
        Response response = RestAssured.given()
                .baseUri(BASE_URI)
                .queryParam("api_key", API_KEY)
                .queryParam("language", language)
                .queryParam("page", page)
                .get("/popular");

        // Validate the response
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
