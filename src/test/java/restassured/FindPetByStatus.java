package restassured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static restassured.BaseClass.requestSpecification;

public class FindPetByStatus {

    @Test
    public void findPetByStatus() {

        given(requestSpecification)
                .when()
                .get("/findByStatus?status=available")
                .then()
                .assertThat()
                .statusCode(200);

    }

}
