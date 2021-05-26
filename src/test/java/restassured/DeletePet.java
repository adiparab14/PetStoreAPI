package restassured;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static restassured.BaseClass.*;

public class DeletePet {

    @Test
    public void deletePetById() {

        id = addNewPet().then()
                .extract().path("id");

        given(requestSpecification).log().all()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .when()
                .delete(String.valueOf(id))
                .then()
                .assertThat()
                .statusCode(200);

    }
}
