package restassured;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static restassured.BaseClass.*;
import static restassured.BaseClass.id;

public class UpdatePet {

    @Test
    public void updatePet() {

        id = addNewPet().then().assertThat()
                .extract().path("id");

        given(requestSpecification).log().all()
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
