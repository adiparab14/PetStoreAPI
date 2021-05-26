package restassured;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static restassured.BaseClass.*;

public class UploadImage {

    @Test
    public void uploadImage() {

        id = addNewPet().then()
                .extract().path("id");

        given(requestSpecification)
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
