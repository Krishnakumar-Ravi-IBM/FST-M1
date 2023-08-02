package activities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class activity2_RA {
    final static String base_URI = "https://petstore.swagger.io/v2/user";

    @Test(priority = 1)
    public void postCreateUser() throws IOException {

        FileInputStream fileInput = new FileInputStream("src/test/java/activities/userDetails.json");
        String reqBody = new String(fileInput.readAllBytes());
        Response resp = given()
                .contentType(ContentType.JSON)
                .body(reqBody)
                .when().post(base_URI);
        fileInput.close();

        //Assertions
        resp.then()
                .body("code",equalTo(200));
//                .body("message",equalTo("5080210"));
    }

    @Test(priority = 2)
    public void getUserDetails() throws IOException {
        File outputFile = new File("src/test/java/activities/userGETResponse.json");

        Response getReponse = given()
                .contentType(ContentType.JSON)
                .pathParam("username", "testUser")
                .when().get(base_URI+"/{username}");
        String getResponseBody = getReponse.getBody().asPrettyString();
        try {
            outputFile.createNewFile();
            FileWriter writer = new FileWriter(outputFile.getPath());
            writer.write(getResponseBody);
            writer.close();
        }
        catch(IOException excp) {
            excp.printStackTrace();
        }
//        Assertion
        getReponse.then()
                .body("id",equalTo(5080210))
                .body("username",equalTo( "testUser"))
                .body("firstName",equalTo( "TestFname"))
                .body("lastName",equalTo( "TestLname"))
                .body("email",equalTo( "user@testdomain.com"))
                .body("password",equalTo( "testpassword"))
                .body("phone",equalTo( "6131234056"));

    }
    @Test(priority = 3)
    public void deleteUser(){
        Response deleteResponse = given()
                .contentType(ContentType.JSON)
                .pathParam("username", "testUser")
                .when().delete(base_URI+"/{username}");
//        Assertions
        deleteResponse.then()
                .body("code", equalTo(200))
                .body("message", equalTo("testUser"));
    }

}
