package restassured;

import restassured.BaseClass.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static restassured.BaseClass.addNewPet;
import static restassured.BaseClass.deleteNewPet;
import static restassured.BaseClass.id;

public class AddPet {

    @Test
    public void addPet() {

        id = addNewPet().then().assertThat()
                        .statusCode(200)
                        .body("status", Is.is("available"))
                        .extract().path("id");
        deleteNewPet(id);
    }

}
