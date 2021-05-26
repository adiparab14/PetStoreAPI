package restassured;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static restassured.BaseClass.*;

public class UpdatePet {

    @Test
    public void updatePet() {

        id = addNewPet().then().assertThat()
                .extract().path("id");

        given(requestSpecification)
                .contentType(ContentType.JSON)
                .filter(new AllureRestAssured())
                .body(createRequest(id))
                .when()
                .put()
                .then()
                .assertThat()
                .statusCode(200);

        deleteNewPet(id);
    }

}
