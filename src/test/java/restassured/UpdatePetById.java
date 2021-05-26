package restassured;

import io.restassured.http.ContentType;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static restassured.BaseClass.*;

public class UpdatePetById {

    @Test
    public void updatePetById() {

        id = addNewPet().then().assertThat()
                .extract().path("id");

        given(requestSpecification)
                .contentType(ContentType.URLENC)
                .formParam("name", updatedName)
                .when()
                .post("/"+ id )
                .then()
                .assertThat()
                .body("message", Is.is(String.valueOf(id)))
                .statusCode(200);

        deleteNewPet(id);
    }

}
