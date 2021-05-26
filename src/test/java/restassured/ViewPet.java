package restassured;

import io.qameta.allure.restassured.AllureRestAssured;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static restassured.BaseClass.*;

public class ViewPet {

    @Test
    public void readPet() {


        id = addNewPet().then()
                .extract().path("id");

        given(requestSpecification).log().all()
                .filter(new AllureRestAssured())
                .when()
                .get(String.valueOf(id))
                .then()
                .assertThat()
                .statusCode(200)
                .body("id", Is.is(id));

        deleteNewPet(id);
    }
}

