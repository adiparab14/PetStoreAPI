package restassured;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static restassured.BaseClass.*;
import static restassured.BaseClass.id;

public class UploadImage {

    @Test
    public void uploadImage() {

        id = addNewPet().then()
                .extract().path("id");

        given(requestSpecification).log().all()
                .filter(new AllureRestAssured())
                .contentType(ContentType.MULTIPART)
                .formParam("additionalMetadata", "image")
                .multiPart("file", new File("src/main/resources/dog.png"), "image/png")
                .when()
                .post("/"+ id + "/uploadImage")
                .then()
                .assertThat()
                .statusCode(200);

        deleteNewPet(id);
    }
}
