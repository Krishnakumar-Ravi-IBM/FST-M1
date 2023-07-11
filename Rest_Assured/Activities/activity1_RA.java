package activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.Matchers.equalTo;


public class activity1_RA {

    final static String base_URI = "https://petstore.swagger.io/v2/pet/";

    @Test (priority = 1)
    public void postCreatePet(){
        HashMap<String, Object> petDetails = new HashMap<>();
        petDetails.put("id", 99128);
        petDetails.put("name", "Rossie");
        petDetails.put("status", "Available");

        Response resp = given()
                .contentType(ContentType.JSON)
                .body(petDetails)
                .when().post(base_URI);
        String responseBody = resp.getBody().asPrettyString();
        System.out.println("The Post Response body: "+responseBody);

//        Assertions:
        resp
                .then()
//                .statusCode(200)
                .body("id",equalTo(99128))
                .body("name",equalTo("Rossie"))
                .body("status",equalTo("Available"));
    }

//    @Test(priority = 1, dataProvider = "TestDataPetID")
@Test(priority = 2)
public void getPetDetails(){
       Response getResponse = given()
                .contentType(ContentType.JSON)
                .when().pathParam("petId", 99128)
                .get(base_URI+"{petId}");
        String getResponseBody = getResponse.getBody().asPrettyString();
        System.out.println("The Get response body: "+getResponseBody);
//Assertion
        getResponse.then()
//                .statusCode(200)
                .body("id",equalTo(99128))
                .body("name",equalTo("Rossie"))
                .body("status",equalTo("Available"));
    }

//    @Test(priority = 3, dataProvider = "TestDataPetID")
    @Test(priority = 3)
    public void delPetDetails(){
        Response delResponse = given()
                .contentType(ContentType.JSON)
                .when().pathParam("petId",99128)
                .delete(base_URI+"{petId}");
        String delResponseBody = delResponse.getBody().asPrettyString();
        System.out.println("The Delete response body: "+delResponseBody);
        //Assertions
        delResponse.then()
//                .statusCode(200)
                .body("code",equalTo(200))
                .body("message",equalTo("99128"));
    }
//    @DataProvider
//    public Object[][] TestDataPetID(){
//           Object[][] PetID = new Object[][] {{"99127"}};
//    return PetID;
//    }
}
