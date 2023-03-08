package com.juaracoding.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SuppressWarnings("unchecked")
public class TestRateMovie {


    @Test
    public void testRateMovie() {
        String baseUrl = "https://api.themoviedb.org/3";
        String apiKeyV4 = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2MWI1MDlhNmFkOGFlNzcwMjcxZGM1YzFkODE5OWFjOSIsInN1YiI6IjY0MDcyZDYxMTJiMTBlMDA3Y2E1ZGU0OCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.zlvb6635xm83sRPxGgcZ3czVXDfXioD7JCX7HteWib4";
        JSONObject requestBody = new JSONObject();
        requestBody.put("value",8.5);
        System.out.println(requestBody.toJSONString());

        given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+apiKeyV4)
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON)
                .body(requestBody.toJSONString())
                .when().post(baseUrl+"/movie/631842/rating")
                .then()
                .statusCode(201)
                .body("success",equalTo(true))
                .log().all();

    }
}

