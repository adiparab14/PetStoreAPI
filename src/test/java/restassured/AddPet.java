package restassured;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static restassured.BaseClass.*;

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
