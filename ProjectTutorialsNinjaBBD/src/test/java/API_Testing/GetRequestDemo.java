package API_Testing;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequestDemo {

    public static void main(String[] args) {

        // Base URI
        RestAssured.baseURI = "https://gorest.co.in";

        // Bearer Token
        String token =
                "9e5cf113410422c91806fb39d2b587dab5576c3b5bd659c5beff4d60cb085915";

//        GET REQUEST

        System.out.println("============== GET REQUEST ==============");

        Response getResponse =
                given()
                .when()
                    .get("/public/v2/users/8056479");

        // Print Response
        System.out.println("Status Code : "
                + getResponse.getStatusCode());

        System.out.println("Response Body : ");
        System.out.println(getResponse.getBody().asString());

        System.out.println("Response Time : "
                + getResponse.getTime());

        System.out.println("Content Type : "
                + getResponse.getContentType());

//        GET VALIDATIONS

        System.out.println("\n============== GET VALIDATIONS ==============");

        given()
        .when()
            .get("/public/v2/users/8056479")
        .then()
            .statusCode(200)
            .body("name", equalTo("Sarada Devar"))
            .body("email",
                    equalTo("devar_sarada@schultz.test"))
            .body("gender", equalTo("male"))
            .body("status", equalTo("active"))
            .time(lessThan(5000L))
            .header("Content-Type",
                    containsString("application/json"))
            .log().all();

//        JSON EXTRACTION

        System.out.println("\n============== JSON EXTRACTION ==============");

        JsonPath jsonPath = getResponse.jsonPath();

        int id = jsonPath.getInt("id");
        String name = jsonPath.getString("name");
        String email = jsonPath.getString("email");
        String gender = jsonPath.getString("gender");
        String status = jsonPath.getString("status");

        System.out.println("ID : " + id);
        System.out.println("Name : " + name);
        System.out.println("Email : " + email);
        System.out.println("Gender : " + gender);
        System.out.println("Status : " + status);

//        POST REQUEST

        System.out.println("\n============== POST REQUEST ==============");

        // Request Body
        String postRequestBody =
                "{ "
                + "\"user_id\":8477478,"
                + "\"title\":\"API Testing\","
                + "\"body\":\"This is POST request.\""
                + "}";

        // POST Request
        Response postResponse =
                given()
                    .header("Authorization",
                            "Bearer " + token)
                    .contentType(ContentType.JSON)
                    .body(postRequestBody)
                .when()
                    .post("/public/v2/posts");

        // Print Response
        System.out.println("POST Status Code : "
                + postResponse.getStatusCode());

        System.out.println("POST Response Body : ");
        System.out.println(postResponse.getBody().asString());

//        POST VALIDATIONS

        System.out.println("\n============== POST VALIDATIONS ==============");

        postResponse.then()
                .statusCode(201)
                .body("user_id", equalTo(8477478))
                .body("title", equalTo("API Testing"))
                .body("body",
                        equalTo("This is POST request."))
                .time(lessThan(5000L))
                .header("Content-Type",
                        containsString("application/json"))
                .log().all();

//        EXTRACT GENERATED POST ID

        int generatedPostId =
                postResponse.jsonPath().getInt("id");

        System.out.println("Generated Post ID : "
                + generatedPostId);

//        PATCH REQUEST

        System.out.println("\n============== PATCH REQUEST ==============");

        String patchRequestBody =
                "{ "
                + "\"title\":\"Updated API Testing\""
                + "}";

        given()
            .header("Authorization",
                    "Bearer " + token)
            .contentType(ContentType.JSON)
            .body(patchRequestBody)
        .when()
            .patch("/public/v2/posts/" + generatedPostId)
        .then()
            .statusCode(200)
            .body("title",
                    equalTo("Updated API Testing"))
            .log().all();

//         PUT REQUEST

        System.out.println("\n============== PUT REQUEST ==============");

        String putRequestBody =
                "{ "
                + "\"user_id\":8477478,"
                + "\"title\":\"Full Updated Title\","
                + "\"body\":\"This is fully updated body.\""
                + "}";

        given()
            .header("Authorization",
                    "Bearer " + token)
            .contentType(ContentType.JSON)
            .body(putRequestBody)
        .when()
            .put("/public/v2/posts/" + generatedPostId)
        .then()
            .statusCode(200)
            .body("title",
                    equalTo("Full Updated Title"))
            .body("body",
                    equalTo("This is fully updated body."))
            .log().all();

     
//         DELETE REQUEST

        System.out.println("\n============== DELETE REQUEST ==============");

        given()
            .header("Authorization",
                    "Bearer " + token)
        .when()
            .delete("/public/v2/posts/" + generatedPostId)
        .then()
            .statusCode(204)
            .log().all();

        System.out.println("Post Deleted Successfully");

        System.out.println("\n============== TEST COMPLETED ==============");
    }
}