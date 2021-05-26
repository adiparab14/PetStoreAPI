package restassured;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.hamcrest.core.Is;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static restassured.BaseClass.*;

public class FindPetByStatus {

    @Test
    public void findPetByStatus() {

        given(requestSpecification).log().all()
                .filter(new AllureRestAssured())
                .when()
                .get("/findByStatus?status=available")
                .then()
                .assertThat()
                .statusCode(200);

    }

}
