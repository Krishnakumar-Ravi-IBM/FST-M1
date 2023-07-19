package projects;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification. RequestSpecification;
import io.restassured.specification. ResponseSpecification;
import org.testng.annotations.Test;
//import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured. RestAssured.given;
import static org.hamcrest.Matchers.*;


public class projRestAssured
{
    String sshKey="ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIHSAr+ifFBbYabxcf/noLaovoPo7aLoFLWBndoj4xXHI";
    int sshKeyId;

    //RequestSpec
    RequestSpecification requestSpec=new RequestSpecBuilder()
            .setBaseUri("https://api.github.com/user/keys")
            .addHeader("Authorization", "token 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")
            .addHeader("Content-Type", "application/json")
            .build();

    //ResponseSpec
    ResponseSpecification responseSpec=new ResponseSpecBuilder()
            .expectResponseTime (lessThan (5000L))
            .expectBody( "key", equalTo (sshKey))
            .expectBody("title", equalTo ("TestAPIKey"))
            .build();

    @Test(priority=1)
    public void postRequestTest(){
//Body of Request I
        Map<String, String> reqBody = new HashMap<>();
        reqBody.put("title", "TestAPIKey");
        reqBody.put("key", sshKey);
//Response generation
        Response response=given().spec (requestSpec).body (reqBody).when().post(); //Extract the ID
        sshKeyId = response.then().extract().path("id");
        response.then().statusCode(201). spec (responseSpec);
    }

    @Test(priority = 2)
    public void getTest(){
//path:https://api.github.com/user/keys/{keyId}
// Response Generation and Assertion
        given()
                .spec(requestSpec).pathParam("keyId", sshKeyId)
                .when().get("/{keyId}")
                .then().statusCode(200). spec(responseSpec);
    }

    @Test(priority=3)
    public void delTest(){
//path:https://api.github.com/user/keys/{keyId}
// Response Generation and Assertion
        given().spec(requestSpec).pathParam("keyId", sshKeyId)
                .when().delete("/{keyId}")
                .then().statusCode (anyOf(is (200), is (204))).time (lessThan(3000L));
    }

}