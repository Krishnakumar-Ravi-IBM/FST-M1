package activities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class activity3_RA {

    RequestSpecification reqSpec;
    ResponseSpecification respSpec;

    @BeforeTest
    public void setUp() {
        final String base_URI = "https://petstore.swagger.io/v2/pet";

        reqSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .build();
        respSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/JSON")
                .expectBody("[0].status", equalTo("alive"))
                .build();
    }

    @DataProvider
    public Object[][] petDetails() {
        Object[][] petData = new Object[][]{
                {77232, "Riley","alive"},
                {77233, "Hansel", "alive"}
        }; return petData;
    }

    @Test (priority = 1)//(dataProvider = "petDetails")
    public void postPet() {

    }

}
