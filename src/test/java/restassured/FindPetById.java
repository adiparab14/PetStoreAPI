package restassured;

import io.qameta.allure.restassured.AllureRestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static restassured.BaseClass.*;

public class FindPetById {

    @Test
    public void findPetById() {

        id = addNewPet().then().assertThat()
                .extract().path("id");

        given(requestSpecification).log().all()
                .filter(new AllureRestAssured())
                .when()
                .get("/"+id)
                .then()
                .assertThat()
                .statusCode(200);

        deleteNewPet(id);

    }

    @Test
    public void findPetByIdInvalid() {

        int id = 0;
        given(requestSpecification).log().all()
                .filter(new AllureRestAssured())
                .when()
                .get("/"+id)
                .then()
                .assertThat()
                .statusCode(404);

    }
}
