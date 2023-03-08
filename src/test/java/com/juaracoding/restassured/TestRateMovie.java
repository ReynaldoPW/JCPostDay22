package com.juaracoding.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRateMovie {
    String BASE_URI = "https://api.themoviedb.org/3/movie";
    String MOVIE_ID = "631842";
    float RATING = 8.5f;

    String AUTH_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2MWI1MDlhNmFkOGFlNzcwMjcxZGM1YzFkODE5OWFjOSIsInN1YiI6IjY0MDcyZDYxMTJiMTBlMDA3Y2E1ZGU0OCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.zlvb6635xm83sRPxGgcZ3czVXDfXioD7JCX7HteWib4";

    @Test
    public void testRateMovie() {
        // Set up the request headers and body
        String jsonBody = "{\"value\":" + RATING + "}";
        String authHeader = "Bearer " + AUTH_TOKEN;

        // Make the API request
        Response response = RestAssured.given()
                .baseUri(BASE_URI)
                .header("Authorization", authHeader)
                .pathParam("movie_id", MOVIE_ID)
                .body(jsonBody)
                .contentType("application/json")
                .post("/{movie_id}/rating");

        // Validate the response
        Assert.assertEquals(response.getStatusCode(), 201);
        System.out.println("Response Code : "+response.getStatusCode());
    }
}

